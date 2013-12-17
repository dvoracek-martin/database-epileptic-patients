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
      <spring:message code="label.addRecord"/> upravit zaznam
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
   </jsp:attribute>
    <jsp:body>


        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.seizures"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <form:form class="form-horizontal" role="form" method="POST"
                   action="/GENEPI/patient/${patient.id}/seizure/${seizure.id}/edit" commandName="seizure">

            <%@include file="formView.jsp" %>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-primary" type="submit"><spring:message code="label.add"/> ulozit</button>
                </div>
            </div>
        </form:form>

    </jsp:body>
</t:menuLVL2.NEW303>


