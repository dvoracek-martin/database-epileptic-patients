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
                <th class="col-xs-3"><spring:message code="label.epilepsyInFamily"/></th>
                <c:if test="${anamnesis.epilepsyInFamily==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.epilepsyInFamily==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.prenatalRisk"/></th>
                <c:if test="${anamnesis.prenatalRisk==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.prenatalRisk==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.fibrilConvulsions"/></th>
                <c:if test="${anamnesis.fibrilConvulsions==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.fibrilConvulsions==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.inflammationCNS"/></th>
                <c:if test="${anamnesis.inflammationCns==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.inflammationCns==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.injuryCNS"/></th>
                <c:if test="${anamnesis.injuryCns==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.injuryCns==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.operationCNS"/></th>
                <c:if test="${anamnesis.operationCns==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.operationCns==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.earlyPMDRetardation"/></th>
                <c:if test="${anamnesis.earlyPmdRetardation==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.earlyPmdRetardation==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th><spring:message code="label.beginningEpilepsy"/></th>
                <td>${anamnesis.beginningEpilepsy}</td>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.firstFever"/></th>
                <c:if test="${anamnesis.firstFever==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.firstFever==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.infantileSpasm"/></th>
                <c:if test="${anamnesis.infantileSpasm==true}">
                    <td class="col-xs-9"><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${anamnesis.infantileSpasm==false}">
                    <td class="col-xs-9"><spring:message code="label.no"/></td>
                </c:if>
            </tr>
            <tr>
                <th class="col-xs-3"><spring:message code="label.epilepticSyndrome"/></th>
                <c:if test="${anamnesis.specificSyndrome==0}">
                    <td>-</td>
                </c:if>
                <c:if test="${anamnesis.specificSyndrome==1}">
                    <td class="col-xs-9"><spring:message
                            code="label.mesiotemporalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==2}">
                    <td class="col-xs-9"><spring:message
                            code="label.extratemporalFocalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==3}">
                    <td class="col-xs-9"><spring:message code="label.temporalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==4}">
                    <td class="col-xs-9"><spring:message code="label.hemisphericSymptomaticEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==5}">
                    <td class="col-xs-9"><spring:message code="label.multifocalEpilepsy"/></td>
                </c:if>

                <c:if test="${anamnesis.specificSyndrome==6}">
                    <td class="col-xs-9"><spring:message code="label.temporalEpilepsy"/>other</td>
                </c:if>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.nonCNSComorbidity"/></th>

                <c:choose>
                    <c:when test="${empty anamnesis.nonCnsComorbidity}">
                        <td>-</td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">${anamnesis.nonCnsComorbidity}</td>
                    </c:otherwise>
                </c:choose>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.comment"/></th>
                <c:choose>
                    <c:when test="${empty anamnesis.comment}">
                        <td class="col-xs-9"><spring:message code="label.noComments"/></td>
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