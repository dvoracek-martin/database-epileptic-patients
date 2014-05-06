<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="operationDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.OperationDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-operation-${operationDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.dateOfOperation"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayBO.dateOperation}
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.ageAtSurgery"/>
            </th>
            <td class="col-xs-9">
                ${operationDisplayBO.ageAtOperation}
            </td>
        </tr>

       <tr>
           <th class="col-xs-3">
               <spring:message code="label.durationOfEpilepsyAtTheTimeOfSurgery"/>
           </th>
           <td class="col-xs-9">
               ${operationDisplayBO.epilepsyLastAtOperation}
           </td>
       </tr>

        <tr>
            <th class="col-xs-3">
                <spring:message code="label.typeOfOperation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.operationType.${operationDisplayBO.typeOperation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.rangeOfOperation"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.operationRange.${operationDisplayBO.rangeOperation}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.localizationOfOperation"/>
            </th>
            <c:choose>
                <c:when test="${empty operationDisplayBO.localizationOperation}">
                    <td>
                        -
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${operationDisplayBO.localizationOperation}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.mst"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayBO.mst}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.calosotomy"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayBO.colostomy}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.vns"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayBO.vns}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.vnsImplantationDate"/>
            </th>
            <c:choose>
                <c:when test="${empty operationDisplayBO.vnsImplantationDate}">
                    <td>
                        -
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${operationDisplayBO.vnsImplantationDate}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.operationDetails"/>
            </th>
            <c:choose>
                <c:when test="${empty operationDisplayBO.operationDetails}">
                    <td>
                        -
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${operationDisplayBO.operationDetails}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.completeResection"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${operationDisplayBO.completeResection}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty operationDisplayBO.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${operationDisplayBO.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>

        </tbody>
    </table>
</div>