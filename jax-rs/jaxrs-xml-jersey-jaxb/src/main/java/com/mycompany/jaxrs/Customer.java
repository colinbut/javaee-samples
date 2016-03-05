/**
 * 
 */
package com.mycompany.jaxrs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author colin
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name = "customer")
public class Customer {

	String name;
	int pin;
	
	@XmlElement
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@XmlAttribute
	public int getPin(){
		return pin;
	}
	
	public void setPin(int pin){
		this.pin = pin;
	}
}
