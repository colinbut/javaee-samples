/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jajp.util;

import com.mycompany.jajp.Address;
import com.mycompany.jajp.Employee;

/**
 * Utility class to create employee objects
 * 
 * @author colin
 *
 */
public class EmployeeCreator {

	/**
	 * Creates a default employee object with some dummy data filled in
	 * 
	 * @return an employee
	 */
	public static Employee createDefaultEmployee() {
		
		Employee employee = new Employee();
		employee.setId(100);
		employee.setName("Joe Doe");
		employee.setPermanent(true);
		employee.setPosition("Software Tester");
		employee.setPhoneNumbers(new long[]{123456789});
		
		Address address = new Address();
		address.setStreet("123 Liverpool Street");
		address.setCity("London");
		address.setPostcode("EC245J");
		
		employee.setAddress(address);
		
		return employee;
		
	}
}
