package com.mycompany.cdi.service.jdbc;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.mycompany.cdi.repository.ItemRepository;
import com.mycompany.cdi.service.ItemService;

@Default
public class ItemServiceJdbc implements ItemService {

	@Inject
	private ItemRepository itemRepository;
}
