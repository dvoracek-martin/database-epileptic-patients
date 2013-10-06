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
				<h2>Anamnéza</h2>
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
						action="/GENEPI/patient/${patientID}/anamnesis/create" commandName="anamnesis">

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
    				<label class="control-label" for="epilepsyInFamily"><strong>Epilepsie v rodině</strong></label>
    				<div class="controls">
    					<form:checkbox path="epilepsyInFamily" input="epilepsyInFamily" class="input-block-level" />
						<form:errors path="epilepsyInFamily" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="prenatalRisk"><strong>Prenatální rizika</strong></label>
    				<div class="controls">
    					<form:checkbox path="prenatalRisk" input="prenatalRisk" class="input-block-level" />
						<form:errors path="prenatalRisk" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="fibrilConvulsions"><strong>Fibrilní křeče</strong></label>
    				<div class="controls">
    					<form:checkbox path="fibrilConvulsions" input="fibrilConvulsions" class="input-block-level" />
						<form:errors path="fibrilConvulsions" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="inflammationCns"><strong>Zánět CNS</strong></label>
    				<div class="controls">
    					<form:checkbox path="inflammationCns" input="inflammationCns" class="input-block-level" />
						<form:errors path="inflammationCns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="injuryCns"><strong>Úraz CNS</strong></label>
    				<div class="controls">
    					<form:checkbox path="injuryCns" input="injuryCns" class="input-block-level" />
						<form:errors path="injuryCns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="operationCns"><strong>Operace CNS</strong></label>
    				<div class="controls">
    					<form:checkbox path="operationCns" input="operationCns" class="input-block-level" />
						<form:errors path="operationCns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="earlyPmdRetardation"><strong>Časná PMD retardace</strong></label>
    				<div class="controls">
    					<form:checkbox path="earlyPmdRetardation" input="earlyPmdRetardation" class="input-block-level" />
						<form:errors path="earlyPmdRetardation" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="beginningEpilepsy"><strong>Začátek epilepsie</strong></label>
    				<div class="controls">
    					<form:input path="beginningEpilepsy" id="beginningEpilepsy" type="text" class="input-medium datepicker" />
						<form:errors path="beginningEpilepsy" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="firstFever"><strong>První záchvat s horečkou</strong></label>
    				<div class="controls">
    					<form:checkbox path="firstFever" input="firstFever" class="input-block-level" />
						<form:errors path="firstFever" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="infantileSpasm"><strong>Infantilní spasmy</strong></label>
    				<div class="controls">
    					<form:checkbox path="infantileSpasm" input="infantileSpasm" class="input-block-level" />
						<form:errors path="infantileSpasm" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="specificSyndromeIdcom"><strong>Epileptický syndrom</strong></label>
    				<div class="controls">
    					<form:select path="specificSyndromeIdcom" id="specificSyndromeIdcom" type="text" class="input-large">
							<form:option value="0">
								Zvolte syndrom
							</form:option>
							<form:option value="1">
								Extratemporální fokální epilepsie
							</form:option>
							<form:option value="2">
								Hemisferální symtomaptická epilepsie
							</form:option>
							<form:option value="3">
								Meziotemporální epilepsie (MTLE)
							</form:option>
							<form:option value="4">
								Multifokální epilepsie
							</form:option>	
							<form:option value="4">
								Temporální epilepsie jiná než MTLE
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="nonCnsComorbidity"><strong>Non CNS komorbidita</strong></label>
    				<div class="controls">
    					<form:input path="nonCnsComorbidity" id="nonCnsComorbidity" type="text" class="input-medium" 
    					value="porod per SC. pro gestrózu zjištěnou až během porodu" />
						<form:errors path="nonCnsComorbidity" cssClass="error">
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


