/**
 * 
 */
package com.mycompany.jsf.form.tags;

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
@SessionScoped
public class FormBean implements Serializable {

	private static final long serialVersionUID = -6029599086290455998L;
	
	private String name;
	private String description;
	private String password;
	private boolean rememberMe;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	
	
}
