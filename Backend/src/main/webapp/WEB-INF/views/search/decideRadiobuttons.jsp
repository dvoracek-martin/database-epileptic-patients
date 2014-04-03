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
                <form:radiobutton path="${param.propertyName}" value="1"/> <spring:message code="label.yes"/>
                <form:radiobutton path="${param.propertyName}" value="2"/> <spring:message code="label.no"/>

                <form:radiobutton path="${param.propertyName}" value="3" checked="true"/> <spring:message
                    code="label.notDistinguish"/>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-xs-8 radios">
                <form:radiobutton path="${param.propertyName}" value="1"/> <spring:message code="label.yes"/>
                <form:radiobutton path="${param.propertyName}" value="2"/> <spring:message code="label.no"/>

                <form:radiobutton path="${param.propertyName}" value="3"/> <spring:message
                    code="label.notDistinguish"/>
            </div>
        </c:otherwise>
    </c:choose>
</div>