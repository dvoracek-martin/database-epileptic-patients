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
    <label for="done" class="col-xs-4 control-label">
        <spring:message code="label.diagnosticTestMri"/>
    </label>

    <div class="col-xs-8">
        <form:select path="done" id="done" type="text" class="form-control">
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
        <jsp:param name="labelName" value="mriFinding"/>
        <jsp:param name="propertyName" value="mriFinding"/>
    </jsp:include>

    <div class="form-group">
        <label for="mriDescription" class="col-xs-4 control-label">
            <spring:message code="label.descriptionMri"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="mriDescription" id="mriDescription" class="form-control resize-vertical"/>
        </div>
    </div>


    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="fdgPet"/>
        <jsp:param name="propertyName" value="fdgPet"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionPetHypometabolism" class="col-xs-4 control-label">
            <spring:message code="label.fdgPet"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionPetHypometabolism" id="descriptionPetHypometabolism" class="form-control resize-vertical"/>
        </div>
    </div>


    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="interictalSpect"/>
        <jsp:param name="propertyName" value="interictalSpect"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionSpectHypoperfuse" class="col-xs-4 control-label">
            <spring:message code="label.descriptionSpectHypoperfuse"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionSpectHypoperfuse" id="descriptionSpectHypoperfuse" class="form-control resize-vertical"/>
        </div>
    </div>


    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="ictalSpect"/>
        <jsp:param name="propertyName" value="ictalSpect"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionSpectHypoperfuse" class="col-xs-4 control-label">
            <spring:message code="label.descriptionSpectHyperperfuse"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionSpectHyperperfuse" id="descriptionSpectHyperperfuse" class="form-control resize-vertical"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="siscom"/>
        <jsp:param name="messageCode" value="siscom"/>
    </jsp:include>

    <div class="form-group">
        <label for="mrsProtocol" class="col-xs-4 control-label">
            <spring:message code="label.mrsProtocol"/>
        </label>

        <div class="col-xs-8">
            <form:select path="mrsProtocol" id="mrsProtocol" type="text" class="form-control">
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
        <jsp:param name="labelName" value="mrsFinding"/>
        <jsp:param name="propertyName" value="mrsFinding"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionMrsAbnormality" class="col-xs-4 control-label">
            <spring:message code="label.descriptionMrsAbnormality"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionMrsAbnormality" id="descriptionMrsAbnormality" class="form-control resize-vertical"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="fmri"/>
        <jsp:param name="messageCode" value="fmri"/>
    </jsp:include>


    <div class="form-group">
        <label for="detailsFmri" class="col-xs-4 control-label">
            <spring:message code="label.fmriDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="detailsFmri" id="detailsFmri" class="form-control resize-vertical"/>
        </div>
    </div>


    <div class="form-group">
        <label for="fmri" class="col-xs-4 control-label">pro
            <spring:message code="label.dti"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="dti" id="dti"/>
            <form:errors path="dti" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="detailsDtiStudy" class="col-xs-4 control-label">
            <spring:message code="label.dtiStudyDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="detailsDtiStudy" id="detailsDtiStudy" class="form-control"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
    <jsp:param name="propertyName" value="wada"/>
    <jsp:param name="messageCode" value="wada"/>
</jsp:include>


    <div class="form-group">
        <label for="detailsWada" class="col-xs-4 control-label">
            <spring:message code="label.wadaDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="detailsWada" id="detailsWada" class="form-control resize-vertical"/>
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
</div>