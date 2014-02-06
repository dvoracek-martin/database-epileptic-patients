<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-anamnesis-${anamnesis.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.epilepsyInFamily"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.epilepsyInFamily}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.prenatalRisk"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.prenatalRisk}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.fibrilConvulsions"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.fibrilConvulsions}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.inflammationCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.inflammationCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.injuryCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.injuryCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.operationCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.operationCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.earlyPmdRetardation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.earlyPmdRetardation}"/>
            </td>
        </tr>
        <tr>
            <th>
                <spring:message code="label.beginningEpilepsy"/>
            </th>
            <td>
                ${anamnesis.beginningEpilepsy}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.firstFever"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.firstFever}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.infantileSpasm"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesis.infantileSpasm}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.epilepticSyndrome"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.specificSyndrome.${anamnesis.specificSyndrome}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.nonCnsComorbidity"/>
            </th>
            <c:choose>
                <c:when test="${empty anamnesis.nonCnsComorbidity}">
                    <td>
                        -
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${anamnesis.nonCnsComorbidity}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty anamnesis.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${anamnesis.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>