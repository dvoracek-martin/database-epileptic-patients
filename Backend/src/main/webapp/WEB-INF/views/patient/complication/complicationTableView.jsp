<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<table class="record-head table">
    <tr>
        <td class="col-xs-2">
            <a data-toggle="collapse" href="#collapse${complication.id}">
                ${complication.date}
            </a>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.process.${complication.process}"/>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.complicationType.${complication.complicationType}"/>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.complication.${complication.complication}"/>
        </td>
        <td class="col-xs-2">
            <a href="<c:url value="/patient/${patient.id}/complication/${complication.id}/edit"/>">
                <span class="glyphicon glyphicon-edit"></span><spring:message code="label.edit"/>
            </a>
        </td>
        <td class="col-xs-2">
            <a href="<c:url value="/patient/${patient.id}/complication/${complication.id}/hide"/>">
                <span class="glyphicon glyphicon-remove-circle"></span><spring:message code="label.delete"/>
            </a>
        </td>
    </tr>
</table>

<div id="collapse${complication.id}" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td colspan="3" class="col-xs-8">
                ${complication.comment}
            </td>
        </tr>
    </table>
</div>



<table class="table">
    <tbody>
    <tr class="info">
        <td><spring:message code="label.process"/></td>
        <c:if test="${complication.withComplication==true}">
            <td><spring:message code="label.withComplications"/></td>
        </c:if>
        <c:if test="${complication.withComplication==false}">
            <td><spring:message code="label.withoutComplications"/></td>
        </c:if>
    </tr>
    <c:if test="${complication.withComplication==true}">
    <tr class="info">
        <td><spring:message code="label.typeComplication"/></td>
        <c:if test="${complication.complicationType==1}">
            <td><spring:message code="label.unexpectedPermanent"/></td>
        </c:if>
        <c:if test="${complication.complicationType==2}">
            <td><spring:message code="label.expectedPermanent"/></td>
        </c:if>
        <c:if test="${complication.complicationType==3}">
            <td><spring:message code="label.transitional"/></td>
        </c:if>
    </tr>
    <tr class="info">
        <td><spring:message code="label.complication"/></td>
        <c:if test="${complication.complication==1}">
            <td><spring:message code="label.aphasia"/></td>
        </c:if>
        <c:if test="${complication.complication==2}">
            <td><spring:message code="label.edema"/></td>
        </c:if>
        <c:if test="${complication.complication==3}">
            <td><spring:message code="label.hemiparesis"/></td>
        </c:if>
        <c:if test="${complication.complication==4}">
            <td><spring:message code="label.hydrocefalus"/></td>
        </c:if>
        <c:if test="${complication.complication==5}">
            <td><spring:message code="label.ischemia"/></td>
        </c:if>
        <c:if test="${complication.complication==6}">
            <td><spring:message code="label.other"/></td>
        </c:if>
        <c:if test="${complication.complication==7}">
            <td><spring:message code="label.hemorrhage"/></td>
        </c:if>
        <c:if test="${complication.complication==8}">
            <td><spring:message
                    code="label.paresisOfCranialNerves"/></td>
        </c:if>
        <c:if test="${complication.complication==9}">
            <td><spring:message code="label.visualFieldDefects"/></td>
        </c:if>
        <c:if test="${complication.complication==10}">
            <td><spring:message code="label.death"/></td>
        </c:if>
        <c:if test="${complication.complication==11}">
            <td><spring:message code="label.inflammation"/></td>
        </c:if>
    </tr>