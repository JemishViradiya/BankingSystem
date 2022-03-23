<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
	<form:form action="transfer/${clientdetails.client_id }" method="post">
		<div class="container">
			<div class="card">
			<div class="homeButton">
					<a href="home/${clientdetails.client_id }">Home</a>
				</div>
				<table>
			<tr>
				<td>Receiver Account </td>
				<td>
					<form:input path="receiver_account_number"/>
				</td>
			</tr>
			<tr>
				<td>
					Transfer From
				</td>
				<td>
					<select name="sender_account_number" required="required">
					<c:forEach var="account" items="${clientdetails.accountlist }">
						<option value=${account.account_number }>
							${account.account_number }(${account.account_type }) : ${account.account_balance }
						</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Transfer Amount</td>
				<td><form:input path="transaction_amount"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Transfer"/>
				</td>
			</tr>
		</table>
			</div>
		</div>
		
	</form:form>
</body>
</html>