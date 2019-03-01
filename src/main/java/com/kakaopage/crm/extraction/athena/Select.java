package com.kakaopage.crm.extraction.athena;

import com.kakaopage.crm.extraction.Function;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Select extends Clause {
    private final List<SelectExpression> selectExpressions = new ArrayList<>();

    public void add(Function function) {
        add(function, null);
    }

    public void add(Function function, String alias) {
        selectExpressions.add(new SelectExpression(function, alias));
    }

    public void remove(String name) {
        int i = indexOf(name);
        if (i != -1) {
            selectExpressions.remove(i);
        }
    }

    public void removeAll() {
        selectExpressions.clear();
    }

    public void alias(String name, String alias) {
        SelectExpression expression = findExpression(name);
        if (expression != null) {
            expression.setName(alias);
        }
    }

    public Function column(String name) {
        SelectExpression expression = findExpression(name);
        return expression == null ? null : expression.getFunction();
    }

    private SelectExpression findExpression(String name) {
        for (SelectExpression expression : selectExpressions) {
            if (name.equals(expression.getName())) {
                return expression;
            }
        }

        return null;
    }

    private int indexOf(String name) {
        for (int i = 0; i < selectExpressions.size(); i++) {
            if (name.equals(selectExpressions.get(i).getName())) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String stringify(StatementContext context) {
        return String.format("select %s", StringUtils.join(selectExpressions, ", "));
    }
}
