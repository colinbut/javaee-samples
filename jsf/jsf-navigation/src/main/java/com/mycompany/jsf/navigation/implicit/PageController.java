package com.mycompany.jsf.navigation.implicit;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PageController {

	public String moveToPage2() {
		return "page2"; //outcome
	}
}
