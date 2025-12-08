<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="number" value="3" />
<c:choose>
    <c:when test="${number == 3}">
        Number is 3
    </c:when> 
    <c:when test="${number == 5}">
        Number is 5
    </c:when>
    <c:otherwise> 
        Number is not 3 or 5
    </c:otherwise>
</c:choose>
</body>
</html>