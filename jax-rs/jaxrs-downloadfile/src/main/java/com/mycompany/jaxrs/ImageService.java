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
@Path("/image")
public class ImageService {

	private static final String IMAGE_PATH = "/Applications/dev-sandbox/projects/tech-training/jax-rs/JAX-RS-DownloadFile/image.png";
	
	@GET
	@Path("/get")
	@Produces("image/png")
	public Response getFile(){
		
		File file = new File(IMAGE_PATH);
		ResponseBuilder response = Response.ok((Object)file);
		response.header("Content-Disposition", "attachment; file=\"image_from_server.png\"");
		return response.build();
	}
}
