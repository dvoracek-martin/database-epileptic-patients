<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Pacient
    </jsp:attribute>
	<jsp:attribute name="header">
      Pacient
    </jsp:attribute>

	<jsp:body>
			<div>
					<div>
						<h2>
							<spring:message code="label.exportPatient" /> <a href="<c:url value="/patient/${patient.id}/overview" />"
						style="text-decoration: none">${patient.contact.firstName} ${patient.contact.lastName}</a>
						</h2>
					</div>
					
					<form:form method="POST" modelAttribute="patient" class="form-horizontal"
				action="/GENEPI/patient/edit" commandName="patient">
						<div class="control-group">
						    <label class="control-label" for="inputFormat"><spring:message code="label.chooseFormat"/></label>
						    <div class="controls">
						     	<input type="radio"id="inputFormat" name="format" value="pdf"> pdf
								<input type="radio" name="format" valus="csv"> csv
							</div>
						 </div>

						 <div class="control-group">
						    <div class="controls">
						      	<button type="submit" class="btn btn-primary"><spring:message code="label.export"/></button>
						    </div>
						  </div>
						
					</form:form>

				</div>
	</jsp:body>
</t:menuLVL3>

