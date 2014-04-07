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

<%--<div class="form-group">
    <label for="date" class="col-xs-4 control-label">
        <spring:message code="label.beginningEpilepsy"/>
    </label>

    <div class="col-xs-8">
        <c:choose>
            <c:when test="${empty anamnesis.beginningEpilepsy}">
                <div class='input-group date datepicker-simple'>
                    <form:input path="beginningEpilepsy" id="date" type="text" class="input-sm form-control"
                                autocomplete="off"/>
                    <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <form:input path="beginningEpilepsy" id="date" type="text" class="input-sm form-control"
                            disabled="true"/>
            </c:otherwise>
        </c:choose>
        <form:errors path="beginningEpilepsy" cssClass="text-danger"/>
    </div>
</div>--%>

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
        <form:select path="specificSyndrome" id="specificSyndrome" type="text" class="form-control input-sm">
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
    <label for="nonCnsComorbidity" class="col-xs-4 control-label">
        <spring:message code="label.nonCnsComorbidity"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="nonCnsComorbidity" id="nonCnsComorbidity" class="form-control resize-vertical"/>
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