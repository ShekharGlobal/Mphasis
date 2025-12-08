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
<c:url value="/Login.jsp" var="url">
<c:param name="p1" value="Naveen"></c:param>
<c:param name="p2" value="Kumar"></c:param>
</c:url>

<a href="${url}"> Link</a> 
</body>
</html>