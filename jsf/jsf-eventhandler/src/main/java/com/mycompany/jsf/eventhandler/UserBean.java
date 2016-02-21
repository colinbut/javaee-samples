package com.mycompany.jsf.eventhandler;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped
public class UserBean {

	public void isAdmin(ComponentSystemEvent event) {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		if(!"admin".equals(facesContext.getExternalContext().getSessionMap().get("role"))) {
			
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) facesContext.getApplication().getNavigationHandler();
			
			nav.performNavigation("access-denied");
			
		}
	}
	
}
