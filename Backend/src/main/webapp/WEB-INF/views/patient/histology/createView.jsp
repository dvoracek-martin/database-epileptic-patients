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
				<h2>Histologie</h2>
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
    				<label class="control-label" for="histopathologyIdcom"><strong>Histopatologie</strong></label>
    				<div class="controls">
    					<form:select path="histopathologyIdcom" id="histopathologyIdcom" type="text" class="input-large">
								<form:option value="1">
									FCD	
								</form:option>
								<form:option value="2">
									Gliální léze		
								</form:option>
								<form:option value="3">
									HS		
								</form:option>
								<form:option value="4">
									Hamartom	
								</form:option>
								<form:option value="5">
									MCD jiná
								</form:option>
								<form:option value="6">
									Normální		
								</form:option>
								<form:option value="7">
									Nádor		
								</form:option>
								<form:option value="8">
									Posttraumatické změny		
								</form:option>
								<form:option value="8">
									SWC		
								</form:option>
								<form:option value="9">
									TSC		
								</form:option>
								<form:option value="10">
									Vaskulární léze		
								</form:option>
								<form:option value="11">
									Zánětlivá léze		
								</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="histopathologyClasificationIdcom"><strong>Klasifikace FCD</strong></label>
    				<div class="controls">
    					<form:select path="histopathologyClasificationIdcom" id="histopathologyClasificationIdcom" type="text" class="input-large">
								<form:option value="1">
									0	
								</form:option>
								<form:option value="2">
									FCD typ lla		
								</form:option>
								<form:option value="3">
									FCD typ llb			
								</form:option>
								<form:option value="4">
									FCD typ lla		
								</form:option>
								<form:option value="5">
									FCD typ la	
								</form:option>
								<form:option value="6">
									FCD typ lb		
								</form:option>
								<form:option value="7">
									mMCD typ l		
								</form:option>
								<form:option value="8">
									mMCD typ ll		
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


