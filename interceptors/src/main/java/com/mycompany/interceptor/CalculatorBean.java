package com.mycompany.interceptor;

import javax.enterprise.inject.Model;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.interceptor.interceptors.AuditLoggingInterceptor;
import com.mycompany.interceptor.interceptors.ConstructorInterceptor;
import com.mycompany.interceptor.interceptors.LoggingInterceptor;
import com.mycompany.interceptor.interceptors.annotation.Auditable;
import com.mycompany.interceptor.interceptors.annotation.Loggable;

//@Interceptors({
//	LoggingInterceptor.class,
//	AuditLoggingInterceptor.class
//})
@Loggable
@Auditable
@Model
public class CalculatorBean {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorBean.class);
	
	@Interceptors(ConstructorInterceptor.class)
	public CalculatorBean() {
		logger.info(this.getClass().getName() + " - Constructor");
	}
	
	
	public void init() {
		logger.info("Inside init method");
	}
	
	public int sum(int x, int y) {
		int result = x + y;
		logger.info("Sum of " + x + " and " + y + " is: %s", result);
		return result;
	}
	
	public int multiply(int x, int y) {
		int result = x * y;
		logger.info("Multiply of " + x + " and " + y + " is: %s", result);
		return result;
	}
	
	public int minus(int x, int y) {
		int result = x - y;
		logger.info("Minus of " + x + " and " + y + " is: %s", result);
		return result;
	}
	
	@ExcludeClassInterceptors
	public int divide(int x, int y) {
		int result = x / y;
		logger.info("Divide of " + x + " and " + y + " is: %s", result);
		return result;
	}
	
}
