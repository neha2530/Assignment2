package com.example.demo.resource;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.DocumentService;

/*import com.javatechie.spring.camel.api.dto.Order;
import com.javatechie.spring.camel.api.processor.OrderProcessor;
import com.javatechie.spring.camel.api.service.MinioService;*/

@Component
public class ApplicationResource extends RouteBuilder {

	/*
	 * @Autowired private MinioService service;
	 * 
	 * @BeanInject private OrderProcessor processor;
	 */
	
	@Autowired private DocumentService service;

	@Override
	public void configure() throws Exception {
		/*
		 * from("minio:input-test?autoCreateBucket=true")
		 * .log("Received a message from Minio") .process(exchange -> { byte[] bytes =
		 * exchange.getIn().getBody(byte[].class);
		 * service.savePdfDocument("Resume"+Math.random()+".pdf", bytes);
		 * System.out.println(exchange); });
		 * 
		 * 
		 * from("minio:update-test?autoCreateBucket=true")
		 * .log("Received a message from Minio") .process(exchange -> { byte[] bytes =
		 * exchange.getIn().getBody(byte[].class);
		 * service.savePdfDocument("Resume"+System.currentTimeMillis()+".pdf", bytes);
		 * System.out.println(exchange); })
		 * 
		 * .to("minio://delete-test?accessKey=minioadmin&secretKey=minioadmin");
		 */
         //  .to("log:MinioLog");
		   
//		   from("minio:delete-test?autoCreateBucket=true")
//           .log("Received a message from Minio")
//           .process(exchange -> {
//        	   byte[] bytes = exchange.getIn().getBody(byte[].class);
//        	   service.savePdfDocument("Resume"+System.currentTimeMillis()+".pdf", bytes);
//        	   System.out.println(exchange);
//           })
//           
//          .to("log:MinioLog");
		   
			/*
			 * from("file:src/main/resources/input?recursive=true")
			 * .log("Uploading file to MinIO") .setHeader(MinioConstants.OBJECT_NAME,
			 * constant("file"+System.currentTimeMillis()+".pdf"))
			 * .to("minio://input-test?accessKey=minioadmin&secretKey=minioadmin");
			 */
		  
			
			  restConfiguration().component("servlet").port(8080).host("localhost").
			  bindingMode(RestBindingMode.json);
			  
			  from("direct:getData")
			    .routeId("getDataRoute")
			    .log("Received GET request in getDataRoute")
			    .setBody().constant("Hello, this is the response for your GET request");



				/*
				 * from("direct:getData") .process(ex -> { List<Document> docs
				 * =service.getAll(); ex.getMessage().setBody(docs); });
				 */
			 
//		  from("file:src/main/resources?fileName=Resume.pdf")
//		  .log("Uploading file to MinIO") 
//		  .setHeader(MinioConstants.OBJECT_NAME, constant("Resume.pdf"))
//		  .to("minio://input-test?accessKey=minioadmin&secretKey=minioadmin");
//		  
//		 
//		  from("file:src/main/resources?fileName=grant.sql")
//		  .log("Uploading file to MinIO") 
//		  .setHeader(MinioConstants.OBJECT_NAME, constant("grant.sql"))
//		  .to("minio://input-test?accessKey=minioadmin&secretKey=minioadmin");

		
   }
		
				// TODO Auto-generated method stub
				
			}
	    
	
	
		/*
		 * restConfiguration().component("servlet").port(8080).host("localhost").
		 * bindingMode(RestBindingMode.json);
		 * 
		 * rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
		 * .setBody(constant("Welcome to spring camel project")).endRest();
		 * 
		 * 
		 * rest().get("/upload-to-minio").produces(MediaType.APPLICATION_JSON_VALUE).
		 * route().setBody(() -> service.uploadFileToMinio()) .endRest();
		 * 
		 * rest().get("/read-from-minio").produces(MediaType.APPLICATION_JSON_VALUE).
		 * route().setBody(() -> service.getFileFromMinio()) .endRest();
		 * 
		 * rest().post("/addOrder").consumes(MediaType.APPLICATION_JSON_VALUE).type(
		 * Order.class).outType(Order.class) .route().process(processor).endRest();
		 */
	


