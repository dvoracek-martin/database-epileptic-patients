<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="histologyDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.HistologyDisplayBO"/>

<jsp:useBean id="patient"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO"/>

<table class="record-head table">
    <tr>
        <td class="col-xs-4">
            <a href="#collapse-histology-${histologyDisplayBO.id}"
               data-toggle="collapse">
                ${histologyDisplayBO.date}
            </a>
        </td>
        <td class="col-xs-4">
            <spring:message code="label.histopathology.${histologyDisplayBO.histopathology}"/>
        </td>
        <td class="col-xs-4">
            <spring:message code="label.fcdClassification.${histologyDisplayBO.fcdClassification}"/>
        </td>
    </tr>
</table>

<div id="collapse-histology-${histologyDisplayBO.id}"
     class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td colspan="3" class="col-xs-8">
                ${histologyDisplayBO.comment}
            </td>
        </tr>
    </table>
</div>