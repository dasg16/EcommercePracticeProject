<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel ="stylesheet" href = "../CSS/style.css">   	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body style="background-color: #FFEBCD">
	<div align="center">

		<h1>NoMealWaste Store Administration</h1>
		<h2>Admin Login</h2>

		<form action="login_form" action="login" method="post">

			<table>

				<tr>
					<td>Email:</td>
					<td><input type="text" placeholder="Enter Email" name="email"
						id="email" size="20" required></td>

				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" placeholder="Enter Password"
						name="password" id="password" size="20" required></td>
					
				</tr>
				
				<tr>
				<td colspan="2" align="center">
					<button type="submit">Login</button>	
				</td>				
				</tr>
				
				
			</table>
			
				<div align="center">
				<h4 class="loginFailure_message"><b>${LoginStatus}</b></label>
				</div>				
				
	</div>
</body>
</html>