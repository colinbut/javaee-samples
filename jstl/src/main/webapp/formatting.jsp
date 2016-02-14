<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Formatting Tags Example</title>
</head>
<body>

	<!-- formatNumber tag -->
	<fmt:formatNumber value="${product.price}" type="NUMBER" maxFractionDigits="2"></fmt:formatNumber>
	<fmt:formatNumber value="4532.34" type="NUMBER" minFractionDigits="4"></fmt:formatNumber>
	<fmt:formatNumber value="4532.3489" type="NUMBER" minFractionDigits="2"></fmt:formatNumber>
	<fmt:formatNumber value="8.3489" type="NUMBER" minIntegerDigits="3"></fmt:formatNumber>
	<fmt:formatNumber value="1238.3489" type="NUMBER" maxIntegerDigits="1"></fmt:formatNumber>
	
	<fmt:setLocale value="en_GB"/>
	<fmt:formatNumber value="120.78" type="CURRENCY"></fmt:formatNumber>
	
	<fmt:formatNumber value="1234.56" type="NUMBER" groupingUsed="TRUE"></fmt:formatNumber>
	
	<fmt:formatNumber value="0.567" type="PERCENT"></fmt:formatNumber>
	
	<!-- setLocale tag -->
	<fmt:setLocale value="en_US"/>
	<fmt:formatNumber value="120.78" type="CURRENCY"></fmt:formatNumber>
	<fmt:setLocale value="en_GB"/>
	<fmt:formatNumber value="120.78" type="CURRENCY"></fmt:formatNumber>
	<fmt:setLocale value="en_IN"/>
	<fmt:formatNumber value="120.78" type="CURRENCY"></fmt:formatNumber>
	
	<!-- parseNumber tag -->
	<fmt:parseNumber value="456.34" var="number" integerOnly="TRUE" type="NUMBER"></fmt:parseNumber>
	<c:out value="${number}"></c:out>
	
	<!-- message tag -->
	<fmt:message key="thankYouMessage"></fmt:message>
	
	<!-- formatDate tag -->
	<c:set var="date" value="<%=new Date()%>"></c:set>
	<fmt:formatDate value="${date}" type="time"/>
	<fmt:formatDate value="${date}" type="date"/>
	<fmt:formatDate value="${date}" type="both"/>
	<fmt:formatDate value="${date}" type="both" timeStyle="short"/>
	<fmt:formatDate value="${date}" type="both" timeStyle="medium"/>
	<fmt:formatDate value="${date}" type="both" timeStyle="long"/>
	<fmt:formatDate value="${date}" type="both" pattern="yyyy-MM-dd"/>
	
	
	<fmt:formatDate value="${date}" type="both" pattern="yyyy-MM-dd" dateStyle="long"/>
	<fmt:setTimeZone value="GMT-8"/>
	<fmt:formatDate value="${date}" type="both" pattern="yyyy-MM-dd" dateStyle="long"/>
	
	<c:set var="now" value="20-10-2010" />
	<fmt:parseDate value="${now}" var="parsedDate" pattern="dd-MM-YYYY"></fmt:parseDate>
	<c:out value="${parsedDate}"></c:out>
	
	
	
	
</body>
</html>