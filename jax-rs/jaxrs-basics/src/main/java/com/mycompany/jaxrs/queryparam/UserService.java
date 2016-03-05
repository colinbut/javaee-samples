/**
 * 
 */
package com.mycompany.jaxrs.queryparam;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author colin
 *
 */
@Path("/users")
public class UserService {

	@GET
	@Path("/query")
	public Response getUsers(
			@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy
			){
		return Response.status(200).entity("getUsers is called, from : " +
			from + ", to : " + to + ", orderBy" + orderBy.toString()).build();
	}
	
	// Programmatic Query Param
	
	@GET
	@Path("/query2")
	public Response getUsersQueryProgrammatically(@Context UriInfo info){
		
		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
		
		return Response.status(200).entity("getUsers is called, from : " +
				from + ", to : " + to + ", orderBy" + orderBy.toString()).build();
	}
	
	// Default Value - Optional Parameter
	
	@GET
	@Path("/query3")
	public Response getUsersDefaultValue(
			@DefaultValue("1000") @QueryParam("from") int from,
			@DefaultValue("999") @QueryParam("to") int to,
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy
			){
		return Response.status(200).entity("getUsers is called, from : " +
				from + ", to : " + to + ", orderBy" + orderBy.toString()).build();
	}
	
}
