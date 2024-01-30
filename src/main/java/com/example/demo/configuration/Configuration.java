package com.example.demo.configuration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

public class Configuration {
	@Value("${minioapp.api.path}")
	String contextPath;

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean servlet = new ServletRegistrationBean
	      (new CamelHttpTransportServlet(), contextPath+"/*");
	    servlet.setName("CamelServlet");
	    return servlet;
	}
}
