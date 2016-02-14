/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jajp.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.junit.Test;

import static org.junit.Assert.*;

import com.mycompany.jajp.Address;
import com.mycompany.jajp.Employee;
import com.mycompany.jajp.util.EmployeeCreator;

/**
 * Test class testing the JAJP's Stream API
 * 
 * @author colin
 *
 */
public class StreamJsonTest {

	/**
	 * Test generating JSON from a Java Object and output to a JSON file
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testGenerateJsonFromObject() throws FileNotFoundException {
		
		int id = new Random().nextInt();
		
		JsonGenerator jsonGenerater = Json.createGenerator(new FileOutputStream("src/main/resources/employee-in-" + id));
		
		Employee employee = EmployeeCreator.createDefaultEmployee();
		Address address = employee.getAddress();
		
		jsonGenerater.writeStartObject(); // {
		jsonGenerater.write("id", employee.getId())
						.write("name", employee.getName())
						.write("position", employee.getPosition())
						.write("permanent", employee.isPermanent());
		
		jsonGenerater.writeStartObject("address")
					.write("street", address.getStreet())
					.write("postcode", address.getPostcode())
					.write("city", address.getCity())
					.writeEnd(); // end of address object
		
		jsonGenerater.writeStartArray("phoneNumbers");
		for(long number : employee.getPhoneNumbers()) {
			jsonGenerater.write(number);
		}
		jsonGenerater.writeEnd(); // end of phoneNumber 
		
		jsonGenerater.writeEnd(); // end of json }
		
		jsonGenerater.close();
		
	}
	
	/**
	 * Test parses JSON read from JSON file into Java objects
	 *  
	 * @throws FileNotFoundException
	 */
	@Test
	public void testParseJsonToObject() throws FileNotFoundException {
		
		String jsonFile = "src/main/resources/employee-in.json";
		
		JsonParser jsonParser = Json.createParser(new FileInputStream(jsonFile));
		
		Employee employee = new Employee();
		Address address = new Address();
		
		String keyName = null;
		List<Long> phoneNumbers = new ArrayList<>();
		
		while(jsonParser.hasNext()) {
			Event event = jsonParser.next();
			switch (event) {
			case KEY_NAME:
				keyName = jsonParser.getString();
				break;
			case VALUE_STRING:
				setStringValues(employee, address, keyName, jsonParser.getString());
				break;
			case VALUE_NUMBER:
				setNumberValues(employee, address, keyName, jsonParser.getLong(), phoneNumbers);
				break;
			case VALUE_FALSE:
				setBooleanValues(employee, address, keyName, false);
				break;
			case VALUE_TRUE:
				setBooleanValues(employee, address, keyName, true);
				break;
			case VALUE_NULL:
				// don't set anything
				break;
			default:
				// looking for other events
			}
		}
		
		employee.setAddress(address);
		long[] numbers = new long[phoneNumbers.size()];
		int index = 0;
		for(Long l : phoneNumbers) {
			numbers[index++] = l;
		}
		employee.setPhoneNumbers(numbers);
		System.out.println(employee);
		
		jsonParser.close();
	}
	
	private void setNumberValues(Employee employee, Address address, String key, 
			long value, List<Long> phoneNumbers) {
		switch (key) {
		case "id":
			employee.setId((int)value);
			break;
		case "phoneNumbers":
			phoneNumbers.add(value);
			break;
		default:
			fail(getUnknownKeyMessage(key));
		}
	}
	
	private void setBooleanValues(Employee employee, Address address, String key, boolean value) {
		if(key.equals("permanent")) {
			employee.setPermanent(value);
		} else {
			fail(getUnknownKeyMessage(key));
		}
		
	}
	
	private void setStringValues(Employee employee, Address address, String key, String value) {
		switch(key) {
		case "name":
			employee.setName(value);
			break;
		case "position":
			employee.setPosition(value);
			break;
		case "city":
			address.setCity(value);
			break;
		case "street":
			address.setStreet(value);
			break;
		case "postcode": 
			address.setPostcode(value);
			break;
			default:
				fail(getUnknownKeyMessage(key));
				
		}
	}
	
	private String getUnknownKeyMessage(String key) {
		return "Unknown element with key = " + key;
	}
}
