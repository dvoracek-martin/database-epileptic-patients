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
				<h2><spring:message code="label.neurologicalFinding"/></h2>
			</div>

			<table class="table">
				<tbody>
					<tr>
						<th>Pacient:</th>
						<td>${patient.contact.firstName}</td>

						<th>Rodné číslo:</th>
						<td>${patient.nin}</td>

						<th>Datum narození:</th>
						<td>${patient.birthday}</td>
							
					</tr>
					<tr>	
						<th>Adresa:</th>
						<td>${patient.contact.addressStreet}</td>
							
						<th>Telefon:</th>
						<td>${patient.contact.phoneNumber}</td>
							
						<th>Email:</th>
						<td>${patient.contact.email}</td>
												
							
					</tr>
					<tr>
						<th>Pohaví:</th>
						<td>${patient.gender}</td>
							
						<th>Věk při začátku epilepsie:</th>
						<td></td>
							
						<th>Ošetřující lékař:</th>
						<td></td>
							
					</tr>
				</tbody>
			</table>
			
			<!-- form for adding new record -->
			<!-- mapping resource in action with c:url caused errors -->
			<form:form class="form-horizontal" method="POST"
						action="/GENEPI/patient/${patientID}/neurologicalFinding/create" commandName="neurologicalFinding">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message code="label.dateExamination"/></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="hemisphereDominance"><strong><spring:message code="label.hemisphereDominance"/></strong></label>
    				<div class="controls">
    					<form:select path="hemisphereDominance" id="hemisphereDominance" type="text" class="input-large">
								<form:option value="1">
									<spring:message code="label.ambidexter"/>
								</form:option>
								<form:option value="2">
									<spring:message code="label.lefthander"/>
								</form:option>
								<form:option value="3">
									<spring:message code="label.unspecified"/>
								</form:option>
								<form:option value="4">
									<spring:message code="label.righthander"/>
								</form:option>					

						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="abnormalNeurologicalFinding"><strong><spring:message code="label.abnormalNeurologicalFinding"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="abnormalNeurologicalFinding" input="abnormalNeurologicalFinding" class="input-block-level" />
						<form:errors path="abnormalNeurologicalFinding" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="hemiparesis"><strong><spring:message code="label.hemiparesis"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="hemiparesis" input="hemiparesis" class="input-block-level" />
						<form:errors path="hemiparesis" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="visualFieldDefects"><strong><spring:message code="label.visualFieldDefects"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="visualFieldDefects" input="visualFieldDefects" class="input-block-level" />
						<form:errors path="visualFieldDefects" cssClass="error">
						</form:errors>
    				</div>
  				</div>
  				<!--
  				<div class="control-group">
    				<label class="control-label" for="neurologicalFindingDetail"><strong><spring:message code="label.neurologicalFindingDetail"/></strong></label>
    				<div class="controls">
    					<form:textarea path="" id="neurologicalFindingDetail" />
						<form:errors path="" cssClass="error">
						</form:errors>
    				</div>
  				</div>
				-->
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
	
		<datalist id="doctors">
	<c:forEach items="${doctors}" var="doctor">
		<option value="${doctor.id}">dfdf</option>
	
			</c:forEach>
	</datalist>
	</jsp:body>
</t:menuLVL3>


