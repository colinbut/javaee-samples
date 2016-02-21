/**
 * 
 */
package com.mycompany.jsf.managedbean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 * @author colin
 *
 */
@ManagedBean
//@SessionScoped
//@RequestScoped
//@ApplicationScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = -6029599086290455998L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
