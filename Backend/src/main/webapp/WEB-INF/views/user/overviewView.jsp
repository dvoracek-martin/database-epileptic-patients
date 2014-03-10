<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="title">
      <spring:message code="label.profile"/>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.myProfile"/>
                </h2>

            </div>

        </div>

        <spring:message code="label.userID"/>
        &nbsp;
        <div class="label label-info">${user.id}</div>
        <br>

        <spring:message code="label.username"/>
        &nbsp;
        <div class="label label-info">${user.username}</div>
        <br>

        <spring:message code="label.firstname"/>
        &nbsp;
        <div class="label label-info">${user.contact.firstName}</div>
        <br>

        <spring:message code="label.lastname"/>
        &nbsp;
        <div class="label label-info">${user.contact.lastName}</div>
        <br>

        <spring:message code="label.street"/>
        &nbsp;
        <div class="label label-info">${user.contact.addressStreet}</div>
        <br>

        <spring:message code="label.addressHn"/>
        &nbsp;
        <div class="label label-info">${user.contact.addressHn}</div>
        <br>

        <spring:message code="label.addressCity"/>
        &nbsp;
        <div class="label label-info">${user.contact.addressCity}</div>
        <br>

        <spring:message code="label.addressPostalcode"/>
        &nbsp;
        <div class="label label-info">${user.contact.addressPostalcode}</div>
        <br>

        <spring:message code="label.addressCountry"/>
        &nbsp;
        <div class="label label-info">${user.contact.addressCountry}</div>
        <br>

        <spring:message code="label.telephone"/>
        &nbsp;
        <div class="label label-info">${user.contact.phoneNumber}</div>
        <br>

        <spring:message code="label.email"/>
        &nbsp;
        <div class="label label-info">${user.contact.email}</div>
        <br> <input type="button" class="btn btn-small btn-primary"
                    onclick="document.location = '<c:url value="/user/${user.id}/edit"/>';"
                    value="<spring:message code="label.editData" />"> <input
            type="button" class="btn btn-small btn-primary"
            onclick="document.location = '<c:url value="/user/${user.id}/change-password"/>';"
            value="<spring:message code="label.changePassword" />">

    </jsp:body>
</t:menuLVL1>




