<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${invasiveTestEeg.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestIeeg"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestEeg.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestEeg.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.intracranialElectrodes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.intracranialElectrodes.${invasiveTestEeg.intracranialElectrodes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationIntracranialElectrodes"/>
                </th>
                <td class="col-xs-9">
                        ${invasiveTestEeg.localizationIntracranialElectrodes}
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegSlowing"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEegSlowing.${invasiveTestEeg.invasiveEegSlow}"/>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.invasiveEeg.${invasiveTestEeg.invasiveEegInterictalSpikes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveEegInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                        ${invasiveTestEeg.localizationInvasiveEegInterictalSpikes}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegStatusEpilepticus"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${invasiveTestEeg.invasiveEegStatusEpilepticus}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveIctalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEeg.${invasiveTestEeg.invasiveIctalEegPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveIctalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                        ${invasiveTestEeg.localizationInvasiveIctalEegPatterns}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestEeg.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestEeg.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>