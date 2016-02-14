<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL XML Tags Examples</title>
</head>
<body>

	<c:import url="books.xml" var="xmltext"></c:import>

	<!-- parse -->
	<x:parse xml="${xmltext}" var="xmloutput"></x:parse>
	
	<!-- select -->
	<x:out select="$xmloutput/books/books[1]/name"/>
	
	<!-- choose/when/otherwise -->
	<x:choose>
		<x:when select="$xmloutput//books/author = 'ZARA'">
			<c:out value="Book is written by ZARA"></c:out>
		</x:when>
		<x:when select="$xmloutput//books/author = 'NUHA'">
			<c:out value="Book is written by NUHA"></c:out>
		</x:when>
		<x:otherwise>
			<c:out value="Unknown author!"></c:out>
		</x:otherwise>
	</x:choose>

	<!-- if -->
	<x:if select="price > 100">
		<c:out value="Book cost over 100"></c:out>
	</x:if>
	
	<!-- forEach -->
	<x:forEach select="$xmloutput/books/book" var="book">
		<x:out select="name"/>
		<x:out select="author"/>
		<x:out select="price"/>
	</x:forEach>
	
	<!-- set -->
	<x:set var="books3Price" select="$xmloutput/books/book[1]/price"/>
	<x:out select="$book3Price"/>
	
	<!-- transform -->
	<c:import url="books.xsl" var="xslt"></c:import>
	<x:transform xml="${xmloutput}" xslt="${xslt}"></x:transform>
	

</body>
</html>