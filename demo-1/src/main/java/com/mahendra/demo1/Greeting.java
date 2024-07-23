package com.mahendra.demo1;

import jakarta.ws.rs.*;

@Path("/greet")
@Produces("text/plain")
public class Greeting {

	// http://localhost:8080/greet?name=Mahendra
	@GET
	public String greet(@QueryParam("name") String name) {
		if (name == null || name.trim().length() == 0) {
			name = "Unknown";
		}
		return "Hello " + name;
	}

	// Create REST Endpoint to accept THREE query params "principal", "rate" and
	// "duration"
	// Then calculate and print interest using formula : principal * rate /100 /12 *
	// duration
}
