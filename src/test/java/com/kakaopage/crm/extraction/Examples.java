package com.kakaopage.crm.extraction;

import com.kakaopage.crm.extraction.functions.Constant;
import com.kakaopage.crm.extraction.functions.Value;
import com.kakaopage.crm.extraction.predicates.Conjunction;
import com.kakaopage.crm.extraction.predicates.Disjunction;
import com.kakaopage.crm.extraction.predicates.GreaterThan;
import com.kakaopage.crm.extraction.predicates.IsIn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Examples {

/*
    Relations:
        Metadata:
            series: String,
            episode: String,
            item: String,
            amount: Double,
            token: String

        Event:
            t: ( year, month, day, hour )
            customer: String,
            service: String,
            name: String,
            at: String,
            meta: Metadata


        History:
            t: ( year, month, day, hour )
            customer: String,
            events: Array[Event]

        Summary:
            t: ( year, month, day, hour )
            customer: String,
            from: String,
            duration: Integer,
            event: Striting,
            last: String,
            frequency: Integer,
            distribution: Distribution

        Distribution:
            hour: Integer[24]
            day: Integer[7]


        ContentMetadata:
            category: []



    - (
        Π { customer } (
            σ { t between from1 and to1 & event = reading & array_sum(distribution.hour[ 9, 10, 11 ]) > 0 } ( Summary ) ),

        Π { customer } (
            σ { t between from2 and to2 & event = reading & frequency > 0 } ( Summary ) )
    )



    지난주까지 과거 4주내에 한주에 3일 이상 열람 이력이 있으나 이번주 미열람자
    --------------------------------------------------------------------------------
    define
      S1: time(-1w, 0w) &  days(reading) >= 3
      S2: time(-2w, -1w) &  days(reading) >= 3
      S3: time(-3w, -2w) &  days(reading) >= 3
      S4: time(-4w, -3w) &  days(reading) >= 3
      S5: time(0w, now) & sum(frequency(reading)) > 0

    - (
        Π { customer } (
            ∪ (
                σ { days >= 3 } γ { customer, alias(count(from), days) } Π { customer, from } σ { t between array_filter(-1w and 0w & event = reading & frequency > 0 } ( Summary ) ),
                σ { days >= 3 } γ { customer, alias(count(from), days) } Π { customer, from } σ { t between -2w and -1w & event = reading & frequency > 0 } ( Summary ) ),
                σ { days >= 3 } γ { customer, alias(count(from), days) } Π { customer, from } σ { t between -3w and -2w & event = reading & frequency > 0 } ( Summary ) ),
                σ { days >= 3 } γ { customer, alias(count(from), days) } Π { customer, from } σ { t between -4w and -3w & event = reading & frequency > 0 } ( Summary ) )
            )
        ),

        Π { customer } (
            σ { t between 0w and now & event = reading & frequency > 0 } ( Summary ) )
    )


    Π { customer } ⨝ { event.meta.series = series } (
        Π { customer, event.meta.series } ×× ( σσ { events[*].event = reading } σ { t between from and to } ( History ), alias(unnest(events), event) ),
        Π { series } σ { category in [ ] } ( SeriesMetadata )
    )


    π σ ρ τ γ ∧ ∨ ¬ = ≠ ≥ ≤ ∩ ∪ - ⨯ ⨝ ⟕ ⟖ ⟗


{
    "job": "abcde",
    "execution": "zyxwv",
    "process": {
        "id": "12345",
        "time": "",

    }
}



    	  {
    	  	"expressions": [{

    	  			"variable": "s1",

    	  			"operation": {

    	  				"@Symbol": "σ",

    	  				"condition": {

    	  					"@Symbol": "∧",

    	  					"_1": [{
    	  							"@Symbol": "=",

    	  							"_1": {
    	  								"@FuncIdentifier": "val",
    	  								"dataSet": "events",
    	  								"attribute": "s"
    	  							},

    	  							"_2": {
    	  								"@FuncIdentifier": "const",
    	  								"value": "IDN"
    	  							}
    	  						},

    	  						{
    	  							"@Symbol": "=",

    	  							"_1": {
    	  								"@FuncIdentifier": "val",
    	  								"dataset": "events",
    	  								"attribute": "ev"
    	  							},

    	  							"_2": {
    	  								"@FuncIdentifier": "const",
    	  								"value": "READING"
    	  							}
    	  						},

    	  						{
    	  							"@Symbol": "∈",

    	  							"_1": {
    	  								"@FuncIdentifier": "format",
    	  								"time": {
    	  									"@FuncIdentifier": "time",
    	  									"text": {
    	  										"@FuncIdentifier": "val",
    	  										"dataSet": "events",
    	  										"attribute": "at"
    	  									}
    	  								},

    	  								"pattern": "yyyy-MM-dd",
                                        "timezone": "Asia/Jakarta"
    	  							},

    	  							"_2": {
    	  								"@FuncIdentifier": "const",
    	  								"value": ["2018-12-31", "2019-01-01"]
    	  							}
    	  						}
    	  					]
    	  				},

    	  				"_1": {
    	  					"name": "summary"
    	  				}
    	  			}
    	  		},

    	  		{

    	  			"variable": "s2",

    	  			"operation": {

    	  				"@Symbol": "π",

    	  				"attributes": [{

    	  						"@FuncIdentifier": "as",

    	  						"function": {

    	  							"@FuncIdentifier": "val",

    	  							"attribute": "u"
    	  						},

    	  						"alias": "customer"
    	  					},

    	  					{

    	  						"@FuncIdentifier": "as",

    	  						"function": {

    	  							"@FuncIdentifier": "val",

    	  							"attribute": "ev"
    	  						},

    	  						"alias": "event"
    	  					},

    	  					{

    	  						"@FuncIdentifier": "as",

    	  						"function": {

    	  							"@FuncIdentifier": "val",

    	  							"attribute": "at"
    	  						},

    	  						"alias": "at"
    	  					},

    	  					{

    	  						"@FuncIdentifier": "as",

    	  						"function": {

    	  							"@FuncIdentifier": "val",

    	  							"attribute": "meta"
    	  						},

    	  						"alias": "meta"
    	  					}

    	  				],

    	  				"_1": {
    	  					"name": "s1"
    	  				}
    	  			}
    	  		}
    	  	],

    	  	"sink": {

    	  		"name": "test",

    	  		"relation": {
    	  			"name": "s2"
    	  		}
    	  	}
    	  }


        π σ ρ τ γ ∧ ∨ ¬ = ≠ ≥ ≤ ∩ ∪ - ⨯ ⨝ ⟕ ⟖ ⟗




        s1 <- σ { val(c1) > 10 and g(val(c2), const(v1), const(v2)) = 0 } (s0)
        s2 <- π { as(f(val(c1)), c1'), as(val(c2), c2), as(val(c3), c3) } (s1)
        s3 <- π { as(val(c1'), c1'), as(val(c2), c2) } (s2)
        s4 <- ρ { c2 -> c2' } (s3)
        s5 <- γ { [ alias(val(c1'), c1'') ], [ alias(sum(val(c2')), c2'') ] } (s4)

        [
            c1,
            c2,
            c3,
            c4,
            c5,
            c6,
            c7
        ]

        [
            c1',
            c2,
            c3
        ]

        [
            c1',
            c2
        ]

        [
            c1',
            c2'
        ]

        [
            c1'',
            c2''
        ]






            {

            }

            {
                c1' -> f(val(c1))
            }

            [ (c1', f(val(c1)), (c2, val(c2)), (c3, val(c3)) ]


            {
                c1' -> f(val(c1))
            }

            [ (c1', val(c1')), (c2, val(c2)) ]


            {
                c1' -> f(val(c1))
                c2' -> c2
            }




            [ (c1', val(c1')), (c2', val(c2)) ]


            {
                c1' -> f(val(c1))
                c2' -> c2
                c1'' -> val(c1')
                c2'' -> sum(val(c2'))
            }

            [ (c1', val(c1')), (c2'', sum(val(c2')) ]

 */


    @Test
    public void pushDown() {
        List<Predicate> predicates = new ArrayList<>();
        List<String> values = new ArrayList<>();
        values.add("a");
        values.add("b");
        values.add("c");

        predicates.add(new IsIn<String>(new Value(null, "col1"), new Constant<List<String>>(values)));
        predicates.add(new GreaterThan(new Value("s1", "col2"), new Constant<Integer>(3)));

        Disjunction disjunction = new Disjunction(predicates);
        System.out.println(disjunction.toPushDownExpression());
    }


    @Test
    public void parseDescription() {

//        Gson gson =  new GsonBuilder().registerTypeAdapter(Function.class, new FunctionJsonDeserializer())
//                .registerTypeAdapter(Predicate.class, new PredicateJsonDeserializer())
//                .registerTypeAdapter(Assignment.class, new AssignmentJsonDeserializer())
//                .create();
//
//        String description = "{\"expressions\":[{\"variable\":\"s1\",\"operation\":{\"@Symbol\":\"σ\",\"condition\":{\"@Symbol\":\"∧\",\"_1\":[{\"@Symbol\":\"=\",\"_1\":{\"@FuncIdentifier\":\"some\",\"of\":{\"@FuncIdentifier\":\"some\",\"of\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"frequency\"}}},\"_2\":{\"@FuncIdentifier\":\"const\",\"value\":10}},{\"@Symbol\":\"∈\",\"_1\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"event\"},\"_2\":{\"@FuncIdentifier\":\"const\",\"value\":[\"reading\",\"purchase\"]}}]},\"_1\":{\"name\":\"summary\"}}},{\"variable\":\"s2\",\"operation\":{\"@Symbol\":\"π\",\"attributes\":[{\"@FuncIdentifier\":\"as\",\"function\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"customer\"},\"alias\":\"customer\"}],\"_1\":{\"name\":\"s1\"}}}],\"sink\":{\"name\":\"test\",\"relation\":{\"name\":\"s2\"}}}";
//        Extraction extraction = gson.fromJson(description, Extraction.class);


//        String desc = "{\"expressions\":[{\"variable\":\"s1\",\"operation\":{\"@Symbol\":\"σ\",\"condition\":{\"@Symbol\":\"∧\",\"_1\":[{\"@Symbol\":\"=\",\"_1\":{\"@FuncIdentifier\":\"val\",\"dataset\":\"events\",\"attribute\":\"s\"},\"_2\":{\"@FuncIdentifier\":\"const\",\"value\":\"IDN\"}},{\"@Symbol\":\"=\",\"_1\":{\"@FuncIdentifier\":\"val\",\"dataset\":\"events\",\"attribute\":\"ev\"},\"_2\":{\"@FuncIdentifier\":\"const\",\"value\":\"READING\"}},{\"@Symbol\":\"∈\",\"_1\":{\"@FuncIdentifier\":\"format\",\"time\":{\"@FuncIdentifier\":\"time\",\"text\":{\"@FuncIdentifier\":\"val\",\"dataset\":\"events\",\"attribute\":\"at\"}},\"pattern\":\"yyyy-MM-dd\",\"timezone\":\"Asia/Jakarta\"},\"_2\":{\"@FuncIdentifier\":\"const\",\"value\":[\"2018-12-31\",\"2019-01-01\"]}}]},\"_1\":{\"name\":\"summary\"}}},{\"variable\":\"s2\",\"operation\":{\"@Symbol\":\"π\",\"attributes\":[{\"@FuncIdentifier\":\"as\",\"function\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"u\"},\"alias\":\"customer\"},{\"@FuncIdentifier\":\"as\",\"function\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"ev\"},\"alias\":\"event\"},{\"@FuncIdentifier\":\"as\",\"function\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"at\"},\"alias\":\"at\"},{\"@FuncIdentifier\":\"as\",\"function\":{\"@FuncIdentifier\":\"val\",\"attribute\":\"meta\"},\"alias\":\"meta\"}],\"_1\":{\"name\":\"s1\"}}}],\"sink\":{\"name\":\"test\",\"relation\":{\"name\":\"s2\"}}}";
//        Extraction extraction = Extraction.of(desc);
//        List<Step> steps = Serializer.serialize(extraction);
    }
}
