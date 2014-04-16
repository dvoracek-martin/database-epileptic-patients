<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="invasiveTestEegDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.InvasiveTestEegDisplayVO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-invasive-test-eeg-${invasiveTestEegDisplayVo.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestIeeg"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestEegDisplayVo.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestEegDisplayVo.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.intracranialElectrodes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.intracranialElectrodes.${invasiveTestEegDisplayVo.intracranialElectrodes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationIntracranialElectrodes"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEegDisplayVo.localizationIntracranialElectrodes}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEegDisplayVo.localizationIntracranialElectrodes}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegSlowing"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEegSlowing.${invasiveTestEegDisplayVo.invasiveEegSlow}"/>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.invasiveEeg.${invasiveTestEegDisplayVo.invasiveEegInterictalSpikes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveEegInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEegDisplayVo.localizationInvasiveEegInterictalSpikes}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEegDisplayVo.localizationInvasiveEegInterictalSpikes}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEegStatusEpilepticus"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${invasiveTestEegDisplayVo.invasiveEegStatusEpilepticus}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveIctalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEeg.${invasiveTestEegDisplayVo.invasiveIctalEegPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveIctalEegPatterns"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEegDisplayVo.localizationInvasiveIctalEegPatterns}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEegDisplayVo.localizationInvasiveIctalEegPatterns}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestEegDisplayVo.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestEegDisplayVo.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>