<%@page import="com.mycompany.jsp.tutorials.Circle"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP tutorials</title>
</head>
<body>
	<h1>JSP Tutorials</h1>
	<p>Hello! The time is now <%= new Date() %> </p>
	<br />
	<%
		out.println("Your IP address " + request.getRemoteAddr());
	%>
	
	<!-- declarations in JSP -->
	<%! int i = 0; %>
	<%! int a,b,c = 0; %>
	<%! Circle circle = new Circle(2.0); %>
	
	<p>
		Today's date: <%= new Date().toString() %>
	</p>
	
	<%-- This is a JSP comment --%>
	
	<!-- This is the standard HTML comment -->
	
	<h5>If Else Example</h5>
	
	<%! int day= 3; %>
	<% if(day == 6 | day == 7){ %>
	<p>Today is a weekend</p>
	<% } else{ %>
	<p>Today is not a weekend</p>
	<% } %>	
	
	<!-- Scriplets -->
	<%
		int dayOfWeek = 7;
		
		if(dayOfWeek == 6 | dayOfWeek == 7) {
			out.println("Today is a weekend");
		}
		else {
			out.println("Today is not a weekend");
		}
	
	%>
	
	<h5>Switch Case Example</h5>
	
	<%! int dayOfTheWeek = 4; %>
	<!-- Scriplets -->
	<%
		switch(dayOfTheWeek) {
		case 1:
			out.println("It's Monday");
			break;
		case 2:
			out.println("It's Tuesday");
			break;
		case 3:
			out.println("It's Wednesday");
			break;
		case 4:
			out.println("It's Thursday");
			break;
		case 5:
			out.println("It's Friday");
			break;
		case 6:
			out.println("It's Saturday");
			break;
		case 7:
			out.println("It's Sunday");
			break;
			default:throw new IllegalArgumentException("Illegal Argument");
				
		}
	%>
	
	<h5>Loop Examples</h5>
	<h6><u>For Loop</u></h6>
	<%! int fontsize; %>
	<% for(fontsize = 1; fontsize <= 5; fontsize++) { %>
	<font color="green" size="<%= fontsize %> ">
		JSP Tutorial
	</font>
	<br />
	<% } %>
	
	<h6><u>While Loop</u></h6>
	<%! int fontSize;  %>
	<% while( fontSize <= 5) { %>
	<font color="red" size="<%= fontSize %>">
		JSP Tutorial
	</font>
	<br />
	<% fontSize++; %>
	<% } %> 
	
	<!-- JSP tags -->
	<jsp:include page="hello.jsp"></jsp:include>
	<%-- <jsp:forward page=""></jsp:forward> --%>
	
	<!-- JSP sessions -->
	<h5>JSP Sessions</h5>
	<a href="sessions-example/session-test.html">Sessions Example</a>
	
	<h5>JSP Form Example</h5>
	<a href="forms-example/form.jsp">JSP Forms</a>
	
</body>
</html>