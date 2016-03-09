/**
 * 
 */
package com.mycompany.jpa.hibernate.many_to_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author colin
 *
 */
@Entity
@Table(name = "stock")
public class Stock {

	private int stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;
	
	// one - to - many mappings
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);
	
	private Set<Category> categories = new HashSet<>(0);
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id", nullable = false)
	public int getStockId() {
		return stockId;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	@Column(name = "stock_code", nullable = false, length = 10)
	public String getStockCode() {
		return stockCode;
	}
	
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	@Column(name = "stock_name", nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	// establishes 1 - 1 entity relationship between Stock <-> StockDetail
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	public StockDetail getStockDetail() {
		return stockDetail;
	}
	
	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}
	
	// establishes 1 - M entity relationship between Stock <-> StockDailyRecord
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	public Set<StockDailyRecord> getStockDailyRecords() {
		return stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "stock_category", 
		joinColumns = {	@JoinColumn(name = "stock_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "category_id", nullable = false, updatable = false)}
	)
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockCode=" + stockCode
				+ ", stockName=" + stockName + ", stockDetail=" + stockDetail 
				+ ", stockDailyRecord=" + stockDailyRecords
				+ "]";
	}
	
	
}
