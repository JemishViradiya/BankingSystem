<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    
<title>Login Page</title>
<style>
	*{
		font-family: 'Roboto', sans-serif;
	}
	.container{
		display: flex;
		flex-direction:row;
		align-content:center;
		justify-content: center;
		margin-top:10%
	}
	.card{
		display: flex;
		flex-direction: row;
		align-content:center;
		justify-content: center;
		padding:15px;
		border-radius:5px;
		
		background-color: #bbb8cd;
	}
	table{
		padding:5px;
		display: flex;
		flex-direction: row;
		align-items: center;
		justify-content: center;
	}
	td{
		padding:5px;
		color: #00264d;
	}
	input[type="text"], input[type="password"]
	{
	
		padding:5px;
		width:200px;
		background-color: #385273;
		border: none;
		color:white;
	}
	input[type="submit"]
	{
		width:100%;
		padding:7px;
		background-color: #00264d;
		border: none;
		color: white;
		cursor: pointer;
	}
	td:last-child {
		text-align: center;
		color:#00264d;
	}
</style>
</head>
<body>
	${message }
	<form:form action="login" method="post">
		<div class="container">
			<div class="card">
				<table>
					<tr>
						<td>UserName</td>
						<td>
							<input type="text" name="username" placeholder="Username" />
						</td>
					</tr>
					<tr>
						<td>Password</td>
						<td>
							<input type="password" name="password" placeholder="Password" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="LOGIN"/>				
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<a href="register">Don't have Account with us?</a>
						</td>
					</tr>	
				</table>
			</div>
		</div>
	</form:form>
	
</body>
</html>