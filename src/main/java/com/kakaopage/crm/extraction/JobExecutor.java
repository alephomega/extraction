package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class JobExecutor {
    private static final TimeZone TIMEZONE = TimeZone.getTimeZone(ApplicationProperties.get("service.timezone"));
    private static final FastDateFormat TIME_FORMAT = FastDateFormat.getInstance(ApplicationProperties.get("service.time-pattern"));

    private PhaseListener phaseListener = new PhaseListener();

    public void run(String description, Map<String, String> params) {
        Execution execution = new Gson().fromJson(description, Execution.class);
        String id = execution.getId();
        String job = execution.getJob();

        Job metadata = API.job(job);
        String expression = replace(metadata.getExpression(), params);

        System.out.println("expression:\n" + expression);

        Extraction extraction;
        try {
            extraction = Extraction.of(id, job, expression);
        } catch (Exception e) {
            phaseListener.onFailure(job, id, e);
            throw e;
        }

        phaseListener.onStart(job, id);

        try {
            Process process = Serializer.serialize(extraction);

            Cohort cohort = run(job, id, process);
            phaseListener.onSuccess(job, id, cohort);

        } catch (Exception e) {
            phaseListener.onFailure(job, id, e);
            throw e;
        }
    }

    private static String replace(String description, Map<String, String> params) {
        String at = params.get("at");
        String rs = applyRandomString(applyTimestamp(at, description));

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            rs = StringUtils.replace(rs, String.format("${%s}", key), entry.getValue());
        }

        rs = applyIf(rs);

        return rs;
    }

    private static String applyTimestamp(String at, String description) {
        String rs = description;
        Matcher matcher = Pattern.compile("\\$\\{timestamp:([^},]+),?(-*\\d+[yMdHms])?\\}").matcher(rs);

        boolean result = matcher.find();
        if (result) {
            StringBuffer sb = new StringBuffer();
            do {
                String replacement;
                TemporalUnit unit = ChronoUnit.SECONDS;

                long amount = 0;
                try {
                    String option = matcher.group(2);
                    if (option != null) {
                        amount = Long.parseLong(option.substring(0, option.length()-1));

                        switch (option.charAt(option.length()-1)) {
                            case 'y':
                                unit = ChronoUnit.YEARS;
                                break;
                            case 'M':
                                unit = ChronoUnit.MONTHS;
                                break;
                            case 'd':
                                unit = ChronoUnit.DAYS;
                                break;
                            case 'H':
                                unit = ChronoUnit.HOURS;
                                break;
                            case 'm':
                                unit = ChronoUnit.MINUTES;
                                break;
                            case 's':
                                unit = ChronoUnit.SECONDS;
                        }
                    }

                    Instant instant = TIME_FORMAT.parse(at).toInstant().plus(amount, unit);
                    replacement = FastDateFormat.getInstance(matcher.group(1), TIMEZONE).format(Date.from(instant));
                } catch (ParseException e) {
                    // Should not happen
                    replacement = matcher.group(1);
                }

                matcher.appendReplacement(sb, replacement);
                result = matcher.find();
            } while (result);

            matcher.appendTail(sb);
            rs = sb.toString();
        }

        return rs;
    }


    private static String applyRandomString(String description) {
        String rs = description;
        Matcher matcher = Pattern.compile("\\$\\{random-string:(\\d+)\\}").matcher(description);

        boolean result = matcher.find();
        if (result) {
            StringBuffer sb = new StringBuffer();
            do {
                matcher.appendReplacement(sb, RandomStringUtils.randomAlphanumeric(Integer.parseInt(matcher.group(1))));
                result = matcher.find();
            } while (result);

            matcher.appendTail(sb);
            rs = sb.toString();
        }

        return rs;
    }

    private static String applyIf(String description) {
        String rs = description;
        Matcher matcher = Pattern.compile("\\$\\{if:(true|false),([^},]+),([^},]+)\\}").matcher(description);

        boolean result = matcher.find();
        if (result) {
            StringBuffer sb = new StringBuffer();
            do {
                if (Boolean.valueOf(matcher.group(1))) {
                    matcher.appendReplacement(sb, matcher.group(2));
                } else {
                    matcher.appendReplacement(sb, matcher.group(3));
                }

                result = matcher.find();
            } while (result);

            matcher.appendTail(sb);
            rs = sb.toString();
        }

        return rs;
    }


    public abstract Cohort run(String id, String job, Process process);
}