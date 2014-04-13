<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="operationFieldset">
    <legend>
        <spring:message code="label.operation"/>
    </legend>

    <div class="form-group">
        <label for="operationType" class="col-xs-4 control-label">
            <spring:message code="label.typeOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:select path="operationTypeOperation" id="operationType" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.operationType.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.operationType.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.operationType.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.operationType.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.operationType.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.operationType.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.operationType.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.operationType.7"/>
                </form:option>
                <form:option value="8">
                    <spring:message code="label.operationType.8"/>
                </form:option>
                <form:option value="9">
                    <spring:message code="label.operationType.9"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="operationRange" class="col-xs-4 control-label">
            <spring:message code="label.rangeOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:select path="operationRangeOperation" id="operationRange" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.operationRange.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.operationRange.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.operationRange.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.operationRange.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.operationRange.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.operationRange.5"/>
                </form:option>

            </form:select>
        </div>
    </div>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="operationMst"/>
        <jsp:param name="messageCode" value="mst"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="operationColostomy"/>
        <jsp:param name="messageCode" value="calosotomy"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="operationVns"/>
        <jsp:param name="messageCode" value="vns"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="operationCompleteResection"/>
        <jsp:param name="messageCode" value="completeResection"/>
    </jsp:include>

</fieldset>