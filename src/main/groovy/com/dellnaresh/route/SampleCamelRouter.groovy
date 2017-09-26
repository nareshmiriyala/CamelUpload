package com.dellnaresh.route

import com.dellnaresh.process.MyProcessor
import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class SampleCamelRouter extends RouteBuilder
{
    @Override
    void configure() throws Exception {
        from("file:/tmp/input?noop=true")
        .process(new MyProcessor())
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))

                .setHeader(Exchange.CONTENT_TYPE, constant("multipart/form-data"))
        .to("http4://localhost:8097/upload")

    }
}
