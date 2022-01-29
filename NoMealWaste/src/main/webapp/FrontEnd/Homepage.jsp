<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body style="background-color:#FFEBCD">
	<form action="homepage" method="post">
		<jsp:directive.include file="Header.jsp" />
		<div align="center">
			<h3>Main Content</h3>
			<h2>New Food Supplier</h2>
			<h2>Best Services Food Supplier</h2>
			<h2>Most Favorite Food Supplier</h2>
		</div>

		

		<jsp:directive.include file="Footer.jsp" />
	</form>



</body>
</html>