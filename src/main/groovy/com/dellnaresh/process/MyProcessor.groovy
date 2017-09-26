package com.dellnaresh.process

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.http.entity.mime.MultipartEntityBuilder

class MyProcessor implements Processor {
    @Override
    void process(Exchange exchange) throws Exception {
        File file=exchange.getIn().getBody(File.class)
        String fileName=exchange.getIn().getHeader(Exchange.FILE_NAME,String.class)
        MultipartEntityBuilder entity=MultipartEntityBuilder.create()
        entity.addBinaryBody("file", file)
        entity.addTextBody("name", fileName)
        exchange.getOut().setBody(entity.build())

    }
}
