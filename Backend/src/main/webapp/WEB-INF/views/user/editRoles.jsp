<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="head">
         <link href="<c:url value="/resources/custom/css/custom.css" />"
               rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.editRoles"/>
    </jsp:attribute>

	<jsp:attribute name="script">
        <script src="<c:url value="/resources/jquery-ui/js/jquery-ui.min.js" />"></script>
	    <script src="<c:url value="/resources/custom/js/edit-roles.js" />"></script>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.editRoles"/>
                    <a href="<c:url value="/user/${user.id}/overview"/>">
                            ${user.username}
                    </a>
                </h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 col-lg-6">
                <label>
                    <spring:message code="label.availableRoles"/>
                </label>
                <ul id="sortable1"
                    class="connected sortable panel-body role-list">
                    <c:forEach var="possibleRole"
                               items="${possibleRoles}">
                        <li draggable>
                                ${possibleRole.authority}
                            <input type="hidden"
                                   name="role"
                                   value="${possibleRole.id}">
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="col-md-12 col-lg-6">
                <label>
                    <spring:message code="label.assignedRoles"/>
                </label>

                <form:form id="role-form"
                           action="/GENEPI/user/${user.id }/edit-roles"
                           method="POST"
                           role="form">

                    <ul id="sortable2"
                        class="connected sortable role-list">
                        <c:forEach var="role"
                                   items="${user.roles}">
                            <li draggable>
                                    ${role.authority}
                                <input type="hidden"
                                       name="role"
                                       value="${role.id}">
                            </li>
                        </c:forEach>
                    </ul>
                </form:form>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12">
                <button class="btn btn-primary"
                        type="submit"
                        form="role-form">
                    <spring:message code="label.save"/>
                </button>
            </div>
        </div>
    </jsp:body>
</t:menuLVL1>