/**
 * 
 */
package com.mycompany.jaxrs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author colin
 *
 */
public class JerseyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JerseyClient.get();
		//JerseyClient.post();
	}
	
	public static void get(){
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/JAX-RS-JSON-Jersey-Jackson/rest/json/metallica/get");
		
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new RuntimeException("Failed: HTTP error code: " + response.getStatus());
		}
		
		String output = response.getEntity(String.class);
		
		System.out.println("Output from server...  \n");
		System.out.println(output);
		
	}
	
	public static void post(){
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/JAX-RS-JSON-Jersey-Jackson/rest/json/metallica/post");
		
		String input = "{\"singer\":\"Metallica\",\"title\":\"Fade to Black\"}";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
		if(response.getStatus() != 200){
			throw new RuntimeException("Failed: HTTP error code: " + response.getStatus());
		}
		
		String output = response.getEntity(String.class);
		
		System.out.println("Output from server...  \n");
		System.out.println(output);
		
	}

}
