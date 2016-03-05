/**
 * 
 */
package com.mycompany.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author colin
 *
 */
@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMessage(@PathParam("param") String msg) {
		String message = "Jersey Says: " + msg;
		return Response.status(200).entity(message).build();
	}
	
	
}
