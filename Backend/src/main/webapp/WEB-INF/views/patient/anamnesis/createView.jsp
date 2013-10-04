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
      Přidat záznam
    </jsp:attribute>
	<jsp:attribute name="header">
      Přidat záznam
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
   </jsp:attribute>
	<jsp:body>
					<div>
					<h2>Přehled pacienta</h2>
				</div>
				<table style="border: 1px solid black">
					<tbody>
						<tr>
							<th>Číslo pacienta:</th>
							<td></td>

							<th>Rodné číslo:</th>
							<td></td>

							<th>Adresa:</th>
							<td></td>

						</tr>
						<tr>
							<th>Telefon:</th>
							<td></td>

							<th>Věk:</th>
							<td></td>

							<th>Pohaví:</th>
							<td></td>
						</tr>

						<tr>
							<th>Email:</th>
							<td></td>

							<th>Věk při začátku epilepsie:</th>
							<td></td>

							<th>Ošetřující lékař:</th>
							<td></td>

						</tr>
					</tbody>
				</table>

				<!-- form for adding new record -->
				<div class="form" style="margin: 10px; width: 60%">
					<!-- form for adding new patient -->
					<!-- mapping resource in action with c:url caused errors -->
					<form:form method="POST"
				action="/GENEPI/patient/${patientID}/anamnesis/create"
				commandName="anamnesis">
						<form:label path="date">Datum</form:label>
						<form:input path="date" type="text"
					class="input-block-level datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
						
						
							<form:label path="doctorId"><spring:message code="label.doctor" /></form:label>
						<form:select path="doctorId" type="text"
					class="input-block-level">
						<c:forEach items="${doctors}" var="doctor">
	<form:option value="${doctor.id}">${doctor.contact.firstName} ${doctor.contact.lastName}</form:option>
			</c:forEach>
							
							</form:select>

						<form:label path="epilepsyInFamily">Epilepsie v rodině</form:label>
						<form:checkbox path="epilepsyInFamily" class="input-block-level" />
						<form:errors path="epilepsyInFamily" cssClass="error">
						</form:errors>

						<form:label path="prenatalRisk">Prenatální rizika</form:label>
						<form:checkbox path="prenatalRisk" class="input-block-level" />
						<form:errors path="prenatalRisk" cssClass="error">
						</form:errors>

						<form:label path="fibrilConvulsions">Fibrilní křeče</form:label>
						<form:checkbox path="fibrilConvulsions" class="input-block-level" />
						<form:errors path="fibrilConvulsions" cssClass="error">
						</form:errors>

						<form:label path="inflammationCns">Zánět CNS</form:label>
						<form:checkbox path="inflammationCns" class="input-block-level" />
						<form:errors path="inflammationCns" cssClass="error">
						</form:errors>

						<form:label path="injuryCns">Úraz CNS</form:label>
						<form:checkbox path="injuryCns" class="input-block-level" />
						<form:errors path="injuryCns" cssClass="error">
						</form:errors>

						<form:label path="operationCns">Operace CNS</form:label>
						<form:checkbox path="operationCns" class="input-block-level" />
						<form:errors path="operationCns" cssClass="error">
						</form:errors>

						<form:label path="earlyPmdRetardation">Časná PMD retardace</form:label>
						<form:checkbox path="earlyPmdRetardation"
					class="input-block-level" />
						<form:errors path="earlyPmdRetardation" cssClass="error">
						</form:errors>

						<form:label path="beginningEpilepsy">Začátek epilepsie</form:label>
						<form:input path="beginningEpilepsy" type="text"
					class="input-block-level datepicker" />
						<form:errors path="beginningEpilepsy" cssClass="error">
						</form:errors>

						<form:label path="firstFever">První záchvat s horečkou</form:label>
						<form:checkbox path="firstFever" class="input-block-level" />
						<form:errors path="firstFever" cssClass="error">
						</form:errors>

						<form:label path="infantileSpasm">Infantilní spasmy</form:label>
						<form:checkbox path="infantileSpasm" class="input-block-level" />
						<form:errors path="infantileSpasm" cssClass="error">
						</form:errors>

						<form:label path="specificSyndromeIdcom">Epileptický syndrom</form:label>
						<form:select path="specificSyndromeIdcom" type="text"
					class="input-block-level">
							<form:option value="0">Zvolte syndrom</form:option>
							<form:option value="1">Extratemporální
							fokální epilepsie</form:option>
							<form:option value="2">Hemisferální
							symtomaptická epilepsie</form:option>
							<form:option value="3">Meziotemporální
							epilepsie (MTLE)</form:option>
							<form:option value="4">Multifokální
							epilepsie</form:option>
						</form:select>

						<form:label path="nonCnsComorbidity">Non CNS komorbidita</form:label>
						<form:input path="nonCnsComorbidity" type="text"
					class="input-block-level" />
						<form:errors path="nonCnsComorbidity" cssClass="error">
						</form:errors>

						<form:label path="comment">Komentář</form:label>
						<form:textarea cols="40" rows="10" path="comment" />

						<button class="btn btn-small btn-primary" type="submit">Pridat</button>
					</form:form>
				</div>
	
		<datalist id="doctors">
	<c:forEach items="${doctors}" var="doctor">
		<option value="${doctor.id}">dfdf</option>
	
			</c:forEach>
	</datalist>
	</jsp:body>
</t:menuLVL3>


