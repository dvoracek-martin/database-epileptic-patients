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
				<h2>Neuropsychologie</h2>
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
						action="/GENEPI/patient/${patientID}/neuropsychology/create" commandName="neuropsychology">

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
    				<label class="control-label" for="neuropsychologicalExamination"><strong>Neuropsychologické vyšetření</strong></label>
    				<div class="controls">
    					<form:checkbox path="neuropsychologicalExamination" input="neuropsychologicalExamination" class="input-block-level" checked="checked" />
						<form:errors path="neuropsychologicalExamination" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="intelligenceLevelIdcom"><strong>Inteligenční úroveň</strong></label>
    				<div class="controls">
    					<form:select path="intelligenceLevelIdcom" id="intelligenceLevelIdcom" type="text" class="input-large">
							<form:option value="0">
								Zvolte syndrom
							</form:option>
							<form:option value="1">
								Mírná mentální retardace
							</form:option>
							<form:option value="2">
								Naprůměrná inteligence
							</form:option>
							<form:option value="3">
								Podprůměrná inteligence
							</form:option>
							<form:option value="4">
								Průměrná inteligence
							</form:option>	
							<form:option value="5">
								Středně těžká mentální retardace
							</form:option>
							<form:option value="6">
								Těžká mentální retardace
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="specificLearning"><strong>Specifická porucha učení</strong></label>
    				<div class="controls">
    					<form:checkbox path="specificLearning" input="specificLearning" class="input-block-level" />
						<form:errors path="specificLearning" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="developmentalLanguageDisorders"><strong>Vývojová porucha řeči</strong></label>
    				<div class="controls">
    					<form:checkbox path="developmentalLanguageDisorders" input="developmentalLanguageDisorders" class="input-block-level" />
						<form:errors path="developmentalLanguageDisorders" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="adhdSyndrome"><strong>ADHD syndrom</strong></label>
    				<div class="controls">
    					<form:checkbox path="adhdSyndrome" input="adhdSyndrome" class="input-block-level" />
						<form:errors path="adhdSyndrome" cssClass="error">
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


