/**
 * 
 */
package com.mycompany.batch.batchlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.batch.runtime.JobExecution;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author colin
 *
 */
@WebServlet(name = "BatchServlet", urlPatterns = "/run_batch_job")
public class BatchServlet extends HttpServlet {

	private static final long serialVersionUID = -8680554388266914605L;

	@Inject
	private BatchExecutor batchExecutor;
	
	/**
	 * {@inheritDoc}
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		String executionIdRequestParam = request.getParameter("executionId");
		long executionId = -1;
		if(executionIdRequestParam != null) {
			executionId = Long.valueOf(executionIdRequestParam);
		}
		
		if(action.equals("START")) {
			executionId = batchExecutor.submitJob();
			out.println("Batch execution " + executionId + " is running");
		} else if(action.equals("RESTART")) {
			executionId = batchExecutor.restartJob(executionId);
			out.println("Batch execution " + executionId + " is the result of a restart");
		} else if(action.equals("VIEW")) {
			JobExecution jobExecution = batchExecutor.getJobExecutionDetails(executionId);
			out.println("Execution Id \n " + jobExecution);
		} else if(action.equals("STOP")) {
			batchExecutor.stopJob(executionId);
			out.println("Batch execution " + executionId + " stopped");
		}
		
		String contextPath = request.getContextPath();
		
		out.println("<h2>Options</h2>");
		
		// view
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"")
			.append(contextPath)
			.append("/run-batch-job")
			.append("?action=")
			.append("VIEW");
		if(Long.valueOf(executionId) != null) {
			sb.append("&executionId=").append(executionId);
		}
		sb.append("\">").append("View details for executionId :" + executionId).append("</a>");
		
		out.println(sb.toString());
		out.println("<hr/>");
		
		// restart
		StringBuilder sb2 = new StringBuilder();
		sb2.append("<a href=\"")
			.append(contextPath)
			.append("/run-batch-job")
			.append("?action=")
			.append("RESTART");
		if(Long.valueOf(executionId) != null) {
			sb2.append("&executionId=").append(executionId);
		}
		sb2.append("\">").append("Restart executionId :" + executionId).append("</a>");
		
		out.println(sb2.toString());
		out.println("<hr/>");
		
		// start
		StringBuilder sb3 = new StringBuilder();
		sb3.append("<a href=\"")
			.append(contextPath)
			.append("/run-batch-job")
			.append("?action=")
			.append("START");
		if(Long.valueOf(executionId) != null) {
			sb3.append("&executionId=").append(executionId);
		}
		sb3.append("\">").append("Start a new job").append("</a>");
		
		out.println(sb3.toString());
		out.println("<hr/>");
		
		
		// stop
		StringBuilder sb4 = new StringBuilder();
		sb4.append("<a href=\"")
			.append(contextPath)
			.append("/run-batch-job")
			.append("?action=")
			.append("STOP");
		if(Long.valueOf(executionId) != null) {
			sb4.append("&executionId=").append(executionId);
		}
		sb4.append("\">").append("Stop job " + executionId).append("</a>");
		
		out.println(sb4.toString());
		out.println("<hr/>");
	}
	
}
