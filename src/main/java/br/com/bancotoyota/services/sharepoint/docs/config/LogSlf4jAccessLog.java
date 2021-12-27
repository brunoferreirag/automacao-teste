package br.com.bancotoyota.services.sharepoint.docs.config;

import org.apache.catalina.valves.AbstractAccessLogValve;

import lombok.extern.slf4j.Slf4j;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.StringWriter;

@Slf4j
public class LogSlf4jAccessLog extends AbstractAccessLogValve {

    @Override
    protected void log(CharArrayWriter message) {
        try {
        	StringWriter stringWriter = new StringWriter();
			message.writeTo(stringWriter);
			log.info(stringWriter.toString());
        } catch (IOException ioe) {
            log.warn(sm.getString(
                    "accessLogValve.writeFail", message.toString()), ioe);
        }
    }
}
