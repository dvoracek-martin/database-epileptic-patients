<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><spring:message code="label.edituser" /> - <spring:message code="label.changePassword" /></title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico"/>">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/responsive.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/validation.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
	rel="stylesheet">

</head>
<body>
	<!-- box of whole page -->
	<div class="container-fluid">
		<!--  it defines box with logo -->
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">GENEPI - <spring:message
						code="label.edituser" /> - <spring:message code="label.changePassword" /></a>
			</div>

		</div>

		<!--  it defines box with menu and logo -->
		<div class="span3">
			<div class="well sidebar-nav">
				<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
					src="<c:url value="/resources/img/logo.png"/>" alt="logo" />
				</a>
			</div>
			<div>
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Pacienti</li>
						<li><a href="patientList">Kartotéka pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel:</li>
						<li><a href="myProfile">Profil</a></li>
						<li><a href="j_spring_security_logout">Odhlásit</a></li->
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
				
				<h2>
					<spring:message code="label.edituser" /> <a onclick="document.location = '/GENEPI/userOverview/${user.id}';">${user.username}</a> - <spring:message code="label.changePassword" /> 
				</h2>	
				<form:form method="POST" modelAttribute="user" action="/GENEPI/userChangePassword" commandName="user">		
							<form:hidden path="id" id="id" />
							<form:hidden path="contact" id="contact" />
							<form:hidden path="contact.firstName" id="firstName" />
							<form:hidden path="contact.lastName" id="lastName" />
							<form:hidden path="contact.addressStreet" id="addressStreet" />
							<form:hidden path="contact.addressHn" id="addressHn" />
							<form:hidden path="contact.addressCity" id="addressCity" />
							<form:hidden path="contact.addressPostalcode" id="addressPostalcode" />
							<form:hidden path="contact.addressCountry" id="addressCountry" />
							<form:hidden path="contact.phoneNumber" id="phoneNumber" />
							<form:hidden path="contact.email" id="email" />
							
							<spring:message code="label.newPassword" />
							<br>
							<form:input id="password" path="password" type="password"
							pattern=".{8,30}" class="input-block-level"
							onFocusOut="passwordValidation();" required="true"
							title="Délka musí být mezi 8-30 znaky." />
						<form:errors path="password" cssClass="alert alert-error">
						</form:errors>
				
							<div id="passwordErrEmpty" class="alert alert-error"
								style="display: none">Toto pole nesmí zůstat prázdné!</div>
							<div id="passwordErr" class="alert alert-error"
								style="display: none">Délka není mezi 8-30 znaky!</div>

							<spring:message code="label.passwordAgain" />
							<input type="password" id="passwordAgain" pattern=".{8,30}"
								class="input-block-level" onFocusOut="passwordAgainValidation();"
								 title="Délka musí být mezi 8-30 znaky." />
							<div id="passwordAgainErrEmpty" class="alert alert-error"
								style="display: none">Toto pole nesmí zůstat prázdné!</div>
							<div id="passwordAgainErrLength" class="alert alert-error"
								style="display: none">Délka není mezi 8-30 znaky!</div>
							<div id="passwordAgainErrComparison" class="alert alert-error"
								style="display: none">Hesla se neshodují.</div>
							<div id="passwordAgainSuccComparison" class="alert alert-success"
								style="display: none">Hesla se shodují.</div>	
								
							<button class="btn btn-small btn-primary" type="submit"
								onclick="validation();">
							<spring:message code="label.change" />
				</form:form>

				
			</div>
		</div>
	</div>


	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/validation.js"/>"></script>
	<script src="<c:url value="/resources/js/other.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap-tab.js"/>"></script>

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