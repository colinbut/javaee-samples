package com.mycompany.cdi.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

import com.mycompany.cdi.annotations.Jpa;
import com.mycompany.cdi.service.ItemService;

@Named("itemServlet")
public class ItemServlet extends HttpServlet {

	private static final long serialVersionUID = -8150172946959312653L;

	private ItemService itemService;
	
	@Inject
	public void setItemService(@Jpa ItemService itemService) {
		this.itemService = itemService;
	}
}
