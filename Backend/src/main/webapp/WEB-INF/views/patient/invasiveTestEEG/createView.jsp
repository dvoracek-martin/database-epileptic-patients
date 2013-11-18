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
				<h2><spring:message code="label.invasiveTestEEG"/></h2>
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
						action="/GENEPI/patient/${patientID}/invasiveTestEEG/create" commandName="invasiveTestEEG">

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
    				<label class="control-label" for="invasiveMonitoring"><strong>Invazivní monitorace</strong></label>
    				<div class="controls">
    					<form:checkbox path="invasiveMonitoring" input="invasiveMonitoring" class="input-block-level" />
						<form:errors path="invasiveMonitoring" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="corticalMappingIdcoml"><strong>Kortikální mapování</strong></label>
    				<div class="controls">
    					<form:select path="corticalMappingIdcoml" id="corticalMappingIdcoml" type="text" class="input-large">
							<form:option value="1">
								Awake craniotomy
							</form:option>
							<form:option value="2">
								Extraoperační elektrická stimulace
							</form:option>
							<form:option value="3">
								Importovane funkcni mapovani
							</form:option>
							<form:option value="4">
								Intraoperační elektrická stimulace
							</form:option>	
							<form:option value="5">
								Intraoperační elektrická stimulace + sledování intaktnosti drah
							</form:option>
							<form:option value="6">
								Neprovedeno
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="intracranialElectrodesIdcom"><strong>Intrakraniální elektrody</strong></label>
    				<div class="controls">
    					<form:select path="intracranialElectrodesIdcom" id="intracranialElectrodesIdcom" type="text" class="input-large">
							<form:option value="1">
								Intracereb. + subdur. stripy + gridy
							</form:option>
							<form:option value="2">
								Intracerebrální
							</form:option>
							<form:option value="3">
								Intracerebrální + subdurální gridy
							</form:option>
							<form:option value="4">
								Intracerebrální + subdurální stripy
							</form:option>	
							<form:option value="5">
								Subdurální stripy
							</form:option>
							<form:option value="6">
								Subdurání gridy
							</form:option>
							<form:option value="7">
								Subdurání stripy + gridy
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationIntracranialElectrodes"><strong>Lokalizace intrakraniálních elektrod</strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationIntracranialElectrodes" input="localizationIntracranialElectrodes" class="input-medium" />
						<form:errors path="localizationIntracranialElectrodes" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="invasiveEegSlowingIdcom"><strong>Invazivní EEG zpomalení</strong></label>
    				<div class="controls">
    					<form:select path="invasiveEegSlowingIdcom" id="invasiveEegSlowingIdcom" type="text" class="input-large">
							<form:option value="1">
								Generalizované intermitentní
							</form:option>
							<form:option value="2">
								Generalizované kontinuální
							</form:option>
							<form:option value="3">
								Lokalizované intermitentní
							</form:option>
							<form:option value="4">
								Lokalizované kontinuální
							</form:option>	
							<form:option value="5">
								Žádné
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="invasiveEegInterictalSpikesIdcom"><strong>Invazivní EEG interiktální hroty</strong></label>
    				<div class="controls">
    					<form:select path="invasiveEegInterictalSpikesIdcom" id="invasiveEegInterictalSpikesIdcom" type="text" class="input-large">
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
								Nelokalizované
							</form:option>
							<form:option value="5">
								Regionální
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationInvasiveEegInterictalSpikes"><strong>Lokalizace invazivních EEG interiktálních hrotů</strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationInvasiveEegInterictalSpikes" input="localizationInvasiveEegInterictalSpikes" class="input-medium" />
						<form:errors path="localizationInvasiveEegInterictalSpikes" cssClass="error">
						</form:errors>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="invasiveEegStatusEpilepticus"><strong>Invazivní EEG status epilepticus</strong></label>
    				<div class="controls">
    					<form:checkbox path="invasiveEegStatusEpilepticus" input="invasiveEegStatusEpilepticus" class="input-block-level" />
						<form:errors path="invasiveEegStatusEpilepticus" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="invasiveIctalEegPatternsIdcom"><strong>Invazivní EEG iktální vzorce</strong></label>
    				<div class="controls">
    					<form:select path="invasiveIctalEegPatternsIdcom" id="invasiveIctalEegPatternsIdcom" type="text" class="input-large">
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
								Nelokalizované
							</form:option>
							<form:option value="5">
								Regionální
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationInvasiveIctalEegPatterns"><strong>Lokalizce invazivních EEG iktálních vzorců</strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationInvasiveIctalEegPatterns" input="localizationInvasiveIctalEegPatterns" class="input-medium" />
						<form:errors path="localizationInvasiveIctalEegPatterns" cssClass="error">
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


