package com.mycompany.jsf.navigation.fromaction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PageController {

	public String processPage1() {
		return "success";
	}
	
	public String processPage2() {
		return "success";
	}
}
