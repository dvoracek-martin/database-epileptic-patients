<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Diagnostické testy - MRI
    </jsp:attribute>
	<jsp:attribute name="header">
      Diagnostické testy - MRI
    </jsp:attribute>

	<jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2>Diagnostické testy - MRI</h2>
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
 
			<c:if test="${empty patient.diagnosticTestMRIList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>
					<spring:message code="label.noRecords" />!</h4>
				</div>
 			</c:if>

			<!-- Anamnesis list START -->
			<div class="accordion">
				<c:forEach items="${patient.diagnosticTestMRIList}"
				var="diagnosticTestMRI">
					<div>
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion" href="#collapse${diagnosticTestMRI.id}">
					    	    <strong><spring:message
									code="label.dateExamination" />:</strong> ${diagnosticTestMRI.date}
					    	</a>
						</div>

					    <div id="collapse${diagnosticTestMRI.id}"
						class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info"
								style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close"
										href="<c:url value="/patient/${patientID}/diagnosticTestMRI/${diagnosticTestMRI.id}/delete"/>"><spring:message
											code="label.delete" /></a>
									</div>
									<div class="pull-left">
										<a class="close"
										href="<c:url value="/patient/${patientID}/diagnosticTestMRI/list"/>"><spring:message
											code="label.edit" /></a>
									</div>								
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td><spring:message code="label.MRIProtocol" /></td>
											<c:if test="${diagnosticTestMRI.mriProtocolIdcom==1}">
												<td>EPI 2</td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriProtocolIdcom==2}">
												<td>Standard + 1.5 mm T1w</td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriProtocolIdcom==3}">
												<td>Standardní MRI protokol</td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.MRIFinding" /></td>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==1}">
												<td><spring:message code="label.bilateral" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==2}">
												<td><spring:message code="label.focal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==3}">
												<td><spring:message code="label.hemispheric" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==4}">
												<td><spring:message code="label.lobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==5}">
												<td><spring:message code="label.multilobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==6}">
												<td><spring:message code="label.notDone" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==7}">
												<td><spring:message code="label.normal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mriFindingIdcom==8}">
												<td><spring:message code="label.postoperative" /></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>FDG PET</td>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==1}">
												<td><spring:message code="label.bilateral" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==2}">
												<td><spring:message code="label.focal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==3}">
												<td><spring:message code="label.hemispheric" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==4}">
												<td><spring:message code="label.lobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==5}">
												<td><spring:message code="label.multilobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==6}">
												<td><spring:message code="label.notDone" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==7}">
												<td><spring:message code="label.normal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.fdgPetIdcom==8}">
												<td><spring:message code="label.postoperative" /></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.interictalSPECT" /></td>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==1}">
												<td><spring:message code="label.bilateral" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==2}">
												<td><spring:message code="label.focal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==3}">
												<td><spring:message code="label.hemispheric" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==4}">
												<td><spring:message code="label.lobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==5}">
												<td><spring:message code="label.multilobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==6}">
												<td><spring:message code="label.notDone" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==7}">
												<td><spring:message code="label.normal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.interictalSpectIdcom==8}">
												<td><spring:message code="label.postoperative" /></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>FDG PET</td>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==1}">
												<td><spring:message code="label.bilateral" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==2}">
												<td><spring:message code="label.focal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==3}">
												<td><spring:message code="label.hemispheric" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==4}">
												<td><spring:message code="label.lobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==5}">
												<td><spring:message code="label.multilobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==6}">
												<td><spring:message code="label.notDone" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==7}">
												<td><spring:message code="label.normal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.ictaliSpectIdcom==8}">
												<td><spring:message code="label.postoperative" /></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>SISCOM</td>
											<c:if test="${diagnosticTestMRI.siscom==true}">
												<td style="column-span: 2"><spring:message
													code="label.yes" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.siscom==false}">
												<td><spring:message code="label.no" /></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>MRS protokol</td>
											<c:if test="${diagnosticTestMRI.mrsProtocolIdcom==1}">
												<td>CSI</td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsProtocolIdcom==2}">
												<td>Single voxel</td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsProtocolIdcom==3}">
												<td>Single voxel + CSI</td>
											</c:if>		
										</tr>
										<tr class="info">
											<td><spring:message code="label.MRSFinding" /></td>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==1}">
												<td><spring:message code="label.bilateral" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==2}">
												<td><spring:message code="label.focal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==3}">
												<td><spring:message code="label.hemispheric" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==4}">
												<td><spring:message code="label.lobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==5}">
												<td><spring:message code="label.multilobar" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==6}">
												<td><spring:message code="label.notDone" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==7}">
												<td><spring:message code="label.normal" /></td>
											</c:if>
											<c:if test="${diagnosticTestMRI.mrsFinfingIdcom==8}">
												<td><spring:message code="label.postoperative" /></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>DTI</td>
											<c:if test="${diagnosticTestMRI.dti==true}">
												<td style="column-span: 2"><spring:message
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
											<td>fMRI</td>
											<c:if test="${diagnosticTestMRI.fmri==true}">
												<td style="column-span: 2"><spring:message
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
											<td>WADA</td>
											<c:if test="${diagnosticTestMRI.wada==true}">
												<td style="column-span: 2"><spring:message
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
											<td><spring:message code="label.descriptionMRI" /></td>
											<td>${diagnosticTestMRI.mriDescribe}</td>
										</tr>
										<tr class="info">
											<td><spring:message
												code="label.localizationSPECTHypoperfuse" /></td>
											<td>${diagnosticTestMRI.localizationSpectHypoperfuse}</td>
										</tr>
										<tr class="info">
											<td><spring:message
												code="label.localizationMRSAbnormality" /></td>
											<td>${diagnosticTestMRI.localizationMrsAbnormality}</td>
										</tr>
										<tr class="info">
											<td><spring:message
												code="label.localizationPetHypometabolism" /></td>
											<td>${diagnosticTestMRI.localizationPetHypometabolism}</td>
										</tr>
										<tr class="info">
											<td><spring:message
												code="label.localizationSPECTHyperperfuse" /></td>
											<td>${diagnosticTestMRI.localizationSpectHyperperfuse}</td>
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
				              		</tbody>
			            		</table>
		            		</div>
					    </div>
	            	</div>
	            </c:forEach>
            </div>
	</jsp:body>
</t:menuLVL3>


