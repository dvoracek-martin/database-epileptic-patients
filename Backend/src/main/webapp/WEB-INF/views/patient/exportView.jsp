<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				action="/GENEPI/patient/export" commandName="patient">
						<div class="control-group">
						    <label class="control-label" for="inputFormat"><spring:message code="label.chooseFormat"/></label>
						    <div class="controls">
						     	<input type="radio" id="pdfFormat" name="format" value="pdf" checked> pdf
								<input type="radio" id="xlsxFormat" name="format" value="xlsx"> xlsx
							</div>
						 </div>

						 <div class="control-group">
						    <div class="controls">
						      	<button type="submit" class="btn btn-primary"><spring:message code="label.export"/></button>						 
						    </div>
						  </div>
						  
						  <form:hidden path="id" id="id" />
						
					</form:form>

				</div>
	</jsp:body>
</t:menuLVL3>
