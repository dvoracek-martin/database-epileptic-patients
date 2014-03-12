<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

<jsp:attribute name="title">
      <spring:message code="label.patient"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.verifyPatient"/>
                </h2>
            </div>
        </div>

        <%@include file="patientDetails.jsp" %>

        <form:form class="form-horizontal" role="form" method="POST"
                   action="/GENEPI/patient/${patient.id}/verify" commandName="patientVO">

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <div class="checkbox">
                        <label>
                            <form:checkbox path="verified" id="verified"/> <spring:message code="label.recordsVerified"/>
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.save"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL2>