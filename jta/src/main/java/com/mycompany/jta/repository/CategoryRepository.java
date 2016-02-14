/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jta.repository;

import com.mycompany.jta.model.Category;

public interface CategoryRepository {

    Category getCategoryById(int id);

    void saveCategory(Category category);

}
