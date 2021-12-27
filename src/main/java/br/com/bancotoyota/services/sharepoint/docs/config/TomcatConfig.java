package br.com.bancotoyota.services.sharepoint.docs.config;

import javax.servlet.Filter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        LogSlf4jAccessLog accessLog = new LogSlf4jAccessLog();
        accessLog.setPattern("%h %l %u \"%r\" %s %b"); // o mesmo que o COMMON_ALIAS só que sem o timestamp que já é colocado pelo Log4j2
        accessLog.setCondition("health");
        tomcat.addContextValves(accessLog);

        Logger logger = LogManager.getLogger("access-log");

        logger.log(Level.ERROR, logger.getName() + " log level: " + logger.getLevel());
        logger.warn("gerando access log");
        return tomcat;
    }
    
    @Autowired
    @Bean
    public FilterRegistrationBean<Filter> healthFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter((request, response, chain) -> {
            request.setAttribute("health", Boolean.TRUE);
            chain.doFilter(request, response);
        });
        registrationBean.addUrlPatterns("/actuator/*");

        return registrationBean;
    }
}
