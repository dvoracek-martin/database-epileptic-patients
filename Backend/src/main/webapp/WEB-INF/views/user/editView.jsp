<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

    <jsp:attribute name="head">

    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.editUser"/>
    </jsp:attribute>

	<jsp:attribute name="script">

    </jsp:attribute>

    <jsp:body>

        <h2>
            <spring:message code="label.editUser"/>
            <c:choose>
                <c:when test="${isAdmin}">
                    <a href="<c:url value="/user/${user.id}/overview" />">${user.username}</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/profile" />">${user.username}</a>
                </c:otherwise>
            </c:choose>
        </h2>

        <form:form class="form-horizontal"
                   action="/GENEPI/user/${user.id}/edit"
                   method="POST"
                   commandName="user">

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
                        <spring:message code="label.save"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL1>