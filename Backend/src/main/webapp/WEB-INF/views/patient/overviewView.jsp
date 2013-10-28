<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Pacient
    </jsp:attribute>
	<jsp:attribute name="header">
      Pacient
    </jsp:attribute>

	<jsp:body>
				<div>
					<div class="span5">
						<h2>Přehled pacienta</h2>
					</div>
					<div>
						<h3 class="pull-right">
							<a id="export"
						href="<c:url value="/patient/${patient.id}/export" />">Export
								pacienta</a>
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

				<!-- print out latest anamnesis START -->
				<div>
					<div class="span4">
						<h3>Anamnéza</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/anamnesis/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>
				</br>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		               			<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}</td>
								</tr>
									<tr class="info">
											<td><spring:message code="label.epilepsyInFamily" /></td>
											<c:if test="${patient.anamnesisList[0].epilepsyInFamily==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].epilepsyInFamily==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.prenatalRisk" /></td>
											<c:if test="${patient.anamnesisList[0].prenatalRisk==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].prenatalRisk==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.fibrilConvulsions" /></td>
											<c:if test="${patient.anamnesisList[0].fibrilConvulsions==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].fibrilConvulsions==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.inflammationCNS" /></td>
											<c:if test="${patient.anamnesisList[0].inflammationCns==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].inflammationCns==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.injuryCNS" /></td>
											<c:if test="${patient.anamnesisList[0].injuryCns==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].injuryCns==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.operationCNS" /></td>
											<c:if test="${patient.anamnesisList[0].operationCns==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].operationCns==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.earlyPMDRetardation" /></td>
											<c:if test="${patient.anamnesisList[0].earlyPmdRetardation==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].earlyPmdRetardation==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.beginningEpilepsy" /></td>
											<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
										</tr>
										<tr class="info">
											<td><spring:message code="label.firstFever" /></td>
											<c:if test="${patient.anamnesisList[0].firstFever==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].firstFever==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.infantileSpasm" /></td>
											<c:if test="${patient.anamnesisList[0].infantileSpasm==true}">
												<td><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${patient.anamnesisList[0].infantileSpasm==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.epilepticSyndrome" /></td>
											<c:if test="${patient.anamnesisList[0].specificSyndromeIdcom==1}">
												<td>Extratemporální fokální epilepsie</td>
											</c:if>

											<c:if test="${patient.anamnesisList[0].specificSyndromeIdcom==2}">
												<td>Hemisferální symtomaptická epilepsie</td>
											</c:if>

											<c:if test="${patient.anamnesisList[0].specificSyndromeIdcom==3}">
												<td>Meziotemporální epilepsie (MTLE)</td>
											</c:if>

											<c:if test="${patient.anamnesisList[0].specificSyndromeIdcom==4}">
												<td>Multifokální epilepsie</td>
											</c:if>

											<c:if test="${patient.anamnesisList[0].specificSyndromeIdcom==5}">
												<td>Temporální epilepsie jiná než MTLE</td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.nonCNSComorbidity" /></td>
											<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty patient.anamnesisList[0].comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${patient.anamnesisList[0].comment}</td>
												</c:otherwise>
											</c:choose>
										</tr>		               			
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/anamnesis/list" />">Zobrazit vsechny</a>	
						</br>
						</br>
            		</c:otherwise>
				</c:choose>

            	<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Záchvaty</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/seizure/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>
				<c:choose>
				    <c:when test="${empty patient.seizureList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		               			<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.seizureList[0].date}</td>
								</tr>
								<tr class="info">
									<td>Četnost záchvatů</td>
									<c:if test="${patient.seizureList[0].seizureFrequencyIdcom==1}">
										<td>Denně</td>
									</c:if>
									<c:if test="${patient.seizureList[0].seizureFrequencyIdcom==2}">
										<td>Týdně</td>
									</c:if>
									<c:if test="${patient.seizureList[0].seizureFrequencyIdcom==3}">
										<td>Méně než měsíčně</td>
									</c:if>
									<c:if test="${patient.seizureList[0].seizureFrequencyIdcom==4}">
										<td>Měsíčně</td>
									</c:if>
								</tr>
								
								<tr class="info">
									<td>Status epilepticus</td>
									<c:if test="${patient.seizureList[0].statusEpilepticus==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.seizureList[0].statusEpilepticus==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>SSC klasifikace</td>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==1}">
										<td>1. Epileptický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==2}">
										<td>2. Aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==3}">
										<td>2.a. Somastosenzorická aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==4}">
										<td>2.b. Zraková aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==5}">
										<td>2.c. Sluchová aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==6}">
										<td>2.d. Čichová aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==7}">
										<td>2.e. Chuťová aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==8}">
										<td>2.f. Autonomní aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==9}">
										<td>2.g. Epigastrická aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==10}">
										<td>2.h. Psychická aura</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==11}">
										<td>3. Absence</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==12}">
										<td>4. Autonomní záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==13}">
										<td>5. Psychomotorický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==14}">
										<td>6. Motorický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==15}">
										<td>6.a. Klonický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==16}">
										<td>6.b. Tonický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==17}">
										<td>6.c. Tonicko-klonický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==18}">
										<td>6.d. Atonický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==19}">
										<td>6.e. Akinetický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==20}">
										<td>6.f. Versivní záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==21}">
										<td>6.g. Myoklonický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==22}">
										<td>6.h. Hypermotorický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==23}">
										<td>6.i. Hypomotorický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==24}">
										<td>6.j. Negativní myoklonický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==25}">
										<td>6.k. Astatický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==26}">
										<td>6.l. Akinetický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==27}">
										<td>6.m. Afázický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==28}">
										<td>6.n. Gelastický záchvat</td>
									</c:if>
									<c:if test="${patient.seizureList[0].sscClassificationIdcom==29}">
										<td>7. Paroxysmální příhoda</td>
									</c:if>
								</tr>
								<tr class="info">
									<td>ILAE klasifikace</td>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==1}">
										<td>I.A.1. Jednoduchý parciální záchvat s motorickými symptomy</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==2}">
										<td>I.A.2. Jednoduchý parciální záchvat s psychickými symptomy</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==3}">
										<td>I.A.3. Jednoduchý parciální záchvat s autonomními symptomy</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==4}">
										<td>I.A.4. Jednoduchý parciální záchvat se somatosenzorickými symptomy</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==5}">
										<td>I.B.1. Komplexní parciální záchvat s jednoduchým parciálním záchvatem na počátku,  následovaným poruc</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==6}">
										<td>I.B.2. Komplexní parciální záchvat s poruchou vědomí na počátku</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==7}">
										<td>I.C. Parciální záchvat sekundárně se rozvíjející v generalizovaný</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==8}">
										<td>II.A.1. Generalizovaný - Typická absence</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==9}">
										<td>II.A.2. Generalizovaný - Atypická absence</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==10}">
										<td>II.B. Generalizovaný - Myoklonický</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==11}">
										<td>II.C. Generalizovaný - Klonický</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==12}">
										<td>II.D. Generalizovaný - Tonický</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==13}">
										<td>II.E. Generalizovaný - Tonicko-klonický</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==14}">
										<td>II.F. Generalizovaný - Atonický</td>
									</c:if>
									<c:if test="${patient.seizureList[0].ilaeClassificationIdcom==15}">
										<td>III. Neklasifikovaný</td>
									</c:if>
								</tr>
								<tr class="info">
									<td><spring:message code="label.comment" /></td>
									<c:choose>
										<c:when test="${empty patient.seizureList[0].comment}">
											<td>Žádný</td>
										</c:when>
										<c:otherwise>
											<td>${patient.seizureList[0].comment}</td>
										</c:otherwise>
									</c:choose>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/seizure/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Farmakoterapie</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/pharmacotherapy/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>
				<c:choose>
				    <c:when test="${empty patient.pharmacotherapyList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		               			<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.pharmacotherapyList[0].date}</td>
								</tr>
								<tr class="info">
									<td>Léčivo</td>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==1}">
										<td>ACTH</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==2}">
										<td>CBZ</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==3}">
										<td>CLB</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==4}">
										<td>CZP</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==5}">
										<td>DZP</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==6}">
										<td>ESL</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==7}">
										<td>ETS</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==8}">
										<td>FBM</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==9}">
										<td>GBP</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==10}">
										<td>LCM</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==11}">
										<td>LEV</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==12}">
										<td>LTG</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==13}">
										<td>OXC</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==14}">
										<td>PB</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==15}">
										<td>PGB</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==16}">
										<td>PHT</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==17}">
										<td>PRM</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==18}">
										<td>RFM</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==19}">
										<td>STM</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==20}">
										<td>TGB</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==21}">
										<td>TPM</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==22}">
										<td>VGB</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==23}">
										<td>VPA</td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].aedIdcom==24}">
										<td>ZNS</td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Efektivita</td>
									<c:if test="${patient.pharmacotherapyList[0].effective==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].effective==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Při operaci</td>
									<c:if test="${patient.pharmacotherapyList[0].duringSurgery==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.pharmacotherapyList[0].duringSurgery==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td><spring:message code="label.comment" /></td>
									<c:choose>
										<c:when test="${empty patient.pharmacotherapyList[0].comment}">
											<td>Žádný</td>
										</c:when>
										<c:otherwise>
											<td>${patient.pharmacotherapyList[0].comment}</td>
										</c:otherwise>
									</c:choose>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">Zobrazit vsechny</a>
	            		</br>
	            		</br>	
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Neurologické nálezy</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/neurologicalFinding/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>
				
				<c:choose>
				    <c:when test="${empty patient.neurologicalFindingList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		               			<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.neurologicalFindingList[0].date}</td>
								</tr>
		                		
								<tr class="info">
									<td>Dominance hemisféry</td>
									<c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==1}">
										<td>Ambidexter</td>
									</c:if>
									<c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==2}">
										<td>Levák</td>
									</c:if>
									<c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==3}">
										<td>Nespecifikováno</td>
									</c:if>
									<c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==4}">
										<td>Pravák</td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Abnormální neurologický nález</td>
									<c:if test="${patient.neurologicalFindingList[0].abnormalNeurologicalFinding==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neurologicalFindingList[0].abnormalNeurologicalFinding==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Hemiparéza</td>
									<c:if test="${patient.neurologicalFindingList[0].hemiparesis==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neurologicalFindingList[0].hemiparesis==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Defekt zorného pole</td>
									<c:if test="${patient.neurologicalFindingList[0].visualCut==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neurologicalFindingList[0].visualCut==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td><spring:message code="label.comment" /></td>
									<c:choose>
										<c:when test="${empty patient.neurologicalFindingList[0].comment}">
											<td>Žádný</td>
										</c:when>
										<c:otherwise>
											<td>${patient.neurologicalFindingList[0].comment}</td>
										</c:otherwise>
									</c:choose>
								</tr>
								
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/neurologicalFinding/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Neuropsychologie</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/neuropsychology/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.neuropsychologyList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		               			<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.neuropsychologyList[0].date}</td>
								</tr>

								<tr class="info">
									<td>Neuropsychologické vyšetření</td>
									<c:if test="${patient.neuropsychologyList[0].neuropsychologicalExamination==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].neuropsychologicalExamination==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Věk při neuropsychologickém vyšetření</td>
									<td><strong>N/A</strong></td>
								</tr>
								<tr class="info">
									<td>Inteligenční úroveň</td>
									<c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==1}">
										<td>Mírná mentální retardace</td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==2}">
										<td>Naprůměrná inteligence</td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==3}">
										<td>Podprůměrná inteligence</td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==4}">
										<td>Průměrná inteligence</td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==5}">
										<td>Středně těžká mentální retardace</td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==6}">
										<td>Těžká mentální retardace</td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Specifická porucha učení</td>
									<c:if test="${patient.neuropsychologyList[0].specificLearning==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].specificLearning==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>Vývojová porucha řeči</td>
									<c:if test="${patient.neuropsychologyList[0].developmentalLanguageDisorders==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].developmentalLanguageDisorders==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td>ADHD syndrom</td>
									<c:if test="${patient.neuropsychologyList[0].adhdSyndrome==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${patient.neuropsychologyList[0].adhdSyndrome==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td><spring:message code="label.comment" /></td>
									<c:choose>
										<c:when test="${empty patient.neuropsychologyList[0].comment}">
											<td>Žádný</td>
										</c:when>
										<c:otherwise>
											<td>${patient.neuropsychologyList[0].comment}</td>
										</c:otherwise>
									</c:choose>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Diagnostické testy - EEG</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/diagnosticTestEEG/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.diagnosticTestEEGList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		               			<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.diagnosticTestEEGList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/diagnosticTestEEG/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Diagnostické testy - MRI</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/diagnosticTestMRI/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.diagnosticTestMRIList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.diagnosticTestMRIList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/diagnosticTestMRI/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Invazivní testy - EEG</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.invasiveTestEEGList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.invasiveTestEEGList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/list" />">Zobrazit vsechny</a>
	            		</br>
	            		</br>	
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Invazivní testy - ECoG</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/invasiveTestECOG/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.invasiveTestECOGList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.invasiveTestECOGList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/invasiveTestECOG/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Operace</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/operation/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.operationList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.operationList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/operation/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Histologie</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/histology/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.histologyList}">
				    	</br></br>
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.histologyList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/histology/list" />">Zobrazit vsechny</a>	
	            		</br>
	            		</br>
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<div>
					<div class="span4">
						<h3>Outcome</h3>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patient/${patient.id}/outcome/create" />"><spring:message code="label.addRecord"/></a>
						</h3>
					</div>
				</div>

				<c:choose>
				    <c:when test="${empty patient.outcomeList}">
						</br></br>
				     	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr class="alert-info">
             					 		<td colspan="2"><strong>Vyšetření dne:</strong> ${patient.outcomeList[0].date}</td>
								</tr>

								<tr class="info">
									<td><spring:message code="label.epilepsyInFamily" /></td>
									<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.prenatalRisk" /></td>
									<td>${patient.anamnesisList[0].prenatalRisk}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.fibrilConvulsions" /></td>
									<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.inflammationCNS" /></td>
									<td>${patient.anamnesisList[0].inflammationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.injuryCNS" /></td>
									<td>${patient.anamnesisList[0].injuryCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.operationCNS" /></td>
									<td>${patient.anamnesisList[0].operationCns}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.earlyPMDRetardation" /></td>
									<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.beginningEpilepsy" /></td>
									<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.firstFever" /></td>
									<td>${patient.anamnesisList[0].firstFever}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.infantileSpasm" /></td>
									<td>${patient.anamnesisList[0].infantileSpasm}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.epilepticSyndrome" /></td>
									<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
								</tr>
								<tr class="info">
									<td><spring:message code="label.nonCNSComorbidity" /></td>
									<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
								</tr>
		              		</tbody>
	            		</table>
	            		<a href="<c:url value="/patient/${patient.id}/outcome/list" />">Zobrazit všechny</a>	
	            		</br>
						</br>
            		</c:otherwise>
				</c:choose>
	</jsp:body>
</t:menuLVL3>

