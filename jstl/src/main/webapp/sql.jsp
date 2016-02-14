<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL SQL Tags Examples</title>
</head>
<body>

	<!-- setDataSource tag -->
	<!-- used to connect to a database -->
	<sql:setDataSource driver="com.mysql.jdbc.Driver" 
						url="jdbc:mysql://localhost/bookstore"
						var="localsource"
						user="root"
						password=""/>
	
	<!-- query tag -->					
	<sql:query var="result" dataSource="${localsource}"
				sql="SELECT * FROM BOOKS WHERE ID > 0">
	</sql:query>
	
	<c:forEach items="${result.rows}" var="row">
		<c:out value="${row.id}"/> : <c:out value="${row.title}"/> : <c:out value="${row.author}"/>
	</c:forEach>
	
	<!-- update tag -->
	<sql:update dataSource="${localsource}" 
				sql="UPDATE BOOKS SET AUTHOR='Author 2' WHERE ID = 2"></sql:update>
				
	<!-- param & dateParam tag -->	
	<sql:update dataSource="${localsource}"
				sql="UPDATE BOOKS SET TITLE = 'Title 2' WHERE ID = ?">
			<sql:param value="2"></sql:param>
			<%-- <sql:dateParam value="<%= new Date() %>"/> --%>	
	</sql:update>
	
	<!-- transactions tag -->
	
	<sql:transaction dataSource="${localsource}">
		<sql:update sql="UPDATE BOOKS SET AUTHOR='Author 1' WHERE ID = 1"></sql:update>
		<sql:update sql="UPDATE BOOKS SET TITLE='Title 1' WHERE ID = 1"></sql:update>
		<sql:update sql="INSERT INTO BOOKS VALUES (3,'Title 3', 'Author 3')">
		</sql:update>
		<sql:update sql="INSERT INTO BOOKS VALUES (4,'Title 4', 'Author 4')">
		</sql:update>
		<sql:query var="result" sql="SELECT  * FROM BOOKS"></sql:query>
	</sql:transaction>					

	<c:forEach items="${result.rows}" var="row">
		<c:out value="${row.id}"/> : <c:out value="${row.title}"/> : <c:out value="${row.author}"/>
	</c:forEach>

</body>
</html>