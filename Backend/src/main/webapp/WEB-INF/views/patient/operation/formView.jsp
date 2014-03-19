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
        <div class='input-group date datepicker-simple'>
            <form:input path="date" id="date" type="text" class="input-sm form-control" autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date" cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label for="dateOfOperation" class="col-xs-4 control-label">
        <spring:message code="label.dateOfOperation"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input path="dateOperation" id="dateOfOperation" type="text" class="input-sm form-control"
                        autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="dateOperation" cssClass="text-danger"/>
    </div>
</div>


<div id="section-done" class="section-hide">
    <div class="form-group">
        <label for="operationType" class="col-xs-4 control-label">
            <spring:message code="label.typeOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:select path="typeOperation" id="operationType" type="text" class="input-sm form-control">
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
            <form:select path="rangeOperation" id="operationRange" type="text" class="input-sm form-control">
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

    <div class="form-group">
        <label for="localizationOperation" class="col-xs-4 control-label">
            <spring:message code="label.localizationOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationOperation" id="localizationOperation"
                           class="form-control resize-vertical"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="mst"/>
        <jsp:param name="messageCode" value="mst"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="colostomy"/>
        <jsp:param name="messageCode" value="calosotomy"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="vns"/>
        <jsp:param name="messageCode" value="vns"/>
    </jsp:include>


    <div class="form-group">
        <label for="vnsImplantationDate" class="col-xs-4 control-label">
            <spring:message code="label.vnsImplantationDate"/>
        </label>

        <div class="col-xs-8">
            <div class='input-group date datepicker-simple'>
                <form:input path="vnsImplantationDate" id="vnsImplantationDate" type="text"
                            class="input-sm form-control"
                            autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
            </div>
            <form:errors path="vnsImplantationDate" cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="operationDetails" class="col-xs-4 control-label">
            <spring:message code="label.operationDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="operationDetails" id="operationDetails" class="form-control resize-vertical"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="completeResection"/>
        <jsp:param name="messageCode" value="completeResection"/>
    </jsp:include>

    <div class="form-group">
        <label for="comment" class="col-xs-4 control-label">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
        </div>
    </div>
</div>