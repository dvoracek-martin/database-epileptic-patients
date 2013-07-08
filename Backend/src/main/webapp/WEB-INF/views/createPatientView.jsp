<%@page pageEncoding="utf-8"%>
<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Přidat pacienta</title>
<link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<%
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername();
		Collection<GrantedAuthority> authorities = user.getAuthorities();
	%>

	<!-- box of whole page -->
	<div class="container-fluid">
		<!--  it defines box with logo -->
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">GENEPI - PŘIDAT PACIENTA</a>
			</div>

		</div>

		<!--  it defines box with menu and logo -->
		<div class="span3">
			<div class="well sidebar-nav">
				<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
					src="resources/img/logo.png" alt="logo" />
				</a>
			</div>
			<div>
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Pacienti</li>
						<li><a href="patientsList">Kartotéka pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel: <%=username%></li>
						<li><a href="myProfile">Profil</a></li>
						<li><a href="j_spring_security_logout">Odhlásit</a></li>
						<li class="nav-header">Jazyk</li>
					</ul>
				</div>
				<!--  It block with copyright -->
				<div class="span3">
					<div id="copyright">
						<p>GENEPI, &copy; 2013, FIT CVUT</p>
					</div>
				</div>
			</div>
		</div>

		<!-- box with content -->
		<div class="span9">
			<div class="hero-unit">
				<div style="border-bottom: 2px solid black">
					<h2>Přidat pacienta</h2>
				</div>
				<div class="form" style="margin: 10px; width: 60%">

					<form:form modelAttribute="patient">
					</form:form>

					<!-- form for adding new patient -->
					<form:form method="POST" action="addPatient" commandName="patient">
						<form:label path="contact.firstName">Jmeno</form:label>
						<form:input path="contact.firstName" type="text"
							class="input-block-level" />
						<form:label path="contact.lastName">Prijmeni</form:label>
						<form:input path="contact.lastName" type="text"
							class="input-block-level" />
						<form:label path="birthday">Datum narozeni</form:label>
						<form:input path="birthday" placeholder="DD/MM/YYYY" type="date"
							class="input-block-level" />
						<form:errors path="birthday" cssclass="error"></form:errors>


						<form:label path="gender">pohlavi</form:label>
						<form:select path="gender" class="input-block-level">
							<form:option value="NONE" label="--- Select ---" />
							<form:option value="male" label="male" />
							<form:option value="female" label="female" />
						</form:select>
						<button class="btn btn-small btn-primary" type="submit">Přidat</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/application.js"></script>
</body>
</html>