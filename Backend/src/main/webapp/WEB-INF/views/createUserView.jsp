<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page pageEncoding="utf-8"%>
<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Přidat pacienta</title>
<link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link
	href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
	rel="stylesheet">

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
						<li><a href="?lang=cs">CZ</a></li>
						<li><a href="?lang=en">EN</a></li>
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
					<h2>
						<spring:message code="label.adduser" />
					</h2>
				</div>
				<div class="form" style="margin: 10px; width: 60%">
					<!-- form for adding new patient -->
					<form:form method="POST" action="addPatient" commandName="patient">				
						<form:label path="user.username">
							<spring:message code="label.username" />
						</form:label>
						<form:input path="user.login" type="text"
							class="input-block-level" />
						<form:errors path="user.login" cssClass="error">
						</form:errors>
						
						<form:label path="user.password">
							<spring:message code="label.password" />
						</form:label>
						<form:input path="user.password" type="text"
							class="input-block-level" />
						<form:errors path="user.password" cssClass="error">
						</form:errors>
						
						<form:label path="contact.firstName">
							<spring:message code="label.firstname" />
						</form:label>
						<form:input path="contact.firstName" type="text"
							class="input-block-level" />
						<form:errors path="contact.firstName" cssClass="error">
						</form:errors>
						
						<form:label path="contact.lastName">
							<spring:message code="label.lastname" />
						</form:label>
						<form:input path="contact.lastName" type="text"
							class="input-block-level" />

						<form:label path="birthday">
							<spring:message code="label.birthdate" />
						</form:label>
						<form:input path="birthday" type="text"
							class="input-block-level datepicker" />
						<form:errors path="birthday" cssClass="error" />

						<form:label path="nin">
							<spring:message code="label.idnumber" />
						</form:label>
						<form:input path="nin" type="text" class="input-block-level" />
						<form:errors path="nin" cssClass="error" />


						<form:label path="gender">
							<spring:message code="label.sex" />
						</form:label>
						<form:select path="gender" class="input-block-level">
							<form:option value="NONE" label="--- Select ---" />
							<form:option value="male" label="male" />
							<form:option value="female" label="female" />
						</form:select>

						<form:label path="contact.addressStreet">
							<spring:message code="label.street" />
						</form:label>
						<form:input path="contact.addressStreet" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressStreet" cssClass="error" />

						<form:label path="contact.addressHn">
							<spring:message code="label.addressHn" />
						</form:label>
						<form:input path="contact.addressHn" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressHn" cssClass="error" />

						<form:label path="contact.addressCity">
							<spring:message code="label.addressCity" />
						</form:label>
						<form:input path="contact.addressCity" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressCity" cssClass="error" />

						<form:label path="contact.addressPostalcode">
							<spring:message code="label.addressPostalcode" />
						</form:label>
						<form:input path="contact.addressPostalcode" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressPostalcode" cssClass="error" />

						<form:label path="contact.addressCountry">
							<spring:message code="label.addressCountry" />
						</form:label>
						<form:input path="contact.addressCountry" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressCountry" cssClass="error" />

						<form:label path="contact.phoneNumber">
							<spring:message code="label.phoneNumber" />
						</form:label>
						<form:input path="contact.phoneNumber" type="text"
							class="input-block-level" />
						<form:errors path="contact.phoneNumber" cssClass="error" />

						<form:label path="contact.email">
							<spring:message code="label.email" />
						</form:label>
						<form:input path="contact.email" type="text"
							class="input-block-level" />
						<form:errors path="contact.email" cssClass="error" />

						<form:label path="doctorId">lekar-to be implemented</form:label>
						<form:input path="doctorId" type="text" class="input-block-level" />
						<form:errors path="doctorId" cssClass="error" />

						<button class="btn btn-small btn-primary" type="submit">
							<spring:message code="label.add" />
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="resources/js/jquery.js"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script>
		$(function() {
			$(".datepicker").datepicker({
				dateFormat : "dd/mm/yy",
				changeYear : true
			});

		});
	</script>
</body>
</html>