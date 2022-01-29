<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel ="stylesheet" href = "../CSS/style.css">    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>No Meal Waste</title>

<%-- <%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null)
{
	response.sendRedirect("AdminLogin.jsp");
}
%> --%>

</head>
<body style="background-color:#FFEBCD">
<jsp:directive.include file="AdminHeader.jsp"/>

<div align= "center">

<h2 class= "pageheading">Administrative Dashboard</h2>
</div>
<div align= "center">

<hr width = 70% style="height:2px;border-width:0;color:gray;background-color:gray">
<h2 class= "pageheading">Quick Actions: </h2>
<a href="create_meal">Add New Meals</a> |
<a href="create_user">Add New User</a> |
<a href="create_categories">Add New Category</a> |
<a href="create_customer">Add New Customer</a> 
</div>
<hr width = 70% style="height:2px;border-width:0;color:gray;background-color:gray">

<div align= "center">
<h2 class= "pageheading">Recent Sales: </h2>
</div>
<hr width = 70% style="height:2px;border-width:0;color:gray;background-color:gray">

<div align= "center">
<h2 class= "pageheading">Recent Reviews: </h2>
</div>
<hr width = 70% style="height:2px;border-width:0;color:gray;background-color:gray">

<div align= "center">
<h2 class= "pageheading">Statistics: </h2>
</div>
<hr width = 70% style="height:2px;border-width:0;color:gray;background-color:gray">




<div align= "center">
<jsp:directive.include file="AdminFooter.jsp"/>
</div>
</body>
</html>