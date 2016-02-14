/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jta.service;

import com.mycompany.jta.model.StockDetail;

import javax.transaction.SystemException;

public interface StockDetailService {

    StockDetail getStockDetailByCompanyName(String companyName);

    void saveStockDetail(StockDetail stockDetail) throws SystemException;
}
