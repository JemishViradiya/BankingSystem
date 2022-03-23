<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receiver Info</title>
<style>
* {
	font-family: 'Roboto', sans-serif;
}

.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin-top: 10%
}

.card {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	justify-content: center;
	padding: 15px;
	border-radius: 5px;
	background-color: #bbb8cd;
}

table {
	padding: 5px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
}

td {
	padding: 5px;
	color: #00264d;
}

input[type="text"], input[type="email"] {
	padding: 5px;
	width: 250px;
	background-color: #385273;
	border: none;
	color: white;
}

select {
	padding: 5px;
	width: 260px;
	-moz-appearance: none;
	-webkit-appearance: none;
	appearance: none;
	background-color: #385273;
	border: none;
	color: white;
}

select::-ms-expand {
	color: white;
	background-color: #385273;
	border: none;
}

input[type="submit"] {
	width: 100%;
	padding: 7px;
	background-color: #00264d;
	border: none;
	color: white;
	cursor: pointer;
}

td:last-child {
	text-align: center;
	color: #00264d;
}

.homeButton {
	margin-top: -15px;
	margin-left: 15px;
	padding: 15px 6px 6px 6px;
	border-radius: 0 0 5px 5px;
	background-color: #00264d;
	font-size: 12px;
	cursor: pointer;
}

.homeButton a {
	text-decoration: none;
	color: white;
}
</style>
</head>
<body>
	${error }
	<form action="verify/${clientdetails.client_id }" method="post">
		<div class="container">
			<div class="card">
			<div class="homeButton">
					<a href="home/${clientdetails.client_id }">Home</a>
				</div>
				<table>
			<tr>
				<td>Receiver First Name</td>
				<td>
					<input type="text" name="client.first_name" placeholder="first name" />
				</td>
			</tr>
			<tr>
				<td>Receiver Last Name</td>
				<td><input type="text" name="client.last_name" placeholder="last name" /></td>
			</tr>
			<tr>
				<td>Receiver Email Id</td>
				<td><input type="email" name="client.email" placeholder="email address"/></td>
			</tr>
			<tr>
				<td>Receiver Account Number</td>
				<td><input type="text" name="account_number" placeholder="account number"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="VERIFY RECEIVER" /></td>
			</tr>
		</table>
			</div>
		</div>
		
	</form>
	
</body>
</html>