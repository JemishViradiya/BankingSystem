<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
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
	padding: 10px;
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
	color: white;
	font-size: 13px
}

.link a {
	color: white;
	text-decoration: none;
	text-align: center;
	padding:10px;
	background-color: #00264d
}

.link {
	text-align: center;
	
}

.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 5% 0 0 5%;
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
				<a href="loginpage">Logout</a>
			</div>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Address</th>
					<th>Accounts</th>

				</tr>
				<c:forEach var="client" items="${clientlist }">
					<tr>
						<td>${client.first_name }</td>
						<td>${client.last_name }</td>
						<td>${client.email }</td>
						<td class="link"><c:choose>
								<c:when test="${empty client.accountlist  }">
									<a href="provide/${client.client_id }">Provide an
										Account</a>
								</c:when>
								<c:otherwise>
									<table>
										<c:forEach var="account" items="${client.accountlist }">
											<tr>
												<td>${account.account_number }</td>
												<td>${account.account_type }</td>
												<td>$${account.account_balance }</td>
											</tr>
										</c:forEach>
										<c:forEach var="request" items="${requestlist }">
											<tr >
												<td class="link" colspan="3"><c:if
														test="${request.client_id == client.client_id }">
														<a href="provide/${request.id }/${client.client_id }">Provide
															${request.account_type } Account</a>
													</c:if></td>
											</tr>

										</c:forEach>
									</table>
								</c:otherwise>

							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>