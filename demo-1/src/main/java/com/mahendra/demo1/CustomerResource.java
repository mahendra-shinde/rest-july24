package com.mahendra.demo1;

import jakarta.ws.rs.*;
import java.util.*;

@Path("/api/customer")
@Produces("application/json")
public class CustomerResource {
	
	@GET
	public Customer findCustomer(@QueryParam("id") String id) {
        Customer c = new Customer();
        c.setCustId(id);
        c.setFirstName("Mahendra");
        c.setEmail("mahendra-shinde@outlook.com");
        c.setLastName("Shinde");
        return c;
	}
	
	@GET
	@Path("/all")
	public List<Customer> findAll(){
		List<Customer> customers = new LinkedList<>();
		customers.add(new Customer("Mahendra","Shinde","C001","mail@server.com"));
		customers.add(new Customer("John","Doe","C002","john@server.com"));
		return customers;
	}
}
