package com.mycompany.ejb.service;

import javax.ejb.Local;

import com.mycompany.ejb.bean.PersonBean;

@Local
public interface PersonServiceBean {

	void sendPerson(PersonBean person);
	
	void storePerson(PersonBean person);
	
	void printPerson();
}
