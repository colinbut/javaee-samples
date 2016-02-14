package com.mycompany.jta.service;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.jta.exception.GenericException;
import com.mycompany.jta.exception.StockException;
import com.mycompany.jta.model.Stock;
import com.mycompany.jta.repository.StockRepository;

@Model
@Transactional(Transactional.TxType.MANDATORY) // CMT (Container-Managed Transactions)
public class StockServiceImpl implements StockService {

	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
		
	@Inject
	private StockRepository stockRepository;
	
	
	@Override
	@Transactional(Transactional.TxType.NEVER)
	public String retrieveStockName() {
		logger.info("Before executing retrieveStockName method");	
		String stockName = stockRepository.findStockName();
		logger.info("After executing retrieveStockName method");
		return stockName;
	}

	@Override
	@Transactional(Transactional.TxType.NEVER)
	public String retrieveStockNameFromDatabase() {
		logger.info("executing retrieveStockNameFromDatabase method");
		return retrieveStockName();
	}

	@Override
	@Transactional(
			value = Transactional.TxType.REQUIRES_NEW,
			rollbackOn = {StockException.class},
			dontRollbackOn = GenericException.class
	)
	public void insertStock(Stock stock) throws Exception {
		if(!stockRepository.saveStock(stock)) {
			throw new StockException(); // should cause rollback
		} else {
			throw new GenericException(); // should not cause Rollback
		}
	}

}
