<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="dateBeforeBirth"
             scope="request"
             type="java.lang.Boolean"/>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="date">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input id="date"
                        class="input-sm form-control"
                        type="text"
                        autocomplete="off"
                        path="date"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date"
                     cssClass="text-danger"/>
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors"
                  class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="dateOfOperation">
        <spring:message code="label.dateOfOperation"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input id="dateOfOperation"
                        class="input-sm form-control"
                        type="text"
                        autocomplete="off"
                        path="dateOperation"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="dateOperation"
                     cssClass="text-danger"/>
    </div>
</div>


<div id="section-done" class="section-hide">
    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="operationType">
            <spring:message code="label.typeOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:select id="operationType"
                         class="input-sm form-control"
                         type="text"
                         path="typeOperation">
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
        <label class="col-xs-4 control-label"
               for="operationRange">
            <spring:message code="label.rangeOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:select id="operationRange"
                         class="input-sm form-control"
                         type="text"
                         path="rangeOperation">
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
        <label class="col-xs-4 control-label"
               for="localizationOperation">
            <spring:message code="label.localizationOfOperation"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="localizationOperation"
                           class="form-control resize-vertical"
                           path="localizationOperation"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="mst"/>
        <jsp:param name="messageCode"
                   value="mst"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="colostomy"/>
        <jsp:param name="messageCode"
                   value="calosotomy"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="vns"/>
        <jsp:param name="messageCode"
                   value="vns"/>
    </jsp:include>


    <div class="form-group">
        <label class="col-xs-4 control-label"
            for="vnsImplantationDate">
            <spring:message code="label.vnsImplantationDate"/>
        </label>

        <div class="col-xs-8">
            <div class='input-group date datepicker-simple'>
                <form:input id="vnsImplantationDate"
                            class="input-sm form-control"
                            type="text"
                            autocomplete="off"
                            path="vnsImplantationDate"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
            </div>
            <form:errors path="vnsImplantationDate"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="operationDetails">
            <spring:message code="label.operationDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="operationDetails"
                           class="form-control resize-vertical"
                           path="operationDetails"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="completeResection"/>
        <jsp:param name="messageCode"
                   value="completeResection"/>
    </jsp:include>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="comment">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="comment"
                           class="form-control resize-vertical"
                           path="comment"/>
        </div>
    </div>
</div>