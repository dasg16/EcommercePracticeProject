<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.nomealwaste.entity.Category"%>
<%@ page import="com.nomealwaste.service.CategoryService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #FFEBCD">
	<div align="center">
		<div>
			<img src="NoMealWasteLogo.JPG" width="400" height="150" />
		</div>

		<div>
			<input type="text" name="keyword" size="50" /> <input type="button"
				value="search" /> <a href="login">Login In</a> | <a href="register">Register
				Account</a> | <a href="view_cart">Cart</a> |

		</div>

		<div>
			<%
			CategoryService categoryDAO = new CategoryService();
			List<Category> categoryList = categoryDAO.listCategory();
			%>
			<%
			for (int i = 0; i < categoryList.size(); i++) {
			%>
			<a href="view_category?id= <%out.println(categoryList.get(i).getCategoryId());%>"> 
			<%
 				if (i != 0) {
 				%> | <%
 				}
 			%> <%
 				out.println(categoryList.get(i).getName());
 				%>

			</a>
			<%
			}
			%>

		</div>

	</div>
</body>
</html>