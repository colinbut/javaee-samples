package com.mycompany.interceptor.interceptors;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.interceptor.interceptors.annotation.Loggable;

@Priority(Interceptor.Priority.APPLICATION) // need this to enable Interceptors for Interceptor Binding
@Loggable
@Interceptor
public class LoggingInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
	
	private static final String CLASSNAME = LoggingInterceptor.class.getName(); 
	
	@AroundInvoke
	public Object auditLog(InvocationContext ctx) throws Exception {
		
		if(logger.isDebugEnabled()) {
			logger.debug(CLASSNAME + " - before " + ctx.getMethod().getName() + " method invoke");
		}
		
		Object result = ctx.proceed();
		
		logger.debug(CLASSNAME + " - after " + ctx.getMethod().getName() + " method invoke");
		
		return result;
	}
}
