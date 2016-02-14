package com.mycompany.jta.web;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.jta.service.StockService;
import com.mycompany.jta.service.StockServiceImpl;


@ManagedBean
@SessionScoped
public class ControllerBean implements Serializable {

	private static final long serialVersionUID = -6029599086290455998L;
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerBean.class);
	
	@Inject
	@Default
	private StockService stockService;
	
	private String stockName;

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		logger.info("Before executing getStockName method");
		
		if(stockService != null) {
			try {
				stockName = stockService.retrieveStockNameFromDatabase();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} else {
			stockName = "Stock Default";
		}
		logger.info("After executing getStockName method");
		return stockName;
	}

	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
}
