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
      <spring:message code="label.addRecord" />
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.addRecord" />
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
   </jsp:attribute>
	<jsp:body>

			<div class="span5">
				<h2>
					<spring:message code="label.diagnosticTestMriMulti" />
				</h2>
			</div>

			<table class="table">
				<tbody>
					<tr>
						<th><spring:message code="label.patient" />:</th>
						<td>${patient.contact.firstName}</td>

						<th><spring:message code="label.birthIdentificationNumber" />:</th>
						<td>${patient.nin}</td>

						<th><spring:message code="label.birthdate" />:</th>
						<td>${patient.birthday}</td>
							
					</tr>
					<tr>	
						<th><spring:message code="label.address" />:</th>
						<td>${patient.contact.addressStreet}</td>
							
						<th><spring:message code="label.telephone" />:</th>
						<td>${patient.contact.phoneNumber}</td>
							
						<th><spring:message code="label.email" />:</th>
						<td>${patient.contact.email}</td>
												
							
					</tr>
					<tr>
						<th><spring:message code="label.gender" />:</th>
						<td>${patient.gender}</td>
							
						<th><spring:message code="label.ageAtTheBeginningOfEpilepsy" />:</th>
						<td></td>
							
						<th><spring:message code="label.assignedDoctor" />:</th>
						<td></td>
							
					</tr>
				</tbody>
			</table>
			
			<!-- form for adding new record -->
			<!-- mapping resource in action with c:url caused errors -->
			<form:form class="form-horizontal" method="POST"
			action="/GENEPI/patient/${patientID}/diagnosticTestMRI/create"
			commandName="diagnosticTestMRI">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message
							code="label.dateExamination" /></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text"
						class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>  				

  				<div class="control-group">
    				<label class="control-label" for="done"><strong><spring:message code="label.diagnosticTestMri" /></strong></label>
    				<div class="controls">
    					<form:select path="done" id="done"
						type="text" class="input-large">
							<form:option value="true">
								<spring:message code="label.done" />
							</form:option>
							<form:option value="false">
								<spring:message code="label.notDone" />
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mriFinding"><strong><spring:message
							code="label.MRIFinding" /></strong></label>
    				<div class="controls">
    					<form:select path="mriFinding" id="mriFinding"
						type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral" />
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal" />
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric" />
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar" />
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar" />
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone" />
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal" />
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative" />
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mriDescription"><strong><spring:message code="label.descriptionMRI" /></strong></label>
    				<div class="controls">
    					<form:textarea path="mriDescription" id="mriDescription" />
    					<form:errors path="mriDescription" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="fdgPet"><strong>FDG PET</strong></label>
    				<div class="controls">
    					<form:select path="fdgPet" id="fdgPet" type="text"
						class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral" />
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal" />
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric" />
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar" />
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar" />
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone" />
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal" />
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative" />
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="descriptionPetHypometabolism"><strong><spring:message code="label.descriptionPetHypometabolism" /></strong></label>
    				<div class="controls">
    					<form:textarea path="descriptionPetHypometabolism" id="descriptionPetHypometabolism" />
    					<form:errors path="descriptionPetHypometabolism" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="interictalSpect"><strong><spring:message
							code="label.interictalSPECT" /></strong></label>
    				<div class="controls">
    					<form:select path="interictalSpect"
						id="interictalSpect" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral" />
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal" />
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric" />
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar" />
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar" />
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone" />
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal" />
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative" />
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="descriptionSpectHypoperfuse"><strong><spring:message code="label.descriptionSPECTHypoperfuse" /></strong></label>
    				<div class="controls">
    					<form:textarea path="descriptionSpectHypoperfuse" id="descriptionSpectHypoperfuse" />
    					<form:errors path="descriptionSpectHypoperfuse" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="ictalSpect"><strong><spring:message code="label.ictalSpect" /></strong></label>
    				<div class="controls">
    					<form:select path="ictalSpect"
						id="ictalSpect" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral" />
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal" />
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric" />
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar" />
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar" />
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone" />
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal" />
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative" />
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="descriptionSpectHyperperfuse"><strong><strong><spring:message code="label.descriptionSPECTHyperperfuse" /></strong></label>
    				<div class="controls">
    					<form:textarea path="descriptionSpectHyperperfuse" id="descriptionSpectHyperperfuse" />
    					<form:errors path="descriptionSpectHyperperfuse" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="siscom"><strong>SISCOM</strong></label>
    				<div class="controls">
    					<form:checkbox path="siscom" input="siscom"
						class="input-block-level" />
						<form:errors path="siscom" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mrsProtocol"><strong><spring:message code="label.MrsProtocol" /></strong></label>
    				<div class="controls">
    					<form:select path="mrsProtocol" id="mrsProtocol"
						type="text" class="input-large">
							<form:option value="1">
								CSI
							</form:option>
							<form:option value="2">
								Single voxel
							</form:option>
							<form:option value="3">
								Single voxel + CSI
							</form:option>
						</form:select>
    				</div>
  				</div>	

  				<div class="control-group">
    				<label class="control-label" for="mrsFinding"><strong><spring:message code="label.MrsFinding" /></strong></label>
    				<div class="controls">
    					<form:select path="mrsFinding" id="mrsFinding"
						type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral" />
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal" />
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric" />
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar" />
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar" />
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone" />
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal" />
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative" />
							</form:option>
						</form:select>
    				</div>
  				</div>	

  				<div class="control-group">
    				<label class="control-label" for="descriptionMrsAbnormality"><strong><spring:message code="label.descriptionMrsAbnormality" /></strong></label>
    				<div class="controls">
    					<form:textarea path="descriptionMrsAbnormality" id="descriptionMrsAbnormality" />
    					<form:errors path="descriptionMrsAbnormality" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="fmri"><strong>fMRI</strong></label>
    				<div class="controls">
    					<form:checkbox path="fmri" input="fmri" class="input-large" />
						<form:errors path="fmri" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="detailsFmri"><strong><spring:message
							code="label.FMRIDetails" /></strong></label>
    				<div class="controls">
    					<form:textarea path="detailsFmri" id="detailsFmri" />
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="dti"><strong>DTI</strong></label>
    				<div class="controls">
    					<form:checkbox path="dti" input="dti" class="input-large" />
						<form:errors path="dti" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="detailsDtiStudie"><strong><spring:message
							code="label.DTIStudyDetails" /></strong></label>
    				<div class="controls">
    					<form:textarea path="detailsDtiStudie" id="detailsDtiStudie" />
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="wada"><strong>WADA</strong></label>
    				<div class="controls">
    					<form:checkbox path="wada" input="wada" class="input-large" />
						<form:errors path="wada" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="detailsWada"><strong><spring:message
							code="label.WADADetails" /></strong></label>
    				<div class="controls">
    					<form:textarea path="detailsWada" id="detailsWada" />
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
			     		<button class="btn btn-primary" type="submit">
						<spring:message code="label.add" />
					</button>
			    	</div>
			  	</div>				
			</form:form>
	</jsp:body>
</t:menuLVL3>


