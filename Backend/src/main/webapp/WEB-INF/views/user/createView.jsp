<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

    <jsp:attribute name="head">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.addUser"/>
    </jsp:attribute>
	<jsp:attribute name="script">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.addUser"/>
                </h2>
            </div>
        </div>

        <form:form class="form-horizontal" method="POST" action="/GENEPI/user/create" commandName="user">


            <div class="form-group">
                <label for="username" class="col-xs-3 control-label">
                    <spring:message code="label.username"/>*
                </label>

                <div class="col-xs-8">
                    <form:input path="username" type="text" class=" form-control input-sm" id="username"/>
                    <form:errors path="username" cssClass="text-danger"/>
                    <c:if test="${not uniqueUsername}">
                        <span class="text-danger"><spring:message code="label.nonUnique"/></span>
                    </c:if>
                </div>
            </div>

            <div class="form-group">
                <label for="contact.lastName" class="col-xs-3 control-label">
                    <spring:message code="label.lastname"/>*
                </label>

                <div class="col-xs-8">
                    <form:input path="contact.lastName" type="text" class=" form-control input-sm"
                                id="contact.lastName"/>
                    <form:errors path="contact.lastName" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label for="contact.firstName" class="col-xs-3 control-label">
                    <spring:message code="label.firstname"/>*
                </label>

                <div class="col-xs-8">
                    <form:input path="contact.firstName" type="text" class=" form-control input-sm"
                                id="contact.firstName"/>
                    <form:errors path="contact.firstName" cssClass="text-danger"/>
                </div>
            </div>


            <%-- Do we really want this information??? add country list if true
                    <form:label path="contact.addressStreet">
                        <spring:message code="label.street"/>
                    </form:label>
                    <form:input id="addressStreet" path="contact.addressStreet"
                                type="text" pattern=".{0,30}" class="input-block-level"
                                onchanged="addressStreetValidation();"
                                title="Nesmí přesáhnout délku 30 znaků."/>
                    <form:errors path="contact.addressStreet" cssClass="alert alert-error"/>
                    <div id="addressStreetErr" class="alert alert-error"
                         style="display: none">Je delší jak 30 znaků!
                    </div>

                    <form:label path="contact.addressHn">
                        <spring:message code="label.addressHn"/>
                    </form:label>
                    <form:input id="addressHn" path="contact.addressHn" type="text"
                                pattern=".{0,10}" class="input-block-level"
                                onchange="addressHnValidation();"
                                title="Nesmí přesáhnout délku 10 znaků."/>
                    <form:errors path="contact.addressHn" cssClass="alert alert-error"/>
                    <div id="addressHnErr" class="alert alert-error" style="display: none">Je
                        delší jak 10 znaků!
                    </div>

                    <form:label path="contact.addressCity">
                        <spring:message code="label.addressCity"/>
                    </form:label>
                    <form:input id="addressCity" path="contact.addressCity" type="text"
                                pattern=".{0,30}" class="input-block-level"
                                onchange="addressCityValidation();"
                                title="Nesmí přesáhnout délku 30 znaků."/>
                    <form:errors path="contact.addressCity" cssClass="alert alert-error"/>
                    <div id="addressCityErr" class="alert alert-error"
                         style="display: none">Je delší jak 30 znaků!
                    </div>

                    <form:label path="contact.addressPostalcode">
                        <spring:message code="label.addressPostalcode"/>
                    </form:label>
                    <form:input id="addressPostalcode" path="contact.addressPostalcode"
                                type="text" pattern="\d{0,10}" class="input-block-level"
                                onchange="addressPostalcodeValidation();"
                                title="Smí obsahovat pouze číslce. Nesmí přesáhnout délku 10 číslic."/>
                    <form:errors path="contact.addressPostalcode"
                                 cssClass="alert alert-error"/>
                    <div id="addressPostalcodeErr" class="alert alert-error"
                         style="display: none">Je delší jak 10 znaků!
                    </div>

                    <form:label path="contact.addressCountry">
                        <spring:message code="label.addressCountry"/>
                    </form:label>
                    <form:input path="contact.addressCountry" type="text"
                                class="input-block-level" list="countries"/>
                    <form:errors path="contact.addressCountry" cssClass="error"/>

            --%>

            <div class="form-group">
                <label for="contact.email" class="col-xs-3 control-label">
                    <spring:message code="label.email"/>*
                </label>

                <div class="col-xs-8">
                    <form:input path="contact.email" type="email" class=" form-control input-sm" id="contact.email"/>
                    <form:errors path="contact.email" cssClass="text-danger"/>
                    <c:if test="${not uniqueEmail}">
                        <span class="text-danger"><spring:message code="label.nonUnique"/></span>
                    </c:if>
                </div>
            </div>

            <div class="form-group">
                <label for="contact.phoneNumber" class="col-xs-3 control-label">
                    <spring:message code="label.telephone"/>
                </label>

                <div class="col-xs-8">
                    <form:input path="contact.phoneNumber" type="text" class=" form-control input-sm"
                                id="contact.phoneNumber"/>
                    <form:errors path="contact.phoneNumber" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-small btn-primary" type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL1>