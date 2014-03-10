<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/custom/js/datepicker.js" />"></script>
        <script src="<c:url value="/resources/custom/js/cardForm/customjs.js" />"></script>
    </jsp:attribute>

<jsp:body>
    <div class="row">
        <div class="col-xs-12">
            <h2>
                <spring:message code="label.invasiveTestsIeeg"/>
            </h2>
        </div>
    </div>

    <%@include file="../patientDetails.jsp" %>

    <%-- mapping resource in action with c:url caused errors --%>
    <form:form class="form-horizontal" role="form" method="POST"
               action="/GENEPI/patient/${patient.id}/invasive-test-eeg/save" commandName="invasiveTestEeg">

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
            <label for="done" class="col-xs-3 control-label">
                <spring:message code="label.invasiveTestIeeg"/>
            </label>

            <div class="col-xs-8">
                <form:select path="done" id="done" type="text" class="form-control">
                    <form:option value="1">
                        <spring:message code="label.done.1"/>
                    </form:option>
                    <form:option value="2">
                        <spring:message code="label.done.2"/>
                    </form:option>
                </form:select>
            </div>
        </div>

        <div id="section-done" class="section-hide">
            <div class="form-group">
                <label for="intracranialElectrodes" class="col-xs-3 control-label">
                    <spring:message code="label.intracranialElectrodes"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="intracranialElectrodes" id="intracranialElectrodes" type="text"
                                 class="form-control">
                        <form:option value="0">
                            <spring:message code="label.intracranialElectrodes.0"/>
                        </form:option>
                        <form:option value="1">
                            <spring:message code="label.intracranialElectrodes.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.intracranialElectrodes.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.intracranialElectrodes.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.intracranialElectrodes.4"/>
                        </form:option>
                        <form:option value="5">
                            <spring:message code="label.intracranialElectrodes.5"/>
                        </form:option>
                        <form:option value="6">
                            <spring:message code="label.intracranialElectrodes.6"/>
                        </form:option>
                        <form:option value="7">
                            <spring:message code="label.intracranialElectrodes.7"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="localizationIntracranialElectrodes" class="col-xs-3 control-label">
                    <spring:message code="label.localizationIntracranialElectrodes"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea path="localizationIntracranialElectrodes" id="localizationIntracranialElectrodes"
                                   class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="intracranialElectrodes" class="col-xs-3 control-label">
                    <spring:message code="label.invasiveEegSlowing"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="invasiveEegSlow" id="invasiveEegSlow" type="text" class="form-control">
                        <form:option value="0">
                            <spring:message code="label.invasiveEegSlowing.0"/>
                        </form:option>
                        <form:option value="1">
                            <spring:message code="label.invasiveEegSlowing.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.invasiveEegSlowing.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.invasiveEegSlowing.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.invasiveEegSlowing.4"/>
                        </form:option>
                        <form:option value="5">
                            <spring:message code="label.invasiveEegSlowing.5"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <jsp:include page="invasiveEegOptionsView.jsp">
                <jsp:param name="labelName" value="invasiveEegInterictalSpikes"/>
                <jsp:param name="propertyName" value="invasiveEegInterictalSpikes"/>
            </jsp:include>

            <div class="form-group">
                <label for="localizationInvasiveEegInterictalSpikes" class="col-xs-3 control-label">
                    <spring:message code="label.localizationInvasiveEegInterictalSpikes"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea path="localizationInvasiveEegInterictalSpikes"
                                   id="localizationInvasiveEegInterictalSpikes" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="invasiveEegStatusEpilepticus" class="col-xs-3 control-label">
                    <spring:message code="label.invasiveEegStatusEpilepticus"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="invasiveEegStatusEpilepticus" id="invasiveEegStatusEpilepticus"/>
                    <form:errors path="invasiveEegStatusEpilepticus" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <jsp:include page="invasiveEegOptionsView.jsp">
                <jsp:param name="labelName" value="invasiveIctalEegPatterns"/>
                <jsp:param name="propertyName" value="invasiveIctalEegPatterns"/>
            </jsp:include>

            <div class="form-group">
                <label for="localizationInvasiveIctalEegPatterns" class="col-xs-3 control-label">
                    <spring:message code="label.localizationInvasiveIctalEegPatterns"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea path="localizationInvasiveIctalEegPatterns"
                                   id="localizationInvasiveIctalEegPatterns" class="form-control"/>
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
</t:menuLVL2>