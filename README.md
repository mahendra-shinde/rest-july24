# Introduction to RESTful Services
- **Definition**: REST (Representational State Transfer) is an architectural style for designing networked applications.
- **Core Principles**:
  - Stateless operations
  - Uniform interface (using standard HTTP methods)
  - Resource-based (every resource is identified by a URL)
  - Representations (resources can be represented in different formats like JSON, XML)
  - Hypermedia as the Engine of Application State (HATEOAS)

## Setting Up the Environment
- **Prerequisites**:
  - Java Development Kit (JDK) 8 or later
  - Maven 3.6.0 or later
  - IDE (e.g., IntelliJ IDEA, Eclipse)

## Project Structure
- **Maven Project Structure**:
  ```
  my-restful-service/
  ├── src/
  │   ├── main/
  │   │   ├── java/
  │   │   │   └── com/
  │   │   │       └── example/
  │   │   │           └── rest/
  │   │   │               ├── ApplicationConfig.java [OPTIONAL]
  │   │   │               ├── MyResource.java
  │   │   │               └── model/
  │   │   │                   └── MyModel.java
  │   │   └── resources/
  │   │       └── META-INF/
  └── pom.xml
  ```

#### Creating the Maven Project
1. **Generate the Maven Project**:
   ```bash
   mvn archetype:generate -DgroupId=com.mahendra -DartifactId=my-demo1 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   ```

2. **Add Dependencies in `pom.xml`**:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.glassfish.jersey.core</groupId>
           <artifactId>jersey-server</artifactId>
           <version>3.1.0</version>
       </dependency>
       <dependency>
           <groupId>org.glassfish.jersey.containers</groupId>
           <artifactId>jersey-container-servlet-core</artifactId>
           <version>3.1.0</version>
       </dependency>
       <dependency>
           <groupId>org.glassfish.jersey.media</groupId>
           <artifactId>jersey-media-json-binding</artifactId>
           <version>3.1.0</version>
       </dependency>
       <dependency>
           <groupId>javax.ws.rs</groupId>
           <artifactId>javax.ws.rs-api</artifactId>
           <version>2.1</version>
       </dependency>
   </dependencies>
   ```

#### Creating RESTful Services with Jersey
 
1. **Creating a Resource Class**:
   - `MyResource.java`
     ```java
     package com.mahendra.rest;

     import javax.ws.rs.GET;
     import javax.ws.rs.Path;
     import javax.ws.rs.Produces;
     import javax.ws.rs.core.MediaType;

     @Path("/hello")
     public class MyResource {

         @GET
         @Produces(MediaType.APPLICATION_JSON)
         public String getHello() {
             return "{\"message\":\"Hello, World!\"}";
         }
     }
     ```

3. **Model Class**:
   - `MyModel.java`
     ```java
     package com.mahendra.rest.model;

     public class MyModel {
         private String id;
         private String name;

         // Getters and Setters
         public String getId() {
             return id;
         }

         public void setId(String id) {
             this.id = id;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }
     }
     ```

#### Building and Running the Application

1. **Build the Project**:
   ```bash
   mvn clean install
   ```

2. **Running the Application**:
   - Use a container like Apache Tomcat or a lightweight server like Grizzly.
   - Example with Grizzly:
     ```java
     import org.glassfish.jersey.server.ResourceConfig;
     import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
     import org.glassfish.grizzly.http.server.HttpServer;

     import java.net.URI;

     public class Main {
         public static void main(String[] args) {
             ResourceConfig config = new ResourceConfig().packages("com.mahendra.rest");
             URI uri = URI.create("http://localhost:8080/");
             HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
             Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
         }
     }
     ```

3. **Accessing the API**:
   - Open a browser or use a tool like Postman to access `http://localhost:8080/hello`.

#### Advanced Topics

1. **Path Parameters**:
   - Example:
     ```java
     @Path("/hello/{name}")
     public class MyResource {
         @GET
         @Produces(MediaType.APPLICATION_JSON)
         public String getHello(@PathParam("name") String name) {
             return "{\"message\":\"Hello, " + name + "!\"}";
         }
     }
     ```

2. **Query Parameters**:
   - Example:
     ```java
     @Path("/hello")
     public class MyResource {
         @GET
         @Produces(MediaType.APPLICATION_JSON)
         public String getHello(@QueryParam("name") String name) {
             return "{\"message\":\"Hello, " + name + "!\"}";
         }
     }
     ```

3. **Handling HTTP Methods**:
   - Example for POST:
     ```java
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Response createModel(MyModel model) {
         // Logic to save model
         return Response.status(Response.Status.CREATED).entity(model).build();
     }
     ```

4. **Exception Handling**:
   - Custom Exception Mapper:
     ```java
     @Provider
     public class CustomExceptionMapper implements ExceptionMapper<Throwable> {
         @Override
         public Response toResponse(Throwable exception) {
             return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(exception.getMessage())
                            .type(MediaType.APPLICATION_JSON)
                            .build();
         }
     }
     ```

5. **Filters and Interceptors**:
   - Example of a Logging Filter:
     ```java
     @Provider
     public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
         @Override
         public void filter(ContainerRequestContext requestContext) throws IOException {
             System.out.println("Request: " + requestContext.getUriInfo().getRequestUri());
         }

         @Override
         public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
             System.out.println("Response: " + responseContext.getStatus());
         }
     }
     ```


- **Further Reading**: Suggested materials for advanced learning.
  - Official [Jersey Documentation](https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest31x/index.html)
  - RESTful Web Services by Leonard Richardson and Sam Ruby
  - RESTful Java with JAX-RS by Bill Burke
