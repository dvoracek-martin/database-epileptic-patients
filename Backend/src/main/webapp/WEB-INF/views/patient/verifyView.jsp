<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

<jsp:attribute name="title">
      <spring:message code="label.patient"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.NEW303.css" />" rel="stylesheet">
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

        <form class="form-horizontal" role="form" method="POST" action="/GENEPI/patient/${patient.id}/verify">

            <div class="form-group">
                <label for="verification" class="col-xs-3 control-label">
                    <spring:message code="label.verifyPatient"/>
                </label>

                <div class="col-xs-8">
                    <select id="verification" type="text" class="form-control">
                        <option value="1">
                           v poradku
                        </option>
                        <option value="2">
                           ne v proadku
                        </option>
                    </select>
                </div>
            </div>

        </form>

    </jsp:body>
</t:menuLVL2.NEW303>