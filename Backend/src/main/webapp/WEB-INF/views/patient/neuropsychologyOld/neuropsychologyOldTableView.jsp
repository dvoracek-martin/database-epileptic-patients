<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-neuropsychology-old-${neuropsychologyOldDisplayVo.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.neuropsychologicalExamination"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayVo.neuropsychologicalExamination}"/>
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
                <spring:message code="label.intelligenceLevel.${neuropsychologyOldDisplayVo.intelligenceLevel}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.specificLearning"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayVo.specificLearning}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.developmentalLanguageDisorders"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayVo.developmentalLanguageDisorders}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.adhdSyndrome"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayVo.adhdSyndrome}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty neuropsychologyOldDisplayVo.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${neuropsychologyOldDisplayVo.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>