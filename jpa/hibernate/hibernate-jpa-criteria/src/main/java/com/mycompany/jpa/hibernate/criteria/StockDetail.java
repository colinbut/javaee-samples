/**
 * 
 */
package com.mycompany.jpa.hibernate.criteria;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author colin
 *
 */
@Entity
@Table(name = "stock_detail")
public class StockDetail {

	private int stockId;
	private Stock stock;
	private String companyName;
	private String companyDescription;
	private String remark;
	private Date listedDate;
	
	@GenericGenerator(name = "generator", strategy = "foreign", 
			parameters = @Parameter(name = "property", value = "stock"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "stock_id", nullable = false)
	public int getStockId() {
		return stockId;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	@Column(name = "company_name", nullable = false, length = 100)
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name = "company_desc", nullable = false, columnDefinition = "TEXT")
	public String getCompanyDescription() {
		return companyDescription;
	}
	
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	
	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "listed_date", nullable = false)
	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}
	
	@Override
	public String toString() {
		return "StockDetail [stockId=" + stockId + ", "
				+ ", companyName=" + companyName + ", companyDescription="
				+ companyDescription + ", remark=" + remark + ", listedDate="
				+ listedDate + "]";
	}
	
}
