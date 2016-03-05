/**
 * 
 */
package com.mycompany.jaxrs.headerparam;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * @author colin
 *
 */
@Path("/usersHeaderParam")
public class UserServiceHeaderParam {

	// inject directly
	
	@GET
	@Path("/getHeaderParam")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {
		return Response.status(200).entity("addUser is called, userAgent : " + userAgent).build();
	}
	
	// using Context (programmatically)
	
	@GET
	@Path("/getContext")
	public Response addUser(@Context HttpHeaders headers) {
		String userAgent = headers.getRequestHeader("user-agent").get(0);
		
		for(String header : headers.getRequestHeaders().keySet()) {
			System.out.println(header.toString());
		}
		
		return Response.status(200).entity("addUser is called, userAgent : " + userAgent)
				.build();
	}
	
}
