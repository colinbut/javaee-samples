package com.mycompany.jsf.form.tags;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = -4330164300910778050L;
	
	private String name;
	private String country;
	
	public String outcome() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.country = facesContext.getExternalContext().getRequestParameterMap().get("country");
		return country;
	}
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	private String favColor1 = "Yellow";
	private String favColor2;
	private String favColor3;
	public String getFavColor1() {
		return favColor1;
	}
	public void setFavColor1(String favColor1) {
		this.favColor1 = favColor1;
	}
	public String getFavColor2() {
		return favColor2;
	}
	public void setFavColor2(String favColor2) {
		this.favColor2 = favColor2;
	}
	public String getFavColor3() {
		return favColor3;
	}
	public void setFavColor3(String favColor3) {
		this.favColor3 = favColor3;
	}
	
	// label / value
	private static Map<String, Object> colorValues;
	
	static {
		colorValues = new HashMap<String, Object>();
		colorValues.put("Color1 - Red", "Red");
		colorValues.put("Color2 - Green", "Green");
		colorValues.put("Color3 - Blue", "Blue");
	}
	
	public Map<String, Object> getColorValues() {
		return colorValues;
	}
	
	
	public static class Color {
		private String colorLabel;
		private String colorValue;
		
		/**
		 * @param colorLabel
		 * @param colorValue
		 */
		public Color(String colorLabel, String colorValue) {
			this.colorLabel = colorLabel;
			this.colorValue = colorValue;
		}
		public String getColorLabel() {
			return colorLabel;
		}
		public void setColorLabel(String colorLabel) {
			this.colorLabel = colorLabel;
		}
		public String getColorValue() {
			return colorValue;
		}
		public void setColorValue(String colorValue) {
			this.colorValue = colorValue;
		}
	}
	
	private Color[] colorList;
	
	public Color[] getColorList() {
		
		colorList = new Color[3];
		colorList[0] = new Color("Color1 - Black", "Black");
		colorList[1] = new Color("Color2 - Grey", "Grey");
		colorList[2] = new Color("Color3 - White", "White");
		return colorList;
		
	}
	
}
