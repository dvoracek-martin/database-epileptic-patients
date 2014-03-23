<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="heading" class="col-xs-4 control-label">
        <spring:message code="label.heading"/>
    </label>

    <div class="col-xs-8">
        <form:input path="heading" type="text" class=" form-control input-sm" id="heading"/>
        <form:errors path="heading" cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label for="message" class="col-xs-4 control-label">
        <spring:message code="label.message"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="message" id="message" class="form-control resize-vertical"/>
    </div>
</div>