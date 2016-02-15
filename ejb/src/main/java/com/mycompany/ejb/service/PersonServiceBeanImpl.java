package com.mycompany.ejb.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.ejb.bean.PersonBean;
import com.mycompany.ejb.repository.PersonRepository;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PersonServiceBeanImpl implements PersonServiceBean {

	private static final Logger logger = LoggerFactory.getLogger(PersonServiceBeanImpl.class);
	
	@EJB
	private PersonRepository personRepository;

	public void sendPerson(PersonBean person) {
		
	}

	public void storePerson(PersonBean person) {
		
	}

	public void printPerson() {
		
	}
	
}
