/**
 * 
 */
package com.mycompany.jsf.datatables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author colin
 *
 */
@ManagedBean
@SessionScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 2830304349850872352L;
	
	private String orderNo;
	private String productName;
	private BigDecimal orderPrice;
	private int orderQty;
	
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
	
	private boolean sortAscending = true;

	private List<Order> orderList = new ArrayList<Order>(Arrays.asList(
			new Order("A001", "HP PC", new BigDecimal("700.00"), 1),
			new Order("A002", "MacBook Pro", new BigDecimal("999.00"), 3),
			new Order("A003", "Leather Jacket", new BigDecimal("34.00"), 4),
			new Order("A005", "Nike Trainers", new BigDecimal("60.00"), 5),
			new Order("A004", "Milk", new BigDecimal("45.00"), 12)
			));

	
	public List<Order> getOrderList() {
		return orderList;
	}
	
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public String deleteOrder(Order order) {
		orderList.remove(order);
		return null;
	}
	
	public String addOrder() {
		Order order = new Order(orderNo, productName, orderPrice, orderQty);
		orderList.add(order);
		return null;
	}
	
	public String editOrder(Order order) {
		order.setEditable(true);
		return null;
	}
	
	public String saveOrder() {
		for(Order order : orderList) {
			order.setEditable(false);
		}
		return null;
	}
	
	public String sortByOrderNo() {
		
		if(sortAscending) {
			Collections.sort(orderList, new Comparator<Order>() {
				public int compare(Order o1, Order o2) {
					return o1.getOrderNo().compareTo(o2.getOrderNo());
				}
			});
			sortAscending = false;
		} else {
			Collections.sort(orderList, new Comparator<Order>() {
				public int compare(Order o1, Order o2) {
					return o2.getOrderNo().compareTo(o1.getOrderNo());
				}
			});
			sortAscending = true;
		}
		
		return null;
	}
	
	
	
	
}
