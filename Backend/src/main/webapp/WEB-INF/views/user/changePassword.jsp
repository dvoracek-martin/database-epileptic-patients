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
        <script src="<c:url value="/resources/custom/js/passwordValidation.js" />"></script>
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
        <form:form class="form-horizontal" method="POST" action="/GENEPI/user/${user.id}/change-password"
                   commandName="user">

            <div class="form-group">
                <label for="newPassword" class="col-xs-3 control-label">
                    <spring:message code="label.newPassword"/>
                </label>

                <div class="col-xs-8">
                    <form:input path="password" id="newPassword" type="password" pattern=".{8,128}"
                                class="form-control"/>
                    <form:errors path="password" cssClass="text-danger">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="newPasswordAgain" class="col-xs-3 control-label">
                    <spring:message code="label.passwordAgain"/>
                </label>

                <div class="col-xs-8">
                    <input name="passwordAgain" id="newPasswordAgain" type="password" pattern=".{8,128}"
                           class="form-control"/>
                    <c:if test="${not samePasswords}">
                        <span class="text-danger"><spring:message code="label.samePasswords"/> </span>
                    </c:if>
                </div>
            </div>


            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.change"/>
                    </button>
                </div>
            </div>

        </form:form>
    </jsp:body>
</t:menuLVL1>