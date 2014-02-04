<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <div class="col-sm-offset-4 col-sm-8">
        <div class="checkbox">
            <label>
                <form:checkbox path="${param.propertyName}" id="${param.propertyName}"/>
                <spring:message code="label.${param.messageCode}"/>
            </label>
        </div>
    </div>
</div>