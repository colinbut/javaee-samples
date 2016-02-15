package com.mycompany.batch.batchlets;

import javax.batch.api.Batchlet;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

/**
 * A batch that processes the dispatching of orders at the 
 * end of the week
 * 
 * @author colin
 *
 */
public class DispatchOrdersBatch implements Batchlet {

	@Inject
	private JobContext jobContext;
	
	@Override
	public String process() throws Exception {
		System.out.println("Processing dispatch orders batch job");
		long executionId = jobContext.getExecutionId();
		if(executionId % 2 == 0) {
			throw new Exception("Error - cannot process even jobs");
		}
		return "SUCCESS";
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stopping dispatch orders batch job");
		BatchRuntime.getJobOperator().stop(1000);
	}

}
