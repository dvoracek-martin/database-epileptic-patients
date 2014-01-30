<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${neuropsychologyOld.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.neuropsychologicalExamination"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOld.neuropsychologicalExamination}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                Věk při neuropsychologickém vyšetření
            </th>
            <td class="col-xs-9">
                <strong>N/A</strong>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intelligenceLevel"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.intelligenceLevel.${neuropsychologyOld.intelligenceLevel}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.specificLearning"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOld.specificLearning}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.developmentalLanguageDisorders"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOld.developmentalLanguageDisorders}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.ADHDSyndrome"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOld.adhdSyndrome}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty neuropsychologyOld.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${neuropsychologyOld.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>