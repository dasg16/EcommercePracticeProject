<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Header</title>
</head>
<body style="background-color: #FFEBCD">
	<div align="center">
		<div>
			<img alt="" src="../Images/admin.png" width="75" height="75"">
		</div>
		Welcome, Admin ${username} | <a href="admin_logout">Logout</a>
<br>
<br>
		<div id="header_menu">
			<div>
				<a href="list_users"> <img alt="" src="../Images/user.png"
					width="75" height="75"><br> Users
				</a> |
			</div>
			<div>
				<a href="list_categories"> <img alt=""
					src="../Images/category.png" width="75" height="75"><br>
					Categories
				</a> |
			</div>
			<br>
			<div>
				<a href="list_meals"> <img alt="" src="../Images/meal.png" width="75"
					height="75"><br> Meals
				</a> |
			</div>
			<div>
				<a href="customers"> <img alt="" src="../Images/customer.png"
					width="75" height="75"><br> Customers
				</a> |
			</div>
			<div>
				<a href="reviews"> <img alt="" src="../Images/reviews.png"
					width="75" height="75"><br> Reviews
				</a> |
			</div>
			<div>
				<a href="orders"> <img alt="" src="../Images/orders.png"
					width="75" height="75"><br> Orders
				</a>
			</div>
		</div>
</body>
</html>