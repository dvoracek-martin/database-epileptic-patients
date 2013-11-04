<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Pacient
    </jsp:attribute>
	<jsp:attribute name="header">
      Pacient
    </jsp:attribute>

	<jsp:attribute name="script">
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script>
			$(document).ready(function() {
				$('p.tree-toggler').click(function() {
					$(this).parent().children('ul.tree').toggle(300);
				});
			});
		</script>
					
					<!--jQuery for changing action method of foorm when clicking on SAVE set-->
					<script>
						$('#saveButton')
								.click(
										function() {
											$('#exportForm')
													.attr('action',
															'<c:url value="/patient/export/save" />');
											$('#exportName').attr(
													'value',
													$('#exportNameToCopy')
															.val());

											<sec:authorize ifAnyGranted="ROLE_ADMIN">
											$('#isGeneric').attr(
													'value',
													$('#isGenericBox').is(
															':checked'));
											</sec:authorize>

											$('#exportForm').submit();
										});
					</script>
						<!--change action URL when deleting users SET-->
						<script>
							$('#genericSetDeleteButton')
									.click(
											function() {
												$('#genericSets')
														.attr('action',
																'<c:url value="/patient/export/delete" />');
												$('#genericSets').submit();
											});
						</script>
						<script>
							$('#userSetDeleteButton')
									.click(
											function() {
												$('#userSets')
														.attr('action',
																'<c:url value="/patient/export/delete" />');
												$('#userSets').submit();
											});
						</script>
				
	</jsp:attribute>

	<jsp:body>

					<div>
						<h2>
							<spring:message code="label.exportPatient" /> <a
					href="<c:url value="/patient/${patient.id}/overview" />"
					style="text-decoration: none">${patient.contact.firstName} ${patient.contact.lastName}</a>
						</h2>
					</div>
<!-- Lists -->
<!-- user Lists -->						
					<div class="span6">
					<form id="genericSets" method="POST"
				action="<c:url value="/patient/export/load" />">
					<label>Generic Sets</label>
					
						<select name="exportId" class="input-large">
							<c:forEach items="${listOfSavedConfigurations}" var="exportParam">
								<option value="${exportParam.id}">
									${exportParam.name}
								</option>
							</c:forEach>	
						</select>
					<c:forEach items="${patientList}" var="patient">
					<input type="hidden" name="patient" value="${patient.id}">
							</c:forEach>	
					<button class="btn btn-primary" type="submit">LOAD</button>
					
						<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<button id="genericSetDeleteButton" class="btn btn-primary"
						type="submit">DELETE</button>
						</sec:authorize>
					</form>
					</div>
					
<!-- generic Lists -->						
					<div class="span6">
					<form id="userSets" method="POST"
				action="<c:url value="/patient/export/load" />">
					<label>My Sets</label>
					
						<select name="exportId" class="input-large">
							<c:forEach items="${listOfUsersSavedConfigurations}"
						var="exportParam">
								<option value="${exportParam.id}">
									${exportParam.name}
								</option>
							</c:forEach>	
						</select>
					<c:forEach items="${patientList}" var="patient">
					<input type="hidden" name="patient" value="${patient.id}">
							</c:forEach>	
					<button class="btn btn-primary" type="submit">LOAD</button>
					<button id="userSetDeleteButton" class="btn btn-primary"
					type="submit">DELETE</button>				
					</form>
					</div>
<!-- Lists END -->										
						
				
<!-- Tree list  -->

			<div class="span3">
				<form:form id="exportForm" method="POST"
				action="/GENEPI/patient/export" commandName="exportParams">
				
					<!-- Hidden fields  -->
					<!-- Export name -->
					<input id="exportName" type="hidden" name="exportName" value="">
					<!-- patient ids -->
						<c:forEach items="${patientList}" var="patient">
					<input type="hidden" name="patient" value="${patient.id}">
							</c:forEach>	
					<!-- Is Generic checkbox -->		
					<input id="isGeneric" type="hidden" name="isGeneric" value="0">

		 <ul class="nav nav-list">
            <li><p class="tree-toggler nav-header">Anamneza<form:checkbox
								path="anamnesis" class="input-block-level" />
							</p>
                <ul class="nav nav-list tree">
                						   <li><form:label path="anamnesisId">anamnesisid</form:label>
						<form:checkbox path="anamnesisId" class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisDate">anamnesisDate</form:label>
						<form:checkbox path="anamnesisDate" class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisDoctorId">anamnesisDoctorId</form:label>
						<form:checkbox path="anamnesisDoctorId" class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisAdded">anamnesisAdded</form:label>
						<form:checkbox path="anamnesisAdded" class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisBeginningEpilepsy">anamnesisBeginningEpilepsy</form:label>
						<form:checkbox path="anamnesisBeginningEpilepsy"
									class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisFirstFever">anamnesisFirstFever</form:label>
						<form:checkbox path="anamnesisFirstFever"
									class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisInfantileSpasm">anamnesisInfantileSpasm</form:label>
						<form:checkbox path="anamnesisInfantileSpasm"
									class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisSpecificSyndrome">anamnesisSpecificSyndrome</form:label>
						<form:checkbox path="anamnesisSpecificSyndrome"
									class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisEpilepsyInFamily">anamnesisEpilepsyInFamily</form:label>
						<form:checkbox path="anamnesisEpilepsyInFamily"
									class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisParentalRisk">anamnesisParentalRisk</form:label>
						<form:checkbox path="anamnesisParentalRisk"
									class="input-block-level" /></li>
										
										   <li><form:label path="anamnesisFibrilConvulsions">anamnesisFibrilConvulsions</form:label>
						<form:checkbox path="anamnesisFibrilConvulsions"
									class="input-block-level" /></li>
										<li><form:label path="anamnesisInflammationCns">anamnesisInflammationCns</form:label>
						<form:checkbox path="anamnesisInflammationCns"
									class="input-block-level" /></li>
										
										<li><form:label path="anamnesisInjuryCns">anamnesisInjuryCns</form:label>
						<form:checkbox path="anamnesisInjuryCns" class="input-block-level" /></li>
										
										<li><form:label path="anamnesisOperationCns">anamnesisOperationCns</form:label>
						<form:checkbox path="anamnesisOperationCns"
									class="input-block-level" /></li>
										
										<li><form:label path="anamnesisEarlyPmdRetardation">anamnesisEarlyPmdRetardation</form:label>
						<form:checkbox path="anamnesisEarlyPmdRetardation"
									class="input-block-level" /></li>
										
										<li><form:label path="anamnesisNonCnsComorbidity">anamnesisNonCnsComorbidity</form:label>
						<form:checkbox path="anamnesisNonCnsComorbidity"
									class="input-block-level" /></li>
										
										<li><form:label path="anamnesisComment">anamnesisComment</form:label>
						<form:checkbox path="anamnesisComment" class="input-block-level" /></li>
</ul>
</li>
            
            <li><p class="tree-toggler nav-header">Dalsi <input
								type="checkbox">
						</p>
                <ul class="nav nav-list tree">
                    <li>Link <input type="checkbox"></li>
                      <li>Link <input type="checkbox"></li>
                </ul>
            </li>
            </ul>


<!-- Tree list END -->
			
						<div class="control-group span6">
						    <label class="control-label" for="pdfFormat">Formát</label>
						    <div class="controls">
						    	<input type="radio" id="pdfFormat" name="exportType"
							value="pdf" checked> pdf
								<input type="radio" id="xlsxFormat" name="exportType"
							value="xlsx"> xlsx
								<input type="radio" id="docxFormat" name="exportType"
							value="docx"> docx
							<input type="radio" id="txtFormat" name="exportType" value="txt"> txt
								<input type="radio" id="csvFormat" name="exportType" value="csv"> csv
						    </div>
						</div>
						
						<div class="control-group span6">
						    <div class="controls">
						      	<button id="exportButton" type="submit"
							class="btn btn-primary">
							<spring:message code="label.export" />
						</button>	
						    </div>
						</div>
            </form:form>											 																					
						
					<div class="span6">
					<p>Uložit sestavu</p>
					<input id="exportNameToCopy" type="text">
					
						<sec:authorize ifAnyGranted="ROLE_ADMIN">
						<input id="isGenericBox" type="checkbox" name="isGeneric">Is Generic???
						</sec:authorize>
						<button id="saveButton" class="btn btn-primary" type="submit">SAVE</button>					
					</div>

		</div>
	</jsp:body>
</t:menuLVL3>


