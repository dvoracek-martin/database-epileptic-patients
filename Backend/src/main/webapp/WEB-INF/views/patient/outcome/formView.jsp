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
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.outcome"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <%-- mapping resource in action with c:url caused errors --%>
        <form:form class="form-horizontal" role="form" method="POST"
                   action="/GENEPI/patient/${patient.id}/outcome/save" commandName="outcome">

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
                <label for="seizureOutcome" class="col-xs-3 control-label">
                    <spring:message code="label.rangeOperations"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="seizureOutcome" id="seizureOutcome" type="text" class="form-control">

                        <form:option value="1">
                            <spring:message code="label.seizureOutcome.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.seizureOutcome.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.seizureOutcome.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.seizureOutcome.4"/>
                        </form:option>
                        <form:option value="5">
                            <spring:message code="label.seizureOutcome.5"/>
                        </form:option>
                        <form:option value="6">
                            <spring:message code="label.seizureOutcome.6"/>
                        </form:option>
                        <form:option value="7">
                            <spring:message code="label.seizureOutcome.7"/>
                        </form:option>
                        <form:option value="8">
                            <spring:message code="label.seizureOutcome.8"/>
                        </form:option>
                        <form:option value="9">
                            <spring:message code="label.seizureOutcome.9"/>
                        </form:option>
                        <form:option value="10">
                            <spring:message code="label.seizureOutcome.10"/>
                        </form:option>
                        <form:option value="11">
                            <spring:message code="label.seizureOutcome.11"/>
                        </form:option>
                        <form:option value="12">
                            <spring:message code="label.seizureOutcome.12"/>
                        </form:option>
                        <form:option value="13">
                            <spring:message code="label.seizureOutcome.13"/>
                        </form:option>
                        <form:option value="14">
                            <spring:message code="label.seizureOutcome.14"/>
                        </form:option>

                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="outcomeAed" class="col-xs-3 control-label">
                    <spring:message code="label.aed"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="aed" id="outcomeAed" type="text" class="form-control">

                        <form:option value="1">
                            <spring:message code="label.outcomeAed.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.outcomeAed.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.outcomeAed.3"/>
                        </form:option>

                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="outcomeEeg" class="col-xs-3 control-label">
                    <spring:message code="label.eeg"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="eeg" id="outcomeEeg" type="text" class="form-control">

                        <form:option value="1">
                            <spring:message code="label.outcomeEeg.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.outcomeEeg.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.outcomeEeg.3"/>
                        </form:option>

                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="outcomeMri" class="col-xs-3 control-label">
                    <spring:message code="label.mri"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="mri" id="outcomeMri" type="text" class="form-control">

                        <form:option value="1">
                            <spring:message code="label.done.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.done.2"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="outcomeNeuropsychology" class="col-xs-3 control-label">
                    <spring:message code="label.neuropsychology"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="neuropsychology" id="outcomeNeuropsychology" type="text" class="form-control">

                        <form:option value="1">
                            <spring:message code="label.done.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.done.2"/>
                        </form:option>
                    </form:select>
                </div>
            </div>



            <div class="form-group">
                <label for="operationDetails" class="col-xs-3 control-label">
                    <spring:message code="label.operationDetails"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea path="operationDetails" id="operationDetails" class="form-control"/>
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

            <input type="hidden" name="distance" value="${distance}">

            <input type="hidden" name="operationId" value="${operation}">

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

<%--
        <div class="control-group">
            <label class="control-label" for="seizureOutcome"><strong>Seizure outcome</strong></label>

            <div class="controls">
                <form:select path="seizureOutcome" id="seizureOutcome" type="text" class="input-large">
                    <form:option value="1">
                        0
                    </form:option>
                    <form:option value="2">
                        IA
                    </form:option>
                    <form:option value="3">
                        IB
                    </form:option>
                    <form:option value="4">
                        IC
                    </form:option>
                    <form:option value="5">
                        ID
                    </form:option>
                    <form:option value="6">
                        IIA
                    </form:option>
                    <form:option value="7">
                        IIB
                    </form:option>
                    <form:option value="8">
                        IIC
                    </form:option>
                    <form:option value="9">
                        IID
                    </form:option>
                    <form:option value="10">
                        IIIA
                    </form:option>
                    <form:option value="11">
                        IIIB
                    </form:option>
                    <form:option value="12">
                        IV
                    </form:option>
                    <form:option value="13">
                        V
                    </form:option>
                    <form:option value="14">
                        VI
                    </form:option>
                </form:select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="aed"><strong>AED</strong></label>

            <div class="controls">
                <form:select path="aed" id="aed" type="text" class="input-large">
                    <form:option value="1">
                        <spring:message code="label.notDropped"/>
                    </form:option>
                    <form:option value="2">
                        <spring:message code="label.dropped"/>
                    </form:option>
                    <form:option value="3">
                        <spring:message code="label.reduced"/>
                    </form:option>
                </form:select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="eeg"><strong>EEG</strong></label>

            <div class="controls">
                <form:select path="eeg" id="eeg" type="text" class="input-large">
                    <form:option value="1">
                        <spring:message code="label.notDone"/>
                    </form:option>
                    <form:option value="2">
                        <spring:message code="label.spikes"/>
                    </form:option>
                    <form:option value="3">
                        <spring:message code="label.noSpikes"/>
                    </form:option>
                </form:select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="mri"><strong>MRI</strong></label>

            <div class="controls">
                <form:select path="mri" id="mri" type="text" class="input-large">
                    <form:option value="1">
                        <spring:message code="label.notDone"/>
                    </form:option>
                    <form:option value="2">
                        <spring:message code="label.done"/>
                    </form:option>
                </form:select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="neuropsychology"><strong><spring:message
                    code="label.neuropsychology"/></strong></label>

            <div class="controls">
                <form:select path="neuropsychology" id="neuropsychology" type="text" class="input-large">
                    <form:option value="1">
                        <spring:message code="label.notDone"/>
                    </form:option>
                    <form:option value="2">
                        <spring:message code="label.done"/>
                    </form:option>
                </form:select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="comment"><strong><spring:message code="label.comment"/></strong></label>

            <div class="controls">
                <form:textarea path="comment" id="comment"/>
            </div>
        </div>

        <input type="hidden" name="distance" value="${distance}">

        <input type="hidden" name="operationId" value="${operation}">

---%>