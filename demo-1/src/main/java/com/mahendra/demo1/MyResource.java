package com.mahendra.demo1;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
/// The Path for this endpoint is "GET http://localhost:8080/myresource [PLAIN TEXT]"
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getIt2() {
        return "<h2>Got it!</h2>";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getIt3() {
        return "<message>Got it!</message>";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt4() {
        return "{\"message\": \"Got it!\"}";
    }
    
    @POST
    public String create() {
    	System.out.println("Post method invoked !");
    	return "hello POST";
    }
    
    @DELETE
    public String delete() {
    	System.out.println("Delete method invoked !");
    	return "hello DELETE";
    }
    
    @PUT
    public String update() {
    	System.out.println("Put method invoked !");
    	return "hello PUT";
    }
}
