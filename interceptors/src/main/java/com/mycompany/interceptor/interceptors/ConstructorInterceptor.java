package com.mycompany.interceptor.interceptors;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
public class ConstructorInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ConstructorInterceptor.class);
	
	private static final String CLASSNAME = ConstructorInterceptor.class.getName();
	
	@AroundConstruct
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.info("Inside " + CLASSNAME);
		return ctx.proceed();
	}
}
