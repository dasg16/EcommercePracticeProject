<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Category"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>
<script type="text/javascript" src="../JS/jquery-3.6.0.min.js"></script>
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
		<%
		Category category = (Category) request.getAttribute("categoryObj");
		%>
		<%
		if (category == null) {
		%>
		<h2>Create New Category</h2>
		<%
		}
		%>

		<%
		if (category != null) {
		%>
		<h2>Edit Category</h2>
		<%
		}
		%>

	</div>


	<div align="center">
		<%
		if (category == null) {
		%>
		<form action="create_categories" method="post"
			onsubmit="return validateFormInput()">

			<%
			}
			%>
			
			<%
			if (category != null) {
			%>
			<form action="update_categories" method="post"
				onsubmit="return validateFormInput()">
				<input type = "hidden" name = "categoryId" value = <%out.println(category.getCategoryId());%>/>
				<%
				}
				%>

				<table>

					<tr>
						<td>Name:</td>
						<%
						if (category != null) {
						%>
						<td><input type="text" id="name" name="name" size="20"
							value="<%out.println(category.getName());%>" /></td>
						<%
						}
						%>

						<%
						if (category == null) {
						%>
						<td><input type="text" id="name" name="name" size="20" /></td>
						<%
						}
						%>

					</tr>
					<tr>
						<td><button type="submit">Save</button> 
						<button onclick="javascript:history.go(-1);">Cancel</button> 
						</td>
					</tr>

				</table>
			</form>
	</div>

	<div align="center">
		<jsp:directive.include file="AdminFooter.jsp" />
	</div>
</body>
<script type="text/javascript">
	function validateFormInput() {
		var fieldName = document.getElementById("name");
		if (fieldName.value.length == 0) {
			alert("Name is required!")
			fieldName.focus();
			return false;
		}
		return true;
	}
</script>

</html>