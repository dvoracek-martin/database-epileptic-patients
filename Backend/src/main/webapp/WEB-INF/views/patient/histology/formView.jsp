<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/custom/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/custom/js/datepicker.NEW303.js" />"></script>
        <script src="<c:url value="/resources/custom/js/cardForm/histology.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.histology"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <%-- mapping resource in action with c:url caused errors --%>
        <form:form class="form-horizontal" role="form" method="POST"
                   action="/GENEPI/patient/${patient.id}/histology/save" commandName="histology">

            <div class="form-group">
                <label for="date" class="col-xs-3 control-label">
                    <spring:message code="label.dateExamination"/>
                </label>

                <div class="col-xs-8">
                    <form:input path="date" id="date" type="text" class="form-control datepicker-today"
                                autocomplete="off"/>
                    <form:errors path="date" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="histopathology" class="col-xs-3 control-label">
                    <spring:message code="label.histopathology"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="histopathology" id="histopathology" type="text" class="form-control">
                        <form:option value="0">
                            <spring:message code="label.histopathology.0"/>
                        </form:option>
                        <form:option value="1">
                            <spring:message code="label.histopathology.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.histopathology.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.histopathology.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.histopathology.4"/>
                        </form:option>
                        <form:option value="5">
                            <spring:message code="label.histopathology.5"/>
                        </form:option>
                        <form:option value="6">
                            <spring:message code="label.histopathology.6"/>
                        </form:option>
                        <form:option value="7">
                            <spring:message code="label.histopathology.7"/>
                        </form:option>
                        <form:option value="8">
                            <spring:message code="label.histopathology.8"/>
                        </form:option>
                        <form:option value="9">
                            <spring:message code="label.histopathology.9"/>
                        </form:option>
                        <form:option value="10">
                            <spring:message code="label.histopathology.10"/>
                        </form:option>
                        <form:option value="11">
                            <spring:message code="label.histopathology.11"/>
                        </form:option>
                        <form:option value="12">
                            <spring:message code="label.histopathology.12"/>
                        </form:option>
                        <form:option value="13">
                            <spring:message code="label.histopathology.13"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div id="section-fcd">
                <div class="form-group">
                    <label for="fcdClassification" class="col-xs-3 control-label">
                        <spring:message code="label.fcdClassification"/>
                    </label>

                    <div class="col-xs-8">
                        <form:select path="fcdClassification" id="fcdClassification" type="text" class="form-control">
                            <form:option value="0">
                                Zvolte
                            </form:option>
                            <form:option value="1">
                                <spring:message code="label.fcdClassification.1"/>
                            </form:option>
                            <form:option value="2">
                                <spring:message code="label.fcdClassification.2"/>
                            </form:option>
                            <form:option value="3">
                                <spring:message code="label.fcdClassification.3"/>
                            </form:option>
                            <form:option value="4">
                                <spring:message code="label.fcdClassification.4"/>
                            </form:option>
                            <form:option value="5">
                                <spring:message code="label.fcdClassification.5"/>
                            </form:option>
                            <form:option value="6">
                                <spring:message code="label.fcdClassification.6"/>
                            </form:option>
                            <form:option value="7">
                                <spring:message code="label.fcdClassification.7"/>
                            </form:option>
                        </form:select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="comment" class="col-xs-3 control-label">
                    <spring:message code="label.comment"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea path="comment" id="comment" class="form-control"/>
                </div>
            </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
        </form:form>

    </jsp:body>
</t:menuLVL2.NEW303>