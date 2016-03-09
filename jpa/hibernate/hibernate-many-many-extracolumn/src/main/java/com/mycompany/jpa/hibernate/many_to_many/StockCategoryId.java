package com.mycompany.jpa.hibernate.many_to_many;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class StockCategoryId {

	private Stock stock;
	private Category category;
	
	@ManyToOne
	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	@ManyToOne
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
