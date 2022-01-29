<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Meal"%>
<%@ page import="com.nomealwaste.service.CategoryService"%>
<%@ page import="com.nomealwaste.entity.Category"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Meal</title>
<link rel="stylesheet" href="../CSS/style.css">
<%-- <%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if (session.getAttribute("username") == null) {
	response.sendRedirect("AdminLogin.jsp");
}
%> --%>
</head>
<body style="background-color: #FFEBCD">
	<jsp:directive.include file="AdminHeader.jsp" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

	<div align="center">
		<%
		Meal meal = (Meal) request.getAttribute("mealObj");
		%>
		<%
		if (meal == null) {
		%>
		<h2>Create New Meal</h2>
		<%
		}
		%>

		<%
		if (meal != null) {
		%>
		<h2>Edit Meal</h2>
		<%
		}
		%>

	</div>


	<div align="center">
		<%
		if (meal == null) {
		%>
		<form action="create_meal" enctype='multipart/form-data' method="post"
			onsubmit="return validateFormInput()">

			<%
			}
			%>

			<%
			if (meal != null) {
			%>
			<form action="update_meal" enctype='multipart/form-data' method="post"
				onsubmit="return validateFormInput()">
				<input type="hidden" name="mealId"
					value=<%out.println(meal.getMealId());%> />
					console.log("<%out.println(meal.getMealId());%>");
				<%
				}
				%>
				
				<%
						CategoryService categoryService = new CategoryService();
						List<Category> category = categoryService.listCategory();
								%>

				<table>

					<tr>
						<td>Category:</td>
						<%
						if (meal != null) {
						%>
						<td>
						<select name="category" class="custom-select" id="category" style="width:170px">
								<%
								for (int i = 0; i < category.size(); i++) {
								%>
								<option value= "<%out.println(category.get(i).getName());%>"><%out.println(category.get(i).getName());%></option>
								<%
						}
						%>
 					</select></td>

						
					<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td>
						
						<select name="category" class="custom-select" id="category" style="width:170px">
						
								<%
								for (int i = 0; i < category.size(); i++) {
								%>
								<option value= "<%out.println(category.get(i).getName());%>"><%out.println(category.get(i).getName());%></option>
								<%
						}
						%>
						</select></td>
						<%
						}
						%> 

					</tr>


					<tr>
						<td>Meal Name:</td>
						<%
						if (meal != null) {
						%>
						<td><input type="text" id="name" name="name" size="20"
							value="<%out.println(meal.getMealName());%>" /></td>
						<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td><input type="text" id="name" name="name" size="20" /></td>
						<%
						}
						%>

					</tr>
					<tr>
						<td>Meal Provider Name:</td>
						<%
						if (meal != null) {
						%>

						<td><input type="text" id="provider" name="provider"
							size="20" value="<%out.println(meal.getProvider());%>" /></td>
						<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td><input type="text" id="provider" name="provider"
							size="20" /></td>
						<%
						}
						%>
					</tr>
					<tr>
						<td>Publish Date:</td>
						<%
						if (meal != null) {
						%>
									
						<td><input autocomplete="false" type="text" id="datepicker" name="publish_date"
							size="20" value="<%out.println(meal.getPublishDate());%>" /></td>
						<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td><input autocomplete="false" type="text" id="datepicker" name="publish_date"
							size="20" /></td>
						<%
						}
						%>
					</tr>

					<tr>
						<td>Description:</td>
						<%
						if (meal != null) {
						%>
						<td><input type="text" id="description" name="description"
							size="20" value="<%out.println(meal.getDescription());%>" /></td>
						<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td><input type="text" id="description" name="description"
							size="20" /></td>
						<%
						}
						%>
					</tr>

					<tr>
						<td>Image:</td>
						<%
						if (meal != null) {
						%>
						<td><input type="file" onchange="onFileSelected(event)" id="image" name="image" size="20"
							value="<%out.println(meal.getImage());%>" /><br>
							<img alt="Image Preview" id="thumbnail" style = "width:10% ; margin-top:10px">
							</td>
						<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td><input type="file" onchange="onFileSelected(event)" id="image" name="image" size="20" /><br>
						<img alt="Image Preview" id="thumbnail" style = "width:10% ; margin-top:10px">
						</td>
						
						<%
						}
						%>
					</tr>

					<tr>
						<td>Price:</td>
						<%
						if (meal != null) {
						%>
						<td><input type="text" id="price" name="price" size="20"
							value="<%out.println(meal.getPrice());%>" /></td>
						<%
						}
						%>

						<%
						if (meal == null) {
						%>
						<td><input type="text" id="price" name="price" size="20" /></td>
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
	
	function onFileSelected(event) {
		  var selectedFile = event.target.files[0];
		  var reader = new FileReader();

		  var imgtag = document.getElementById("thumbnail");
		  imgtag.title = selectedFile.name;

		  reader.onload = function(event) {
		    imgtag.src = event.target.result;
		  };

		  reader.readAsDataURL(selectedFile);
		}
	
	 $( function() {
		    $( "#datepicker" ).datepicker();
	} );
</script>
</html>