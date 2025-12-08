<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	User Agent : ${header["user-agent"]}
	<br /> Count Attribute : ${count}
	<br /> Application Scope Attribute : ${applicationScope.count}
	<br /> Session Scope Attribute : ${sessionScope.count}
	<br /> Request Scope Attribute : ${requestScope.count}
	<br />

	<h1>Registration Details</h1>
	<table>
		<tr>
			<td>First Name</td>
			<td>${param.fnames}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${param.lname}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${param.gender}</td>
		</tr>
	</table>

	<h1>Registration Details in User Bean</h1>
	<table>
		<tr>
			<td>First Name</td>
			<td>${userBean.fName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${userBean.lName}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${userBean.gender}</td>
		</tr>
	</table>
</body>
</html>