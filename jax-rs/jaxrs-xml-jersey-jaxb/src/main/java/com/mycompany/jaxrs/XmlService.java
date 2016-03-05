/**
 * 
 */
package com.mycompany.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author colin
 *
 */
@Path("/xml/customer")
public class XmlService {

	@GET
	@Path("/{pin}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerInXML(@PathParam("pin") int pin) {
		Customer customer = new Customer();
		customer.setName("Colin");
		customer.setPin(pin);
		return customer;
	}
	
}
