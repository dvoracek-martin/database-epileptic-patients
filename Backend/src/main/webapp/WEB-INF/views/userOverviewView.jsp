<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>

<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="cs">
<head>
<meta charset="utf-8" />
<title>Pacient</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">
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
				</a> <a class="brand" href="#">GENEPI - UŽIVATEL</a>
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
				<h2>Přehled pacienta</h2>
				<form:form method="POST" action="editUser" commandName="user">

						<spring:message code="label.userid" />*
						<input id="id" type="text"
							class="input-block-level" disabled="disabled" value="fdfsfsdfds"/>
					<span class="label label-info">4515454465646</span>		
					<form:label path="username">
							<spring:message code="label.username" />*
						</form:label>
						<form:input id="username" path="username" type="text"
							class="input-block-level" value="user.username"/>
							
					<form:label path="password">
							<spring:message code="label.password" />*
						</form:label>
						<form:input id="password" path="password" type="password" pattern=".{8,30}"
								class="input-block-level" onFocusOut="passwordValidation();" required="true"  title="Délka musí být mezi 8-30 znaky."/>
								
					<spring:message code="label.passwordAgain" />*
						<input type="password" id="passwordAgain" pattern=".{8,30}"
							class="input-block-level" 	onFocusOut="passwordAgainValidation();" required="true" title="Délka musí být mezi 8-30 znaky."/>
				</form:form>

			</div>
		</div>
	</div>
	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
</body>
</html>


