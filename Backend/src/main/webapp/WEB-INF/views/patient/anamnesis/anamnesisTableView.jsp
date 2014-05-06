<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="anamnesisDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.AnamnesisDisplayBO"/>

<div id="collapse-anamnesis-${anamnesisDisplayBO.id}"
     class="collapse in">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.epilepsyInFamily"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.epilepsyInFamily}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.prenatalRisk"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.prenatalRisk}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.fibrilConvulsions"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.fibrilConvulsions}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.inflammationCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.inflammationCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.injuryCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.injuryCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.operationCns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.operationCns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.earlyPmdRetardation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.earlyPmdRetardation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.firstFever"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.firstFever}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.infantileSpasm"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${anamnesisDisplayBO.infantileSpasm}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.epilepticSyndrome"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.specificSyndrome.${anamnesisDisplayBO.specificSyndrome}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.nonCnsComorbidity"/>
            </th>
            <c:choose>
                <c:when test="${empty anamnesisDisplayBO.nonCnsComorbidity}">
                    <td>
                        -
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${anamnesisDisplayBO.nonCnsComorbidity}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty anamnesisDisplayBO.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${anamnesisDisplayBO.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>