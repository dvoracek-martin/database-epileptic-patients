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
                <spring:message code="label.invasiveTestEEG"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestEeg.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestEeg.done==1}">
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
                    <spring:message code="label.invasiveEEGSlowing"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEegSlowing.${invasiveTestEeg.invasiveEegSlowing}"/>
                </td>
            </tr>

            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEEGInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.invasiveEeg.${invasiveTestEeg.invasiveEegInterictalSpikes}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.localizationInvasiveEEGInterictalSpikes"/>
                </th>
                <td class="col-xs-9">
                        ${invasiveTestEeg.localizationInvasiveEegInterictalSpikes}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveEEGStatusEpilepticus"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestScalpEeg.invasiveEegStatusEpilepticus}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.invasiveIctalEEGPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.invasiveEeg.${invasiveTestEeg.invasiveIctalEegPatterns}"/>
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


<%--
    <c:if test="${invasiveTestEEG.done==true}">
        <tr class="info">
            <td><spring:message code="label.intracranialElectrodes"/></td>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==1}">
                <td><spring:message code="label.IC"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==2}">
                <td><spring:message code="label.IcSd"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==3}">
                <td><spring:message code="label.IcSdStripsGrids"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==4}">
                <td><spring:message code="label.Sd"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==5}">
                <td><spring:message code="label.SdGrids"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==6}">
                <td><spring:message code="label.Grids"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.intracranialElectrodes==7}">
                <td><spring:message code="label.IcSdGrids"/></td>
            </c:if>
        </tr>
        <tr class="info">
            <td><spring:message code="label.localizationIntracranialElectrodes"/></td>
            <td>${invasiveTestEEG.localizationIntracranialElectrodes}</td>
        </tr>
        <tr class="info">
            <td><spring:message code="label.invasiveEEGSlowing"/></td>
            <c:if test="${invasiveTestEEG.invasiveEegSlow==1}">
                <td><spring:message code="label.generalizedIntermittent"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegSlow==2}">
                <td><spring:message code="label.generalizedContinuous"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegSlow==3}">
                <td><spring:message code="label.localizedIntermittent"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegSlow==4}">
                <td><spring:message code="label.localizedContinuous"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegSlow==5}">
                <td>spring:message code="label.absent"/></td>
            </c:if>
        </tr>
        <tr class="info">
            <td><spring:message code="label.invasiveEEGInterictalSpikes"/></td>
            <c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==1}">
                <td><spring:message code="label.missing"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==2}">
                <td><spring:message code="label.focal"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==3}">
                <td><spring:message code="label.multiregional"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==4}">
                <td><spring:message code="label.notlocalizable"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==5}">
                <td><spring:message code="label.regional"/></td>
            </c:if>
        </tr>
        <tr class="info">
            <td><spring:message code="label.localizationInvasiveEEGInterictalSpikes"/></td>
            <td>${invasiveTestEEG.localizationInvasiveEegInterictalSpikes}</td>
        </tr>
        <tr class="info">
            <td><spring:message code="label.invasiveEEGStatusEpilepticus"/></td>
            <c:if test="${invasiveTestEEG.invasiveEegStatusEpilepticus==true}">
                <td style="column-span: 2"><spring:message code="label.yes"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveEegStatusEpilepticus==false}">
                <td><spring:message code="label.no"/></td>
            </c:if>
        </tr>
        <tr class="info">
            <td><spring:message code="label.invasiveIctalEEGPatterns"/></td>
            <c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==1}">
                <td><spring:message code="label.missing"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==2}">
                <td><spring:message code="label.focal"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==3}">
                <td><spring:message code="label.multiregional"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==4}">
                <td><spring:message code="label.notlocalizable"/></td>
            </c:if>
            <c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==5}">
                <td><spring:message code="label.regional"/></td>
            </c:if>
        </tr>
        --%>