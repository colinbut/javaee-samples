package com.mycompany.jsf.eventhandler;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class NormalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String buttonId;
	
	public void printIt(ActionEvent ev) {
		buttonId = ev.getComponent().getClientId();
		System.out.println(buttonId);
	}
	
	public String outcome() {
		return "result";
	}
	
}
