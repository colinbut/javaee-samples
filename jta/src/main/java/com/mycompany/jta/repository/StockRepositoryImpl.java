package com.mycompany.jta.repository;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.jta.model.Stock;

@Dependent
public class StockRepositoryImpl implements StockRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String findStockName() {
		Stock stock = entityManager.find(Stock.class, 1);
		return stock.getStockName();
	}

	@Override
	public boolean saveStock(Stock stock) {
		entityManager.persist(stock);
		return true;
	}
	
	
}
