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
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
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
                   action="/GENEPI/patient/${patient.id}/neurological-finding/save" commandName="neurologicalFinding">



            <div class="form-group">
                <label for="date" class="col-xs-4 control-label">
                    <spring:message code="label.dateExamination"/>
                </label>

                <div class="col-xs-8">
                    <form:input path="date" id="date" type="text" class="input-sm form-control datepicker-today"
                                autocomplete="off"/>
                    <form:errors path="date" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="hemisphereDominance" class="col-xs-4 control-label">
                    <spring:message code="label.hemisphereDominance"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="hemisphereDominance" id="hemisphereDominance" type="text" class="input-sm form-control">
                        <form:option value="0">
                            <spring:message code="label.hemisphereDominance.0"/>
                        </form:option>
                        <form:option value="1">
                            <spring:message code="label.hemisphereDominance.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.hemisphereDominance.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.hemisphereDominance.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.hemisphereDominance.4"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <jsp:include page="../../components/checkboxComponentView.jsp">
                <jsp:param name="propertyName" value="abnormalNeurologicalFinding"/>
                <jsp:param name="messageCode" value="abnormalNeurologicalFinding"/>
            </jsp:include>

            <jsp:include page="../../components/checkboxComponentView.jsp">
                <jsp:param name="propertyName" value="hemiparesis"/>
                <jsp:param name="messageCode" value="hemiparesis"/>
            </jsp:include>

            <jsp:include page="../../components/checkboxComponentView.jsp">
                <jsp:param name="propertyName" value="visualFieldDefects"/>
                <jsp:param name="messageCode" value="visualFieldDefect"/>
            </jsp:include>

            <div class="form-group">
                <label for="comment" class="col-xs-4 control-label">
                    <spring:message code="label.comment"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea style="resize:vertical" path="comment" id="comment" class=" form-control"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
            <%--
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
                <label for="hemisphereDominance" class="col-xs-3 control-label">
                    <spring:message code="label.hemisphereDominance"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="hemisphereDominance" id="hemisphereDominance" type="text" class="form-control">
                        <form:option value="0">
                            <spring:message code="label.hemisphereDominance.0"/>
                        </form:option>
                        <form:option value="1">
                            <spring:message code="label.hemisphereDominance.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.hemisphereDominance.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.hemisphereDominance.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.hemisphereDominance.4"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="abnormalNeurologicalFinding" class="col-xs-3 control-label">
                    <spring:message code="label.abnormalNeurologicalFinding"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="abnormalNeurologicalFinding" id="abnormalNeurologicalFinding"/>
                    <form:errors path="abnormalNeurologicalFinding" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="hemiparesis" class="col-xs-3 control-label">
                    <spring:message code="label.hemiparesis"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="hemiparesis" id="hemiparesis"/>
                    <form:errors path="hemiparesis" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="visualFieldDefects" class="col-xs-3 control-label">
                    <spring:message code="label.visualFieldDefect"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="visualFieldDefects" id="visualFieldDefects"/>
                    <form:errors path="visualFieldDefects" cssClass="error">
                    </form:errors>
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

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>--%>
        </form:form>

    </jsp:body>
</t:menuLVL2.NEW303>