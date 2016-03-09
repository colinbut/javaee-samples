package com.mycompany.jpa.hibernate.many_to_many;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "stock_category2")
@AssociationOverrides({
	@AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "stock_id")),
	@AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "category_id"))
})
public class StockCategory {

	private StockCategoryId pk = new StockCategoryId();
	private Date createdDate;
	private String createdBy;
	
	@Transient
	public Stock getStock() {
		return getPk().getStock();
	}
	
	public void setStock(Stock stock) {
		getPk().setStock(stock);
	}
	
	@Transient
	public Category getCategory() {
		return getPk().getCategory();
	}
	
	public void setCategory(Category category) {
		getPk().setCategory(category);
	}
	
	@EmbeddedId
	public StockCategoryId getPk() {
		return pk;
	}
	
	public void setPk(StockCategoryId pk) {
		this.pk = pk;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false, length = 10)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_by", nullable = false, length = 255)
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
