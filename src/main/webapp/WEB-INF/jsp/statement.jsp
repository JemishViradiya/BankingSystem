<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statement</title>
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
	align-items:center;
	margin:5% 0 0 5%;
	width: 80%;
	background-color: #ae768f;
	border-radius: 10px;
}

.card {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	justify-content: center;
	padding: 15px;
	border-radius: 5px;
	
	width: 100%
	
}

tr:first-child td{
	text-align: center;
	font-size: 15px;
	background-color: #ae768f
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
		<div class="container">
			<div class="card">
			<div class="homeButton">
					<a href="home/${client_id }">Home</a>
				</div>
					<table>
			<tr>
				<th>Date</th>
				<th>Description</th>
			</tr>
			<c:forEach var="transaction" items="${transactionlist }">
				<tr>
					<td>${transaction.transaction_date }</td>
					<td>
						<c:choose>
						<c:when test="${transaction.transaction_type eq 'Deposit' }">
							$${transaction.transaction_amount } Deposited into Account
						</c:when>
						<c:when test="${transaction.transaction_type eq 'Withdraw' }">
							$${transaction.transaction_amount } Withdraw from Account
						</c:when>
						<c:when test="${transaction.transaction_type eq 'Transfer' &&
								transaction.receiver_account_number ne account }">
							$${transaction.transaction_amount } Transfer into 
							${transaction.receiver_account_number }
						</c:when>
						<c:when test="${transaction.transaction_type eq 'Transfer' &&  
									transaction.receiver_account_number eq account}" >
							$${transaction.transaction_amount } Received from ${transaction.sender_account_number }
						</c:when>
						<c:otherwise>
							$${transaction.transaction_amount } of ${transaction.transaction_type } (${transaction.receiver_account_number })
							has paid
						</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
			</div>
		</div>
		
		
</body>
</html>