<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="operationWithOutcomesDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationWithOutcomesDisplayVO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
               var="isAuthorized"/>

<div id="collapse-outcome-${operationWithOutcomesDisplayVo.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">

<%-- getting outcomes --%>
<c:set var="outcome6" value=""/>
<c:set var="outcome12" value=""/>
<c:set var="outcome24" value=""/>
<c:set var="outcome60" value=""/>
<c:set var="outcome120" value=""/>

<c:forEach items="${operationWithOutcomesDisplayVo.outcomeList}"
           var="outcomeDisplayVo">
    <c:choose>
        <c:when test="${outcomeDisplayVo.distance==6}">
            <c:set var="outcome6"
                   value="${outcomeDisplayVo}"/>
        </c:when>
        <c:when test="${outcomeDisplayVo.distance==12}">
            <c:set var="outcome12"
                   value="${outcomeDisplayVo}"/>
        </c:when>
        <c:when test="${outcome.distance==24}">
            <c:set var="outcome24"
                   value="${outcomeDisplayVo}"/>
        </c:when>
        <c:when test="${outcomeDisplayVo.distance==60}">
            <c:set var="outcome60"
                   value="${outcomeDisplayVo}"/>
        </c:when>
        <c:when test="${outcomeDisplayVo.distance==120}">
            <c:set var="outcome120"
                   value="${outcomeDisplayVo}"/>
        </c:when>
    </c:choose>
</c:forEach>

<table class="table">
<thead>
<tr>
    <td></td>
    <td><b><spring:message code="label.seizureOutcome"/></b></td>
    <td><b><spring:message code="label.outcomeAed"/></b></td>
    <td><b><spring:message code="label.eeg"/></b></td>
    <td><b><spring:message code="label.mri"/></b></td>
    <td><b><spring:message code="label.neuropsychology"/></b></td>
    <td></td>
</tr>
</thead>
<tbody>
<tr>
    <td rowspan="2"><b><spring:message code="label.distance.6"/></b></td>
    <c:choose>
        <c:when test="${!empty(outcome6)}">
            <td><spring:message code="label.seizureOutcome.${outcome6.seizureOutcome}"/></td>
            <td><spring:message code="label.outcomeAed.${outcome6.aed}"/></td>
            <td><spring:message code="label.outcomeEeg.${outcome6.eeg}"/></td>
            <td><spring:message code="label.done.${outcome6.mri}"/></td>
            <td><spring:message code="label.done.${outcome6.neuropsychology}"/></td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/${outcome6.id}/edit?distance=6&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.editRecord"/>
                    </a>
                </c:if>
            </td>
        </c:when>
        <c:otherwise>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/create?distance=6&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.addRecord"/>
                    </a>
                </c:if>
            </td>

        </c:otherwise>
    </c:choose>
</tr>
<tr>
    <td colspan="6">
        <spring:message code="label.comment"/>:
        <c:choose>
            <c:when test="${!empty(outcome6)}">
                ${outcome6.comment}
            </c:when>
            <c:otherwise>
                -
            </c:otherwise>
        </c:choose>
    </td>
</tr>

<tr>
    <td rowspan="2"><b><spring:message code="label.distance.12"/></b></td>

    <c:choose>
        <c:when test="${!empty(outcome12)}">
            <td><spring:message code="label.seizureOutcome.${outcome12.seizureOutcome}"/></td>
            <td><spring:message code="label.outcomeAed.${outcome12.aed}"/></td>
            <td><spring:message code="label.outcomeEeg.${outcome12.eeg}"/></td>
            <td><spring:message code="label.done.${outcome12.mri}"/></td>
            <td><spring:message code="label.done.${outcome12.neuropsychology}"/></td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/${outcome12.id}/edit?distance=12&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.editRecord"/>
                    </a>
                </c:if>
            </td>
        </c:when>
        <c:otherwise>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/create?distance=12&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.addRecord"/>
                    </a>
                </c:if>
            </td>
        </c:otherwise>
    </c:choose>

</tr>
<tr>
    <td colspan="6">
        <spring:message code="label.comment"/>:
        <c:choose>
            <c:when test="${!empty(outcome12)}">
                ${outcome12.comment}
            </c:when>
            <c:otherwise>
                -
            </c:otherwise>
        </c:choose>
    </td>
</tr>

<tr>
    <td rowspan="2"><b><spring:message code="label.distance.24"/></b></td>

    <c:choose>
        <c:when test="${!empty(outcome24)}">
            <td><spring:message code="label.seizureOutcome.${outcome24.seizureOutcome}"/></td>
            <td><spring:message code="label.outcomeAed.${outcome24.aed}"/></td>
            <td><spring:message code="label.outcomeEeg.${outcome24.eeg}"/></td>
            <td><spring:message code="label.done.${outcome24.mri}"/></td>
            <td><spring:message code="label.done.${outcome24.neuropsychology}"/></td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/${outcome24.id}/edit?distance=24&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.editRecord"/>
                    </a>
                </c:if>
            </td>
        </c:when>
        <c:otherwise>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/create?distance=24&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.addRecord"/>
                    </a>
                </c:if>
            </td>
        </c:otherwise>
    </c:choose>

</tr>
<tr>
    <td colspan="6">
        <spring:message code="label.comment"/>:
        <c:choose>
            <c:when test="${!empty(outcome24)}">
                ${outcome24.comment}
            </c:when>
            <c:otherwise>
                -
            </c:otherwise>
        </c:choose>
    </td>
</tr>

<tr>
    <td rowspan="2"><b><spring:message code="label.distance.60"/></b></td>

    <c:choose>
        <c:when test="${!empty(outcome60)}">
            <td><spring:message code="label.seizureOutcome.${outcome60.seizureOutcome}"/></td>
            <td><spring:message code="label.outcomeAed.${outcome60.aed}"/></td>
            <td><spring:message code="label.outcomeEeg.${outcome60.eeg}"/></td>
            <td><spring:message code="label.done.${outcome60.mri}"/></td>
            <td><spring:message code="label.done.${outcome60.neuropsychology}"/></td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/${outcome60.id}/edit?distance=60&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.editRecord"/>
                    </a>
                </c:if>
            </td>
        </c:when>
        <c:otherwise>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/create?distance=60&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.addRecord"/>
                    </a>
                </c:if>
            </td>
        </c:otherwise>
    </c:choose>

</tr>
<tr>
    <td colspan="6">
        <spring:message code="label.comment"/>:
        <c:choose>
            <c:when test="${!empty(outcome60)}">
                ${outcome60.comment}
            </c:when>
            <c:otherwise>
                -
            </c:otherwise>
        </c:choose>
    </td>
</tr>

<tr>
    <td rowspan="2"><b><spring:message code="label.distance.120"/></b></td>

    <c:choose>
        <c:when test="${!empty(outcome120)}">
            <td><spring:message code="label.seizureOutcome.${outcome120.seizureOutcome}"/></td>
            <td><spring:message code="label.outcomeAed.${outcome120.aed}"/></td>
            <td><spring:message code="label.outcomeEeg.${outcome120.eeg}"/></td>
            <td><spring:message code="label.done.${outcome120.mri}"/></td>
            <td><spring:message code="label.done.${outcome120.neuropsychology}"/></td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/${outcome120.id}/edit?distance=120&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.editRecord"/>
                    </a>
                </c:if>
            </td>
        </c:when>
        <c:otherwise>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>
                <c:if test="${isAuthorized}">
                    <a href="<c:url value="/patient/${patient.id}/outcome/create?distance=120&operation=${operationWithOutcomesDisplayVo.id}" />">
                        <spring:message code="label.addRecord"/>
                    </a>
                </c:if>
            </td>
        </c:otherwise>
    </c:choose>

</tr>
<tr>
    <td colspan="6">
        <spring:message code="label.comment"/>:
        <c:choose>
            <c:when test="${!empty(outcome120)}">
                ${outcome120.comment}
            </c:when>
            <c:otherwise>
                -
            </c:otherwise>
        </c:choose>
    </td>
</tr>

</tbody>
</table>
</div>