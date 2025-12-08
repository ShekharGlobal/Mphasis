<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/RegistrationServletEL" method="post">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="fnames" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lname" /></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="radio" name="gender" value="Male" />Male
                    <input type="radio" name="gender" value="Female" />Female</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="register" value="Register" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
