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
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="aed">
        <spring:message code="label.aed"/>*
    </label>

    <div class="col-xs-8">
        <form:select path="aed" id="aed" type="text" class="form-control input-sm">
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
        <form:errors path="aed" cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="efficiency">
        <spring:message code="label.efficiency"/>
    </label>

    <div class="col-xs-8">
        <form:select path="efficiency" id="efficiency" type="text" class="form-control input-sm">
            <form:option value="1">
                <spring:message code="label.efficiency.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.efficiency.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="duringSurgery"/>
    <jsp:param name="messageCode" value="duringSurgery"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label" for="comment">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
    </div>
</div>