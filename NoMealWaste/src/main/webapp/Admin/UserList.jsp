<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Users"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List Page</title>
<link rel ="stylesheet" href = "../CSS/style.css">
<%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null)
{
	response.sendRedirect("AdminLogin.jsp");
}
%>
</head>
<body style="background-color:#FFEBCD">
	<jsp:directive.include file="AdminHeader.jsp" />

	<div align="center">

		<h2  class= "pageheading">Manage Users - No Meal Waste</h2>
	</div>

	<div align="center">
		<h2>Users Management</h2>
		<h3>
			<a href="CreateUserForm.jsp">Create New User</a>
		</h3>
	</div>
	<div align="center">
		<h4 class="success_message"><b>${updateSuccessStatus}</b></label>
		<h4 class="failure_message"><b>${updateFailedStatus}</b></label>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Edit Options</th>
			</tr>
			<%
			List<Users> user = (List<Users>) request.getAttribute("listUsers");
			%>
			<%
			for (int i = 0; i < user.size(); i++) {
			%>

			<tr>
				<td>
					<%
					out.println(i + 1);
					%>
				</td>
				<td>
					<%
					out.println(user.get(i).getUserID());
					%>
				</td>
				<td>
					<%
					out.println(user.get(i).getEmail());
					%>
				</td>
				<td>
					<%
					out.println(user.get(i).getFullName());
					%>
				</td>
				<td><a href="user_edit?id=<%out.println(user.get(i).getUserID()); %>">Edit</a> | 
				<a href="javascript:confirmDelete(<%out.println(user.get(i).getUserID());%>)">Delete</a></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<div align="center">
		<jsp:directive.include file="AdminFooter.jsp" />
	</div>
	
<script type="text/javascript">
function confirmDelete(userId) {
	if(confirm('Are you sure you want to delete this user? '+	userId)){
		window.location = 'delete_user?id='+ userId;
	}
}
</script>
</body>
</html>