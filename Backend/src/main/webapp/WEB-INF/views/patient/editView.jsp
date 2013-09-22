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
	<a href="<c:url value="/patient/${patient.id}/overview" />">${patient.contact.firstname}
		${patient.contact.lastname}</a>
</h2>

<form:form method="POST" modelAttribute="patient"
			action="/GENEPI/patient/${patient.id}/edit" commandName="patient">
		<form:input id="firstname" path="contact.firstName" type="text"
							value="${patient.contact.firstName}" pattern="[a-žA-Ž]{1,20}"
							class="input-block-level"
							required="true" title="Nesmí přesáhnout délku 20 znaků." />


</form:form>
	</jsp:body>
</t:menuLVL2>