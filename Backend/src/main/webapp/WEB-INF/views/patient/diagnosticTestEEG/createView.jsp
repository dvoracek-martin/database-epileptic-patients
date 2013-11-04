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
				<h2><spring:message code="label.diagnosticTestEEG"/></h2>
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
						action="/GENEPI/patient/${patientID}/diagnosticTestEEG/create" commandName="diagnosticTestEEG">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message code="label.dateExamination"/></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="doctorId"><strong><spring:message code="label.doctor"/></strong></label>
    				<div class="controls">
    					<form:select path="doctorId" id="doctorId" type="text" class="input-large">
							<c:forEach items="${doctors}" var="doctor">
								<form:option value="${doctor.id}">
									${doctor.contact.firstName} ${doctor.contact.lastName}
								</form:option>
							</c:forEach>	
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="basicEegActivityIdcom"><strong><spring:message code="label.basicEEGActivity"/></strong></label>
    				<div class="controls">
    					<form:select path="basicEegActivityIdcom" id="basicEegActivityIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.normal"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.slow"/>
							</form:option>
						</form:select>
    				</div>
  				</div>
  				<div class="control-group">
    				<label class="control-label" for="eegSlowIdcom"><strong><spring:message code="label.EEGSlow"/></strong></label>
    				<div class="controls">
    					<form:select path="eegSlowIdcom" id="eegSlowIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.generalizedContinuous"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.generalizedDiscontinuous"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.localizatedContinuous"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.localizatedDiscontinuous"/>
							</form:option>	
							<form:option value="5">
								<spring:message code="label.none"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="interictalEegSpikesIdcom"><strong><spring:message code="label.interictalEEGSpikes"/></strong></label>
    				<div class="controls">
    					<form:select path="interictalEegSpikesIdcom" id="interictalEegSpikesIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.generalized"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.hemispheric"/>
							</form:option>
							<form:option value="3">
								 <spring:message code="label.multiregional"/>
							</form:option>
							<form:option value="4">
								Nelatralizovatelné
							</form:option>	
							<form:option value="5">
							    <spring:message code="label.regional"/>
							</form:option>
							<form:option value="6">
								<spring:message code="label.none"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationInterictalEEGSpikes"><strong><spring:message code="label.localizationInterictalEEGSpikes"/></strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationInterictalEEGSpikes" input="localizationInterictalEEGSpikes" class="input-medium" value="0" />
						<form:errors path="localizationInterictalEEGSpikes" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="eegStatusEpilepticus"><strong><spring:message code="label.EEGStatusEpilepticus"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="eegStatusEpilepticus" input="eegStatusEpilepticus" class="input-block-level" />
						<form:errors path="eegStatusEpilepticus" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="secondarySidedSynchrony"><strong><spring:message code="label.secondarySidedSynchrony"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="secondarySidedSynchrony" input="secondarySidedSynchrony" class="input-large" />
						<form:errors path="secondarySidedSynchrony" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="ictalEegPatternsIdcom"><strong><spring:message code="label.ictalEEGPatterns"/></strong></label>
    				<div class="controls">
    					<form:select path="ictalEegPatternsIdcom" id="ictalEegPatternsIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.missing"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.multiregional"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.notlocalizable"/>
							</form:option>	
							<form:option value="5">
								 <spring:message code="label.regional"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationIctalEegPattern"><strong><spring:message code="label.localizationIctalEEGPattern"/></strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationIctalEegPattern" input="localizationIctalEegPattern" class="input-medium" />
						<form:errors path="localizationIctalEegPattern" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="comment"><strong><spring:message code="label.comment" /></strong></label>
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
	
		<datalist id="doctors">
	<c:forEach items="${doctors}" var="doctor">
		<option value="${doctor.id}">dfdf</option>
	
			</c:forEach>
	</datalist>
	</jsp:body>
</t:menuLVL3>


