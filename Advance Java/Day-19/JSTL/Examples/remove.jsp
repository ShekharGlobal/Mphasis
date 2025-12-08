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
<c:set var="v1" value="Welcome"></c:set>
<p>Before Removal: ${v1}</p> 

<c:remove var="v1"/>
<p>After Removal: ${v1}</p> 

</body>
</html>