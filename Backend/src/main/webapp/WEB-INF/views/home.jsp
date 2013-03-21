<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Home Page</title>
</head>
<body>
	<a href="j_spring_security_logout">Logout</a>
	<h1>Home Page</h1>
	<P>The time on the server is ${serverTime}.</P>

	<%
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername();
		Collection<GrantedAuthority> authorities = user.getAuthorities();
	%>
	<form name="foo" action="foo" method="post">
		<input name="fieldName" type="text" /> <input type="submit"
			value="Submit">
	</form>

	<h2>User Info:</h2>
	<div style="font-size: 15px">
		<label>Username:</label> <strong><%=username%></strong><br /> <label>Roles:</label>
		<strong> <%
 	for (GrantedAuthority ga : authorities) {
 		out.print(ga.getAuthority() + ", ");
 	}
 %>
		</strong><br />
	</div>
	<h2>Spring 3.2.x Security Namespace Configuration (URL Security)</h2>
	<br /> You can only access this page if you have
	<a href="admin">ROLE_ADMIN admin/admin.jsp</a>
	<br /> You can only access this page if you have
	<a href="edit">ROLE_EDIT edit/edit.jsp</a>

	<h2>Spring 3.2.x Method Security</h2>
	<h3>Invoking Server Side Methods:</h3>
	The following links invoke methods on a server side Spring Controller.
	They all return back a JSON string which you'll see in your browser.
	<ol>
		<li>You must have <strong>ROLE_USER</strong> to invoke this
			method: <a
			href="http://localhost:8080/spring-security/data/userRoleOnly">DataService.userRoleOnlyMethod()</a></li>
		<li>You must have <strong>ROLE_ADMIN</strong> to invoke this
			method: <a
			href="http://localhost:8080/spring-security/data/adminRoleOnly">DataService.adminRoleOnlyMethod()</a></li>
		<li>You must have <strong>ROLE_EDIT</strong> to invoke this
			method: <a
			href="http://localhost:8080/spring-security/data/editRoleOnly">DataService.editRoleOnlyMethod()</a></li>
		<li>You can invoke this method with any of these roles <strong>ROLE_USER,
				ROLE_EDIT, ROLE_ADMIN</strong> to invoke this method: <a
			href="http://localhost:8080/spring-security/data/allRoles">DataService.allRolesMethod()</a></li>
		<li>This method has <strong>no security</strong>: <a
			href="http://localhost:8080/spring-security/data/open">DataService.unprotectedMethod()</a></li>
		<li>You need <strong>ROLE_USER</strong> to invoke this method and
			it will return a JSON string of the <code>org.springframework.security.core.userdetails.User</code>
			object: <a href="http://localhost:8080/spring-security/data/userInfo">DataService.getUserInfo()</a></li>
	</ol>

	<a href="j_spring_security_logout">Login as a different user.</a>
</body>
</html>