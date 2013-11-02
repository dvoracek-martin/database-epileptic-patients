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
				<h2>Diagnostické testy - EEG</h2>
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
    				<label class="control-label" for="basicEegActivityIdcom"><strong>Základní EEG aktivita</strong></label>
    				<div class="controls">
    					<form:select path="basicEegActivityIdcom" id="basicEegActivityIdcom" type="text" class="input-large">
							<form:option value="1">
								Normální
							</form:option>
							<form:option value="2">
								Pomalá
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="eegSlowIdcom"><strong>EEG zpomalení</strong></label>
    				<div class="controls">
    					<form:select path="eegSlowIdcom" id="eegSlowIdcom" type="text" class="input-large">
							<form:option value="1">
								Generalizované kontinuální
							</form:option>
							<form:option value="2">
								Generalizované přerušované
							</form:option>
							<form:option value="3">
								Lokalizované kontinuální
							</form:option>
							<form:option value="4">
								Lokalizované přerušované
							</form:option>	
							<form:option value="5">
								Žádné
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="interictalEegSpikesIdcom"><strong>Interiktální EEG hroty</strong></label>
    				<div class="controls">
    					<form:select path="interictalEegSpikesIdcom" id="interictalEegSpikesIdcom" type="text" class="input-large">
							<form:option value="1">
								Generalizované
							</form:option>
							<form:option value="2">
								Hemisferální
							</form:option>
							<form:option value="3">
								Multiregionální
							</form:option>
							<form:option value="4">
								Nelatralizovatelné
							</form:option>	
							<form:option value="5">
							    Regionální
							</form:option>
							<form:option value="6">
								Žádné
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationInterictalEEGSpikes"><strong>Lokalizace interiktálních EEG hrotů</strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationInterictalEEGSpikes" input="localizationInterictalEEGSpikes" class="input-medium" value="0" />
						<form:errors path="localizationInterictalEEGSpikes" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="eegStatusEpilepticus"><strong>EEG status epilepticus</strong></label>
    				<div class="controls">
    					<form:checkbox path="eegStatusEpilepticus" input="eegStatusEpilepticus" class="input-block-level" />
						<form:errors path="eegStatusEpilepticus" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="secondarySidedSynchrony"><strong>Sekundární bilaterální synchronie</strong></label>
    				<div class="controls">
    					<form:checkbox path="secondarySidedSynchrony" input="secondarySidedSynchrony" class="input-large" />
						<form:errors path="secondarySidedSynchrony" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="ictalEegPatternsIdcom"><strong>Iktální EEG vzorce</strong></label>
    				<div class="controls">
    					<form:select path="ictalEegPatternsIdcom" id="ictalEegPatternsIdcom" type="text" class="input-large">
							<form:option value="1">
								Chybějící
							</form:option>
							<form:option value="2">
								Fokální
							</form:option>
							<form:option value="3">
								Multiregionální
							</form:option>
							<form:option value="4">
								Nelokalizovatelné
							</form:option>	
							<form:option value="5">
								Regionální
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationIctalEegPattern"><strong>Lokalizace iktálních EEG vzorů</strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationIctalEegPattern" input="localizationIctalEegPattern" class="input-medium" />
						<form:errors path="localizationIctalEegPattern" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="comment"><strong>Komentář</strong></label>
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


