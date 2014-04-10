<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label class="col-xs-4 control-label" for="${param.propertyName}">
        <spring:message code="label.${param.messageCode}"/>
    </label>

    <c:choose>
        <c:when test="${toCheck}">
            <div class="col-xs-8">
                <form:radiobutton id="${param.propertyName}1" path="${param.propertyName}" value="1"/>
                <label for="${param.propertyName}1">
                    <spring:message code="label.yes"/>
                </label>

                <form:radiobutton id="${param.propertyName}2" path="${param.propertyName}" value="2"/>
                <label for="${param.propertyName}2">
                    <spring:message code="label.no"/>
                </label>

                <form:radiobutton id="${param.propertyName}3" path="${param.propertyName}" value="3" checked="true"/>

                <label for="${param.propertyName}3">
                    <spring:message code="label.notDistinguish"/>
                </label>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-xs-8 radios">
                <form:radiobutton id="${param.propertyName}1" path="${param.propertyName}" value="1"/>
                <label for="${param.propertyName}1">
                    <spring:message code="label.yes"/>
                </label>

                <form:radiobutton id="${param.propertyName}2" path="${param.propertyName}" value="2"/>
                <label for="${param.propertyName}2">
                    <spring:message code="label.no"/>
                </label>

                <form:radiobutton id="${param.propertyName}3" path="${param.propertyName}" value="3"/>

                <label for="${param.propertyName}3">
                    <spring:message code="label.notDistinguish"/>
                </label>
            </div>
        </c:otherwise>
    </c:choose>
</div>