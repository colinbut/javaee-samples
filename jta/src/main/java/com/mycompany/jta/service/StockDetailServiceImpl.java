/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jta.service;

import com.mycompany.jta.model.StockDetail;
import com.mycompany.jta.repository.StockDetailRepository;


import javax.annotation.Resource;
import javax.inject.Inject;
import javax.transaction.*;

public class StockDetailServiceImpl implements StockDetailService {

    @Resource
    private UserTransaction userTransaction;

    @Inject
    private StockDetailRepository stockDetailRepository;

    @Override
    public StockDetail getStockDetailByCompanyName(String companyName) {
        return stockDetailRepository.findStockDetail(companyName);
    }

    @Override
    public void saveStockDetail(StockDetail stockDetail) throws SystemException {

        try {
            userTransaction.begin();

            stockDetailRepository.saveStockDetail(new StockDetail());

            userTransaction.commit();

        } catch (NotSupportedException e) {
                userTransaction.rollback();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            userTransaction.rollback();
        }

    }
}
