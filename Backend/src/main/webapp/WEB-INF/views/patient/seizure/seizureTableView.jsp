<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-seizure-${seizureDisplayVo.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.seizureFrequency"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.seizureFrequency.${seizureDisplayVo.seizureFrequency}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.secondarilyGeneralizedSeizure"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayVo.secondarilyGeneralizedSeizure}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.statusEpilepticus"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayVo.statusEpilepticus}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.nonepilepticSeizures"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayVo.nonepilepticSeizures}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.occurrence"/>
            </th>
            <td>
                <spring:message code="label.seizureOccurence.${seizureDisplayVo.seizureOccurrence}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3"><spring:message code="label.comment"/></th>
            <c:choose>
                <c:when test="${empty seizureDisplayVo.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${seizureDisplayVo.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td colspan="2">
                <%@include file="detail/seizureDetailTableView.jsp" %>
            </td>
        </tr>
        </tbody>
    </table>
</div>