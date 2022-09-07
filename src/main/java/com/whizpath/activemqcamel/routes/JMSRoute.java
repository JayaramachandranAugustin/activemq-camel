package com.whizpath.activemqcamel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ExpressionSubElementDefinition;
import org.apache.camel.processor.aggregate.GroupedBodyAggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class JMSRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        int i=0;
        from("timer://test?period=100").routeId("GenerateMessage")
                .transform()
                .constant("message ").log("message").to("direct:messageSource");
        from("direct:messageSource").routeId("AggregateMessage").log("data received ${body}").aggregate(new GroupedBodyAggregationStrategy()).constant(true)
                .completionTimeout(100).to("direct:processMessage");

        from("direct:processMessage").routeId("SplitMessage ").log("data received to split ${body}").split(body()).to("direct:splitMessage");

        from("direct:splitMessage").routeId("SendMessage ").log("Message sent to test queue ${body}").to("jmsc:queue:test");
    }
}
