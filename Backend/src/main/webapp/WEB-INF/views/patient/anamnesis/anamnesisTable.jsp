<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${anamnesis.id}" class="panel-collapse collapse <c:if test="${count == 1}">in</c:if> ">
    <div class="panel-body">
        <table class="table">
            <tbody>
            <tr>
                <td><spring:message code="label.epilepsyInFamily"/></td>
                <c:if test="${anamnesis.epilepsyInFamily==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.epilepsyInFamily==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.prenatalRisk"/></td>
                <c:if test="${anamnesis.prenatalRisk==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.prenatalRisk==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.fibrilConvulsions"/></td>
                <c:if test="${anamnesis.fibrilConvulsions==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.fibrilConvulsions==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.inflammationCNS"/></td>
                <c:if test="${anamnesis.inflammationCns==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.inflammationCns==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.injuryCNS"/></td>
                <c:if test="${anamnesis.injuryCns==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.injuryCns==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.operationCNS"/></td>
                <c:if test="${anamnesis.operationCns==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.operationCns==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.earlyPMDRetardation"/></td>
                <c:if test="${anamnesis.earlyPmdRetardation==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.earlyPmdRetardation==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.beginningEpilepsy"/></td>
                <td>${anamnesis.beginningEpilepsy}</td>
            </tr>
            <tr>
                <td><spring:message code="label.firstFever"/></td>
                <c:if test="${anamnesis.firstFever==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.firstFever==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.infantileSpasm"/></td>
                <c:if test="${anamnesis.infantileSpasm==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.infantileSpasm==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.epilepticSyndrome"/></td>
                <c:if test="${anamnesis.specificSyndrome==0}">
                    <td>-</td>
                </c:if>
                <c:if test="${anamnesis.specificSyndrome==1}">
                    <td><spring:message
                            code="label.extratemporalFocalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==2}">
                    <td><spring:message
                            code="label.hemisphericSymptomaticEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==3}">
                    <td><spring:message code="label.mesiotemporalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==4}">
                    <td><spring:message code="label.multifocalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==5}">
                    <td><spring:message code="label.temporalEpilepsy"/></td>
                </c:if>
            </tr>
            <tr>
                <td><spring:message code="label.nonCNSComorbidity"/></td>
                <td>${anamnesis.nonCnsComorbidity}</td>
            </tr>

            <tr>
                <td><spring:message code="label.comment"/></td>
                <c:choose>
                    <c:when test="${empty anamnesis.comment}">
                        <td><spring:message code="label.noComments"/></td>
                    </c:when>
                    <c:otherwise>
                        <td>${anamnesis.comment}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
            </tbody>
        </table>
    </div>
</div>