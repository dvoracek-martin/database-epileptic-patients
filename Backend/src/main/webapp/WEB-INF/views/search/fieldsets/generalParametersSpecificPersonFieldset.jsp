<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset>
    <legend>
        <spring:message code="label.generalParametersSpecificPerson"/>
    </legend>

    <div class="form-group">
        <label for="patientFirstname" class="col-xs-4 control-label">
            <spring:message code="label.firstname"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientFirstname"
                        class="form-control input-sm"
                        type="text"
                        path="patientFirstname"/>

            <form:errors path="patientFirstname"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientLastname" class="col-xs-4 control-label">
            <spring:message code="label.lastname"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientLastname"
                        class="form-control input-sm"
                        type="text"
                        path="patientLastname"/>

            <form:errors path="patientLastname"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientLastname" class="col-xs-4 control-label">
            <spring:message code="label.nin"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientNin"
                        class="form-control input-sm"
                        type="text"
                        path="patientNin"/>

            <form:errors path="patientNin"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientCity" class="col-xs-4 control-label">
            <spring:message code="label.addressCity"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientCity"
                        class="form-control input-sm"
                        type="text"
                        path="patientCity"/>

            <form:errors path="patientCity"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientCountry" class="col-xs-4 control-label">
            <spring:message code="label.addressCountry"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientCountry"
                        class="form-control input-sm"
                        type="text"
                        path="patientCountry"/>

            <form:errors path="patientCountry"
                         cssClass="text-danger"/>
        </div>
    </div>

</fieldset>