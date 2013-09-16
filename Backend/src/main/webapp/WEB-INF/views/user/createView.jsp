<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Přidat pacienta</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico"/>">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
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
						code="label.adduser" /></a>
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
						<li><a href="<c:url value="/patient/list"/>">Kartotéka
								pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel:</li>
						<li><a href="<c:url value="/profile"/>">Profil</a></li>
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
					<form:form method="POST" action="/GENEPI/user/add"
						commandName="user">

						<form:label path="username">
							<spring:message code="label.username" />*
						</form:label>
						<form:input id="username" path="username" type="text"
							pattern="[a-ž\dA-Ž]{1,20}" class="input-block-level"
							onFocusOut="usernameValidation();" required="true"
							title="Nesmí být delší jak 20 znaků. Smí být tvořeno pouze písmeny a čísly." />
						<form:errors path="username" cssClass="alert alert-error">
						</form:errors>
						<div id="usernameErrEmpty" class="alert alert-error"
							style="display: none">Toto pole nesmí zůstat prázdné!</div>
						<div id="usernameErr" class="alert alert-error"
							style="display: none">Je delší jak 20 znaků!</div>
						<div id="usernameErrChar" class="alert alert-error"
							style="display: none">Lze zadat pouze písmena a číslice!</div>

						<form:label path="password">
							<spring:message code="label.password" />*
						</form:label>
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

						<spring:message code="label.passwordAgain" />*
						<input type="password" id="passwordAgain" pattern=".{8,30}"
							class="input-block-level" onFocusOut="passwordAgainValidation();"
							required="true" title="Délka musí být mezi 8-30 znaky." />
						<div id="passwordAgainErrEmpty" class="alert alert-error"
							style="display: none">Toto pole nesmí zůstat prázdné!</div>
						<div id="passwordAgainErrLength" class="alert alert-error"
							style="display: none">Délka není mezi 8-30 znaky!</div>
						<div id="passwordAgainErrComparison" class="alert alert-error"
							style="display: none">Hesla se neshodují.</div>
						<div id="passwordAgainSuccComparison" class="alert alert-success"
							style="display: none">Hesla se shodují.</div>


						<form:label path="contact.firstName">
							<spring:message code="label.firstname" />*
						</form:label>
						<form:input id="firstname" path="contact.firstName" type="text"
							pattern="[a-žA-Ž]{1,20}" class="input-block-level"
							onFocusOut="firstnameValidation();" required="true"
							title="Nesmí přesáhnout délku 20 znaků." />
						<form:errors path="contact.firstName" cssClass="alert alert-error">
						</form:errors>
						<div id="firstnameErrEmpty" class="alert alert-error"
							style="display: none">Toto pole nesmí zůstat prázdné!</div>
						<div id="firstnameErr" class="alert alert-error"
							style="display: none">Je delší jak 20 znaků!</div>

						<form:label path="contact.lastName">
							<spring:message code="label.lastname" />*
						</form:label>
						<form:input id="lastname" path="contact.lastName" type="text"
							pattern="[a-žA-Ž]{1,20}" class="input-block-level"
							onFocusOut="lastnameValidation();" required="true"
							title="Nesmí přesáhnout délku 20 znaků." />
						<form:errors path="contact.lastName" cssClass="alert alert-error">
						</form:errors>
						<div id="lastnameErrEmpty" class="alert alert-error"
							style="display: none">Toto pole nesmí zůstat prázdné!</div>
						<div id="lastnameErr" class="alert alert-error"
							style="display: none">Je delší jak 20 znaků!</div>

						<form:label path="contact.addressStreet">
							<spring:message code="label.street" />
						</form:label>
						<form:input id="addressStreet" path="contact.addressStreet"
							type="text" pattern=".{0,30}" class="input-block-level"
							onchanged="addressStreetValidation();"
							title="Nesmí přesáhnout délku 30 znaků." />
						<form:errors path="contact.addressStreet"
							cssClass="alert alert-error" />
						<div id="addressStreetErr" class="alert alert-error"
							style="display: none">Je delší jak 30 znaků!</div>

						<form:label path="contact.addressHn">
							<spring:message code="label.addressHn" />
						</form:label>
						<form:input id="addressHn" path="contact.addressHn" type="text"
							pattern=".{0,10}" class="input-block-level"
							onchange="addressHnValidation();"
							title="Nesmí přesáhnout délku 10 znaků." />
						<form:errors path="contact.addressHn" cssClass="alert alert-error" />
						<div id="addressHnErr" class="alert alert-error"
							style="display: none">Je delší jak 10 znaků!</div>

						<form:label path="contact.addressCity">
							<spring:message code="label.addressCity" />
						</form:label>
						<form:input id="addressCity" path="contact.addressCity"
							type="text" pattern=".{0,30}" class="input-block-level"
							onchange="addressCityValidation();"
							title="Nesmí přesáhnout délku 30 znaků." />
						<form:errors path="contact.addressCity"
							cssClass="alert alert-error" />
						<div id="addressCityErr" class="alert alert-error"
							style="display: none">Je delší jak 30 znaků!</div>

						<form:label path="contact.addressPostalcode">
							<spring:message code="label.addressPostalcode" />
						</form:label>
						<form:input id="addressPostalcode"
							path="contact.addressPostalcode" type="text" pattern="\d{0,10}"
							class="input-block-level"
							onchange="addressPostalcodeValidation();"
							title="Smí obsahovat pouze číslce. Nesmí přesáhnout délku 10 číslic." />
						<form:errors path="contact.addressPostalcode"
							cssClass="alert alert-error" />
						<div id="addressPostalcodeErr" class="alert alert-error"
							style="display: none">Je delší jak 10 znaků!</div>

						<form:label path="contact.addressCountry">
							<spring:message code="label.addressCountry" />
						</form:label>

						<form:select id="addressCountry" name="countries"
							path="contact.addressCountry">
							<form:option value="Afghanistan" label="Afghanistan" />
							<form:option value="CR" label="Ĺland Islands" />
						</form:select>

						<form:label path="contact.phoneNumber">
							<spring:message code="label.phoneNumber" />
						</form:label>
						<form:input id="phoneNumber" path="contact.phoneNumber"
							type="text" pattern="[0-9+]\d{0,19}"
							onchange="phoneNumberValidation();" class="input-block-level"
							title="Musí být ve formátu +číslo/číslo. Nesmí přesáhnout délku 20 znaků." />
						<form:errors path="contact.phoneNumber"
							cssClass="alert alert-error" />
						<div id="phoneNumberErr" class="alert alert-error"
							style="display: none">Je delší jak 20 znaků!</div>

						<form:label path="contact.email">
							<spring:message code="label.email" />
						</form:label>
						<form:input id="email" path="contact.email" type="email"
							title="example@address.com" class="input-block-level" />
						<form:errors path="contact.email" cssClass="alert alert-error" />



						<c:forEach var="role" items="${listOfPossibleRoles}">
							<td>${role.authority}</td>
							</br>
						</c:forEach>

						<button class="btn btn-small btn-primary" type="submit"
							onclick="validation();">
							<spring:message code="label.add" />
						</button>



						<form:hidden path="id" id="id" />
					</form:form>

				</div>
			</div>
		</div>
	</div>


	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-responsive.js" />"></script>
	<script src="<c:url value="/resources/js/validation.js"/>"></script>
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