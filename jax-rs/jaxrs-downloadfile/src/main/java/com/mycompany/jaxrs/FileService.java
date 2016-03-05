/**
 * 
 */
package com.mycompany.jaxrs;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * @author colin
 *
 */
@Path("/file")
public class FileService {

	@GET
	@Path("/get")
	@Produces("text/plain")
	public Response getFile(){
		
		File file = new File("/Applications/dev-sandbox/projects/tech-training/jax-rs/JAX-RS-DownloadFile/file.log");
		ResponseBuilder response = Response.ok((Object)file);
		response.header("Content-Disposition", "attachment; file=\"file.log\"");
		return response.build();
	}
	
}
