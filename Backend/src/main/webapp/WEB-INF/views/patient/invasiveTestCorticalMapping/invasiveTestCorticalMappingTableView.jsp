<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="invasiveTestCorticalMappingDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.InvasiveTestCorticalMappingDisplayVO"/>

<div id="collapse-invasive-test-cortical-mapping-${invasiveTestCorticalMappingDisplayVo.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestCorticalMapping"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestCorticalMappingDisplayVo.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestCorticalMappingDisplayVo.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.corticalMapping"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.corticalMapping.${invasiveTestCorticalMappingDisplayVo.corticalMapping}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestCorticalMappingDisplayVo.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestCorticalMappingDisplayVo.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>