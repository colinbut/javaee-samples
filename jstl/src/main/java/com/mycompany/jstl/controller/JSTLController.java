/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jstl.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.jstl.model.Product;

/**
 * {@link JSTLController} class
 * 
 * @author colin
 *
 */
@Controller
public class JSTLController {

	@RequestMapping(value = "/coretags", method = RequestMethod.GET)
	public String showCoreTagsPage(ModelMap map) {
		
		List<Product> productList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setName("Name" + i);
			product.setDescription("Description" + i);
			productList.add(product);
		}
		
		Map<String, String> countryCurrencyMap = new HashMap<String, String>();
		countryCurrencyMap.put("UK", "Pounds");
		countryCurrencyMap.put("US", "Dollars");
		countryCurrencyMap.put("JP", "Yen");
		countryCurrencyMap.put("ZH", "Ren Man Bi");
		
		map.addAttribute("productList", productList);
		map.addAttribute("countryCurrencyMap", countryCurrencyMap);
		
		return "coretags";
	}
	
	@RequestMapping(value = "/coretagsParam/{productId}", method = RequestMethod.GET)
	public String showCoreTagsPageWithParams(@RequestParam("productId") int productId) {
		System.out.println(productId);
		return "";
	}
	
	@RequestMapping(value = "/formatting", method=RequestMethod.GET)
	public String showFormattingTagsPage(ModelMap map) {
		List<Product> productList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setName("Name" + i);
			product.setDescription("Description" + i);
			product.setPrice(new BigDecimal(1.00));
			productList.add(product);
		}
		
		Map<String, String> countryCurrencyMap = new HashMap<String, String>();
		countryCurrencyMap.put("UK", "Pounds");
		countryCurrencyMap.put("US", "Dollars");
		countryCurrencyMap.put("JP", "Yen");
		countryCurrencyMap.put("ZH", "Ren Man Bi");
		
		map.addAttribute("productList", productList);
		map.addAttribute("countryCurrencyMap", countryCurrencyMap);
		
		return "formatting";
	}
}
