package com.mycompany.jsf.eventhandler;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class CountryValueListener implements ValueChangeListener {

	public void processValueChange(ValueChangeEvent arg0) throws AbortProcessingException {
		
		CountryBean country = (CountryBean) FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap().get("country");
		
		country.setLocaleCode(arg0.getNewValue().toString());
		
	}

}
