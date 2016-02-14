package com.mycompany.cdi.service.jpa;

import javax.inject.Inject;

import com.mycompany.cdi.annotations.Jpa;
import com.mycompany.cdi.repository.AddressRepository;
import com.mycompany.cdi.service.AddressService;

@Jpa
public class AddressServiceJpa implements AddressService {

	@Inject
	@Jpa
	private AddressRepository addressRepository;
}
