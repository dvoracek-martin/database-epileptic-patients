<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<table class="table">
    <c:set var="seizureDetailsCount" value="0" scope="page"/>
    <c:forEach items="${seizure.seizureDetailList}" var="seizureDetail">
        <c:set var="seizureDetailsCount" value="${seizureDetailsCount + 1}" scope="page"/>
        <tr>
            <th colspan="2" class="col-xs-12">
                    ${seizureDetailsCount}. typ záchvatu (
                <a href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/${seizureDetail.id}/edit"/>">
                    <spring:message code="label.edit"/>
                </a>
                |
                <a href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/${seizureDetail.id}/hide"/>">
                    <spring:message code="label.delete"/>
                </a>
                )
            </th>
        </tr>
        <tr>
            <th class="col-xs-3">
                Zadáno dne
            </th>
            <td class="col-xs-9">
                    ${seizureDetail.date}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.sscClassification"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.sscClassification.${seizureDetail.sscClassification}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.ilaeClassification"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.ilaeClassification.${seizureDetail.ilaeClassification}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3"><spring:message code="label.comment"/></th>
            <c:choose>
                <c:when test="${empty seizureDetail.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${seizureDetail.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>