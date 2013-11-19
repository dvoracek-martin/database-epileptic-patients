<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      Advanced Search
    </jsp:attribute>
	<jsp:attribute name="header">
      
    </jsp:attribute>

	<jsp:body>
			<form:form class="form-horizontal" method="POST"
			action="/GENEPI/advanced-search" commandName="advancedSearch">

				<div class="control-group">
    				<label class="control-label" for="patientName"><strong><spring:message
							code="label.firstname" /></strong></label>
    				<div class="controls">
    					<form:input path="patientName" type="text" class="input-medium" />
						<form:errors path="patientName" cssClass="error">
						</form:errors>
    				</div>
  				</div>
  				</form:form>
</jsp:body>
</t:menuLVL2>