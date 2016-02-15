package com.mycompany.interceptor;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class ControllerBean implements Serializable {

	private static final long serialVersionUID = -6029599086290455998L;
	
	private String sumResult;
	private String multiplyResult;
	private String minusResult;
	private String divideResult;
	
	@Inject
	@Default
	private CalculatorBean calculator;

	public String getSumResult() {
		sumResult = Integer.toString(calculator.sum(10, 20));
		return sumResult;
	}

	public void setSumResult(String sumResult) {
		this.sumResult = sumResult;
	}

	public String getMultiplyResult() {
		multiplyResult = Integer.toString(calculator.multiply(10, 20));
		return multiplyResult;
	}

	public void setMultiplyResult(String multiplyResult) {
		this.multiplyResult = multiplyResult;
	}

	public String getMinusResult() {
		minusResult = Integer.toString(calculator.minus(10, 20));
		return minusResult;
	}

	public void setMinusResult(String minusResult) {
		this.minusResult = minusResult;
	}

	public String getDivideResult() {
		divideResult = Integer.toString(calculator.divide(10, 20));
		return divideResult;
	}

	public void setDivideResult(String divideResult) {
		this.divideResult = divideResult;
	}
	
	
	
}
