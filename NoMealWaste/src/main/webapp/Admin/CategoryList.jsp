<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Category"%>
<link rel ="stylesheet" href = "../CSS/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

		<h2  class= "pageheading" >Manage Categories - No Meal Waste</h2>
	</div>

	<div align="center">
		<h2>Category Management</h2>
		<h3>
			<a href="CreateCategoryForm.jsp">Create New Category</a>
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
				<th>Name</th>
				<th>Edit Options</th>
			</tr>
			<%
			List<Category> category = (List<Category>) request.getAttribute("listCategories");
			%>
			<%
			for (int i = 0; i < category.size(); i++) {
			%>

			<tr>
				<td>
					<%
					out.println(i + 1);
					%>
				</td>
				<td>
					<%
					out.println(category.get(i).getCategoryId());
					%>
				</td>
				<td>
					<%
					out.println(category.get(i).getName());
					%>
				</td>
				<td><a href="category_edit?id=<%out.println(category.get(i).getCategoryId()); %>">Edit</a> | 
				<a href="javascript:confirmDelete(<%out.println(category.get(i).getCategoryId());%>)">Delete</a></td>
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
function confirmDelete(categoryId) {
	if(confirm('Are you sure you want to delete this category? '+	categoryId)){
		window.location = 'delete_category?id='+ categoryId;
	}
}
</script>
</body>
</html>