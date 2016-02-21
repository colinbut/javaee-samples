package com.mycompany.jsf.managedbeaninjection;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "message", eager = true)
@SessionScoped
public class MessageBean implements Serializable {

	private static final long serialVersionUID = 3870180172853974005L;
	
	private String message = "Yo!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
