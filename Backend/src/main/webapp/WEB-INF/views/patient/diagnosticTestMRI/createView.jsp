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
				<h2><spring:message code="label.diagnosticTestMRI"/></h2>
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
						action="/GENEPI/patient/${patientID}/diagnosticTestMRI/create" commandName="diagnosticTestMRI">

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
    				<label class="control-label" for="mriProtocolIdcom"><strong><spring:message code="label.MRIProtocol"/></strong></label>
    				<div class="controls">
    					<form:select path="mriProtocolIdcom" id="mriProtocolIdcom" type="text" class="input-large">
							<form:option value="1">
								EPI 2
							</form:option>
							<form:option value="2">
								Standard + 1.5 mm T1w
							</form:option>
							<form:option value="3">
								Standardní MRI protokol
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mriFindingIdcom"><strong><spring:message code="label.MRIFinding"/></strong></label>
    				<div class="controls">
    					<form:select path="mriFindingIdcom" id="mriFindingIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar"/>
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar"/>
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone"/>
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal"/>
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="fdgPetIdcom"><strong>FDG PET</strong></label>
    				<div class="controls">
    					<form:select path="fdgPetIdcom" id="fdgPetIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar"/>
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar"/>
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone"/>
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal"/>
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="interictalSpectIdcom"><strong><spring:message code="label.interictalSPECT"/></strong></label>
    				<div class="controls">
    					<form:select path="interictalSpectIdcom" id="interictalSpectIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar"/>
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar"/>
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone"/>
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal"/>
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="ictaliSpectIdcom"><strong>FDG PET</strong></label>
    				<div class="controls">
    					<form:select path="ictaliSpectIdcom" id="ictaliSpectIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar"/>
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar"/>
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone"/>
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal"/>
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative"/>
							</form:option>
						</form:select>
    				</div>
  				</div>				

  				<div class="control-group">
    				<label class="control-label" for="siscom"><strong>SISCOM</strong></label>
    				<div class="controls">
    					<form:checkbox path="siscom" input="siscom" class="input-block-level" />
						<form:errors path="siscom" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mrsProtocolIdcom"><strong><spring:message code="label.MRSProtocol"/></strong></label>
    				<div class="controls">
    					<form:select path="mrsProtocolIdcom" id="mrsProtocolIdcom" type="text" class="input-large">
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
    				<label class="control-label" for="mrsFinfingIdcom"><strong><spring:message code="label.MRSFinding"/></strong></label>
    				<div class="controls">
    					<form:select path="mrsFinfingIdcom" id="mrsFinfingIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.bilateral"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focal"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispheric"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.lobar"/>
							</form:option>	
							<form:option value="5">
								<spring:message code="label.multilobar"/>
							</form:option>
							<form:option value="6">
								<spring:message code="label.notDone"/>
							</form:option>
							<form:option value="7">
								<spring:message code="label.normal"/>
							</form:option>
							<form:option value="8">
								<spring:message code="label.postoperative"/>
							</form:option>
						</form:select>
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
    				<label class="control-label" for="detailsDtiStudie"><strong><spring:message code="label.DTIStudyDetails"/></strong></label>
    				<div class="controls">
    					<form:textarea path="detailsDtiStudie" id="detailsDtiStudie" />
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
    				<label class="control-label" for="detailsFmri"><strong><spring:message code="label.FMRIDetails"/></strong></label>
    				<div class="controls">
    					<form:textarea path="detailsFmri" id="detailsFmri" />
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
    				<label class="control-label" for="detailsWada"><strong><spring:message code="label.WADADetails"/></strong></label>
    				<div class="controls">
    					<form:textarea path="detailsWada" id="detailsWada" />
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mriDescribe"><strong><spring:message code="label.descriptionMRI"/></strong></label>
    				<div class="controls">
    					<form:textarea path="mriDescribe" id="mriDescribe" />
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationSpectHypoperfuse"><strong><spring:message code="label.localizationSPECTHypoperfuse"/></strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationSpectHypoperfuse" input="localizationSpectHypoperfuse" class="input-medium" />
						<form:errors path="localizationSpectHypoperfuse" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationMrsAbnormality"><strong><spring:message code="label.localizationMRSAbnormality"/></strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationMrsAbnormality" input="localizationMrsAbnormality" class="input-medium" />
						<form:errors path="localizationMrsAbnormality" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationPetHypometabolism"><strong><spring:message code="label.localizationPetHypometabolism"/></strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationPetHypometabolism" input="localizationPetHypometabolism" class="input-medium" />
						<form:errors path="localizationPetHypometabolism" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationSpectHyperperfuse"><strong><spring:message code="label.localizationSPECTHyperperfuse"/></strong></label>
    				<div class="controls">
    					<form:input type="text" path="localizationSpectHyperperfuse" input="localizationSpectHyperperfuse	" class="input-medium" />
						<form:errors path="localizationSpectHyperperfuse" cssClass="error">
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


