<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-operation-${operationDisplayVo.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.dateOfOperation"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayVo.dateOperation}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.ageAtSurgery"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayVo.ageAtOperation}
            </td>
        </tr>
        <%--
       <tr>
           <th class="col-xs-3">
               <spring:message code="label.durationOfEpilepsyAtTheTimeOfSurgery"/>
           </th>
           <td class="col-xs-9">
               ${operationDisplayVo.durationOfEpilepsyAtTheTimeOfSurgery}
           </td>
       </tr>--%>

        <tr>
            <th class="col-xs-3">
                <spring:message code="label.typeOfOperation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.operationType.${operationDisplayVo.typeOperation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.rangeOfOperation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.operationRange.${operationDisplayVo.rangeOperation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.localizationOfOperation"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayVo.localizationOperation}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.mst"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayVo.mst}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.calosotomy"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayVo.colostomy}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.vns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayVo.vns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.vnsImplantationDate"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayVo.vnsImplantationDate}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.operationDetails"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayVo.operationDetails}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.completeResection"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayVo.completeResection}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty operationDisplayVo.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${operationDisplayVo.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>

        </tbody>
    </table>
</div>