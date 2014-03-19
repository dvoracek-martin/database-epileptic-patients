<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="${param.propertyName}" class="col-xs-4 control-label">
        <spring:message code="label.${param.labelName}"/>
    </label>

    <div class="col-xs-8">
        <form:select path="${param.propertyName}" id="${param.propertyName}" type="text"
                     class="form-control">
            <form:option value="0">
                <spring:message code="label.invasiveEeg.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.invasiveEeg.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.invasiveEeg.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.invasiveEeg.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.invasiveEeg.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.invasiveEeg.5"/>
            </form:option>
        </form:select>
    </div>
</div>
