/**
 * 
 */
package com.mycompany.bean_validation;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Another example of Bean Validation.
 * 
 * A class (JavaBean/POJO/ or even entity) is being validated...
 * 
 * This sample uses field type bean validation
 * 
 * 
 * @author colin
 *
 */
public class Member {

	@NotNull
	private String firstname;
	
	@NotNull
	private String lastname;
	
	@NotNull
	@Min(1)
	@Max(150)
	private int age;
	
	@Size(min = 10, max = 50)
	@NotNull
	private String address;
	
	@Email // uses Hibernate Constraints
	@NotNull
	private String email;
	
	@NotNull
	private BigDecimal telNo;
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public BigDecimal getTelNo() {
		return telNo;
	}
	
	public void setTelNo(BigDecimal telNo) {
		this.telNo = telNo;
	}
}
