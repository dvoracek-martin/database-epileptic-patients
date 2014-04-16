<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="complicationDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.ComplicationDisplayVO"/>

<jsp:useBean id="patient"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO"/>

<sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
               var="isAuthorized"/>

<table class="record-head table">
    <tr>
        <td class="col-xs-2">
            <a href="#collapse${complicationDisplayVo.id}"
               data-toggle="collapse">
                ${complicationDisplayVo.date}
            </a>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.process.${complicationDisplayVo.withComplication}"/>
        </td>
        <td class="col-xs-2">
            <c:if test="${complicationDisplayVo.withComplication == 2}">
                <spring:message code="label.complicationType.${complicationDisplayVo.complicationType}"/>
            </c:if>
        </td>
        <td class="col-xs-2">
            <c:if test="${complicationDisplayVo.withComplication == 2}">
                <spring:message code="label.complication.${complicationDisplayVo.complication}"/>
            </c:if>
        </td>
        <td class="col-xs-2">
            <c:if test="${isAuthorized}">
                <a href="<c:url value="/patient/${patient.id}/complication/${complicationDisplayVo.id}/edit"/>">
                    <span class="glyphicon glyphicon-edit"></span><spring:message code="label.edit"/>
                </a>
            </c:if>
        </td>
        <td class="col-xs-2">
            <c:if test="${isAuthorized}">
                <a href="#delete-complication-${complicationDisplayVo.id}"
                   data-toggle="modal">
                    <span class="glyphicon glyphicon-remove-circle"></span><spring:message code="label.delete"/>
                </a>
            </c:if>
        </td>
    </tr>
</table>

<div id="collapse${complicationDisplayVo.id}"
     class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td class="col-xs-8"
                colspan="3">
                ${complicationDisplayVo.comment}
            </td>
        </tr>
    </table>
</div>

<jsp:include page="../../components/deleteModalComponentView.jsp">
    <jsp:param name="modalId"
               value="delete-complication-${complicationDisplayVo.id}"/>
    <jsp:param name="bodyMessage"
               value="reallyDeleteRecord"/>
    <jsp:param name="deleteUrl"
               value="/patient/${patient.id}/complication/${complicationDisplayVo.id}/hide"/>
</jsp:include>