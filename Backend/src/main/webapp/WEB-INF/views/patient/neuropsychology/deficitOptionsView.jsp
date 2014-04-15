<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="${param.propertyName}">
        <spring:message code="label.${param.labelName}"/>
    </label>

    <div class="col-xs-8">
        <form:select id="${param.propertyName}"
                     class="form-control"
                     type="text"
                     path="${param.propertyName}">
            <form:option value="1">
                <spring:message code="label.deficit.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.deficit.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.deficit.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.deficit.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.deficit.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.deficit.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.deficit.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.deficit.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.deficit.9"/>
            </form:option>
        </form:select>
    </div>
</div>