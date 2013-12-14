<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>
<jsp:attribute name="head">
      <link
              href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
              rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
   </jsp:attribute>
<jsp:body>

    <div class="row">
        <div class="col-xs-12">
            <h2>
                <spring:message code="label.anamnesis"/>
            </h2>
        </div>
    </div>


    <%@include file="../patientDetails.jsp" %>


    <!-- form for adding new record -->
    <%-- mapping resource in action with c:url caused errors --%>
    <form:form class="form-horizontal" role="form" method="POST"
               action="/GENEPI/patient/${patient.id}/anamnesis/create" commandName="anamnesis">

        <%@include file="formView.jsp" %>

        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-8">
                <button class="btn btn-primary" type="submit"><spring:message code="label.add"/></button>
            </div>
        </div>
    </form:form>
</jsp:body>
</t:menuLVL2.NEW303>


