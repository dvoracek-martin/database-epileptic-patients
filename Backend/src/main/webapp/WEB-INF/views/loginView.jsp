<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<meta name="description" content="">
<meta name="author" content="GENEPI team">
<title>Přihlašovací stránka</title>
<link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
		<td><a href="<c:url value="/login"/>"></a></td>
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
		<!-- shall go to the homepage or better logout the user? -->
		<c:redirect url="/" />
	</sec:authorize>

	<sec:authorize var="loggedIn" access="isAuthenticated()" />

	<!-- main strip -->
	<div class="container-fluid">
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">GENEPI - PŘIHLÁŠENÍ</a>
				<div class="nav-collapse collapse">
					<ul id="nav-list" class="nav pull-right">
						<li><a href="#contact">Kontakt</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- box of testing login -->
	<div style="width: 330px; margin: auto; padding-top: 10em">
		<table>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Role</th>
			</tr>

			<tr>
				<td>sue</td>
				<td>suepassword</td>
				<td>ROLE_USER, ROLE_EDIT</td>
			</tr>
		</table>
		<br />
		<h1>Přihlášení</h1>
		<!-- login form -->
		<div class="form" style="border: 0 solid white">
			<form name="f" action="j_spring_security_check" method="post">
				<input type="text" id="username" class="input-block-level"
					name="j_username" placeholder="Přihlašovací jméno"> <input
					type="password" id="password" name="j_password"
					class="input-block-level" placeholder="Heslo">
				<button class="btn btn-large btn-primary" type="submit">Přihlásit</button>
			</form>
		</div>
	</div>

	<!-- box for contact -->
	<div class="row-fluid" id="contact" style="padding-top: 25em">
		<div class="span4" id="contact-info" style="margin-left: 5em">
			<div>
				<h3>Kontaktujte nás!</h3>
			</div>
			<div>
				<div style="float: right; margin-left: 2em">
					<img src="resources/img/genepi.png" />
				</div>
				<p>Pokud zaznamenáváte problémy s přihlášením, tak nás neváhejte
					kontaktovat na naší adrese či využijte formulář vpravo.</p>
				<p>
					<a id="address" href="mailto:admin@genepi.com">admin@genepi.com</a>
				</p>
				<p>____________________________</p>
				<p>GENEPI, &copy; 2013, FIT CVUT</p>
			</div>
		</div>

		<!-- box with contact form -->
		<div class="span4" id="contact-form">
			<form class="form-horizontal">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="name"></label>
						<div class="controls">
							<input class="input-xlarge" type="text" id="name"
								placeholder="Jméno a příjmení">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email"></label>
						<div class="controls">
							<input class="input-xlarge" type="text" id="email"
								placeholder="Email">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="subject"></label>
						<div class="controls">
							<input class="input-xlarge" type="text" id="subject"
								placeholder="Předmět">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="message"></label>
						<div class="controls">
							<textarea class="input-xlarge" rows="3" id="message"
								placeholder="Text zprávy"></textarea>
						</div>
					</div>
					<div class="form-actions"
						style="background: white; border-color: white">
						<button type="submit" class="btn btn-primary">Odeslat</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>