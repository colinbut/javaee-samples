package com.mycompany.jsf.eventhandler;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "country")
@SessionScoped
public class CountryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Map<String, String> countries;
	
	private String localeCode = "en";
	
	static {
		countries = new LinkedHashMap<String, String>();
		countries.put("United Kingdom", "en");
		countries.put("French", "fr");
		countries.put("German", "de");
		countries.put("China", "zh_CN");
	}
	
	public void countryLocaleCodeChanged(ValueChangeEvent ev) {
		localeCode = ev.getNewValue().toString();
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public static void setCountries(Map<String, String> countries) {
		CountryBean.countries = countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
	
	
}
