<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Histologie
    </jsp:attribute>
	<jsp:attribute name="header">
      Histologie
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2>Histologie</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/histology/create" />"><spring:message code="label.addRecord"/></a>
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
 
			<c:if test="${empty patient.histologyList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<!-- Histology list START -->
			<div class="accordion">
				<c:forEach items="${patient.histologyList}" var="histology">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${histology.id}">
					    	    <strong>Vyšetření dne:</strong> ${histology.date}
					    	</a>
						</div>

					    <div id="collapse${histology.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/histology/${histology.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/histology/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td>Histopatologie</td>
											<c:if test="${histology.histopathologyIdcom==1}">
												<td>FCD</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==2}">
												<td>Gliální léze</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==3}">
												<td>HS</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==4}">
												<td>Hamartom</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==5}">
												<td>MCD jiná</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==6}">
												<td>Normální</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==7}">
												<td>Nádor</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==8}">
												<td>Posttraumatické změny</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==9}">
												<td>SWC</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==10}">
												<td>TSC</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==11}">
												<td>Vaskulární léze</td>
											</c:if>
											<c:if test="${histology.histopathologyIdcom==12}">
												<td>Zánětlivá léze</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Klasifikace FCD</td>
											<c:if test="${histology.histopathologyClasificationIdcom==1}">
												<td>0</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==2}">
												<td>FCD typ lla</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==3}">
												<td>FCD typ llb</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==4}">
												<td>FCD typ lla</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==5}">
												<td>FCD typ la</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==6}">
												<td>FCD typ lb</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==7}">
												<td>mMCD typ l</td>
											</c:if>
											<c:if test="${histology.histopathologyClasificationIdcom==8}">
												<td>mMCD typ ll</td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty histology.comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${histology.comment}</td>
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


