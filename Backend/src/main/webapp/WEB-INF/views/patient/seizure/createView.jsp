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
				<h2>Záchvaty</h2>
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
						action="/GENEPI/patient/${patientID}/seizure/create" commandName="seizure">

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
    				<label class="control-label" for="seizureFrequencyIdcom"><strong>Četnost záchvatů</strong></label>
    				<div class="controls">
    					<form:select path="seizureFrequencyIdcom" id="seizureFrequencyIdcom" type="text" class="input-large">
							
								<form:option value="1">
									Denně
								</form:option>
								<form:option value="2">
									Týdně
								</form:option>
								<form:option value="3">
									Méně než měsíčně
								</form:option>
								<form:option value="4">
									Měsíčně
								</form:option>					

						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="sscClassificationIdcom"><strong>SSC klasifikace</strong></label>
    				<div class="controls">
    					<form:select path="sscClassificationIdcom" id="sscClassificationIdcom" type="text" class="input-large">
							
								<form:option value="1">
									1. Epileptický záchvat
								</form:option>
								<form:option value="2">
									2. Aura
								</form:option>
								<form:option value="3">
									2.a. Somastosenzorická aura
								</form:option>
								<form:option value="4">
									2.b. Zraková aura
								</form:option>	
								<form:option value="5">
									2.c. Sluchová aura
								</form:option>
								<form:option value="6">
									2.d. Čichová aura
								</form:option>
								<form:option value="7">
									2.e. Chuťová aura
								</form:option>
								<form:option value="8">
									2.f. Autonomní aura
								</form:option>
								<form:option value="9">
									2.g. Epigastrická aura
								</form:option>	
								<form:option value="10">
									2.h. Psychická aura
								</form:option>	
								<form:option value="11">
									3. Absence
								</form:option>		
								<form:option value="12">
									4. Autonomní záchvat
								</form:option>	
								<form:option value="13">
									5. Psychomotorický záchvat
								</form:option>	
								<form:option value="14">
									6. Motorický záchvat
								</form:option>	
								<form:option value="15">
									6.a. Klonický záchvat
								</form:option>	
								<form:option value="16">
									6.b. Tonický záchvat
								</form:option>	
								<form:option value="17">
									6.c. Tonicko-klonický záchvat
								</form:option>	
								<form:option value="18">
									6.d. Atonický záchvat
								</form:option>	
								<form:option value="19">
									6.e. Akinetický záchvat
								</form:option>	
								<form:option value="20">
									6.f. Versivní záchvat
								</form:option>	
								<form:option value="21">
									6.g. Myoklonický záchvat
								</form:option>	
								<form:option value="22">
									6.h. Hypermotorický záchvat
								</form:option>	
								<form:option value="23">
									6.i. Hypomotorický záchvat
								</form:option>	
								<form:option value="24">
									6.j. Negativní myoklonický záchvat
								</form:option>	
								<form:option value="25">
									6.k. Astatický záchvat
								</form:option>	
								<form:option value="26">
									6.l. Akinetický záchvat
								</form:option>	
								<form:option value="27">
									6.m. Afázický záchvat
								</form:option>	
								<form:option value="28">
									6.n. Gelastický záchvat
								</form:option>	
								<form:option value="29">
									7. Paroxysmální příhoda
								</form:option>	


						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="ilaeClassificationIdcom"><strong>ILAE klasifikace</strong></label>
    				<div class="controls">
    					<form:select path="ilaeClassificationIdcom" id="ilaeClassificationIdcom" type="text" class="input-large">
							
								<form:option value="1">
									I.A.1. Jednoduchý parciální záchvat s motorickými symptomy
								</form:option>
								<form:option value="2">
									I.A.2. Jednoduchý parciální záchvat s psychickými symptomy
								</form:option>
								<form:option value="3">
									I.A.3. Jednoduchý parciální záchvat s autonomními symptomy
								</form:option>
								<form:option value="4">
									I.A.4. Jednoduchý parciální záchvat se somatosenzorickými symptomy
								</form:option>
								<form:option value="5">
									I.B.1. Komplexní parciální záchvat s jednoduchým parciálním záchvatem na počátku,  následovaným poruc
								</form:option>
								<form:option value="6">
									I.B.2. Komplexní parciální záchvat s poruchou vědomí na počátku
								</form:option>
								<form:option value="7">
									I.C. Parciální záchvat sekundárně se rozvíjející v generalizovaný
								</form:option>
								<form:option value="8">
									II.A.1. Generalizovaný - Typická absence
								</form:option>
								<form:option value="9">
									II.A.2. Generalizovaný - Atypická absence
								</form:option>
								<form:option value="10">
									II.B. Generalizovaný - Myoklonický
								</form:option>	
								<form:option value="11">
									II.C. Generalizovaný - Klonický
								</form:option>	
								<form:option value="12">
									II.D. Generalizovaný - Tonický
								</form:option>	
								<form:option value="13">
									II.E. Generalizovaný - Tonicko-klonický
								</form:option>
								<form:option value="14">
									II.F. Generalizovaný - Atonický
								</form:option>		
								<form:option value="15">
									III. Neklasifikovaný
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


