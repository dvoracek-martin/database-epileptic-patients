<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>
    <jsp:attribute name="head">
      <link href="<c:url value="/resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />"
            rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.editPatient"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/moment/moment-with-langs.min.js" />"></script>
        <script src="<c:url value="/resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" />"></script>
        <script src="<c:url value="/resources/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.cs.js" />"></script>
		<script src="<c:url value="/resources/custom/js/datepicker.js" />"></script>
    </jsp:attribute>
    <jsp:body>

        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.editPatient"/>
                </h2>
            </div>
        </div>

        <jsp:include page="patientDetails.jsp"/>

        <form:form class="form-horizontal"
                   action="/GENEPI/patient/${patient.id}/edit"
                   method="POST"
                   commandName="patientFormBO">

            <jsp:include page="formView.jsp"/>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-8">
                    <button class="btn btn-small btn-primary"
                            type="submit">
                        <spring:message code="label.save"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL1>