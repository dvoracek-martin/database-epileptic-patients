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
				<h2><spring:message code="label.neuropsychology"/></h2>
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
    				<label class="control-label" for="intellect"><strong>Intelekt</strong></label>
    				<div class="controls">
    					<form:select path="intellect" id="intellect" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.notAvailable"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.neurodevelopmentalExamination"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.intellectualPerformance"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="neurodevelopmentalExamination"><strong>Neurovývojové vyšetření</strong></label>
    				<div class="controls">
    					<form:select path="neurodevelopmentalExamination" id="neurodevelopmentalExamination" type="text" class="input-large">
    						<form:option value="0">
									-
								</form:option>
							<form:option value="1">
								Deficit
							</form:option>
							<form:option value="2">
								Hranice deficitu
							</form:option>
							<form:option value="3">
								Mírný nadprůměr
							</form:option>
							<form:option value="4">
								Nadprůměr
							</form:option>
							<form:option value="5">
								Nezjištěno
							</form:option>
							<form:option value="6">
								Podprůměr
							</form:option>
							<form:option value="7">
								Průměr
							</form:option>
							<form:option value="8">
								Těžký deficit
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div style="border: 1px solid gray; padding: 1em; margin: 2em">
  					<div class="control-group">
	    				<label class="control-label" for="neurodevelopmentalExaminationAdaptability"><strong>Adaptabilita</strong></label>
	    				<div class="controls">
	    					<form:select path="neurodevelopmentalExaminationAdaptability" id="neurodevelopmentalExaminationAdaptability" type="text" class="input-large">
	    						<form:option value="0">
									-
								</form:option>
	    						<form:option value="1">
								Deficit
								</form:option>
								<form:option value="2">
									Hranice deficitu
								</form:option>
								<form:option value="3">
									Mírný nadprůměr
								</form:option>
								<form:option value="4">
									Nadprůměr
								</form:option>
								<form:option value="5">
									Nezjištěno
								</form:option>
								<form:option value="6">
									Podprůměr
								</form:option>
								<form:option value="7">
									Průměr
								</form:option>
								<form:option value="8">
									Těžký deficit
								</form:option>
							</form:select>
	    				</div>
    				</div>
    				<div class="control-group">
	    				<label class="control-label" for="neurodevelopmentalExaminationSpeechExpressively"><strong>Řeč expresivně</strong></label>
	    				<div class="controls">
	    					<form:select path="neurodevelopmentalExaminationSpeechExpressively" id="neurodevelopmentalExaminationSpeechExpressively" type="text" class="input-large">
	    						<form:option value="0">
									-
								</form:option>
		    					<form:option value="1">
									Deficit
								</form:option>
								<form:option value="2">
									Hranice deficitu
								</form:option>
								<form:option value="3">
									Mírný nadprůměr
								</form:option>
								<form:option value="4">
									Nadprůměr
								</form:option>
								<form:option value="5">
									Nezjištěno
								</form:option>
								<form:option value="6">
									Podprůměr
								</form:option>
								<form:option value="7">
									Průměr
								</form:option>
								<form:option value="8">
									Těžký deficit
								</form:option>
							</form:select>
	    				</div>
    				</div>
    				<div class="control-group">
	    				<label class="control-label" for="neurodevelopmentalExaminationSpeechReceptively"><strong>Řeč receptivně</strong></label>
	    				<div class="controls">
	    					<form:select path="neurodevelopmentalExaminationSpeechReceptively" id="neurodevelopmentalExaminationSpeechReceptively" type="text" class="input-large">
	    						<form:option value="0">
									-
								</form:option>
	    						<form:option value="1">
								Deficit
								</form:option>
								<form:option value="2">
									Hranice deficitu
								</form:option>
								<form:option value="3">
									Mírný nadprůměr
								</form:option>
								<form:option value="4">
									Nadprůměr
								</form:option>
								<form:option value="5">
									Nezjištěno
								</form:option>
								<form:option value="6">
									Podprůměr
								</form:option>
								<form:option value="7">
									Průměr
								</form:option>
								<form:option value="8">
									Těžký deficit
								</form:option>
							</form:select>
	    				</div>
    				</div>
    				<div class="control-group">
	    				<label class="control-label" for="neurodevelopmentalExaminationFineMotorSkills"><strong>Jemná motorika</strong></label>
	    				<div class="controls">
	    					<form:select path="neurodevelopmentalExaminationFineMotorSkills" id="neurodevelopmentalExaminationFineMotorSkills" type="text" class="input-large">
	    						<form:option value="0">
									-
								</form:option>
		    					<form:option value="1">
									Deficit
								</form:option>
								<form:option value="2">
									Hranice deficitu
								</form:option>
								<form:option value="3">
									Mírný nadprůměr
								</form:option>
								<form:option value="4">
									Nadprůměr
								</form:option>
								<form:option value="5">
									Nezjištěno
								</form:option>
								<form:option value="6">
									Podprůměr
								</form:option>
								<form:option value="7">
									Průměr
								</form:option>
								<form:option value="8">
									Těžký deficit
								</form:option>
							</form:select>
	    				</div>
    				</div>
    				<div class="control-group">
	    				<label class="control-label" for="neurodevelopmentalExaminationGrossMotorSkills"><strong>Hrubá motorika</strong></label>
	    				<div class="controls">
	    					<form:select path="neurodevelopmentalExaminationGrossMotorSkills" id="neurodevelopmentalExaminationGrossMotorSkills" type="text" class="input-large">
	    						<form:option value="0">
									-
								</form:option>
	    						<form:option value="1">
								Deficit
								</form:option>
								<form:option value="2">
									Hranice deficitu
								</form:option>
								<form:option value="3">
									Mírný nadprůměr
								</form:option>
								<form:option value="4">
									Nadprůměr
								</form:option>
								<form:option value="5">
									Nezjištěno
								</form:option>
								<form:option value="6">
									Podprůměr
								</form:option>
								<form:option value="7">
									Průměr
								</form:option>
								<form:option value="8">
									Těžký deficit
								</form:option>
							</form:select>
	    				</div>
    				</div>
    				<div class="control-group">
	    				<label class="control-label" for="neurodevelopmentalExaminationSocialBehavior"><strong>Sociální chování</strong></label>
	    				<div class="controls">
	    					<form:select path="neurodevelopmentalExaminationSocialBehavior" id="neurodevelopmentalExaminationSocialBehavior" type="text" class="input-large">
	    						<form:option value="0">
									-
								</form:option>
		    					<form:option value="1">
									Deficit
								</form:option>
								<form:option value="2">
									Hranice deficitu
								</form:option>
								<form:option value="3">
									Mírný nadprůměr
								</form:option>
								<form:option value="4">
									Nadprůměr
								</form:option>
								<form:option value="5">
									Nezjištěno
								</form:option>
								<form:option value="6">
									Podprůměr
								</form:option>
								<form:option value="7">
									Průměr
								</form:option>
								<form:option value="8">
									Těžký deficit
								</form:option>
							</form:select>
	    				</div>
    				</div>
  				</div>

  				<div class="control-group">
	    			<label class="control-label" for="intellectualPerformance"><strong>Intelektový výkon</strong></label>
	    			<div class="controls">
	    				<form:select path="intellectualPerformance" id="intellectualPerformance" type="text" class="input-large">
	    					<form:option value="0">
									-
							</form:option>
		    				<form:option value="1">
									Deficit
							</form:option>
							<form:option value="2">
									Hranice deficitu
							</form:option>
							<form:option value="3">
									Mírný nadprůměr
							</form:option>
							<form:option value="4">
									Nadprůměr
							</form:option>
							<form:option value="5">
									Nezjištěno
							</form:option>
							<form:option value="6">
									Podprůměr
							</form:option>
							<form:option value="7">
									Průměr
							</form:option>
							<form:option value="8">
									Těžký deficit
							</form:option>
						</form:select>
	    			</div>
    			</div>

    			<div class="control-group">
	    			<label class="control-label" for="intellectualPerformanceVerbally"><strong>Verbálne</strong></label>
	    			<div class="controls">
	    				<form:select path="intellectualPerformanceVerbally" id="intellectualPerformanceVerbally" type="text" class="input-large">
	    					<form:option value="0">
									-
							</form:option>
		    				<form:option value="1">
									Deficit
							</form:option>
							<form:option value="2">
									Hranice deficitu
							</form:option>
							<form:option value="3">
									Mírný nadprůměr
							</form:option>
							<form:option value="4">
									Nadprůměr
							</form:option>
							<form:option value="5">
									Nezjištěno
							</form:option>
							<form:option value="6">
									Podprůměr
							</form:option>
							<form:option value="7">
									Průměr
							</form:option>
							<form:option value="8">
									Těžký deficit
							</form:option>
						</form:select>
	    			</div>
    			</div>

    			<div class="control-group">
	    			<label class="control-label" for="intellectualPerformanceNonverbalAbstraction"><strong>Neverbální - abstrakce</strong></label>
	    			<div class="controls">
	    				<form:select path="intellectualPerformanceNonverbalAbstraction" id="intellectualPerformanceNonverbalAbstraction" type="text" class="input-large">
	    					<form:option value="0">
									-
							</form:option>
		    				<form:option value="1">
									Deficit
							</form:option>
							<form:option value="2">
									Hranice deficitu
							</form:option>
							<form:option value="3">
									Mírný nadprůměr
							</form:option>
							<form:option value="4">
									Nadprůměr
							</form:option>
							<form:option value="5">
									Nezjištěno
							</form:option>
							<form:option value="6">
									Podprůměr
							</form:option>
							<form:option value="7">
									Průměr
							</form:option>
							<form:option value="8">
									Těžký deficit
							</form:option>
						</form:select>
	    			</div>
    			</div>

    			<div class="control-group">
	    			<label class="control-label" for="intellectualPerformanceNonverbalDesignCapabilities"><strong>Neverbální - konstrukční schopnosti</strong></label>
	    			<div class="controls">
	    				<form:select path="intellectualPerformanceNonverbalDesignCapabilities" id="intellectualPerformanceNonverbalDesignCapabilities" type="text" class="input-large">
	    					<form:option value="0">
									-
							</form:option>
		    				<form:option value="1">
									Deficit
							</form:option>
							<form:option value="2">
									Hranice deficitu
							</form:option>
							<form:option value="3">
									Mírný nadprůměr
							</form:option>
							<form:option value="4">
									Nadprůměr
							</form:option>
							<form:option value="5">
									Nezjištěno
							</form:option>
							<form:option value="6">
									Podprůměr
							</form:option>
							<form:option value="7">
									Průměr
							</form:option>
							<form:option value="8">
									Těžký deficit
							</form:option>
						</form:select>
	    			</div>
    			</div>

  				<div class="control-group">
    				<label class="control-label" for="neuropsychologicalProfile"><strong><spring:message code="label.neuropsychologicalProfile"/></strong></label>
    				<div class="controls">
    					<form:select path="neuropsychologicalProfile" id="neuropsychologicalProfile" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.notAvailable"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.concern"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.notConcern"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<%@include file="createExtract.jsp" %>

  				<div class="control-group">
    				<label class="control-label" for="presenceOfChanges"><strong>Přítomnost změn v čase</strong></label>
    				<div class="controls">
    					<form:select path="presenceOfChanges" id="presenceOfChanges" type="text" class="input-large">
							<form:option value="1">
								Deteriorace
							</form:option>
							<form:option value="2">
								Progrese
							</form:option>
							<form:option value="3">
								Nezjištěno
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="emotionalStatus"><strong>Emoční status</strong></label>
    				<div class="controls">
    					<form:select path="emotionalStatus" id="emotionalStatus" type="text" class="input-large">
							<form:option value="1">
								ADHD
							</form:option>
							<form:option value="2">
								Bez nápadností
							</form:option>
							<form:option value="3">
								Depresivní poruchy
							</form:option>
							<form:option value="4">
								Porucha autistického spektra
							</form:option>
							<form:option value="5">
								Porucha chování
							</form:option>
							<form:option value="6">
								Porucha přizpůsobení
							</form:option>
							<form:option value="7">
								Úzkost
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


