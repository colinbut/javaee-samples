package com.mycompany.interceptor.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Interceptor
public class DefaultInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(DefaultInterceptor.class);
	
	private static final String CLASSNAME = DefaultInterceptor.class.getName(); 
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		
		if(logger.isDebugEnabled()) {
			logger.debug("Default: " + CLASSNAME + " - before " + ctx.getMethod().getName() + " method invoke");
		}
		
		Object result = ctx.proceed();
		
		if(checkLogLevel()) {
			logger.debug("Default: " + CLASSNAME + " - after " + ctx.getMethod().getName() + " method invoke");
		}
		
		return result;
	}
	
	private boolean checkLogLevel() {
		return logger.isDebugEnabled();
	}
	
}
