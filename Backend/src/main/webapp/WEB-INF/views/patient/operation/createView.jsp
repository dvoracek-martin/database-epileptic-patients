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
				<h2><spring:message code="label.operation"/></h2>
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
						action="/GENEPI/patient/${patientID}/operation/create" commandName="operation">

				<div class="control-group">
    				<label class="control-label" for="date"><strong><spring:message code="label.dateOfContractAward"/></strong></label>
    				<div class="controls">
    					<form:input path="date" id="date" type="text" class="input-medium datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="dateOperation"><strong><spring:message code="label.dateOfOperation"/></strong></label>
    				<div class="controls">
    					<form:input path="dateOperation" id="dateOperation" type="text" class="input-medium datepicker" />
						<form:errors path="dateOperation" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="typeOperationsIdcom"><strong><spring:message code="label.typeOperations"/></strong></label>
    				<div class="controls">
    					<form:select path="typeOperationsIdcom" id="typeOperationsIdcom" type="text" class="input-large">
							<form:option value="1">
								Diskonekce
							</form:option>
							<form:option value="2">
								<spring:message code="label.hemispherectomy"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.individualResection"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.corticalResection"/>
							</form:option>
							<form:option value="5">
								Lesionektomie
							</form:option>	
							<form:option value="6">
								Rozšíření Lesionektomie
							</form:option>
							<form:option value="7">
								<spring:message code="label.standardizedResection"/>
							</form:option>
							<form:option value="8">
								<spring:message code="label.tailoredResection"/>
							</form:option>
							<form:option value="9">
								<spring:message code="label.gammaKnifeSurgery"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="rangeOperationsIdcom"><strong><spring:message code="label.rangeOperations"/></strong></label>
    				<div class="controls">
    					<form:select path="rangeOperationsIdcom" id="rangeOperationsIdcom" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.withoutResection"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.focalResection"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.hemispherectomy"/>
							</form:option>
							<form:option value="4">
								Jednolobární <spring:message code="label.resection"/>
							</form:option>
							<form:option value="5">
								Multilobární <spring:message code="label.resection"/>
							</form:option>	
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="localizationOperations"><strong><spring:message code="label.localizationOperations"/></strong></label>
    				<div class="controls">
    					<form:textarea path="localizationOperations" id="localizationOperations" />
						<form:errors path="localizationOperations" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="mst"><strong>MST</strong></label>
    				<div class="controls">
    					<form:checkbox path="mst" input="mst" class="input-block-level" />
						<form:errors path="mst" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="colostomy"><strong><spring:message code="label.calostomy"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="colostomy" input="colostomy" class="input-large" />
						<form:errors path="colostomy" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="vns"><strong>VNS</strong></label>
    				<div class="controls">
    					<form:checkbox path="vns" input="vns" class="input-block-level" />
						<form:errors path="vns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="VNSImplantationDate"><strong><spring:message code="label.VNSImplantationDate"/></strong></label>
    				<div class="controls">
    					<form:input path="VNSImplantationDate" id="VNSImplantationDate" type="text" class="input-medium datepicker" />
						<form:errors path="VNSImplantationDate" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="operationDetails"><strong><spring:message code="label.operationDetails"/></strong></label>
    				<div class="controls">
    					<form:textarea path="operationDetails" id="operationDetails" />
						<form:errors path="operationDetails" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="completeResection"><strong><spring:message code="label.completeResection"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="completeResection" input="completeResection" class="input-block-level" />
						<form:errors path="completeResection" cssClass="error">
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
	
		<datalist id="doctors">
	<c:forEach items="${doctors}" var="doctor">
		<option value="${doctor.id}">dfdf</option>
	
			</c:forEach>
	</datalist>
	</jsp:body>
</t:menuLVL3>


