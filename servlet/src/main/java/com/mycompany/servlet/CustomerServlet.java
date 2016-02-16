package com.mycompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * CustomerServlet class
 * 
 * @author colin
 *
 */
@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 7742374340061777056L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try(PrintWriter writer = response.getWriter()) {
			writer.println("<html><head>");
			writer.println("<title>MyServlet<title>");
			writer.println("</head><body>");
			writer.println("<h1>My First Servlet</h1>");
			writer.println("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// getting the query parameter
		String customerId = request.getParameter("customerId");
		
		// getting the servlet context information
		ServletContext servletContext = request.getServletContext();
		
		SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
		sessionCookieConfig.setHttpOnly(true);
		sessionCookieConfig.setName("JSESSIONID");
		sessionCookieConfig.setMaxAge(60000);
		sessionCookieConfig.setComment("Cookie Comment");
		sessionCookieConfig.setSecure(true);
		
		HttpSession session = request.getSession(true);
		session.getAttribute("");
		
		// forwards to another servlet to handle it
		try {
			request.getRequestDispatcher("customer").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		// redirects to another servlet (execute another request)
		try {
			response.sendRedirect("http://localhost:8080/order");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) {
		
	}
	
	
	
}
