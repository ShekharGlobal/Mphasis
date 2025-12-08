<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="salary" value="15000" />
	<c:if test="${salary gt 20000}">
		<p>Salary is greater than 20000
	</c:if>
	
	<c:if test="${salary le 20000}">
		<p>Salary is not greater than 20000
	</c:if>

</body>
</html>