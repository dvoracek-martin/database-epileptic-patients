<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="head">

    </jsp:attribute>
	<jsp:attribute name="title">

    </jsp:attribute>
	<jsp:attribute name="script">
        <script src="<c:url value="/resources/custom/js/change-password.js" />"></script>
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
                   action="/GENEPI/user/${user.id}/change-password"
                   method="POST"
                   commandName="user">

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="newPassword">
                    <spring:message code="label.newPassword"/>
                </label>

                <div class="col-xs-8">
                    <form:input id="newPassword"
                                class="form-control"
                                type="password"
                                path="password"/>
                    <form:errors path="password"
                                 cssClass="text-danger">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="newPasswordAgain">
                    <spring:message code="label.passwordAgain"/>
                </label>

                <div class="col-xs-8">
                    <input id="newPasswordAgain"
                           class="form-control"
                           type="password"
                           name="passwordAgain"
                           pattern=".{8,128}"/>
                    <c:if test="${not samePasswords}">
                        <span class="text-danger">
                            <spring:message code="label.samePasswords"/>
                        </span>
                    </c:if>
                </div>
            </div>


            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-primary"
                            type="submit">
                        <spring:message code="label.change"/>
                    </button>
                </div>
            </div>

        </form:form>
    </jsp:body>
</t:menuLVL1>