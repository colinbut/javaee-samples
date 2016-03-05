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
@Path("/excel")
public class ExcelService {

	private static final String EXCEL_PATH = "/Applications/dev-sandbox/projects/tech-training/jax-rs/JAX-RS-DownloadFile/excel.xls";
	
	@GET
	@Path("/get")
	@Produces("application/vnd.ms-excel")
	public Response getFile(){
		
		File file = new File(EXCEL_PATH);
		ResponseBuilder response = Response.ok((Object)file);
		response.header("Content-Disposition", "attachment; file=\"excel_file.xls\"");
		return response.build();
	}
	
}
