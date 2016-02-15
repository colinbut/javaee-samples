package com.mycompany.interceptor.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.interceptor.interceptors.annotation.Auditable;

@Auditable
@Interceptor
public class AuditLoggingInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AuditLoggingInterceptor.class);
	
	private static final String CLASSNAME = AuditLoggingInterceptor.class.getName(); 
	
	@AroundInvoke
	public Object auditLog(InvocationContext ctx) throws Exception {
		
		if(logger.isDebugEnabled()) {
			logger.debug("Auditing: " + CLASSNAME + " - before " + ctx.getMethod().getName() + " method invoke");
		}
		
		Object result = ctx.proceed();
		
		if(checkLogLevel()) {
			logger.debug("Auditing: " + CLASSNAME + " - after " + ctx.getMethod().getName() + " method invoke");
		}
		
		return result;
	}
	
	private boolean checkLogLevel() {
		return logger.isDebugEnabled();
	}
	
}
