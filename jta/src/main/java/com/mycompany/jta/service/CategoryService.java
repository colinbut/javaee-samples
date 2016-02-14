package com.mycompany.jta.service;/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */

import com.mycompany.jta.model.Category;

public interface CategoryService {

    Category findCategoryById(int id);

    void saveCategory(Category category);

}
