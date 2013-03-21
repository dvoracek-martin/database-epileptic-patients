<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Login Page</title>
<link rel="stylesheet" href="resources/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="GENEPI team">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="resources/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="resources/ico/favicon.png">
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
				<input type="text" id="username" class="input-block-level"
					name="j_username" placeholder="Username"> <input
					type="password" id="password" name="j_password"
					class="input-block-level" placeholder="Password">
				<button class="btn btn-large btn-primary" type="submit">Sign in</button>
			</form>
		</div>
	</div>

	<div id="wrapper" style="width: 100%; text-align: center">
		<img src="resources/img/genepi.png" />
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap-transition.js"></script>
	<script src="resources/js/bootstrap-alert.js"></script>
	<script src="resources/js/bootstrap-modal.js"></script>
	<script src="resources/js/bootstrap-dropdown.js"></script>
	<script src="resources/js/bootstrap-scrollspy.js"></script>
	<script src="resources/js/bootstrap-tab.js"></script>
	<script src="resources/js/bootstrap-tooltip.js"></script>
	<script src="resources/js/bootstrap-popover.js"></script>
	<script src="resources/js/bootstrap-button.js"></script>
	<script src="resources/js/bootstrap-collapse.js"></script>
	<script src="resources/js/bootstrap-carousel.js"></script>
	<script src="resources/js/bootstrap-typeahead.js"></script>
</body>
</html>