<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Outcome
    </jsp:attribute>
	<jsp:attribute name="header">
      Outcome
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2>Outcome</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/outcome/create" />"><spring:message code="label.addRecord"/></a>
					</h3>
				</div>
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
						<td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>
							
					</tr>
				</tbody>
			</table>
 
			<c:if test="${empty patient.outcomeList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<!-- Histology list START -->
			<div class="accordion">
				<c:forEach items="${patient.outcomeList}" var="outcome">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${outcome.id}">
					    	    <strong>Vyšetření dne:</strong> ${outcome.date}
					    	</a>
						</div>

					    <div id="collapse${outcome.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/outcome/${outcome.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/outcome/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td>Seizure outcome</td>
											<c:if test="${outcome.finallySeizuresIdcom==1}">
												<td>0</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==2}">
												<td>IA</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==3}">
												<td>IB</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==4}">
												<td>IC</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==5}">
												<td>ID</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==6}">
												<td>IIA</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==7}">
												<td>IIB</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==8}">
												<td>IIC</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==9}">
												<td>IID</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==10}">
												<td>IIIA</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==11}">
												<td>IIIB</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==12}">
												<td>IV</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==13}">
												<td>V</td>
											</c:if>
											<c:if test="${outcome.finallySeizuresIdcom==14}">
												<td>VI</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>EEG hroty</td>
											<c:if test="${outcome.eegSpikes==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${outcome.eegSpikes==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>AED vysazeny</td>
											<c:if test="${outcome.aedPlanted==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${outcome.aedPlanted==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>MRI provedeno</td>
											<c:if test="${outcome.mriDone==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${outcome.mriDone==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Neuropsychologie</td>
											<c:if test="${outcome.neuropsychology==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${outcome.neuropsychology==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty outcome.comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${outcome.comment}</td>
												</c:otherwise>
											</c:choose>
										</tr>
				              		</tbody>
			            		</table>
		            		</div>
					    </div>
	            	</div>
	            </c:forEach>
            </div>
        </br> 
	</jsp:body>
</t:menuLVL3>


