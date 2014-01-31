<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${invasiveTestCorticalMapping.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestCorticalMapping"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestCorticalMapping.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestCorticalMapping.done==1}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.corticalMapping"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.corticalMapping.${invasiveTestCorticalMapping.corticalMapping}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestCorticalMapping.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestCorticalMapping.comment}
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
        <td><spring:message code="label.corticalMapping"/></td>
        <c:if test="${empty invasiveTestCorticalMapping.corticalMapping}">
            <td>-</td>
        </c:if>
        <c:if test="${invasiveTestCorticalMapping.corticalMapping==1}">
            <td>Awake craniotomy</td>
        </c:if>
        <c:if test="${invasiveTestCorticalMapping.corticalMapping==2}">
            <td><spring:message code="label.extraoperativeElectricalStimulation"/></td>
        </c:if>
        <c:if test="${invasiveTestCorticalMapping.corticalMapping==3}">
            <td><spring:message code="label.functionalMappingDone"/></td>
        </c:if>
        <c:if test="${invasiveTestCorticalMapping.corticalMapping==4}">
            <td><spring:message code="label.intraoperativeElectricalStimulation"/></td>
        </c:if>
        <c:if test="${invasiveTestCorticalMapping.corticalMapping==5}">
            <td><spring:message code="label.intraoperativeElectricalStimulation"/> +
                <spring:message code="label.intactnessMonitoringRailways"/></td>
        </c:if>
        <c:if test="${invasiveTestCorticalMapping.corticalMapping==6}">
            <td><spring:message code="label.notDone"/></td>
        </c:if>
    </tr>
--%>
