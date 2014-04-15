<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="dateBeforeBirth"
             scope="request"
             type="java.lang.Boolean"/>

<div class="form-group">
    <label for="date" class="col-xs-4 control-label">
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
        <form:errors path="date" cssClass="text-danger"/>
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors" class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="epilepsyInFamily"/>
    <jsp:param name="messageCode" value="epilepsyInFamily"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="prenatalRisk"/>
    <jsp:param name="messageCode" value="prenatalRisk"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="fibrilConvulsions"/>
    <jsp:param name="messageCode" value="fibrilConvulsions"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="inflammationCns"/>
    <jsp:param name="messageCode" value="inflammationCns"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="injuryCns"/>
    <jsp:param name="messageCode" value="injuryCns"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="earlyPmdRetardation"/>
    <jsp:param name="messageCode" value="earlyPmdRetardation"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="firstFever"/>
    <jsp:param name="messageCode" value="firstFever"/>
</jsp:include>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="infantileSpasm"/>
    <jsp:param name="messageCode" value="infantileSpasm"/>
</jsp:include>

<div class="form-group">
    <label for="specificSyndrome" class="col-xs-4 control-label">
        <spring:message code="label.epilepticSyndrome"/>
    </label>

    <div class="col-xs-8">
        <form:select id="specificSyndrome"
                     class="form-control input-sm"
                     type="text"
                     path="specificSyndrome">
            <form:option value="0">
                <spring:message code="label.specificSyndrome.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.specificSyndrome.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.specificSyndrome.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.specificSyndrome.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.specificSyndrome.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.specificSyndrome.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.specificSyndrome.6"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="nonCnsComorbidity">
        <spring:message code="label.nonCnsComorbidity"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="nonCnsComorbidity"
                       class="form-control resize-vertical"
                       path="nonCnsComorbidity"/>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="comment">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="comment"
                       class="form-control resize-vertical"
                       path="comment"/>
    </div>
</div>