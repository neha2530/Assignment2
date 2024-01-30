package com.example.demo.configuration;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;



@Component
class RestApi extends RouteBuilder {
	
	@Value("${minioapp.api.path}")
	String contextPath;
	
    @Override
    public void configure() {
        CamelContext context = new DefaultCamelContext();
        
    	restConfiguration()
    	  .contextPath(contextPath) 
    	  .port(8080)
    	  .enableCORS(true)
    	  .apiContextPath("/api-doc")
    	  .apiProperty("api.title", "Test REST API")
    	  .apiProperty("api.version", "v1")
    	  .apiContextRouteId("doc-api")
    	  .component("servlet")
    	  .bindingMode(RestBindingMode.json)
    	  ;
    	
    	
    	rest("/api/")
    	  .id("api-route")
    	  .consumes("application/json")
    	  .post("/bean")
    	  .bindingMode(RestBindingMode.json_xml)
    	  .type(Map.class)
    	  
    	  .to("direct:remoteService");
    	
		/*
		 * from("direct:remoteService") .routeId("direct-route") .tracing()
		 * .log(">>> ${body.id}") .log(">>> ${body.name}")
		 * .transform().simple("Hello ${in.body.name}")
		 * .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
		 * .marshal().jaxb("com.example.demo.jaxb");
		 */
    }
}
