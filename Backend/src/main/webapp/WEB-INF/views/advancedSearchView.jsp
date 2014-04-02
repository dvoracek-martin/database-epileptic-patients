<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.advancedSearch"/>
    </jsp:attribute>

<jsp:body>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.advancedSearch"/>
        </h2>
    </div>
    <div class="col-xs-6">
    </div>
</div>

<form:form class="form-horizontal"
           method="POST"
           action="/GENEPI/advanced-search"
           role="form"
           commandName="advancedSearch">

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


<fieldset>
    <legend>
        <spring:message code="label.generalParametersSpecificPerson"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientGender">
            <spring:message code="label.firstname"/>patientGender
        </label>

        <div class="col-xs-8">
            <form:radiobutton path="patientGender" value="1"/>Male
            <form:radiobutton path="patientGender" value="2"/>Female
            <form:radiobutton path="patientGender" value="3" checked="true"/>Nerozlisovat
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeFilter">
            <spring:message code="label.firstname"/>patientAgeFilter
        </label>

        <div class="col-xs-8">
            <form:select id="patientAgeFilter"
                         class="form-control input-sm"
                         type="text"
                         path="patientAgeFilter">

                <form:option value="=">
                    =
                </form:option>
                <form:option value=">">
                    >
                </form:option>
                <form:option value="<">
                    <
                </form:option>
                <form:option value=">=">
                    >=
                </form:option>
                <form:option value="<=">
                    <=
                </form:option>
            </form:select>
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAge">
            <spring:message code="label.firstname"/>patientAge
        </label>

        <div class="col-xs-8">
            <form:input id="patientAge"
                        class="form-control input-sm"
                        type="text"
                        path="patientAge"/>

            <form:errors path="patientAge"
                         cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeEpilepsyFilter"><strong><spring:message
                code="label.firstname"/>patientAgeEpilepsyFilter</strong></label>

        <div class="col-xs-8">
            <form:select id="patientAgeEpilepsyFilter"
                         class="form-control input-sm"
                         type="text"
                         path="patientAgeEpilepsyFilter">

                <form:option value="=">=</form:option>
                <form:option value=">">
                    >
                </form:option>
                <form:option value="<">
                    <
                </form:option>
                <form:option value=">=">
                    >=
                </form:option>
                <form:option value="<=">
                    <=
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeEpilepsy">
            <spring:message code="label.firstname"/>patientAgeEpilepsy
        </label>

        <div class="col-xs-8">
            <form:input id="patientAgeEpilepsy"
                        class="form-control input-sm"
                        type="text"
                        path="patientAgeEpilepsy"/>

            <form:errors path="patientAgeEpilepsy"
                         cssClass="error">
            </form:errors>
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientDoctor">
            <spring:message code="label.doctor"/>
        </label>

        <div class="col-xs-8">
            <form:select id="patientDoctor"
                         class="form-control input-sm"
                         type="text"
                         path="patientDoctor">

                <form:option value="0">
                    Nezvoleno
                </form:option>
                <c:forEach items="${doctors}" var="doctor">
                    <form:option value="${doctor.id}">
                        ${doctor.contact.firstName} ${doctor.contact.lastName}
                    </form:option>
                </c:forEach>
            </form:select>
        </div>
    </div>

</fieldset>

<div class="form-group">
    <div class="col-xs-offset-4 col-xs-8">
        <button class="btn btn-primary" type="submit">
            <spring:message code="label.search"/>
        </button>
    </div>
</div>

</form:form>

</jsp:body>
</t:menuLVL1>