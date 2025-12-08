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
	<c:set var="number" value="3"></c:set>

	<c:choose>

		<c:when test="${number==3}">
			<p>Number is 3</p>
		</c:when>

		<c:when test="${number==5}">
			<p>Number is 5</p>
		</c:when>

		<c:otherwise>
			<p>Number is neither 3 or 5</p>
		</c:otherwise>
	</c:choose>
</body>
</html>