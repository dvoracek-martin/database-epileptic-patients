<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL3>
	<jsp:attribute name="head">
      <link
			href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
			rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
   </jsp:attribute>
	<jsp:body>

			<div class="span5">
				<h2><spring:message code="label.neuropsychology"/></h2>
			</div>

			<table class="table">
				<tbody>
					<tr>
						<th><spring:message code="label.patient"/>:</th>
						<td>${patient.contact.firstName}</td>

						<th><spring:message code="label.birthIdentificationNumber"/>:</th>
						<td>${patient.nin}</td>

						<th><spring:message code="label.birthdate"/>:</th>
						<td>${patient.birthday}</td>
							
					</tr>
					<tr>	
						<th><spring:message code="label.address"/>:</th>
						<td>${patient.contact.addressStreet}</td>
							
						<th><spring:message code="label.telephone"/>:</th>
						<td>${patient.contact.phoneNumber}</td>
							
						<th><spring:message code="label.email"/>:</th>
						<td>${patient.contact.email}</td>
												
							
					</tr>
					<tr>
						<th><spring:message code="label.gender"/>:</th>
						<td>${patient.gender}</td>
							
						<th><spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:</th>
						<td></td>
							
						<th><spring:message code="label.assignedDoctor"/>:</th>
						<td></td>
							
					</tr>
				</tbody>
			</table>
			
			<!-- form for adding new record -->
			<!-- mapping resource in action with c:url caused errors -->
			<form:form class="form-horizontal" method="POST"
						action="/GENEPI/patient/${patientID}/neuropsychology/create" commandName="neuropsychology">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message code="label.dateExamination"/></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="intelligenceLevel"><strong><spring:message code="label.intelligenceLevel"/></strong></label>
    				<div class="controls">
    					<form:select path="intelligenceLevel" id="intelligenceLevel" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.notAvailable"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.neurodevelopmentalExamination"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.intellectualPerformance"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="intelligenceLevel"><strong><spring:message code="label.neuropsychologicalProfile"/></strong></label>
    				<div class="controls">
    					<form:select path="intelligenceLevel" id="intelligenceLevel" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.notAvailable"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.concern"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.notConcern"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="neuropsychologicalExamination"><strong><spring:message code="label.neuropsychologicalExamination"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="neuropsychologicalExamination" input="neuropsychologicalExamination" class="input-block-level" checked="checked" />
						<form:errors path="neuropsychologicalExamination" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="intelligenceLevelIdcom"><strong>Inteligenční úroveň</strong></label>
    				<div class="controls">
    					<form:select path="intelligenceLevelIdcom" id="intelligenceLevelIdcom" type="text" class="input-large">
							<form:option value="1">
								Mírná mentální retardace
							</form:option>
							<form:option value="2">
								Naprůměrná inteligence
							</form:option>
							<form:option value="3">
								Podprůměrná inteligence
							</form:option>
							<form:option value="4">
								Průměrná inteligence
							</form:option>	
							<form:option value="5">
								Středně těžká mentální retardace
							</form:option>
							<form:option value="6">
								Těžká mentální retardace
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="comment"><strong><spring:message code="label.comment"/></strong></label>
    				<div class="controls">
    					<form:textarea path="comment" id="comment" />
    				</div>
  				</div>

  				<div class="control-group">
			    	<div class="controls">
			     		<button class="btn btn-primary" type="submit"><spring:message code="label.add"/></button>
			    	</div>
			  	</div>				
			</form:form>
	</jsp:body>
</t:menuLVL3>


