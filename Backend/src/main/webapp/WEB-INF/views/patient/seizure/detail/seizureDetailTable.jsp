<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>
 
 <table>
 <c:set var="seizureDetailsCount" value="0" scope="page" />
            <c:forEach items="${seizure.seizureDetailList}" var="seizureDetail">
                <c:if test="${seizureDetail.status==0}">
                    <c:set var="seizureDetailsCount" value="${seizureDetailsCount + 1}" scope="page"/>

                    <tr>
                        <td>${seizureDetailsCount}. typ záchvatu</td>
                        <td>(<a href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/${seizureDetail.id}/edit"/>"><spring:message code="label.edit"/></a>|<a href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/${seizureDetail.id}/hide"/>"><spring:message code="label.delete"/></a>)</td>
                        <td></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>Zadáno dne</td>
                        <td>${seizureDetail.date}</td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><spring:message code="label.SSCClassification"/></td>
                        <c:if test="${seizureDetail.sscClassification==1}">
                            <td><spring:message code="label.epilepticSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==2}">
                            <td><spring:message code="label.aura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==3}">
                            <td><spring:message code="label.somatosenzoryAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==4}">
                            <td><spring:message code="label.visualAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==5}">
                            <td><spring:message code="label.auditoryAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==6}">
                            <td><spring:message code="label.olfactoryAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==7}">
                            <td><spring:message code="label.gustatoryAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==8}">
                            <td><spring:message code="label.autonomicAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==9}">
                            <td><spring:message code="label.epigastricAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==10}">
                            <td><spring:message code="label.psychicAura"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==11}">
                            <td><spring:message code="label.absence"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==12}">
                            <td><spring:message code="label.autonomicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==13}">
                            <td><spring:message code="label.psychomotorSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==14}">
                            <td><spring:message code="label.motorSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==15}">
                            <td><spring:message code="label.clonicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==16}">
                            <td><spring:message code="label.tonicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==17}">
                            <td><spring:message code="label.tonicClonicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==18}">
                            <td><spring:message code="label.atonicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==19}">
                            <td><spring:message code="label.akineticSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==20}">
                            <td><spring:message code="label.versiveSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==21}">
                            <td><spring:message code="label.myoclonicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==22}">
                            <td><spring:message code="label.hypermotorSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==23}">
                            <td><spring:message code="label.hypomotorSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==24}">
                            <td><spring:message code="label.negativeMyoclonicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==25}">
                            <td><spring:message code="label.askatikSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==26}">
                            <td><spring:message code="label.akineticSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==27}">
                            <td><spring:message code="label.aphasicSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==28}">
                            <td><spring:message code="label.gelasticSeizure"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.sscClassification==29}">
                            <td><spring:message code="label.paroxymalEvent"/></td>
                        </c:if>
                    </tr>

                    <tr>
                        <td></td>
                        <td><spring:message code="label.ILAEClassification"/></td>
                        <c:if test="${seizureDetail.ilaeClassification==1}">
                            <td><spring:message code="label.simplePartialMotor"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==2}">
                            <td><spring:message code="label.simplePartialPsychic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==3}">
                            <td><spring:message code="label.simplePartialAutonomic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==4}">
                            <td><spring:message code="label.simplePartialSomatosensory"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==5}">
                            <td><spring:message code="label.simplePartialSimple"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==6}">
                            <td><spring:message code="label.simplePartialImpairment"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==7}">
                            <td><spring:message code="label.simplePartialEvolving"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==8}">
                            <td><spring:message code="label.generalizedTypical"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==9}">
                            <td><spring:message code="label.generalizedAtypical"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==10}">
                            <td><spring:message code="label.generalizedMyoclonic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==11}">
                            <td><spring:message code="label.generalizedClonic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==12}">
                            <td><spring:message code="label.generalizedTonic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==13}">
                            <td><spring:message code="label.generalizedTonicClonic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==14}">
                            <td><spring:message code="label.generalizedAtonic"/></td>
                        </c:if>
                        <c:if test="${seizureDetail.ilaeClassification==15}">
                            <td><spring:message code="label.unclassified"/></td>
                        </c:if>
                    </tr>
                </c:if>
            </c:forEach>
            
            </table>