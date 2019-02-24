package com.kakaopage.crm.extraction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

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
		  "expressions": [{
				  "variable": "s1",

				  "operation": {
					  "operator": "σ",
					  "operands": {
						  "condition": {
							  "operator": "∧",
							  "operands": {
								  "predicates": [{
										  "operator": "=",
										  "operands": {
											  "f1": {
												  "operator": "some",
												  "operands": {
													  "of": {
														  "operator": "col",
														  "operands": {
															  "name": "frequency"
														  }
													  }
												  }
											  },

											  "f2": {
												  "operator": "constant",
												  "operands": {
													  "value": 10
												  }
											  }
										  }
									  },

									  {
										  "operator": "∈",
										  "operands": {
											  "f1": {
												  "operator": "col",
												  "operands": {
													  "name": "event"
												  }
											  },

											  "f2": {
												  "operator": "constant",
												  "operands": {
													  "value": ["reading", "purchase"]
												  }
											  }
										  }
									  }
								  ]
							  }
						  },

						  "relation": {
							  "name": "summary"
						  }
					  }
				  }
			  },

			  {
				  "variable": "s2",
				  "operation": {
					  "operator": "π",
					  "operands": {
						  "columns": ["customer"],
						  "relation": {
							  "name": "history"
						  }
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


 */

    @Test
    public void parseDescription() {


        Gson gson =  new GsonBuilder()
                .registerTypeAdapter(Function.class, new FunctionJsonDeserializer())
                .registerTypeAdapter(Predicate.class, new PredicateJsonDeserializer())
                .registerTypeAdapter(Assignment.class, new AssignmentJsonDeserializer())
                .create();

        String description = "{\"expressions\":[{\"variable\":\"s1\",\"operation\":{\"operator\":\"σ\",\"operands\":{\"condition\":{\"operator\":\"∧\",\"operands\":{\"predicates\":[{\"operator\":\"=\",\"operands\":{\"f1\":{\"operator\":\"some\",\"operands\":{\"of\":{\"operator\":\"col\",\"operands\":{\"name\":\"frequency\"}}}},\"f2\":{\"operator\":\"constant\",\"operands\":{\"value\":10}}}},{\"operator\":\"∈\",\"operands\":{\"f1\":{\"operator\":\"col\",\"operands\":{\"name\":\"event\"}},\"f2\":{\"operator\":\"constant\",\"operands\":{\"value\":[\"reading\",\"purchase\"]}}}}]}},\"relation\":{\"name\":\"summary\"}}}},{\"variable\":\"s2\",\"operation\":{\"operator\":\"π\",\"operands\":{\"columns\":[\"customer\"],\"relation\":{\"name\":\"history\"}}}}],\"sink\":{\"name\":\"test\",\"relation\":{\"name\":\"s2\"}}}";
        Extraction extraction = gson.fromJson(description, Extraction.class);
        extraction.toString();
    }
}
