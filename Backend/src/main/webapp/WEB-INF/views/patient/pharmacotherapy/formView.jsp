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
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.pharmacotherapy"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <%-- mapping resource in action with c:url caused errors --%>
        <form:form class="form-horizontal" method="POST"
                   action="/GENEPI/patient/${patient.id}/pharmacotherapy/save" commandName="pharmacotherapy">

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
                <label class="col-xs-3 control-label" for="aed">
                    <spring:message code="label.aed"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="aed" id="aed" type="text" class="form-control">
                        <form:option value="0">
                            <spring:message code="label.aed.0"/>
                        </form:option>
                        <form:option value="1">
                            <spring:message code="label.aed.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.aed.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.aed.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.aed.4"/>
                        </form:option>
                        <form:option value="5">
                            <spring:message code="label.aed.5"/>
                        </form:option>
                        <form:option value="6">
                            <spring:message code="label.aed.6"/>
                        </form:option>
                        <form:option value="7">
                            <spring:message code="label.aed.7"/>
                        </form:option>
                        <form:option value="8">
                            <spring:message code="label.aed.8"/>
                        </form:option>
                        <form:option value="9">
                            <spring:message code="label.aed.9"/>
                        </form:option>
                        <form:option value="10">
                            <spring:message code="label.aed.10"/>
                        </form:option>
                        <form:option value="11">
                            <spring:message code="label.aed.11"/>
                        </form:option>
                        <form:option value="12">
                            <spring:message code="label.aed.12"/>
                        </form:option>
                        <form:option value="13">
                            <spring:message code="label.aed.13"/>
                        </form:option>
                        <form:option value="14">
                            <spring:message code="label.aed.14"/>
                        </form:option>
                        <form:option value="15">
                            <spring:message code="label.aed.15"/>
                        </form:option>
                        <form:option value="16">
                            <spring:message code="label.aed.16"/>
                        </form:option>
                        <form:option value="17">
                            <spring:message code="label.aed.17"/>
                        </form:option>
                        <form:option value="18">
                            <spring:message code="label.aed.18"/>
                        </form:option>
                        <form:option value="19">
                            <spring:message code="label.aed.19"/>
                        </form:option>
                        <form:option value="20">
                            <spring:message code="label.aed.20"/>
                        </form:option>
                        <form:option value="21">
                            <spring:message code="label.aed.21"/>
                        </form:option>
                        <form:option value="22">
                            <spring:message code="label.aed.22"/>
                        </form:option>
                        <form:option value="23">
                            <spring:message code="label.aed.23"/>
                        </form:option>
                        <form:option value="24">
                            <spring:message code="label.aed.24"/>
                        </form:option>
                        <form:option value="25">
                            <spring:message code="label.aed.25"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label" for="efficiency">
                    <spring:message code="label.efficiency"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="efficiency" id="efficiency" type="text" class="form-control">
                        <form:option value="1">
                            <spring:message code="label.efficiency.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.efficiency.2"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label" for="duringSurgery">
                    <spring:message code="label.duringSurgery"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="duringSurgery" id="duringSurgery"/>
                    <form:errors path="duringSurgery" cssClass="error">
                    </form:errors>
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