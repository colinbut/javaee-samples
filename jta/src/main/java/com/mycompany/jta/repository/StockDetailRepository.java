package com.mycompany.jta.repository;/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */

import com.mycompany.jta.model.StockDetail;

public interface StockDetailRepository {

    StockDetail findStockDetail(String companyName);

    void saveStockDetail(StockDetail stockDetail);
}
