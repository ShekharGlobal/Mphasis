<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>JSTL Example</title>
</head>
<body>

    <!-- Import content from another JSP or URL -->
    <c:import url="header.jsp" />

    <h1>Main Content</h1>
    <p>This is the main content of the page.</p>

    <!-- Import content from another JSP or URL -->
    <c:import url="footer.jsp" />

</body>
</html>