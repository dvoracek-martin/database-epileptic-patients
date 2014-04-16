<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="toCheck" scope="request" type="java.lang.Boolean"/>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="${param.propertyName}">
        <spring:message code="label.${param.messageCode}"/>
    </label>

    <div class="col-xs-8">
        <form:radiobutton id="${param.propertyName}1"
                          value="1"
                          path="${param.propertyName}"/>

        <label for="${param.propertyName}1">
            <spring:message code="label.yes"/>
        </label>

        <form:radiobutton id="${param.propertyName}2"
                          value="2"
                          path="${param.propertyName}"/>

        <label for="${param.propertyName}2">
            <spring:message code="label.no"/>
        </label>

        <c:choose>
            <c:when test="${toCheck}">

                <form:radiobutton id="${param.propertyName}3"
                                  value="3"
                                  checked="true"
                                  path="${param.propertyName}"/>

            </c:when>
            <c:otherwise>

                <form:radiobutton id="${param.propertyName}3"
                                  value="3"
                                  path="${param.propertyName}"/>

            </c:otherwise>
        </c:choose>

        <label for="${param.propertyName}3">
            <spring:message code="label.notDistinguish"/>
        </label>

    </div>
</div>