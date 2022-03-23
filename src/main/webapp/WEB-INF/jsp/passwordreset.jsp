<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

input[type="password"] {
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
<script type="text/javascript">

	function validate()
	{
		if(document.form.oldpassword.value!=document.form.password.value)
			{
				alert("Old Password does not match with database")
				return false;
			}
		else{
			if(document.form.newpassword.value!=document.form.confirmpassword.value)
			{
				alert("New Password and confirm password are not same !!!")
				document.form.confirmpassword.value="";
				return false;
			}
		}
		
	
		return true;
		
	}
	
</script>
<body>

	<form name="form" action="resetpassword/${client_id }" method="post"
		onsubmit="return validate();">
		<div class="container">
			<div class="card">
				<div class="homeButton">
					<a href="loginpage">Back</a>
				</div>
				<table>
					<tr>
						<td><input type="hidden" value="${oldpassword }"
							name="oldpassword" /></td>
					</tr>
					<tr>
						<td><input type="password" id="password" name="password"
							placeholder="enter old password" /></td>
					</tr>
					<tr>
						<td><input type="password" id="newpassword"
							name="newpassword" placeholder="enter new password" /></td>
					</tr>
					<tr>
						<td><input type="password" id="" name="confirmpassword"
							placeholder="confirm password" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="RESET PASSWORD" /></td>
					</tr>
				</table>
			</div>
		</div>

	</form>
</body>
</html>