<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors" class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
        <c:if test="${dateBeforeEpiBeginning}">
            <br>
            <span id="date.errors" class="text-danger">
                 <spring:message code="label.cannotBeBeforeEpiBeginning"/>
            </span>
        </c:if>
    </div>
</div>

<div class="form-group">
    <label for="seizureFrequency" class="col-xs-4 control-label">
        <spring:message code="label.seizureFrequency"/>*
    </label>

    <div class="col-xs-8">
        <form:select path="seizureFrequency" id="seizureFrequency" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.seizureFrequency.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.seizureFrequency.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.seizureFrequency.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.seizureFrequency.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.seizureFrequency.4"/>
            </form:option>
        </form:select>
        <form:errors path="seizureFrequency" cssClass="text-danger"/>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="secondarilyGeneralizedSeizure"/>
    <jsp:param name="messageCode" value="secondarilyGeneralizedSeizure"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="statusEpilepticus"/>
    <jsp:param name="messageCode" value="statusEpilepticus"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="nonepilepticSeizures"/>
    <jsp:param name="messageCode" value="nonepilepticSeizures"/>
</jsp:include>


<div class="form-group">
    <label for="seizureOccurrence" class="col-xs-4 control-label">
        <spring:message code="label.occurrence"/>
    </label>

    <div class="col-xs-8">

        <div class="radio">
            <label>
                <form:radiobutton path="seizureOccurrence" value="1" checked="true"/>
                <spring:message code="label.seizureOccurence.1"/>
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="seizureOccurrence" value="2"/>
                <spring:message code="label.seizureOccurence.2"/>
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="seizureOccurrence" value="3"/>
                <spring:message code="label.seizureOccurence.3"/>
            </label>
        </div>
    </div>
</div>

<div class="form-group">
    <label for="comment" class="col-xs-4 control-label">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
    </div>
</div>