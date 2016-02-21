/**
 * 
 */
package com.mycompany.jsf.datatables;

import java.math.BigDecimal;
/**
 * @author colin
 *
 */
public class Order {

	private String orderNo;
	private String productName;
	private BigDecimal orderPrice;
	private int orderQty;
	
	private boolean isEditable;
	
	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * @param orderNo
	 * @param productName
	 * @param orderPrice
	 * @param orderQty
	 */
	public Order(String orderNo, String productName, BigDecimal orderPrice, int orderQty) {
		this.orderNo = orderNo;
		this.productName = productName;
		this.orderPrice = orderPrice;
		this.orderQty = orderQty;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	
}
