package com.mycompany.jta.repository;

import com.mycompany.jta.model.Stock;

public interface StockRepository {

	String findStockName();
	
	boolean saveStock(Stock stock);
}
