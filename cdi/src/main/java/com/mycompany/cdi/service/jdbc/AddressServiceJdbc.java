package com.mycompany.cdi.service.jdbc;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.mycompany.cdi.repository.AddressRepository;
import com.mycompany.cdi.service.AddressService;

@Default
public class AddressServiceJdbc implements AddressService {

	@Inject
	@Default
	private AddressRepository addressRepository;
}
