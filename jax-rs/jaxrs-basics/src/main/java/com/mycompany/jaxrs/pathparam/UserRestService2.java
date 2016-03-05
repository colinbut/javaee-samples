/**
 * 
 */
package com.mycompany.jaxrs.pathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author colin
 *
 */
@Path("/usersi")
public class UserRestService2 {

	// Single Parameter
	
	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") String id ){
		return Response.status(200).entity("getUserById is called, id : " + id).build();
	}
	
	
	// Multiple Parameter
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month,
			@PathParam("day") int day
			) {
		String date = year + "/" + month + "/" + day;
		return Response.status(200).entity("getUserHistory is called year/month/day : " + 
				date).build();
	}
	
}
