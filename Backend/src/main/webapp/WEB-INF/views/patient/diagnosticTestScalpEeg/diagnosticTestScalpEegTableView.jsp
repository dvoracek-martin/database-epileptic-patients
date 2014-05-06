<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="diagnosticTestScalpEegDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.DiagnosticTestScalpEegDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-diagnostic-test-scalp-eeg-${diagnosticTestScalpEegDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.diagnosticTestScalpEeg"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${diagnosticTestScalpEegDisplayBO.done}"/>
            </td>
        </tr>

        <c:if test="${diagnosticTestScalpEegDisplayBO.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.basicEegActivity"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.basicEegActivity.${diagnosticTestScalpEegDisplayBO.basicEegActivity}"/>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.eegSlow"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.eegSlow.${diagnosticTestScalpEegDisplayBO.eegSlow}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.interictalEegSpikes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.interictalEegSpikes.${diagnosticTestScalpEegDisplayBO.interictalEegSpikes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInterictalEegSpikes"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestScalpEegDisplayBO.localizationInterictalEegSpikes}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.eegStatusEpilepticus"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestScalpEegDisplayBO.eegStatusEpilepticus}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.secondarySidedSynchrony"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestScalpEegDisplayBO.secondarySidedSynchrony}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ictalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.ictalEegPatterns.${diagnosticTestScalpEegDisplayBO.ictalEegPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationIctalEegPattern"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestScalpEegDisplayBO.localizationIctalEegPattern}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.descriptionVideoEeg"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestScalpEegDisplayBO.descriptionVideoEeg}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty diagnosticTestScalpEegDisplayBO.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${diagnosticTestScalpEegDisplayBO.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>