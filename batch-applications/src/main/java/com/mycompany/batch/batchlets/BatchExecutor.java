package com.mycompany.batch.batchlets;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.inject.Named;

@Named
public class BatchExecutor {

	JobOperator jobOperator = BatchRuntime.getJobOperator();
	
	public long submitJob() {
		return jobOperator.start("dispatch-orders-job", new Properties());
	}
	
	public long restartJob(long executionId) {
		return jobOperator.restart(executionId, new Properties());
	}
	
	public JobExecution getJobExecutionDetails(long executionId) {
		return jobOperator.getJobExecution(executionId);
	}
	
	public void stopJob(long executionId) {
		jobOperator.stop(executionId);
	}
	
	
}
