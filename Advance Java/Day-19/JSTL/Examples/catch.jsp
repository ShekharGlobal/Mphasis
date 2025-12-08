<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:catch var="v1">
		<%
		int x = 10 / 0;
		%>
	</c:catch>

	<c:if test="${v1 !=null}">
		<p>Exception is: ${v1}</p>
		<p>${v1.message}</p>
	</c:if>
</body>
</html>