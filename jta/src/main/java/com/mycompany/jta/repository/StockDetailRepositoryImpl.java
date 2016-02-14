/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jta.repository;

import com.mycompany.jta.model.StockDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StockDetailRepositoryImpl implements StockDetailRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StockDetail findStockDetail(String companyName) {
        return entityManager.createQuery("SELECT S FROM StockDetail S WHERE S.companyName = "
                + companyName, StockDetail.class)
                .getSingleResult();
    }

    @Override
    public void saveStockDetail(StockDetail stockDetail) {
        entityManager.persist(stockDetail);
    }
}
