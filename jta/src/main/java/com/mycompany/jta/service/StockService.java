package com.mycompany.jta.service;

import com.mycompany.jta.model.Stock;

public interface StockService {

	String retrieveStockName();
	
	String retrieveStockNameFromDatabase();
	
	void insertStock(Stock stock) throws Exception ;
}
