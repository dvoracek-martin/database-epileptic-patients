<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>
<jsp:attribute name="head">
      <link href="<c:url value="/resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker-min.css" />"
            rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      Přidat pacienta
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/moment/moment-min.js" />"></script>
        <script src="<c:url value="/resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker-min.js" />"></script>
        <script src="<c:url value="/resources/bootstrap-datetimepicker/js/locales/bootstrap-datepicker.cs.js" />"></script>
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

        <%@include file="patientDetails.jsp" %>

        <form:form class="form-horizontal" method="POST" action="/GENEPI/patient/${patient.id}/edit"
                   commandName="patientVO">

            <%@include file="formView.jsp" %>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-small btn-primary" type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL1>