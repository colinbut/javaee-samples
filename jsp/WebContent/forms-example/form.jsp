<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form example</title>
</head>
<body>
	<form name="form" method="get" action="textInput.jsp">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="22%">&nbsp;</td>
				<td width="78%">&nbsp;</td>
			</tr>
			<tr>
				<td>Name Student</td>
				<td><input type="text" name="studentName"/></td>
			</tr>
			<tr>
				<td>Active<input type="radio" name="active" value="Active"/></td>
				<td>Deactive<input type="radio" name="deactive" value="DeActive"/></td>
			</tr>
			<tr>
				<td>State<input type="checkbox" name="state" value="State"/></td>
				<td>City<input type="checkbox" name="city" value="City"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			
		</table>
	</form>
</body>
</html>