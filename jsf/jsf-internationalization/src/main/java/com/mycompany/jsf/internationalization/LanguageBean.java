/**
 * 
 */
package com.mycompany.jsf.internationalization;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * @author colin
 *
 */
@ManagedBean(name = "language")
public class LanguageBean {

	private String localCode;

	private static Map<String, Locale> countries;
	
	public Map<String, Locale> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, Locale> countries) {
		LanguageBean.countries = countries;
	}

	static {
		countries = new HashMap<String, Locale>();
		countries.put("English", Locale.ENGLISH);
		countries.put("Chinese", Locale.SIMPLIFIED_CHINESE);
	}
	
	
	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	public void countryLocaleCodeChanged(ValueChangeEvent ev) {
		String newLocaleValue = ev.getNewValue().toString();
		for(Map.Entry<String, Locale> entry : countries.entrySet()) {
			if(entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale(entry.getValue());
			}
		}
	}
	
}
