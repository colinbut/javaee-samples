/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jta.service;

import com.mycompany.jta.model.Category;
import com.mycompany.jta.repository.CategoryRepository;

import javax.annotation.Resource;

public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(int id) {
        return null;
    }

    @Override
    public void saveCategory(Category category) {

    }
}
