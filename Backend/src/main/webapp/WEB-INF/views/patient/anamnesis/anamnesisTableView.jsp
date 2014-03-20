<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-anamnesis-${anamnesisDisplayVo.id}" class="collapse in">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.epilepsyInFamily"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.epilepsyInFamily}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.prenatalRisk"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.prenatalRisk}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.fibrilConvulsions"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.fibrilConvulsions}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.inflammationCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.inflammationCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.injuryCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.injuryCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.operationCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.operationCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.earlyPmdRetardation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.earlyPmdRetardation}"/>
            </td>
        </tr>
        <tr>
            <th>
                <spring:message code="label.beginningEpilepsy"/>
            </th>
            <td>
                ${anamnesisDisplayVo.beginningEpilepsy}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.firstFever"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.firstFever}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.infantileSpasm"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayVo.infantileSpasm}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.epilepticSyndrome"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.specificSyndrome.${anamnesisDisplayVo.specificSyndrome}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.nonCnsComorbidity"/>
            </th>
            <c:choose>
                <c:when test="${empty anamnesisDisplayVo.nonCnsComorbidity}">
                    <td>
                        -
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${anamnesisDisplayVo.nonCnsComorbidity}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty anamnesisDisplayVo.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${anamnesisDisplayVo.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>