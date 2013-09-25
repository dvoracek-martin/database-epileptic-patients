<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="head">
     <link href="<c:url value="/resources/css/validation.css"/>"
			rel="stylesheet">
		<link
			href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
			rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.changePassword" />
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/other.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap-tab.js"/>"></script>
      <script src="<c:url value="/resources/js/validation.js"/>"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
    </jsp:attribute>

	<jsp:body>
	
				<h2>
					<spring:message code="label.edituser" />
					<a href="<c:url value="/user/${user.id}/overview"/>">${user.username}</a>
					<spring:message code="label.changePassword" />
				</h2>
				<form:form method="POST" modelAttribute="user"
			action="/GENEPI/user/change-password" commandName="user">

					<spring:message code="label.newPassword" />
					<br>
					<form:input id="password" path="password" type="password"
				pattern=".{8,30}" class="input-block-level" value="" autofocus="on"
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





					<!-- Hidden form for retrieving user's properties -->
					<!-- //////////////////////////////////////////// -->
					<form:hidden path="id" id="id" />
					<form:hidden path="username" id="username" />
					<!--form:hidden path="password" id="password" /-->
					<form:hidden path="contact.id" id="contact.id" />
					<form:hidden path="contact.firstName" id="contact.firstName" />
					<form:hidden path="contact.lastName" id="contact.lastName" />
					<form:hidden path="contact.addressStreet"
				id="contact.addressStreet" />
					<form:hidden path="contact.addressHn" id="contact.addressHn" />

					<form:hidden path="contact.addressCity" id="contact.addressCity" />
					<form:hidden path="contact.addressPostalcode"
				id="contact.addressPostalcode" />
					<form:hidden path="contact.addressCountry"
				id="contact.addressCountry" />
					<form:hidden path="contact.phoneNumber" id="contact.phoneNumber" />
					<form:hidden path="contact.email" id="contact.email" />
					<!-- ///////////////////////////////////////////// -->
					<!-- ///////////END OF THE HIDDEN FORM//////////// -->

					<button class="btn btn-small btn-primary" type="submit"
				onclick="validation();">
						<spring:message code="label.change" />
				
		</form:form>
	</jsp:body>
</t:menuLVL2>

