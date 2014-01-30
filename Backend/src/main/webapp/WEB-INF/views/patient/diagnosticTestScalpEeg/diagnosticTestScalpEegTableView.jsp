<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${diagnosticTestScalpEeg.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.diagnosticTestScalpEEG"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${diagnosticTestScalpEeg.done}"/>
            </td>
        </tr>

        <c:if test="${diagnosticTestScalpEeg.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.basicEEGActivity"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.basicEegActivity.${diagnosticTestScalpEeg.basicEegActivity}"/>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.EEGSlow"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.eegSlow.${diagnosticTestScalpEeg.eegSlow}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.interictalEEGSpikes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.interictalEegSpikes.${diagnosticTestScalpEeg.interictalEegSpikes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInterictalEegSpikes"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestScalpEeg.localizationInterictalEegSpikes}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.EEGStatusEpilepticus"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestScalpEeg.eegStatusEpilepticus}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.secondarySidedSynchrony"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestScalpEeg.secondarySidedSynchrony}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ictalEEGPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.ictalEegPatterns.${diagnosticTestScalpEeg.ictalEegPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationIctalEEGPattern"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestScalpEeg.localizationIctalEegPattern}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty diagnosticTestScalpEeg.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${diagnosticTestScalpEeg.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>