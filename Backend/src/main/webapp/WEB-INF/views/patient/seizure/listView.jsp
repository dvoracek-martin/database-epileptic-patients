<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Záchvaty
    </jsp:attribute>
	<jsp:attribute name="header">
      Záchvaty
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Záchvaty</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/seizure/create"  />"><spring:message code="label.addRecord"/></a>
					</h3>
				</div>
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
 
			<!-- Seizure list START -->
			<div class="accordion">
				<c:forEach items="${patient.seizureList}" var="seizure">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${seizure.id}">
					    	    <strong>Vyšetření dne:</strong> ${seizure.date}
					    	</a>
						</div>

					    <div id="collapse${seizure.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<a class="close" href="<c:url value="/patient/${patientID}/seizure/${seizure.id}/delete"/>">×</a>
								<table class="table">
		               		<tbody>
								<tr class="info">
									<td>Četnost záchvatů</td>
									<c:if test="${seizure.seizureFrequencyIdcom==1}">
										<td>Denně</td>
									</c:if>
									<c:if test="${seizure.seizureFrequencyIdcom==2}">
										<td>Týdně</td>
									</c:if>
									<c:if test="${seizure.seizureFrequencyIdcom==3}">
										<td>Méně než měsíčně</td>
									</c:if>
									<c:if test="${seizure.seizureFrequencyIdcom==4}">
										<td>Měsíčně</td>
									</c:if>
								</tr>
								
								<tr class="info">
									<td>Status epilepticus</td>
									<c:if test="${seizure.statusEpilepticus==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${seizure.statusEpilepticus==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>SSC klasifikace</td>
									<c:if test="${seizure.sscClassificationIdcom==1}">
										<td>1. Epileptický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==2}">
										<td>2. Aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==3}">
										<td>2.a. Somastosenzorická aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==4}">
										<td>2.b. Zraková aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==5}">
										<td>2.c. Sluchová aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==6}">
										<td>2.d. Čichová aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==7}">
										<td>2.e. Chuťová aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==8}">
										<td>2.f. Autonomní aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==9}">
										<td>2.g. Epigastrická aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==10}">
										<td>2.h. Psychická aura</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==11}">
										<td>3. Absence</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==12}">
										<td>4. Autonomní záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==13}">
										<td>5. Psychomotorický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==14}">
										<td>6. Motorický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==15}">
										<td>6.a. Klonický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==16}">
										<td>6.b. Tonický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==17}">
										<td>6.c. Tonicko-klonický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==18}">
										<td>6.d. Atonický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==19}">
										<td>6.e. Akinetický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==20}">
										<td>6.f. Versivní záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==21}">
										<td>6.g. Myoklonický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==22}">
										<td>6.h. Hypermotorický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==23}">
										<td>6.i. Hypomotorický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==24}">
										<td>6.j. Negativní myoklonický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==25}">
										<td>6.k. Astatický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==26}">
										<td>6.l. Akinetický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==27}">
										<td>6.m. Afázický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==28}">
										<td>6.n. Gelastický záchvat</td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==29}">
										<td>7. Paroxysmální příhoda</td>
									</c:if>
								</tr>
								<tr class="info">
									<td>ILAE klasifikace</td>
									<c:if test="${seizure.ilaeClassificationIdcom==1}">
										<td>I.A.1. Jednoduchý parciální záchvat s motorickými symptomy</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==2}">
										<td>I.A.2. Jednoduchý parciální záchvat s psychickými symptomy</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==3}">
										<td>I.A.3. Jednoduchý parciální záchvat s autonomními symptomy</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==4}">
										<td>I.A.4. Jednoduchý parciální záchvat se somatosenzorickými symptomy</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==5}">
										<td>I.B.1. Komplexní parciální záchvat s jednoduchým parciálním záchvatem na počátku,  následovaným poruc</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==6}">
										<td>I.B.2. Komplexní parciální záchvat s poruchou vědomí na počátku</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==7}">
										<td>I.C. Parciální záchvat sekundárně se rozvíjející v generalizovaný</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==8}">
										<td>II.A.1. Generalizovaný - Typická absence</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==9}">
										<td>II.A.2. Generalizovaný - Atypická absence</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==10}">
										<td>II.B. Generalizovaný - Myoklonický</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==11}">
										<td>II.C. Generalizovaný - Klonický</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==12}">
										<td>II.D. Generalizovaný - Tonický</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==13}">
										<td>II.E. Generalizovaný - Tonicko-klonický</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==14}">
										<td>II.F. Generalizovaný - Atonický</td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==15}">
										<td>III. Neklasifikovaný</td>
									</c:if>
								</tr>

								<tr class="info">
									<td><spring:message code="label.comment" /></td>
									<c:choose>
										<c:when test="${empty seizure.comment}">
											<td>Žádný</td>
										</c:when>
										<c:otherwise>
											<td>${seizure.comment}</td>
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
		<!-- Seizure list END -->
	</jsp:body>
</t:menuLVL3>


