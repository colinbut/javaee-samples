package com.mycompany.concurrency_utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable, ManagedTask, ManagedTaskListener {

	private static final Logger logger = LoggerFactory.getLogger(Task.class);
	
	@Override
	public void run() {
		logger.info("Task is running");
	}

	// ---- ManagedTask interface methods -------------------
	
	@Override
	public Map<String, String> getExecutionProperties() {
		Map<String, String> executionProperties = new HashMap<>();
		return executionProperties;
	}

	@Override
	public ManagedTaskListener getManagedTaskListener() {
		return this;
	}

	// ---- ManagedTaskListener interface methods ----------- 
	
	@Override
	public void taskAborted(Future<?> arg0, ManagedExecutorService arg1, Object arg2, Throwable arg3) {
		logger.info("Task have been aborted!" + arg0 + "-" + arg1 + "-" + arg2 + "-" + arg3);
	}

	@Override
	public void taskDone(Future<?> arg0, ManagedExecutorService arg1, Object arg2, Throwable arg3) {
		logger.info("Task is completed and is successful " + arg0 + "-" + arg1 + "-" + arg2 + "-" + arg3);
	}

	@Override
	public void taskStarting(Future<?> arg0, ManagedExecutorService arg1, Object arg2) {
		logger.info("Task is about to start " + arg0 + "-" + arg1 + "-" + arg2);
	}

	@Override
	public void taskSubmitted(Future<?> arg0, ManagedExecutorService arg1, Object arg2) {
		logger.info("Task is submitted"  + arg0 + "-" + arg1 + "-" + arg2);
	}
	
	

}
