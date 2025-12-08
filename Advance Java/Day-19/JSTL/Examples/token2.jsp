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
<c:set var="list" value="Ajay,Pratap,Singh"></c:set>
<c:forTokens items="${list}" delims="," var="t1">
<p><c:out value="${t1}"></c:out>
</c:forTokens>

</body>
</html>