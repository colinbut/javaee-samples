<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Functions Tags Example</title>
</head>
<body>

	<%-- length function --%>
	<c:out value="Length of text 'Hello' is: ${fn:length('Hello')}"></c:out>
	<br />
	
	<%-- substring function --%>
	<c:out value="${fn:substring('Hello',1,3)}"></c:out>
	<br />
	
	<%-- substringBefore function --%>
	<c:out value="${fn:substringBefore('Hello-Joe','-')}"></c:out>
	<br />
	
	<%-- substringAfter function --%>
	<c:out value="${fn:substringAfter('Hello-Joe','-')}"></c:out>
	<br />
	
	<%-- trim function --%>
	<c:out value="${fn:trim(' Bob the Builder    ')} is awesome!"></c:out>
	<br />
	
	<%-- replace function --%>
	<c:out value="${fn:replace('Joe Bloggs', 'Bloggs', 'Doe')}"></c:out>
	<br />
	
	<%-- contains function --%>
	<c:out value="${fn:contains('Hello','el')}"></c:out>
	<br />
	
	<%-- split & join  function --%>
	<c:set var="array1" value="${fn:split('Hi my name is Joe', ' ')}"></c:set>
	<c:out value="${fn:join(array1, '-')}"></c:out>
	<br />
	
	<%-- indexOf function --%>
	<c:out value="${fn:indexOf('Hello','llo')}"></c:out>
	<br />
	
	<%-- startsWith function --%>
	<c:out value="${fn:startsWith('My name is Joe Doe','My na')}"></c:out>
	<br />
	
	<%-- endsWith function --%>
	<c:out value="${fn:endsWith('My name is Joe Doe','Doe')}"></c:out>
	<br />
	
	<%-- toLowerCase function --%>
	<c:out value="${fn:toLowerCase('Joe Bloggs')}"></c:out>
	<br />
	
	<%-- toUpperCase function --%>
	<c:out value="${fn:toUpperCase('Joe Bloggs')}"></c:out>
	<br />
	
	<%-- containsIgnoreCase function --%>
	<c:out value="${fn:containsIgnoreCase('JoeBloggs','ebl')}"></c:out>
	<br />
	
	<%-- escapeXml function --%>
	<c:set var="xmlString" value="This is <b> JSTL escapeXML example </b> in this 
								JSTL function examples"></c:set>
	Without escaping : ${xmlString}
	<br />
	Using escapeXml - ${fn:escapeXml(xmlString)}

</body>
</html>