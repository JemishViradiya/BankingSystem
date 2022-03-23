<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
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

.fields {
	display: flex;
	flex-direction: row;
	align-items: flex-start;
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

input[type="text"], input[type="email"], input[type="number"], input[type="date"]
	{
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

.button {
	width: 100%
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
	<form action="register" method="post">
		<div class="container">
			<div class="card">
				<div class="homeButton">
					<a href="loginpage">Home</a>
				</div>
				<div class="fields">
					<div class="table">
						<table>
							<tr>
								<td>First Name</td>
								<td><input type="text" name="first_name" /></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="last_name" /></td>
							</tr>
							<tr>
								<td>Identity Card Number</td>
								<td><input type="text" name="id_card_number" /></td>
							</tr>
							<tr>
								<td>Mobile Number</td>
								<td><input type="text" name="telephone_number" /></td>
							<tr>
								<td>Email id</td>
								<td><input type="email" name="email" /></td>
							</tr>
							<tr>
								<td>Monthly Income</td>
								<td><input type="number" name="monthly_income" /></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>Male<input type="radio" name="gender" value="Male">
									Female<input type="radio" name="gender" value="Female" />
								</td>
							</tr>
							<tr>
								<td>Birth Date</td>
								<td><input type="date" name="birth_date" value="2021-12-05" /></td>
							</tr>
							
						</table>
					</div>
					<div class="table">
						<table>
							<tr>
								<td>Marital Status</td>
								<td>Married<input type="radio" name="marital_status"
									value="Married"> Single<input type="radio"
									name="marital_status" value="Single" /> Divorced<input
									type="radio" name="marital_status" value="Divorced" />
								</td>
							</tr>
							<tr>
								<td>Street Name</td>
								<td><input type="text" name="address.street_address" /></td>
							</tr>
							<tr>
								<td>City</td>
								<td><input type="text" name="address.city" /></td>
							</tr>
							<tr>
								<td>State</td>
								<td><input type="text" name="address.state" /></td>
							</tr>
							<tr>
								<td>Postal Code</td>
								<td><input type="text" name="address.postal_code" /></td>
							</tr>
							<tr>
								<td>Country</td>
								<td><input type="text" name="address.country" /></td>
							</tr>

						</table>
					</div>
				</div>
				<div class="button">
					<input type="submit" value="REGISTER" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>