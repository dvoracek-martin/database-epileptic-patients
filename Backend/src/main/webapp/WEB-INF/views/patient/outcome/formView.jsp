<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="dateBeforeBirth"
             scope="request"
             type="java.lang.Boolean"/>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="date">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input id="date"
                        class="input-sm form-control"
                        type="text"
                        autocomplete="off"
                        path="date"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date"
                     cssClass="text-danger"/>
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors"
                  class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="seizureOutcome">
        <spring:message code="label.seizureOutcome"/>*
    </label>

    <div class="col-xs-8">
        <form:select id="seizureOutcome"
                     class="form-control input-sm"
                     type="text"
                     path="seizureOutcome">

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
        <form:errors path="seizureOutcome"
                     cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="outcomeAed">
        <spring:message code="label.aed"/>
    </label>

    <div class="col-xs-8">
        <form:select id="outcomeAed"
                     class="form-control input-sm"
                     type="text"
                     path="aed">

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
    <label class="col-xs-4 control-label"
           for="outcomeEeg">
        <spring:message code="label.eeg"/>
    </label>

    <div class="col-xs-8">
        <form:select id="outcomeEeg"
                     class="form-control input-sm"
                     type="text"
                     path="eeg">

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
    <label class="col-xs-4 control-label"
           for="outcomeMri">
        <spring:message code="label.mri"/>
    </label>

    <div class="col-xs-8">
        <form:select id="outcomeMri"
                     class="form-control input-sm"
                     type="text"
                     path="mri">

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
    <label class="col-xs-4 control-label"
           for="outcomeNeuropsychology">
        <spring:message code="label.neuropsychology"/>
    </label>

    <div class="col-xs-8">
        <form:select id="outcomeNeuropsychology"
                     class="form-control input-sm"
                     type="text"
                     path="neuropsychology">

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
    <label class="col-xs-4 control-label"
           for="comment">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="comment"
                       class="form-control resize-vertical"
                       path="comment"/>
    </div>
</div>

<input type="hidden"
       name="distance"
       value="${distance}">

<input type="hidden"
       name="operationId"
       value="${operation}">