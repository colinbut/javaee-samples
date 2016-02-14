<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Core Tags Examples</title>
</head>
<body>
	
	<%-- setting variable --%>
	<c:set var="test" value="JSTL Core Tags"></c:set>
	
	<%-- out message --%>
	<c:out value="${test}" default="Default Value"></c:out>

	<%-- for each iteration (list) --%>
	<table>
		<c:forEach items="${productList}" var="product" varStatus="status">
			<tr>
				<td><c:out value="${product.name}"></c:out></td>
				<td><c:out value="${product.description}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	<br />
	
	<%-- for each iteration (map) --%>
	<table>
		<c:forEach items="${countryCurrencyMap}" var="entry" >
			<tr>
				<td><c:out value="${entry.key}"/> : <c:out value="${entry.value}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<br />
	
	<%-- if --%>
	<c:if test="${test == 'JSTL Core Tags'}">
		<c:out value="The variable test is set correctly!"></c:out>
	</c:if>
	
	<br />
	
	<%-- Choose When Otherwise (if-else if - else) --%>
	<c:set var="weight" value="1"></c:set>
	<c:choose>
		<c:when test="${weight > 0}">
			<c:out value="Weight is greater than 0!"></c:out>
		</c:when>
		<c:when test="${weight < 0}">
			<c:out value="Weight is less than 0!"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="Weight is equal to 0!"/>
		</c:otherwise>
	</c:choose>
	
	<br />
	
	<%-- Catch --%>
	<c:set var="firstNumber" value="10"></c:set>
	<c:set var="secondNumber" value="0"></c:set>
	
	<c:catch var="exception">
		<c:out value="Dividing ${firstNumber} by ${secondNumber} - ${firstNumber / secondNumber}"></c:out>
	</c:catch>
	<c:if test="${exception != null}">
		<c:out value="Exception is thrown - ${exception}"></c:out>
	</c:if>
	
	<br />
	
	<%-- remove --%>
	<c:set var="price" value="1.99" scope="session"></c:set>
	<c:out value="The price is: ${price}"></c:out>
	<br />
	<c:out value="removing price variable from scope" />
	<c:remove var="price"/>
	<br />
	<c:out value="The price is: ${price}"></c:out>
	
	<br />
	
	<%-- import --%>
	<c:import url="import.jsp" var="imported" ></c:import>
	<%--<c:out value="${imported}"></c:out> --%>
	
	<br />
	
	<%-- forTokens --%>
	<c:forTokens items="25,50,75,100" delims="," var="number">
		<c:out value="${number}"></c:out>
	</c:forTokens>
	
	<br />
	
	<%-- url & param --%>
	<c:url var="link" value="http://localhost:8080/JSTL_Example/">
		<c:param name="productId" value="20"></c:param>
	</c:url>
	<c:import url="${link}"></c:import>
	
	<%-- redirect --%>
	<%-- 
	<c:redirect url="http://localhost:8080/JSTL_Example/">
	</c:redirect>
	--%>
	
</body>
</html>