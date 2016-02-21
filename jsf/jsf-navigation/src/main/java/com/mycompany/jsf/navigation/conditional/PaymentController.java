package com.mycompany.jsf.navigation.conditional;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PaymentController implements Serializable {

	private static final long serialVersionUID = 608399891204607384L;
	
	private boolean registeredCompleted = false;
	private int orderQty = 99;
	
	public boolean isRegisteredCompleted() {
		return registeredCompleted;
	}
	public void setRegisteredCompleted(boolean registeredCompleted) {
		this.registeredCompleted = registeredCompleted;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	
}
