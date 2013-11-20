<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Diagnostické testy - Neurozobrazovací testy
    </jsp:attribute>
	<jsp:attribute name="header">
      Diagnostické testy - Neurozobrazovací testy
    </jsp:attribute>

	<jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2>Diagnostické testy - Neurozobrazovací testy</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
						href="<c:url value="/patient/${patientID}/diagnosticTestMRI/create" />"><spring:message
							code="label.addRecord" /></a>
					</h3>
				</div>
			</div>
			<table class="table">
				<tbody>
					<tr>
						<th><spring:message code="label.patient" />:</th>
						<td>${patient.contact.firstName}</td>

						<th><spring:message code="label.birthIdentificationNumber" />:</th>
						<td>${patient.nin}</td>

						<th><spring:message code="label.birthdate" />:</th>
						<td>${patient.birthday}</td>
							
					</tr>
					<tr>	
						<th><spring:message code="label.address" />:</th>
						<td>${patient.contact.addressStreet}</td>
							
						<th><spring:message code="label.telephone" />:</th>
						<td>${patient.contact.phoneNumber}</td>
							
						<th><spring:message code="label.email" />:</th>
						<td>${patient.contact.email}</td>
												
							
					</tr>
					<tr>
						<th><spring:message code="label.gender" />:</th>
						<td>${patient.gender}</td>
							
						<th><spring:message code="label.ageAtTheBeginningOfEpilepsy" />:</th>
						<td></td>
							
						<th><spring:message code="label.assignedDoctor" />:</th>
						<td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>
							
					</tr>
				</tbody>
			</table>

			<!-- diagnosticTestMRI list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.diagnosticTestMRIList}" var="diagnosticTestMRI">
					<c:if test="${diagnosticTestMRI.status==0}">

						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse${diagnosticTestMRI.id}">
						    	    <strong>Zadáno dne:</strong> ${diagnosticTestMRI.date}
						    	</a>
							</div>

						    <div id="collapse${diagnosticTestMRI.id}" class="accordion-body collapse">
						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patientID}/diagnosticTestMRI/${diagnosticTestMRI.id}/hide"/>"><spring:message code="label.delete" /></a>
										</div>
										<div class="pull-left">
											<a class="close"
											href="<c:url value="/patient/${patientID}/diagnosticTestMRI/list"/>"><spring:message code="label.edit" /></a>
										</div>	
										<br>							
									</div>
									<table class="table">
					               		<tbody>
					               			<tr class="info">
												<td>Diagnostický test - Neurozobrazovací test</td>
												<c:if test="${diagnosticTestMRI.done==false}">
													<td><spring:message code="label.notDone" /></td>
												</c:if>
												<c:if test="${diagnosticTestMRI.done==true}">
													<td><spring:message code="label.done" /></td>
												</c:if>
											</tr>
											<c:if test="${diagnosticTestMRI.done==true}">
												<tr class="info">
													<td><spring:message code="label.MRIFinding" /></td>
													<c:if test="${diagnosticTestMRI.mriFinding==1}">
														<td><spring:message code="label.bilateral" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==2}">
														<td><spring:message code="label.focal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==3}">
														<td><spring:message code="label.hemispheric" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==4}">
														<td><spring:message code="label.lobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==5}">
														<td><spring:message code="label.multilobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==6}">
														<td><spring:message code="label.notDone" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==7}">
														<td><spring:message code="label.normal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mriFinding==8}">
														<td><spring:message code="label.postoperative" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td>MRI popis</td>
													<td>${diagnosticTestMRI.mriDescription}</td>
												</tr>

												<tr class="info">
													<td>FDG PET</td>
													<c:if test="${diagnosticTestMRI.fdgPet==1}">
														<td><spring:message code="label.bilateral" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==2}">
														<td><spring:message code="label.focal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==3}">
														<td><spring:message code="label.hemispheric" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==4}">
														<td><spring:message code="label.lobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==5}">
														<td><spring:message code="label.multilobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==6}">
														<td><spring:message code="label.notDone" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==7}">
														<td><spring:message code="label.normal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fdgPet==8}">
														<td><spring:message code="label.postoperative" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message
														code="label.localizationPetHypometabolism" /></td>
													<td>${diagnosticTestMRI.descriptionPetHypometabolism}</td>
												</tr>

												<tr class="info">
													<td><spring:message code="label.interictalSPECT" /></td>
													<c:if test="${diagnosticTestMRI.interictalSpect==1}">
														<td><spring:message code="label.bilateral" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==2}">
														<td><spring:message code="label.focal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==3}">
														<td><spring:message code="label.hemispheric" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==4}">
														<td><spring:message code="label.lobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==5}">
														<td><spring:message code="label.multilobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==6}">
														<td><spring:message code="label.notDone" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==7}">
														<td><spring:message code="label.normal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.interictalSpect==8}">
														<td><spring:message code="label.postoperative" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message
														code="label.localizationSPECTHypoperfuse" /></td>
													<td>${diagnosticTestMRI.descriptionSpectHypoperfuse}</td>
												</tr>

												<tr class="info">
													<td>Iktální SPECT</td>
													<c:if test="${diagnosticTestMRI.ictalSpect==1}">
														<td><spring:message code="label.bilateral" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==2}">
														<td><spring:message code="label.focal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==3}">
														<td><spring:message code="label.hemispheric" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==4}">
														<td><spring:message code="label.lobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==5}">
														<td><spring:message code="label.multilobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==6}">
														<td><spring:message code="label.notDone" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==7}">
														<td><spring:message code="label.normal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.ictalSpect==8}">
														<td><spring:message code="label.postoperative" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message
														code="label.localizationSPECTHyperperfuse" /></td>
													<td>${diagnosticTestMRI.descriptionSpectHyperperfuse}</td>
												</tr>

												<tr class="info">
													<td>SISCOM</td>
													<c:if test="${diagnosticTestMRI.siscom==true}">
														<tda><spring:message
															code="label.yes" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.siscom==false}">
														<td><spring:message code="label.no" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td>MRS protokol</td>
													<c:if test="${diagnosticTestMRI.mrsProtocol==1}">
														<td>CSI</td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsProtocol==2}">
														<td>Single voxel</td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsProtocol==3}">
														<td>Single voxel + CSI</td>
													</c:if>		
												</tr>

												<tr class="info">
													<td><spring:message code="label.MRSFinding" /></td>
													<c:if test="${diagnosticTestMRI.mrsFinding==1}">
														<td><spring:message code="label.bilateral" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==2}">
														<td><spring:message code="label.focal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==3}">
														<td><spring:message code="label.hemispheric" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==4}">
														<td><spring:message code="label.lobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==5}">
														<td><spring:message code="label.multilobar" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==6}">
														<td><spring:message code="label.notDone" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==7}">
														<td><spring:message code="label.normal" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.mrsFinding==8}">
														<td><spring:message code="label.postoperative" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message
														code="label.localizationMRSAbnormality" /></td>
													<td>${diagnosticTestMRI.descriptionMrsAbnormality}</td>
												</tr>

												<tr class="info">
													<td>fMRI</td>
													<c:if test="${diagnosticTestMRI.fmri==true}">
														<td><spring:message
															code="label.yes" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.fmri==false}">
														<td><spring:message code="label.no" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message code="label.FMRIDetails" /></td>
													<td>${diagnosticTestMRI.detailsFmri}</td>
												</tr>

												<tr class="info">
													<td>DTI</td>
													<c:if test="${diagnosticTestMRI.dti==true}">
														<td><spring:message
															code="label.yes" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.dti==false}">
														<td><spring:message code="label.no" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message code="label.DTIStudyDetails" /></td>
													<td>${diagnosticTestMRI.detailsDtiStudie}</td>
												</tr>
												
												<tr class="info">
													<td>WADA</td>
													<c:if test="${diagnosticTestMRI.wada==true}">
														<td><spring:message
															code="label.yes" /></td>
													</c:if>
													<c:if test="${diagnosticTestMRI.wada==false}">
														<td><spring:message code="label.no" /></td>
													</c:if>
												</tr>

												<tr class="info">
													<td><spring:message code="label.WADADetails" /></td>
													<td>${diagnosticTestMRI.detailsWada}</td>
												</tr>

												<tr class="info">
													<td><spring:message code="label.comment" /></td>
													<c:choose>
														<c:when test="${empty diagnosticTestMRI.comment}">
															<td><spring:message code="label.noComments" /></td>
														</c:when>
														<c:otherwise>
															<td>${diagnosticTestMRI.comment}</td>
														</c:otherwise>
													</c:choose>
												</tr>
											</c:if>
					              		</tbody>
				            		</table>
			            		</div>
						    </div>
		            	</div>
		            </c:if>
	            </c:forEach>
	            <c:if test="${count==0}">
		            <div class="alert alert-block">
		  				<button type="button" class="close" data-dismiss="alert">&times;</button>
		  				<h4><spring:message code="label.noRecords"/></h4>
					</div>
		       	</c:if>
            </div>
	</jsp:body>
</t:menuLVL3>


