<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
   
</head>
<body>

    <c:set var="salary" value="2500" />

    <c:if test="${salary > 2000}">
        <p>Salary is greater than 2000</p>
    </c:if>

    <c:if test="${salary <= 2000}">
        <p>Salary is not greater than 2000</p>
    </c:if>

</body>
</html>
