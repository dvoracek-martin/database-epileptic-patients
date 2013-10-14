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
				<h2>Komplikace</h2>
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
						action="/GENEPI/patient/${patientID}/complication/create" commandName="complication">

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
    				<label class="control-label" for="complicationIdcom"><strong>Komplikace</strong></label>
    				<div class="controls">
    					<form:select path="complicationIdcom" id="complicationIdcom" type="text" class="input-large">
								<option id="title" disabled>Neočekávané permanentní</option>
								<form:option value="1">
									0	
								</form:option>
								<form:option value="2">
									Afázie		
								</form:option>
								<form:option value="3">
									Hemipréza		
								</form:option>
								<form:option value="4">
									Jiné	
								</form:option>
								<form:option value="5">
									Paréza hlavových nervů		
								</form:option>
								<form:option value="6">
									Porucha zorného pole		
								</form:option>
								<form:option value="7">
									Smrt		
								</form:option>
								<option id="title" disabled>Očekávané permanentní</option>
								<form:option value="8">
									0	
								</form:option>
								<form:option value="9">
									Hemipréza		
								</form:option>
								<form:option value="10">
									Jiné	
								</form:option>
								<form:option value="11">
									Paréza hlavových nervů		
								</form:option>
								<form:option value="12">
									Porucha zorného pole		
								</form:option>
								<option id="title" disabled>Přechodné</option>
								<form:option value="13">
									0	
								</form:option>
								<form:option value="14">
									Afázie		
								</form:option>
								<form:option value="15">
									Edém		
								</form:option>
								<form:option value="16">
									Hemipréza		
								</form:option>
								<form:option value="17">
									Hydrocefalus		
								</form:option>
								<form:option value="18">
									Ischémie		
								</form:option>
								<form:option value="19">
									Jiné	
								</form:option>
								<form:option value="20">
									Krvácení	
								</form:option>
								<form:option value="21">
									Paréza hlavových nervů			
								</form:option>
								<form:option value="22">
									Zánět		
								</form:option>

						</form:select>
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


