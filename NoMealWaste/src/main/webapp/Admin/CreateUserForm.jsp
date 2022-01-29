<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>
<script type="text/javascript" src="../JS/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../CSS/style.css">
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if (session.getAttribute("username") == null) {
	response.sendRedirect("AdminLogin.jsp");
}
%>
</head>
<body style="background-color: #FFEBCD">
	<jsp:directive.include file="AdminHeader.jsp" />

	<div align="center">
		<%
		Users user = (Users) request.getAttribute("userObj");
		%>
		<%
		if (user == null) {
		%>
		<h2>Create New User</h2>
		<%
		}
		%>

		<%
		if (user != null) {
		%>
		<h2>Edit User</h2>
		<%
		}
		%>

	</div>


	<div align="center">
		<%
		if (user == null) {
		%>
		<form action="create_user" method="post" onsubmit="return validateFormInput()">

			<%
			}
			%>

			<%
			if (user != null) {
			%>
			<form action="update_user" method="post" onsubmit="return validateFormInput()">
				<input type="hidden" name="userId"
					value=<%out.println(user.getUserID());%> />
				<%
				}
				%>

				<table>

					<tr>
						<td>Email:</td>
						<%
						if (user != null) {
						%>
						<td><input type="text" id="email" name="email" size="20"
							value="<%out.println(user.getEmail());%>" /></td>
						<%
						}
						%>

						<%
						if (user == null) {
						%>
						<td><input type="text" id="email" name="email" size="20" /></td>
						<%
						}
						%>

					</tr>
					<tr>
						<%
						if (user != null) {
						%>
						<td>Full Name:</td>
						<td><input type="text" id="fullname" name="fullname"
							size="20" value="<%out.println(user.getFullName());%>" /></td>
						<%
						}
						%>

						<%
						if (user == null) {
						%>
						<td>Full Name:</td>
						<td><input type="text" id="fullname" name="fullname"
							size="20" /></td>
						<%
						}
						%>
					</tr>
					<tr>

						<%
						if (user != null) {
						%>
						<td>Password:</td>
						<td><input type="text" id="password" name="password"
							size="20" value="<%out.println(user.getPassword());%>" /></td>
						<%
						}
						%>

						<%
						if (user == null) {
						%>
						<td>Password:</td>
						<td><input type="text" id="password" name="password"
							size="20" /></td>
						<%
						}
						%>
					</tr>

					<tr>
						<td><button type="submit">Save</button>
							<button onclick="javascript:history.go(-1);">Cancel</button></td>
					</tr>

				</table>
			</form>
	</div>

	<div align="center">
		<jsp:directive.include file="AdminFooter.jsp" />
	</div>
</body>
<script type="text/javascript">
	
		$(document).ready(function() {
			$("#userform").validate({
			rules:{
				email: "required",
				fullname: "required",
				password: "required",
			},
			messages:{
				email: "Please Enter Email",
				fullname: "Please Enter Full Name",
				password: "Please Enter Password"
			}
				
			});
		});
		function validateFormInput() {
		var fieldEmail = document.getElementById("email");
		var fieldPassword = document.getElementById("password");
		var fieldFullName = document.getElementById("fullname");
		if (fieldEmail.value.length == 0) {
			alert("Email is required!")
			fieldEmail.focus();
			return false;
		}
		if (fieldPassword.value.length == 0) {
			alert("Password is required!")
			fieldPassword.focus();
			return false;
		}
		if (fieldFullName.value.length == 0) {
			alert("Full Name is required!")
			fieldFullName.focus();
			return false;
		}
		return true; 
	 } 
</script>

</html>