<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="invasiveTestCorticalMappingDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestCorticalMappingDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-invasive-test-cortical-mapping-${invasiveTestCorticalMappingDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestCorticalMapping"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestCorticalMappingDisplayBO.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestCorticalMappingDisplayBO.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.corticalMapping"/>
                </th>
                <td class="col-xs-9">
                    <spring:message
                            code="label.corticalMapping.${invasiveTestCorticalMappingDisplayBO.corticalMapping}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestCorticalMappingDisplayBO.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestCorticalMappingDisplayBO.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>