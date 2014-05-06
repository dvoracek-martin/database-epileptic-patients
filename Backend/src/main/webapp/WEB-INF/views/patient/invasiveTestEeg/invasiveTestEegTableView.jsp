<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="invasiveTestEegDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestEegDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-invasive-test-eeg-${invasiveTestEegDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestIeeg"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestEegDisplayBO.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestEegDisplayBO.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.intracranialElectrodes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.intracranialElectrodes.${invasiveTestEegDisplayBO.intracranialElectrodes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationIntracranialElectrodes"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEegDisplayBO.localizationIntracranialElectrodes}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEegDisplayBO.localizationIntracranialElectrodes}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegSlowing"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEegSlowing.${invasiveTestEegDisplayBO.invasiveEegSlow}"/>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.invasiveEeg.${invasiveTestEegDisplayBO.invasiveEegInterictalSpikes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveEegInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEegDisplayBO.localizationInvasiveEegInterictalSpikes}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEegDisplayBO.localizationInvasiveEegInterictalSpikes}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegStatusEpilepticus"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${invasiveTestEegDisplayBO.invasiveEegStatusEpilepticus}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveIctalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEeg.${invasiveTestEegDisplayBO.invasiveIctalEegPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveIctalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEegDisplayBO.localizationInvasiveIctalEegPatterns}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEegDisplayBO.localizationInvasiveIctalEegPatterns}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestEegDisplayBO.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestEegDisplayBO.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>