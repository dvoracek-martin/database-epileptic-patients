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
    <label class="col-xs-4 control-label" for="sscClassification">
        <spring:message code="label.sscClassification"/>
    </label>

    <div class="col-xs-8">
        <form:select path="sscClassification" id="sscClassification" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.sscClassification.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.sscClassification.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.sscClassification.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.sscClassification.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.sscClassification.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.sscClassification.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.sscClassification.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.sscClassification.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.sscClassification.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.sscClassification.9"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.sscClassification.10"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.sscClassification.11"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.sscClassification.12"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.sscClassification.13"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.sscClassification.14"/>
            </form:option>
            <form:option value="15">
                <spring:message code="label.sscClassification.15"/>
            </form:option>
            <form:option value="16">
                <spring:message code="label.sscClassification.16"/>
            </form:option>
            <form:option value="17">
                <spring:message code="label.sscClassification.17"/>
            </form:option>
            <form:option value="18">
                <spring:message code="label.sscClassification.18"/>
            </form:option>
            <form:option value="19">
                <spring:message code="label.sscClassification.19"/>
            </form:option>
            <form:option value="20">
                <spring:message code="label.sscClassification.20"/>
            </form:option>
            <form:option value="21">
                <spring:message code="label.sscClassification.21"/>
            </form:option>
            <form:option value="22">
                <spring:message code="label.sscClassification.22"/>
            </form:option>
            <form:option value="23">
                <spring:message code="label.sscClassification.23"/>
            </form:option>
            <form:option value="24">
                <spring:message code="label.sscClassification.24"/>
            </form:option>
            <form:option value="25">
                <spring:message code="label.sscClassification.25"/>
            </form:option>
            <form:option value="26">
                <spring:message code="label.sscClassification.26"/>
            </form:option>
            <form:option value="27">
                <spring:message code="label.sscClassification.27"/>
            </form:option>
            <form:option value="28">
                <spring:message code="label.sscClassification.28"/>
            </form:option>
            <form:option value="29">
                <spring:message code="label.sscClassification.29"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="ilaeClassification">
        <spring:message code="label.ilaeClassification"/>
    </label>

    <div class="col-xs-8">
        <form:select path="ilaeClassification" id="ilaeClassification" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.ilaeClassification.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.ilaeClassification.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.ilaeClassification.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.ilaeClassification.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.ilaeClassification.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.ilaeClassification.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.ilaeClassification.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.ilaeClassification.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.ilaeClassification.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.ilaeClassification.9"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.ilaeClassification.10"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.ilaeClassification.11"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.ilaeClassification.12"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.ilaeClassification.13"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.ilaeClassification.14"/>
            </form:option>
            <form:option value="15">
                <spring:message code="label.ilaeClassification.15"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="comment">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
    </div>
</div>