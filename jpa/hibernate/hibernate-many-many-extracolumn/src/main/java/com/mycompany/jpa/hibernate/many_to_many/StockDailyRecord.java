/**
 * 
 */
package com.mycompany.jpa.hibernate.many_to_many;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author colin
 *
 */
@Entity
@Table(name = "stock_daily_record")
public class StockDailyRecord {

	private int recordId;
	
	private float priceOpen;
	private float priceClose;
	private float priceChange;
	private long volume;
	private Date date;
	private Stock stock;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id", nullable = false)
	public int getRecordId() {
		return recordId;
	}
	
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_id", nullable = false)
	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	@Column(name = "price_open", precision = 6)
	public float getPriceOpen() {
		return priceOpen;
	}
	
	public void setPriceOpen(float priceOpen) {
		this.priceOpen = priceOpen;
	}
	
	@Column(name = "price_close", precision = 6)
	public float getPriceClose() {
		return priceClose;
	}
	
	public void setPriceClose(float priceClose) {
		this.priceClose = priceClose;
	}
	
	@Column(name = "price_change", precision = 6)
	public float getPriceChange() {
		return priceChange;
	}
	
	public void setPriceChange(float priceChange) {
		this.priceChange = priceChange;
	}
	
	@Column(name = "volume")
	public long getVolume() {
		return volume;
	}
	
	public void setVolume(long volume) {
		this.volume = volume;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "record_date", nullable = false)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "StockDailyRecord [recordId=" + recordId + ", priceOpen="
				+ priceOpen + ", priceClose=" + priceClose + ", priceChange="
				+ priceChange + ", volume=" + volume + ", date=" + date
				+ "]";
	}
	
	
}
