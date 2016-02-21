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
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

import com.mycompany.jsf.datatables.datamodel.SortableDataModel;

/**
 * @author colin
 *
 */
@ManagedBean(name = "sortableOrderBean")
@SessionScoped
public class OrderBeanSortableDataModel implements Serializable {

	private static final long serialVersionUID = 2830304349850872352L;
	
	private SortableDataModel<Order> sortableDataModel;
	
	private boolean sortAscending = true;

	private static final Order[] orderList = {
			new Order("A001", "HP PC", new BigDecimal("700.00"), 1),
			new Order("A002", "MacBook Pro", new BigDecimal("999.00"), 3),
			new Order("A003", "Leather Jacket", new BigDecimal("34.00"), 4),
			new Order("A005", "Nike Trainers", new BigDecimal("60.00"), 5),
			new Order("A004", "Milk", new BigDecimal("45.00"), 12)
	};

	public OrderBeanSortableDataModel() {
		sortableDataModel = new SortableDataModel<Order>(new ArrayDataModel<Order>(orderList));
	}
	
	public DataModel<Order> getOrderList() {
		return sortableDataModel;
	}
	
	public String sortByOrderNo() {
		
		if(sortAscending) {
			sortableDataModel.sortBy(new Comparator<Order>() {
				public int compare(Order o1, Order o2) {
					return o1.getOrderNo().compareTo(o2.getOrderNo());
				}
			});
			sortAscending = false;
		} else {
			sortableDataModel.sortBy(new Comparator<Order>() {
				public int compare(Order o1, Order o2) {
					return o2.getOrderNo().compareTo(o1.getOrderNo());
				}
			});
			sortAscending = true;
		}
		
		return null;
	}
	
	
	
	
}
