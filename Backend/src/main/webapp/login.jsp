<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Login Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div style="width: 330px; margin: auto;">
		<h1>Login Page</h1>

		<table>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Role</th>
			</tr>
			<tr>
				<td>adam</td>
				<td>adampassword</td>
				<td>ROLE_USER</td>
			</tr>
			<tr>
				<td>jane</td>
				<td>janepassword</td>
				<td nowrap>ROLE_USER, ROLE_ADMIN</td>
			</tr>
			<tr>
				<td>sue</td>
				<td>suepassword</td>
				<td>ROLE_USER, ROLE_EDIT</td>
			</tr>
		</table>
		<br />
		<div class="form">
			<form name="f" action="j_spring_security_check" method="post">
				<label for="username">Username:</label><input id="username"
					name="j_username"> </br> <label for="password">Password:</label><input
					id="password" name="j_password" type='password'> </br>
				<input name="submit" type="submit" value="Login" />
			</form>
		</div>
	</div>
</body>
</html>