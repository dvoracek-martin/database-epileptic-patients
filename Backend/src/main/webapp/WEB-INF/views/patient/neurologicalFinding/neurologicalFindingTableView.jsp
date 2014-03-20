<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-neurological-finding-${neurologicalFindingDisplayVo.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.hemisphereDominance"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.hemisphereDominance.${neurologicalFindingDisplayVo.hemisphereDominance}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.abnormalNeurologicalFinding"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neurologicalFindingDisplayVo.abnormalNeurologicalFinding}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.hemiparesis"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neurologicalFindingDisplayVo.hemiparesis}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.visualFieldDefect"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neurologicalFindingDisplayVo.visualFieldDefects}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty neurologicalFindingDisplayVo.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${neurologicalFindingDisplayVo.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>