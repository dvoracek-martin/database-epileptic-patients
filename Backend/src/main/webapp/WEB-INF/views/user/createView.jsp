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

        <form:form class="form-horizontal"
                   action="/GENEPI/user/create"
                   method="POST"
                   commandName="user">


            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="username">
                    <spring:message code="label.username"/>*
                </label>

                <div class="col-xs-8">
                    <form:input id="username"
                                class="form-control input-sm"
                                type="text"
                                path="username"/>
                    <form:errors path="username"
                                 cssClass="text-danger"/>
                    <c:if test="${not uniqueUsername}">
                        <span class="text-danger">
                            <spring:message code="label.nonUnique"/>
                        </span>
                    </c:if>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="contact.lastName">
                    <spring:message code="label.lastname"/>*
                </label>

                <div class="col-xs-8">
                    <form:input id="contact.lastName"
                                class=" form-control input-sm"
                                type="text"
                                path="contact.lastName"/>
                    <form:errors path="contact.lastName"
                                 cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="contact.firstName">
                    <spring:message code="label.firstname"/>*
                </label>

                <div class="col-xs-8">
                    <form:input id="contact.firstName"
                                class=" form-control input-sm"
                                type="text"
                                path="contact.firstName"/>
                    <form:errors path="contact.firstName"
                                 cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="contact.email">
                    <spring:message code="label.email"/>*
                </label>

                <div class="col-xs-8">
                    <form:input id="contact.email"
                                class="form-control input-sm"
                                type="email"
                                path="contact.email"/>
                    <form:errors path="contact.email"
                                 cssClass="text-danger"/>
                    <c:if test="${not uniqueEmail}">
                        <span class="text-danger">
                            <spring:message code="label.nonUnique"/>
                        </span>
                    </c:if>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="contact.phoneNumber">
                    <spring:message code="label.telephone"/>
                </label>

                <div class="col-xs-8">
                    <form:input id="contact.phoneNumber"
                                class=" form-control input-sm"
                                type="text"
                                path="contact.phoneNumber"/>
                    <form:errors path="contact.phoneNumber"
                                 cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-small btn-primary"
                            type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL1>