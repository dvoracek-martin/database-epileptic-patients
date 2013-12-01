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
				 <h2>Outcome</h2>
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
						action="/GENEPI/patient/${patientID}/outcome/create" commandName="outcome">

				<div class="control-group">
    				<label class="control-label" for="date"><strong>Datum zadání</strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="seizureOutcome"><strong>Seizure outcome</strong></label>
    				<div class="controls">
    					<form:select path="seizureOutcome" id="seizureOutcome" type="text" class="input-large">
							<form:option value="1">
								0
							</form:option>
							<form:option value="2">
								IA
							</form:option>
							<form:option value="3">
								IB
							</form:option>
							<form:option value="4">
								IC
							</form:option>	
							<form:option value="5">
								ID
							</form:option>
							<form:option value="6">
								IIA
							</form:option>
							<form:option value="7">
								IIB
							</form:option>
							<form:option value="8">
								IIC
							</form:option>
							<form:option value="9">
								IID
							</form:option>
							<form:option value="10">
								IIIA
							</form:option>
							<form:option value="11">
								IIIB
							</form:option>
							<form:option value="12">
								IV
							</form:option>
							<form:option value="13">
								V
							</form:option>
							<form:option value="14">
								VI
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="aed"><strong>AED</strong></label>
    				<div class="controls">
    					<form:select path="aed" id="aed" type="text" class="input-large">
							<form:option value="1">
								nevysazený
							</form:option>
							<form:option value="2">
								vysazený
							</form:option>
							<form:option value="3">
								redukovaný
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="eeg"><strong>EEG</strong></label>
    				<div class="controls">
    					<form:select path="eeg" id="eeg" type="text" class="input-large">
							<form:option value="1">
								neprovedeno
							</form:option>
							<form:option value="2">
								s hroty
							</form:option>
							<form:option value="3">
								bez hrotů
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mri"><strong>MRI</strong></label>
    				<div class="controls">
    					<form:select path="mri" id="mri" type="text" class="input-large">
							<form:option value="1">
								neprovedeno
							</form:option>
							<form:option value="2">
								provedeno
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="neuropsychology"><strong>Neuropsychologie</strong></label>
    				<div class="controls">
    					<form:select path="neuropsychology" id="neuropsychology" type="text" class="input-large">
							<form:option value="1">
								neprovedeno
							</form:option>
							<form:option value="2">
								provedeno
							</form:option>
						</form:select>
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


