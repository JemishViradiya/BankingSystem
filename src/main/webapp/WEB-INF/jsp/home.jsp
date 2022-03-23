<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>
* {
	font-family: 'Roboto', sans-serif;
}

td {
	padding: 5px
}

table {
	direction: flex;
	flex-direction: row;
	align-content: center;
	justify-content: center;
	width: 100%;
	padding:10px;
	
}

th, td {
	text-align: left;
}

th {
	background-color: #00264d;
	color: white;
	padding: 10px;
	font-size: 13px;
}

td {
	text-align: left;
	padding: 10px;
	background-color: #385273;
	color:white;
	font-size: 13px
}
td a{
	color:white;
	
}
.container {
	display: flex;
	flex-direction: column;
	justify-content:center;
	margin:5% 0 0 5%;
	width: 80%;
	background-color: #ae768f;
	border-radius: 10px;
}

.card {
	display: flex;
	flex-direction: row;
	align-content: center;
	justify-content: center;
	width: 100%
	
}
.features{
	width:100%;
	font-size: 13px;
	display: flex;
	flex-direction: row;
	align-content:center;
	background-color: #00264d;
	justify-content:space-between;
	border-radius: 10px 10px 0px 0px
	
}

.features a{
	padding:15px;
	text-decoration: none;
	color:white;
}
tr:first-child td{
	text-align: center;
	font-size: 15px;
	background-color: #ae768f
}
</style>
</head>
<body>
	<div class="container">
		<div class="features">
			<a href="../deposit/${clientdetails.client_id }">Deposit</a> 
			<a href="../withdraw/${clientdetails.client_id }">Withdraw</a>
			<a href="../paybills/${clientdetails.client_id }">Pay Bills</a> 
			<a href="../transfer/${clientdetails.client_id }">Transfer Fund</a> 
			<a href="../viewprofile/${clientdetails.client_id }">ViewProfile</a> 
			<a href="../newaccount/${clientdetails.client_id }">Open another
				Account</a>  
				<a href="logout">Logout</a>
		
		</div>
		
		<div class="card">
			<table>
				<tr>
					<td colspan="4">Welcome ${clientdetails.first_name } ${clientdetails.last_name }</td>
				</tr>
				
				<tr>
					<th>Account Number</th>
					<th>Account Type</th>
					<th>Balance</th>
					<th>Action</th>
				</tr>
				<c:forEach var="account" items="${clientdetails.accountlist }">
					<tr>
						<td>${account.account_number }</td>
						<td>${account.account_type }</td>
						<td>$${account.account_balance }</td>
						<td><a
							href="statement/${account.account_number }/${client_id}">Statement</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		
		<br>
	</div>


	
</body>
</html>