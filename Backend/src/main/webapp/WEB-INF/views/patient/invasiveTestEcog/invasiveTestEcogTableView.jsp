<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${invasiveTestEcog.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestECoG"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestEcog.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestEcog.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ecogCover"/>
                </th>
                <td class="col-xs-9">
                        ${invasiveTestEcog.ecogCover}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ecogPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.ecogPatterns.${invasiveTestEcog.ecogPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.afterResectionECoG"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.afterResectionEcog.${invasiveTestEcog.afterResectionEcog}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestEcog.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestEcog.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<%--
<tr class="info">
    <td><spring:message code="label.ecogPatterns"/></td>
    <c:if test="${invasiveTestECOG.ecogPatterns==1}">
        <td><spring:message code="label.noSpikes"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.ecogPatterns==2}">
        <td><spring:message code="label.burstSuppresion"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.ecogPatterns==3}">
        <td><spring:message code="label.continuousSpikes"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.ecogPatterns==4}">
        <td><spring:message code="label.ECoGAbnormality"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.ecogPatterns==5}">
        <td><spring:message code="label.spikes"/></td>
    </c:if>
</tr>
<tr class="info">
    <td><spring:message code="label.afterResectionECoG"/></td>
    <c:if test="${invasiveTestECOG.afterResectionEcog==1}">
        <td><spring:message code="label.noSpikes"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.afterResectionEcog==2}">
        <td><spring:message code="label.notDone"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.afterResectionEcog==3}">
        <td><spring:message code="label.done"/></td>
    </c:if>
    <c:if test="${invasiveTestECOG.afterResectionEcog==4}">
        <td><spring:message code="label.spikes"/></td>
    </c:if>
</tr>--%>
