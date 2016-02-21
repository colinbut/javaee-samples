/**
 * 
 */
package com.mycompany.jsf.ajax;

import javax.faces.bean.ManagedBean;

/**
 * @author colin
 *
 */
@ManagedBean
public class HelloBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSayWelcome() {
		if(name == null || name.equals("")) {
			return "";
		}
		else {
			return "Welcome AJAX " + name;
		}
	}
	
}
