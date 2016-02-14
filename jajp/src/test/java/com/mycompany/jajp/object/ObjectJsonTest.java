/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jajp.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import org.junit.Test;

import com.mycompany.jajp.Employee;
import com.mycompany.jajp.Address;
import com.mycompany.jajp.util.EmployeeCreator;

/**
 * Test class to test the JAJP's Object API
 * 
 * @author colin
 *
 */
public class ObjectJsonTest {

	/**
	 * Test reading JSON from JSON file into a Java object
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testReadJsonToObject() throws FileNotFoundException {
		
		String jsonFile = "src/main/resources/employee-in.json";
		JsonReader jsonReader = Json.createReader(new FileInputStream(jsonFile));
		JsonObject jsonObject = jsonReader.readObject();
		
		jsonReader.close();
		
		Employee employee = new Employee();
		employee.setId(jsonObject.getInt("id"));
		employee.setName(jsonObject.getString("name"));
		employee.setPermanent(jsonObject.getBoolean("permanent"));
		employee.setPosition(jsonObject.getString("position"));
		
		JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
		long[] numbers = new long[jsonArray.size()];
		int index = 0;
		for(JsonValue value : jsonArray) {
			numbers[index++] = Long.parseLong(value.toString());
		}
		
		employee.setPhoneNumbers(numbers);
		
		JsonObject innerJsonObject = jsonObject.getJsonObject("address");
		Address address = new Address();
		address.setStreet(innerJsonObject.getString("street"));
		address.setCity(innerJsonObject.getString("city"));
		address.setPostcode(innerJsonObject.getString("postcode"));
		
		employee.setAddress(address);
		
		System.out.println(employee);
		
	}
	
	/**
	 * Test writing an object to JSON data into a JSON file
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testWriteObjectToJson() throws FileNotFoundException {
		
		Employee employee = EmployeeCreator.createDefaultEmployee();
		Address address = employee.getAddress();
		
		JsonObjectBuilder employeeBuilder = Json.createObjectBuilder();
		JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
		JsonArrayBuilder phoneNumbersBuilder = Json.createArrayBuilder();
		
		for(long phoneNumber : employee.getPhoneNumbers()) {
			phoneNumbersBuilder.add(phoneNumber);
		}
		
		addressBuilder.add("street", address.getStreet())
						.add("city", address.getCity())
						.add("postcode", address.getPostcode());
		
		employeeBuilder.add("id", employee.getId())
						.add("name", employee.getName())
						.add("permanent", employee.isPermanent())
						.add("position", employee.getPosition())
						.add("address", addressBuilder)
						.add("phoneNumbers", phoneNumbersBuilder);
		
		JsonObject employeeObject = employeeBuilder.build();
		JsonWriter jsonWriter = Json.createWriter(
								new FileOutputStream("src/main/resources/employee-out.json"));
		jsonWriter.writeObject(employeeObject);
		jsonWriter.close();
		
	}
}
