/**
 * 
 */
package com.mycompany.jta.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author colin
 *
 */
@Entity
@Table(name = "category")
public class Category {

	private int categoryId;
	private String name;
	private String description;
	private Set<Stock> stocks = new HashSet<Stock>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", nullable = false)
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "name", nullable = false, length = 255)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Stock> getStocks() {
		return stocks;
	}
	
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	
}
