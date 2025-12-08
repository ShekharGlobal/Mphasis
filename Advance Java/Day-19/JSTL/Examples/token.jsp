<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

	<c:set var="list" value="Ajay,Pratap,Singh"></c:set>
	
	<c:forTokens items="${list}" delims="," var="token">
	<p><c:out value="${token}">
	
	</c:out></p>
	</c:forTokens>

</body>
</html>