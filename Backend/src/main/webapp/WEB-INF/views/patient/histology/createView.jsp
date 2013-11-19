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
	  <style>
	  #title {
	  	color: black; 
	  	font-weight: bold;
	  	}
	  </style>
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
				<h2><spring:message code="label.histology"/></h2>
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
						action="/GENEPI/patient/${patientID}/histology/create" commandName="histology">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message code="label.dateExamination"/></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="histopathology"><strong><spring:message code="label.histopathology"/></strong></label>
    				<div class="controls">
    					<form:select path="histopathology" id="histopathology" type="text" class="input-large">
								<form:option value="1">
									FCD	
								</form:option>
								<form:option value="2">
									<spring:message code="label.glialLesions"/>		
								</form:option>
								<form:option value="3">
									HS		
								</form:option>
								<form:option value="4">
									<spring:message code="label.hamartoma"/>		
								</form:option>
								<form:option value="5">
									MCD <spring:message code="label.other"/>
								</form:option>
								<form:option value="6">
									<spring:message code="label.unavialable"/>		
								</form:option>
								<form:option value="7">
									<spring:message code="label.normal"/>		
								</form:option>
								<form:option value="8">
									<spring:message code="label.tumor"/>			
								</form:option>
								<form:option value="9">
									<spring:message code="label.post-traumaticChanges"/>			
								</form:option>
								<form:option value="10">
									SWC		
								</form:option>
								<form:option value="11">
									TSC		
								</form:option>
								<form:option value="12">
									<spring:message code="label.vascularLesions"/>	
								</form:option>
								<form:option value="13">
									<spring:message code="label.inflammatoryLesions"/>	
								</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="fcdClasification"><strong><spring:message code="label.FCDClasification"/></strong></label>
    				<div class="controls">
    					<form:select path="fcdClasification" id="fcdClasification" type="text" class="input-large">
								<form:option value="1">
									0	
								</form:option>
								<form:option value="2">
									FCD <spring:message code="label.type"/> lla		
								</form:option>
								<form:option value="3">
									FCD <spring:message code="label.type"/> llb			
								</form:option>
								<form:option value="4">
									FCD <spring:message code="label.type"/> la	
								</form:option>
								<form:option value="5">
									FCD <spring:message code="label.type"/> lb		
								</form:option>
								<form:option value="6">
									mMCD <spring:message code="label.type"/> l		
								</form:option>
								<form:option value="7">
									mMCD <spring:message code="label.type"/> ll		
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


