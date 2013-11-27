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
				<h2>Záchvaty - Přidání záchvatu</h2>
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
						action="/GENEPI/patient/${patient.id}/seizure/${seizureId}/seizure-detail/create" commandName="seizureDetail">

				<div class="control-group">
    				<label class="control-label" for="date"><strong>Datum zadání</strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="sscClassification"><strong><spring:message code="label.SSCClassification"/></strong></label>
    				<div class="controls">
    					<form:select path="sscClassification" id="sscClassification" type="text" class="input-large">
							
								<form:option value="1">
									<spring:message code="label.epilepticSeizure"/>
								</form:option>
								<form:option value="2">
									<spring:message code="label.aura"/>
								</form:option>
								<form:option value="3">
									<spring:message code="label.somatosenzoryAura"/>
								</form:option>
								<form:option value="4">
									<spring:message code="label.visualAura"/>
								</form:option>	
								<form:option value="5">
									<spring:message code="label.auditoryAura"/>
								</form:option>
								<form:option value="6">
									<spring:message code="label.olfactoryAura"/>
								</form:option>
								<form:option value="7">
									<spring:message code="label.gustatoryAura"/>
								</form:option>
								<form:option value="8">
									<spring:message code="label.autonomicAura"/>
								</form:option>
								<form:option value="9">
									<spring:message code="label.epigastricAura"/>
								</form:option>	
								<form:option value="10">
									<spring:message code="label.psychicAura"/>
								</form:option>	
								<form:option value="11">
									<spring:message code="label.absence"/>
								</form:option>		
								<form:option value="12">
									<spring:message code="label.autonomicSeizure"/>
								</form:option>	
								<form:option value="13">
									<spring:message code="label.psychomotorSeizure"/>
								</form:option>	
								<form:option value="14">
									<spring:message code="label.motorSeizure"/>
								</form:option>	
								<form:option value="15">
									<spring:message code="label.clonicSeizure"/>
								</form:option>	
								<form:option value="16">
									<spring:message code="label.tonicSeizure"/>
								</form:option>	
								<form:option value="17">
									<spring:message code="label.tonicClonicSeizure"/>
								</form:option>	
								<form:option value="18">
									<spring:message code="label.atonicSeizure"/>
								</form:option>	
								<form:option value="19">
									<spring:message code="label.akineticSeizure"/>
								</form:option>	
								<form:option value="20">
									<spring:message code="label.versiveSeizure"/>
								</form:option>	
								<form:option value="21">
									<spring:message code="label.myoclonicSeizure"/>
								</form:option>	
								<form:option value="22">
									<spring:message code="label.hypermotorSeizure"/>
								</form:option>	
								<form:option value="23">
									<spring:message code="label.hypomotorSeizure"/>
								</form:option>	
								<form:option value="24">
									<spring:message code="label.negativeMyoclonicSeizure"/>
								</form:option>	
								<form:option value="25">
									<spring:message code="label.askatikSeizure"/>
								</form:option>	
								<form:option value="26">
									<spring:message code="label.akineticSeizure"/>
								</form:option>	
								<form:option value="27">
									<spring:message code="label.aphasicSeizure"/>
								</form:option>	
								<form:option value="28">
									<spring:message code="label.gelasticSeizure"/>
								</form:option>	
								<form:option value="29">
									<spring:message code="label.paroxymalEvent"/>
								</form:option>	


						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="ilaeClassification"><strong><spring:message code="label.ILAEClassification"/></strong></label>
    				<div class="controls">
    					<form:select path="ilaeClassification" id="ilaeClassification" type="text" class="input-large">
							
								<form:option value="1">
									<spring:message code="label.simplePartialMotor"/>
								</form:option>
								<form:option value="2">
									<spring:message code="label.simplePartialPsychic"/>
								</form:option>
								<form:option value="3">
									<spring:message code="label.simplePartialAutonomic"/>
								</form:option>
								<form:option value="4">
									<spring:message code="label.simplePartialSomatosensory"/>
								</form:option>
								<form:option value="5">
									<spring:message code="label.simplePartialSimple"/>
								</form:option>
								<form:option value="6">
									<spring:message code="label.simplePartialImpairment"/>
								</form:option>
								<form:option value="7">
									<spring:message code="label.simplePartialEvolving"/>
								</form:option>
								<form:option value="8">
									<spring:message code="label.generalizedTypical"/>
								</form:option>
								<form:option value="9">
									<spring:message code="label.generalizedAtypical"/>
								</form:option>
								<form:option value="10">
									<spring:message code="label.generalizedMyoclonic"/>
								</form:option>	
								<form:option value="11">
									<spring:message code="label.generalizedClonic"/>
								</form:option>	
								<form:option value="12">
									<spring:message code="label.generalizedTonic"/>
								</form:option>	
								<form:option value="13">
									<spring:message code="label.generalizedTonicClonic"/>
								</form:option>
								<form:option value="14">
									<spring:message code="label.generalizedAtonic"/>
								</form:option>		
								<form:option value="15">
									<spring:message code="label.unclassified"/>
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


