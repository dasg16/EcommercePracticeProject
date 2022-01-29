<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Meal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meal List Page</title>
<link rel ="stylesheet" href = "../CSS/style.css">
<%-- <%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null)
{
	response.sendRedirect("AdminLogin.jsp");
}
%> --%>
</head>
<body style="background-color:#FFEBCD">
<jsp:directive.include file="AdminHeader.jsp" />

	<div align="center">

		<h2  class= "pageheading">Manage Users - No Meal Waste</h2>
	</div>

	<div align="center">
		<h2>Meals Management</h2>
		<h3>
			<a href="CreateMealForm.jsp">Create New Meal</a>
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
				<th>Image</th>
				<th>Category_ID</th>
				<th>Meal Name</th>
				<th>Provider</th>
				<th>Description</th>				
				<th>Price</th>
				<th>Publish Date</th>
				<th>Last Update Time</th>
				<th>Edit Options</th>
			</tr>
			<%
			List<Meal> meal = (List<Meal>) request.getAttribute("listOfMeals");
			%>
			<%
			for (int i = 0; i < meal.size(); i++) {
			%>

			<tr>
				<td>
					<%
					out.println(i + 1);
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getMealId());
					%>
				</td>
				<td style="height:100px;width:80px">
				<img alt="img" src="data:image/jpeg;base64,<%
					out.println(meal.get(i).getBase64Image());
					%>"style = "width:70px; height:auto"/>
				</td>
				<td>
					<%
					out.println(meal.get(i).getCategory());
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getMealName());
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getProvider());
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getDescription());
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getPrice());
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getPublishDate());
					%>
				</td>
				<td>
					<%
					out.println(meal.get(i).getLastUpdateTime());
					%>
				</td>
				<td><a href="meal_edit?id=<%out.println(meal.get(i).getMealId()); %>">Edit</a> | 
				<a href="javascript:confirmDelete(<%out.println(meal.get(i).getMealId());%>)">Delete</a></td>
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
function confirmDelete(mealId) {
	if(confirm('Are you sure you want to delete this meal? '+	mealId)){
		window.location = 'delete_meal?id='+ mealId;
	}
}
</script>

</body>
</html>