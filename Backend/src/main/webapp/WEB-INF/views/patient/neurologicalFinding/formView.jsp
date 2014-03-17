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
        <div class='input-group date datepicker-today'>
            <form:input path="date" id="date" type="text" class="input-sm form-control" autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="hemisphereDominance" class="col-xs-4 control-label">
        <spring:message code="label.hemisphereDominance"/>
    </label>

    <div class="col-xs-8">
        <form:select path="hemisphereDominance" id="hemisphereDominance" type="text"
                     class="input-sm form-control">
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