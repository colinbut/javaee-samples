/**
 * 
 */
package com.mycompany.bean_validation;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Bean Validation example class
 * 
 * Uses reference implementation - Hibernate Validator
 * 
 * @author colin
 *
 */
public class Baby {

	private String firstname;
	private String lastname;
	private Gender gender;
	private String emailAddress;
	private Date dateOfBirth;
	private int numberOfCarsOwn;
	private String address;
	private int numberOfHousesOwn;
	private Date dateOfDeath;
	private boolean deceased;
	private boolean isNewBorn;
	private Object pram;
	private BigDecimal hospitalStayingCostIncurred;
	
	@NotNull(message = "Firstname is compulsory")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Firstname has invalid characters")
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@NotNull(message = "Lastname is compulsory")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Lastname has invalid characters")
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@NotNull(message = "Gender is compulsory")
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Email // Hibernate Constraint
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Past(message = "Date of Birth must be in the past")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Digits(integer = 2, fraction = 0)
	public int getNumberOfCarsOwn() {
		return numberOfCarsOwn;
	}

	public void setNumberOfCarsOwn(int numberOfCarsOwn) {
		this.numberOfCarsOwn = numberOfCarsOwn;
	}

	@Size(min = 10, max = 50, message = "Address size not correct")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Min(value = 0)
	@Max(2)
	public int getNumberOfHousesOwn() {
		return numberOfHousesOwn;
	}

	public void setNumberOfHousesOwn(int numberOfHousesOwn) {
		this.numberOfHousesOwn = numberOfHousesOwn;
	}

	@Future(message = "Date of death must be in the future")
	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	@AssertFalse(message = "This baby should not be deceased")
	public boolean isDeceased() {
		return deceased;
	}

	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}

	@AssertTrue(message = "This baby should be a new born!")
	public boolean isNewBorn() {
		return isNewBorn;
	}

	public void setNewBorn(boolean isNewBorn) {
		this.isNewBorn = isNewBorn;
	}

	@Null
	public Object getPram() {
		return pram;
	}

	public void setPram(Object pram) {
		this.pram = pram;
	}

	@DecimalMin("20.00")
	@DecimalMax("120.00")
	public BigDecimal getHospitalStayingCostIncurred() {
		return hospitalStayingCostIncurred;
	}

	public void setHospitalStayingCostIncurred(
			BigDecimal hospitalStayingCostIncurred) {
		this.hospitalStayingCostIncurred = hospitalStayingCostIncurred;
	}
}
