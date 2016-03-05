/**
 * 
 */
package com.mycompany.jaxrs.matrixparam;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/**
 * JAX-RS MatrixParam example
 * 
 * @author colin
 *
 */
@Path("/books")
public class BookService {

	@GET
	@Path("/{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {
		
		return Response.status(200)
				.entity("getBooks is called, year : " + year
						+ ", author : " + author + ", country : " + country)
						.build();
	}
	
}
