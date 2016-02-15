package com.mycompany.ejb;

import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.ejb.service.PersonServiceBean;

@Singleton
@Startup
public class PersonApplication {

	private static final Logger logger = LoggerFactory.getLogger(PersonApplication.class);
	
	@EJB
	private PersonServiceBean personService;
	
	@PostActivate
	private void init() {
		
	}
}
