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
           for="done">
        <spring:message code="label.diagnosticTestMri"/>
    </label>

    <div class="col-xs-8">
        <form:select id="done"
                     class="input-sm form-control"
                     type="text"
                     path="done">
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-done">

<jsp:include page="resultTypeOptionsView.jsp">
    <jsp:param name="labelName"
               value="mriFinding"/>
    <jsp:param name="propertyName"
               value="mriFinding"/>
</jsp:include>

<div class="form-group">
    <label for="mriDescription" class="col-xs-4 control-label">
        <spring:message code="label.descriptionMri"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="mriDescription"
                       class="form-control resize-vertical"
                       path="mriDescription"/>
    </div>
</div>

<jsp:include page="resultTypeOptionsView.jsp">
    <jsp:param name="labelName"
               value="fdgPet"/>
    <jsp:param name="propertyName"
               value="fdgPet"/>
</jsp:include>

<div class="form-group">
    <label for="descriptionPetHypometabolism" class="col-xs-4 control-label">
        <spring:message code="label.fdgPet"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="descriptionPetHypometabolism"
                       class="form-control resize-vertical"
                       path="descriptionPetHypometabolism"/>
    </div>
</div>

<jsp:include page="resultTypeOptionsView.jsp">
    <jsp:param name="labelName"
               value="interictalSpect"/>
    <jsp:param name="propertyName"
               value="interictalSpect"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="descriptionSpectHypoperfuse">
        <spring:message code="label.descriptionSpectHypoperfuse"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="descriptionSpectHypoperfuse"
                       class="form-control resize-vertical"
                       path="descriptionSpectHypoperfuse"/>
    </div>
</div>

<jsp:include page="resultTypeOptionsView.jsp">
    <jsp:param name="labelName"
               value="ictalSpect"/>
    <jsp:param name="propertyName"
               value="ictalSpect"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="descriptionSpectHypoperfuse">
        <spring:message code="label.descriptionSpectHyperperfuse"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="descriptionSpectHyperperfuse"
                       class="form-control resize-vertical"
                       path="descriptionSpectHyperperfuse"/>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName"
               value="siscom"/>
    <jsp:param name="messageCode"
               value="siscom"/>
</jsp:include>

<div class="form-group">
    <label for="mrsProtocol" class="col-xs-4 control-label">
        <spring:message code="label.mrsProtocol"/>
    </label>

    <div class="col-xs-8">
        <form:select id="mrsProtocol"
                     class="input-sm form-control"
                     type="text"
                     path="mrsProtocol">
            <form:option value="0">
                <spring:message code="label.mrsProtocol.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.mrsProtocol.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.mrsProtocol.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.mrsProtocol.3"/>
            </form:option>
        </form:select>
    </div>
</div>

<jsp:include page="resultTypeOptionsView.jsp">
    <jsp:param name="labelName"
               value="mrsFinding"/>
    <jsp:param name="propertyName"
               value="mrsFinding"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="descriptionMrsAbnormality">
        <spring:message code="label.descriptionMrsAbnormality"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="descriptionMrsAbnormality"
                       class="form-control resize-vertical"
                       path="descriptionMrsAbnormality"/>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName"
               value="fmri"/>
    <jsp:param name="messageCode"
               value="fmri"/>
</jsp:include>


<div class="form-group">
    <label class="col-xs-4 control-label"
           for="detailsFmri">
        <spring:message code="label.fmriDetails"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="detailsFmri"
                       class="form-control resize-vertical"
                       path="detailsFmri"/>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName"
               value="dti"/>
    <jsp:param name="messageCode"
               value="dti"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="detailsDtiStudy">
        <spring:message code="label.dtiStudyDetails"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="detailsDtiStudy"
                       class="form-control"
                       path="detailsDtiStudy"/>
    </div>
</div>

<jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName"
               value="wada"/>
    <jsp:param name="messageCode"
               value="wada"/>
</jsp:include>

<div class="form-group">
    <label for="detailsWada" class="col-xs-4 control-label">
        <spring:message code="label.wadaDetails"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="detailsWada"
                       class="form-control resize-vertical"
                       path="detailsWada"/>
    </div>
</div>


<div class="form-group">
    <label for="comment" class="col-xs-4 control-label">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea id="comment"
                       class="form-control resize-vertical"
                       path="comment"/>
    </div>
</div>
</div>