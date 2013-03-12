<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

    <!-- access the value from the variable saved on the server side -->
	<P>The time on the server is ${serverTime}.</P>

	<!-- mapping with the action name and @RequestMapping value withing the controller -->
	<form name="foo" action="foo" method="post">
		<input name="fieldName" type="text" /> <input type="submit"
			value="Submit">
	</form>
	
	<form name="login" action="login" method="post">
		<input name="fieldName" type="text" /> <input type="submit"
			value="login">
	</form>

</body>
</html>
