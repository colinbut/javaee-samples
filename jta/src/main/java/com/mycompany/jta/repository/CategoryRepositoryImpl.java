/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jta.repository;

import com.mycompany.jta.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category getCategoryById(int id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }
}
