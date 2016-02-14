package com.mycompany.cdi.repository.jpa;

import javax.enterprise.inject.Alternative;

import com.mycompany.cdi.repository.OrderRepository;

@Alternative
public class OrderRepositoryJpa implements OrderRepository {

}
