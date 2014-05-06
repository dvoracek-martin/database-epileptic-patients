<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="complicationDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.ComplicationDisplayBO"/>

<jsp:useBean id="patient"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO"/>

<table class="record-head table">
    <tr>
        <td class="col-xs-3">
            <a href="#collapse${complicationDisplayBO.id}"
               data-toggle="collapse">
                ${complicationDisplayBO.date}
            </a>
        </td>
        <td class="col-xs-3">
            <spring:message code="label.process.${complicationDisplayBO.withComplication}"/>
        </td>
        <td class="col-xs-3">
            <c:if test="${complicationDisplayBO.withComplication == 2}">
                <spring:message code="label.complicationType.${complicationDisplayBO.complicationType}"/>
            </c:if>
        </td>
        <td class="col-xs-3">
            <c:if test="${complicationDisplayBO.withComplication == 2}">
                <spring:message code="label.complication.${complicationDisplayBO.complication}"/>
            </c:if>
        </td>
    </tr>
</table>

<div id="collapse${complicationDisplayBO.id}"
     class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td class="col-xs-8"
                colspan="3">
                ${complicationDisplayBO.comment}
            </td>
        </tr>
    </table>
</div>