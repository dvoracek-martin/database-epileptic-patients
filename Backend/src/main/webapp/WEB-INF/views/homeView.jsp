<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Domovská stránka</title>
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
				</a> <a class="brand" href="#">GENEPI - PŘEHLED</a>
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

		<!--  it defines box with content -->
		<div class="span9">
			<div class="hero-unit">
				<div style="border-bottom: 2px solid black">
					<h1>Přehled novinek</h1>
				</div>

				<div style="margin: 10px">
					<div style="border-bottom: 2px solid black">
						<h3>12.5.2013</h3>
						<p>Podpora pro širší škálu prohlížečů byla doplněna.</p>
					</div>

					<div style="border-bottom: 2px solid black">
						<h3>10.9.2013</h3>
						<p>Beta verze byla předvedena.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/application.js"></script>
</body>
</html>