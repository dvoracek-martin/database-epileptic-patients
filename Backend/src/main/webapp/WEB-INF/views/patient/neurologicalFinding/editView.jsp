<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

    <jsp:attribute name="head">
       <link href="<c:url value="/resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />"
             rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
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
                    <spring:message code="label.neurologicalFinding"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <%-- mapping resource in action with c:url caused errors --%>
        <form:form class="form-horizontal" role="form" method="POST"
                   action="/GENEPI/patient/${patient.id}/neurological-finding/${neurologicalFinding.id}/edit"
                   commandName="neurologicalFinding">

            <%@include file="formView.jsp" %>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.save"/>
                    </button>
                </div>
            </div>

        </form:form>

    </jsp:body>
</t:menuLVL2>