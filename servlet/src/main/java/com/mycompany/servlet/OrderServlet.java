/**
 * 
 */
package com.mycompany.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * OrderServlet class
 * 
 * @author colin
 *
 */
@WebServlet(urlPatterns={"/order", "/orderServlet"})
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = -166920201446310733L;

}
