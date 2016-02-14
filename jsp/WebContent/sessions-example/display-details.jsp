<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Displaying Session Content</title>
</head>
<body>
	<h3>Displaying Session Details</h3>
	<div>
		<p>Hello, <%= session.getAttribute("theName") %></p>
		<a href="../index.jsp">JSP Tutorials</a>
	</div>
</body>
</html>