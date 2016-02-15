package com.mycompany.ejb.bean;

import javax.ejb.MessageDriven;

@MessageDriven
public class PersonBean {

	private String firstname;
	private String secondname;
	private int age;
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSecondname() {
		return secondname;
	}
	
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
