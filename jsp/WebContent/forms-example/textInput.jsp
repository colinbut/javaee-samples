<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String studentNameTextBox = request.getParameter("studentName");
	String activeRadioButton = request.getParameter("active");
	String deactiveRadioButton = request.getParameter("deactive");
	String stateCheckbox = request.getParameter("state");
	String cityCheckbox = request.getParameter("city");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TextInput</title>
</head>
<body>
<p>Value of the textbox in JSP: <%= studentNameTextBox %></p>
<p>Value of the radiobutton in JSP: <%= activeRadioButton %></p>
<p>Value of the radiobutton in JSP: <%= deactiveRadioButton %></p>
<p>Value of the checkbox in JSP: <%= stateCheckbox %></p>
<p>Value of the checkbox in JSP: <%= cityCheckbox %></p>
</body>
</html>