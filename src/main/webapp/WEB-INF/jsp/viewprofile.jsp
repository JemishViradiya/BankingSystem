<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
<style>
* {
	font-family: 'Roboto', sans-serif;
}

.container {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin-top: 5%;
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
.fields{
display: flex;
	flex-direction: row;
	align-items:flex-start;
	justify-content: space-between;
}
.table {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
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

input[type="text"] {
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
	letter-spacing: 2px;
}
.button{
	width:100%
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
	<form:form action="updateprofile/${client_id }" method="post">
		<div class="container">
			<div class="card">
				<div class="homeButton">
					<a href="home/${client_id }">Home</a>
				</div>
				<div class="fields">
				<div class="table">


					<table>
						<tr>
							<td><form:input path="first_name" /></td>
						</tr>
						<tr>
							<td><form:input path="last_name" /></td>

						</tr>
						<tr>
							<td><form:input path="monthly_income" /></td>

						</tr>
						<tr>
							<td>Male : <form:radiobutton path="gender" value="Male" />

								Female :<form:radiobutton path="gender" value="Female" />
							</td>
						</tr>
						<tr>
							<td><form:input path="birth_date" /></td>
						</tr>
						<tr>
							<td>Single :<form:radiobutton path="marital_status"
									value="Single" /> Married : <form:radiobutton
									path="marital_status" value="Married" /> Divorced: <form:radiobutton
									path="marital_status" value="Divorced" />
							</td>
						</tr>
						<tr>
							<td><form:input path="telephone_number" /></td>
						</tr>
						
					</table>
				</div>
				<div class="table">
					<table>
						<tr>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><form:input path="address.street_address" /></td>
						</tr>
						<tr>
							<td><form:input path="address.city" /></td>
						</tr>
						<tr>
							<td><form:input path="address.state" /></td>
						</tr>
						<tr>
							<td><form:input path="address.postal_code" /></td>
						</tr>
						<tr>
							<td><form:input path="address.country" /></td>
						</tr>
						
					</table>
				</div>
				</div>
				<div class="button">
					<input type="submit" value="UPDATE" />
				</div>
			</div>
		</div>

	</form:form>
</body>
</html>