<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

    <jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/custom/js/datepicker.NEW303.js" />"></script>
        <script src="<c:url value="/resources/custom/js/cardForm/complication.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.complication"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <%-- mapping resource in action with c:url caused errors --%>
        <form:form class="form-horizontal" method="POST"
                   action="/GENEPI/patient/${patient.id}/complication/save" commandName="complication">

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
                <label class="col-xs-3 control-label" for="process">
                    <spring:message code="label.process"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="withComplication" id="process" type="text" class="form-control">
                        <form:option value="1">
                            <spring:message code="label.process.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.process.2"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div id="section-with-complication">

                <div class="form-group">
                    <label class="col-xs-3 control-label" for="complicationType">
                        <spring:message code="label.typeComplication"/>
                    </label>

                    <div class="col-xs-8">
                        <form:select path="complicationType" id="complicationType" type="text" class="form-control">
                            <form:option value="0">
                                <spring:message code="label.complicationType.0"/>
                            </form:option>
                            <form:option value="1">
                                <spring:message code="label.complicationType.1"/>
                            </form:option>
                            <form:option value="2">
                                <spring:message code="label.complicationType.2"/>
                            </form:option>
                            <form:option value="3">
                                <spring:message code="label.complicationType.3"/>
                            </form:option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label" for="complication">
                        <spring:message code="label.complication"/>
                    </label>

                    <div class="col-xs-8">
                        <form:select path="complication" id="complication" type="text" class="form-control">
                            <form:option value="0">
                                <spring:message code="label.complication.0"/>
                            </form:option>
                            <form:option value="1">
                                <spring:message code="label.complication.1"/>
                            </form:option>
                            <form:option value="2">
                                <spring:message code="label.complication.2"/>
                            </form:option>
                            <form:option value="3">
                                <spring:message code="label.complication.3"/>
                            </form:option>
                            <form:option value="4">
                                <spring:message code="label.complication.4"/>
                            </form:option>
                            <form:option value="5">
                                <spring:message code="label.complication.5"/>
                            </form:option>
                            <form:option value="6">
                                <spring:message code="label.complication.6"/>
                            </form:option>
                            <form:option value="7">
                                <spring:message code="label.complication.7"/>
                            </form:option>
                            <form:option value="8">
                                <spring:message code="label.complication.8"/>
                            </form:option>
                            <form:option value="9">
                                <spring:message code="label.complication.9"/>
                            </form:option>
                            <form:option value="10">
                                <spring:message code="label.complication.10"/>
                            </form:option>
                            <form:option value="11">
                                <spring:message code="label.complication.11"/>
                            </form:option>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label" for="comment">
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