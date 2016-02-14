package com.mycompany.concurrency_utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ContextService;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@SessionScoped
public class WorkBean {

	private static final Logger logger = LoggerFactory.getLogger(WorkBean.class);
	
	private InitialContext ctx;
	
	private ManagedExecutorService managedExecutorService;
	
	@Resource(lookup = "java:comp/DefaultManagedScheduledExecutorService")
	private ManagedScheduledExecutorService managedScheduledExecutorService;
	
	@Resource(lookup = "java:comp/DefaultManagedThreadFactory")
	private ManagedThreadFactory managedThreadFactory;
	
	@Resource(lookup = "java:comp/DefaultContextService")
	private ContextService contextService;
	
	/**
	 * Constructor
	 * 
	 * @throws NamingException
	 */
	public WorkBean() throws NamingException {
		ctx = new InitialContext();
	}
	
	@PostConstruct
	private void init() {
		try {
			managedExecutorService = (ManagedExecutorService) ctx.lookup("java:comp/DefaultManagedExecutorService");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public void executeTask() {
		Future<?> future = managedExecutorService.submit(new Task());
		
		if(future.isDone()) {
			logger.info("Task finished");
		}
	}
	
	public void executeScheduledTaskAtFixedRate() {
		Future<?> future = managedScheduledExecutorService.schedule(() -> {
			logger.info("Executing task in executeScheduledTask method");
		}, 1L, TimeUnit.SECONDS);
		
		if(future.isDone()) {
			logger.info("Finished executing task");
		}
		
		managedScheduledExecutorService.scheduleAtFixedRate(() -> {
			logger.info("Repeatedly executing task at FixedRate");
		}, 2L, 1L, TimeUnit.SECONDS);
		
		
	}
	
	public void executeScheduledTaskFixedDelay() {
		managedScheduledExecutorService.scheduleWithFixedDelay(() ->{
			logger.info("Repeatedly executing task with FixedDelay");
		}, 1L, 2L, TimeUnit.SECONDS);
	}
	
	public void executeANewThread() {
		Thread thread = managedThreadFactory.newThread(() -> {
			logger.info("Executing in a new Thread that is managed by the ManagedThreadFactory");
		});
		
		thread.start();
	}
	
	public void contextServicing() {
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				logger.info("Executing task inside context servicing");
			}
		};
		
		Runnable proxy = contextService.createContextualProxy(task, Runnable.class);
		
		ExecutorService executorService = Executors.newFixedThreadPool(10, managedThreadFactory);
		
		Future<?> future = executorService.submit(proxy);
		if(future.isDone()) {
			logger.info("Task inside contextServicing method is done!");
		}
		
	}
	
}
