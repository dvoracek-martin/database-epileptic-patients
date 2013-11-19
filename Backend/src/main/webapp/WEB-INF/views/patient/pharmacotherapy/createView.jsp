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
				<h2><spring:message code="label.pharmacotherapy"/></h2>
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
						action="/GENEPI/patient/${patientID}/pharmacotherapy/create" commandName="pharmacotherapy">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message code="label.dateOfContractAward"/></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="aed"><strong>AED</strong></label>
    				<div class="controls">
    					<form:select path="aed" id="aed" type="text" class="input-large">
								<form:option value="1">
									ACTH	
								</form:option>
								<form:option value="2">
									CBZ
								</form:option>
								<form:option value="3">
									CLB
								</form:option>
								<form:option value="4">
									CZP	
								</form:option>
								<form:option value="5">
									DZP
								</form:option>
								<form:option value="6">
									ESL		
								</form:option>
								<form:option value="7">
									ETS	
								</form:option>
								<form:option value="8">
									FBM 				
								</form:option>
								<form:option value="9">
									GBP					
								</form:option>
								<form:option value="10">
									LCM
								</form:option>
								<form:option value="11">
									LEV
								</form:option>
								<form:option value="12">
									LTG			
								</form:option>
								<form:option value="13">
									OXC
								</form:option>
								<form:option value="14">
									PB
								</form:option>
								<form:option value="15">
									PGB
								</form:option>
								<form:option value="16">
									PHT
								</form:option>
								<form:option value="17">
									PRM
								</form:option>
								<form:option value="18">
									RFM
								</form:option>
								<form:option value="19">
									STM
								</form:option>
								<form:option value="20">
									TGB
								</form:option>
								<form:option value="21">
									TPM
								</form:option>
								<form:option value="22">
									VGB
								</form:option>
								<form:option value="23">
									VPA
								</form:option>
								<form:option value="24">
									ZNS
								</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="efficiency"><strong><spring:message code="label.efficiency"/></strong></label>
    				<div class="controls">
    					<form:select path="efficiency" id="efficiency" type="text" class="input-large">
								<form:option value="1">
									<spring:message code="label.resistant"/>	
								</form:option>
								<form:option value="2">
									<spring:message code="label.effective"/>
								</form:option>				
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="duringSurgery"><strong><spring:message code="label.duringSurgery"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="duringSurgery" input="duringSurgery" class="input-block-level" />
						<form:errors path="duringSurgery" cssClass="error">
						</form:errors>
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


