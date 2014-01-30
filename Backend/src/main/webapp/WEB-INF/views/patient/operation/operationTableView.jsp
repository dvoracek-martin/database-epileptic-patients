<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${operation.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.dateOfOperation"/>
            </th>
            <td class="col-xs-9">
                ${operation.dateOfOperation}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.ageAtSurgery"/>
            </th>
            <td class="col-xs-9">
                ${operation.ageAtSurgery}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.durationOfEpilepsyAtTheTimeOfSurgery"/>
            </th>
            <td class="col-xs-9">
                ${operation.durationOfEpilepsyAtTheTimeOfSurgery}
            </td>
        </tr>

        <tr>
            <th class="col-xs-3">
                <spring:message code="label.typeOperations"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.operationType.${operation.typeOperation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.rangeOperations"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.operationRange.${operation.rangeOperation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.localizationOperations"/>
            </th>
            <td class="col-xs-9">
                ${operation.localizationOperation}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.mst"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operation.mst}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.calosotomy"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operation.colostomy}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.VNS"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operation.vns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.VNSImplantationDate"/>
            </th>
            <td class="col-xs-9">
                ${operation.vnsImplantationDate}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.operationDetails"/>
            </th>
            <td class="col-xs-9">
                ${operation.operationDetails}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.completeResection"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operation.completeResection}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty operation.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${operation.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>

        </tbody>
    </table>
</div>