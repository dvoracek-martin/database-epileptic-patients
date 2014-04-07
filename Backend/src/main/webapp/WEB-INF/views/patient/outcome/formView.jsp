<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-4 control-label">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input path="date" id="date" type="text" class="input-sm form-control" autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date" cssClass="text-danger"/>
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors" class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
    </div>
</div>

<div class="form-group">
    <label for="seizureOutcome" class="col-xs-4 control-label">
        <spring:message code="label.seizureOutcome"/>*
    </label>

    <div class="col-xs-8">
        <form:select path="seizureOutcome" id="seizureOutcome" type="text" class="form-control input-sm">

            <form:option value="0">
                <spring:message code="label.seizureOutcome.0"/>
            </form:option>
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
        <form:errors path="seizureOutcome" cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label for="outcomeAed" class="col-xs-4 control-label">
        <spring:message code="label.aed"/>
    </label>

    <div class="col-xs-8">
        <form:select path="aed" id="outcomeAed" type="text" class="form-control input-sm">

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
    <label for="outcomeEeg" class="col-xs-4 control-label">
        <spring:message code="label.eeg"/>
    </label>

    <div class="col-xs-8">
        <form:select path="eeg" id="outcomeEeg" type="text" class="form-control input-sm">

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
    <label for="outcomeMri" class="col-xs-4 control-label">
        <spring:message code="label.mri"/>
    </label>

    <div class="col-xs-8">
        <form:select path="mri" id="outcomeMri" type="text" class="form-control input-sm">

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
    <label for="outcomeNeuropsychology" class="col-xs-4 control-label">
        <spring:message code="label.neuropsychology"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychology" id="outcomeNeuropsychology" type="text" class="form-control input-sm">

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
    <label for="comment" class="col-xs-4 control-label">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
    </div>
</div>

<input type="hidden" name="distance" value="${distance}">

<input type="hidden" name="operationId" value="${operation}">

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