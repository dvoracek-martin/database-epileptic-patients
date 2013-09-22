<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>
	<jsp:attribute name="head">
      <link
			href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
			rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.editPatient" />
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.editPatient" />
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/other.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap-tab.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/validation.js"/>"></script>
		<script>
			$(function() {
				$(".datepicker").datepicker({
					dateFormat : "dd/mm/yy",
					changeYear : true
				});

			});
		</script>
   </jsp:attribute>
	<jsp:body>
	<h2>
	<spring:message code="label.editPatient" />
	<a href="<c:url value="/patient/${patient.id}/overview" />">${patient.contact.firstName}
		${patient.contact.lastName}</a>
	</h2>
	
	<form:form method="POST" modelAttribute="patient"
			action="/GENEPI/patient/edit" commandName="patient">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs">
							<li class=""><a href="#" onclick="editName();">Jméno,
									příjmení, RČ</a></li>
							<li class=""><a href="#" onclick="editAddress();">Adresa</a></li>
							<li class=""><a href="#" onclick="editContact();">Kontakt</a></li>
							<li><button class="btn btn-small btn-primary" type="submit"
							onclick="validation();">
									<spring:message code="label.edit" />
								</button></li>
						</ul>

						<div class="tab-content">
							<div style="display: none">
								<form:input path="id" type="text" value="${patient.id}"
							class="input-block-level" />
								<form:input path="contact.id" type="text"
							value="${patient.contact.id}" class="input-block-level" />
							</div>



							<div id="editName" style="display: block">
								<form:label path="contact.firstName">
									<spring:message code="label.firstname" />
								</form:label>
								<form:input id="firstname" path="contact.firstName" type="text"
							value="${patient.contact.firstName}" pattern="[a-žA-Ž]{1,20}"
							class="input-block-level" onFocusOut="firstnameValidation();"
							required="true" title="Nesmí přesáhnout délku 20 znaků." />

								<form:label path="contact.lastName">
									<spring:message code="label.lastname" />
								</form:label>
								<form:input id="lastname" path="contact.lastName" type="text"
							value="${patient.contact.lastName}" pattern="[a-žA-Ž]{1,20}"
							class="input-block-level" onFocusOut="lastnameValidation();"
							required="true" title="Nesmí přesáhnout délku 20 znaků." />
							
								
							</div>

							<!-- firstname, surname - error messages -->
							<form:errors path="contact.firstName"
						cssClass="alert alert-error">
							</form:errors>
							<div id="firstnameErrEmpty" class="alert alert-error"
						style="display: none">Jméno nesmí zůstat prázdné!</div>
							<div id="firstnameErr" class="alert alert-error"
						style="display: none">Jméno je delší jak 20 znaků!</div>

							<form:errors path="contact.lastName" cssClass="alert alert-error">
							</form:errors>
							<div id="lastnameErrEmpty" class="alert alert-error"
						style="display: none">Příjemní nesmí zůstat prázdné!</div>
							<div id="lastnameErr" class="alert alert-error"
						style="display: none">Příjemní je delší jak 20 znaků!</div>

							<div id="editAddress" style="display: none">
								<form:label path="contact.addressStreet">
									<spring:message code="label.street" />
								</form:label>
								<form:input id="addressStreet" path="contact.addressStreet"
							value="${patient.contact.addressStreet}" type="text"
							pattern=".{0,30}" class="input-block-level"
							onchanged="addressStreetValidation();"
							title="Nesmí přesáhnout délku 30 znaků." />

								<form:label path="contact.addressHn">
									<spring:message code="label.addressHn" />
								</form:label>
								<form:input id="addressHn" path="contact.addressHn" type="text"
							value="${patient.contact.addressHn}" pattern=".{0,10}"
							class="input-block-level" onchange="addressHnValidation();"
							title="Nesmí přesáhnout délku 10 znaků." />

								<form:label path="contact.addressCity">
									<spring:message code="label.addressCity" />
								</form:label>
								<form:input id="addressCity" path="contact.addressCity"
							value="${patient.contact.addressCity}" type="text" pattern=".{0,30}"
							class="input-block-level" onchange="addressCityValidation();"
							title="Nesmí přesáhnout délku 30 znaků." />

								<form:label path="contact.addressPostalcode">
									<spring:message code="label.addressPostalcode" />
								</form:label>
								<form:input id="addressPostalcode"
							value="${patient.contact.addressPostalcode}"
							path="contact.addressPostalcode" type="text" pattern="\d{0,10}"
							class="input-block-level"
							onchange="addressPostalcodeValidation();"
							title="Smí obsahovat pouze číslce. Nesmí přesáhnout délku 10 číslic." />

								<form:label path="contact.addressCountry">
									<spring:message code="label.addressCountry" />
								</form:label>
								<form:input id="addressCountry" path="contact.addressCountry"
							value="${patient.contact.addressCountry}" type="text"
							pattern=".{0,20}" class="input-block-level"
							onchange="addressCountryValidation();"
							title="Nesmí přesáhnout délku 20 znaků." />
							</div>

							<!-- address - error messages -->
							<form:errors path="contact.addressStreet"
						cssClass="alert alert-error" />
							<div id="addressStreetErr" class="alert alert-error"
						style="display: none">Ulice je delší jak 30 znaků!</div>
							<form:errors path="contact.addressHn"
						cssClass="alert alert-error" />
							<div id="addressHnErr" class="alert alert-error"
						style="display: none">Číslo popisné je delší jak 10 znaků!</div>
							<form:errors path="contact.addressCity"
						cssClass="alert alert-error" />
							<div id="addressCityErr" class="alert alert-error"
							style="display: none">Město je delší jak 30 znaků!</div>
							<form:errors path="contact.addressPostalcode"
						cssClass="alert alert-error" />
							<div id="addressPostalcodeErr" class="alert alert-error"
						style="display: none">PSČ je delší jak 10 znaků!</div>
							<form:errors path="contact.addressCountry"
						cssClass="alert alert-error" />
							<div id="addressCountryErr" class="alert alert-error"
						style="display: none">Je delší jak 20 znaků!</div>

							<div id="editContact" style="display: none">
								<form:label path="contact.phoneNumber">
									<spring:message code="label.phoneNumber" />
								</form:label>
								<form:input id="phoneNumber" path="contact.phoneNumber"
							value="${patient.contact.phoneNumber}" type="text"
							pattern="[0-9+]\d{0,19}" onchange="phoneNumberValidation();"
							class="input-block-level"
							title="Musí být ve formátu +číslo/číslo. Nesmí přesáhnout délku 20 znaků." />

								<form:label path="contact.email">
									<spring:message code="label.email" />
								</form:label>
								<form:input id="email" path="contact.email" type="email"
							value="${patient.contact.email}" title="example@address.com"
							class="input-block-level" />
							</div>

							<!-- contact - error messages -->
							<form:errors path="contact.phoneNumber"
						cssClass="alert alert-error" />
							<div id="phoneNumberErr" class="alert alert-error"
						style="display: none">Je delší jak 20 znaků!</div>
							<form:errors path="contact.email" cssClass="alert alert-error" />



							<!-- Hidden form for retrieving user's properties -->
							<!-- --------------------------------------------- -->
							<form:hidden path="contact.id" id="contact.id" />
							<form:hidden path="nin" id="nin" />
							<form:hidden path="birthday" id="birthday" />
							<form:hidden path="gender" id="gender" />
							<form:hidden path="doctorId" id="doctorId" />
							<form:hidden path="checked" id="checked" />
							<form:hidden path="deleted" id="deleted" />
							<form:hidden path="contactId" id="contactId" />
							<!-- --------------------------------------------- -->
							<!-- -----------END OF THE HIDDEN FORM------------ -->


						</div>
					</div>

				</form:form>

	</jsp:body>
</t:menuLVL2>