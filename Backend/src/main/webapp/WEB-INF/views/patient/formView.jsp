<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="contact.firstName" class="col-xs-3 control-label">
        <spring:message code="label.firstname"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.firstName" type="text" class="form-control" id="contact.firstName"/>
        <form:errors path="contact.firstName" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.lastName" class="col-xs-3 control-label">
        <spring:message code="label.lastname"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.lastName" type="text" class="form-control" id="contact.lastName"/>
        <form:errors path="contact.firstName" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="birthday" class="col-xs-3 control-label">
        <spring:message code="label.birthdate"/>
    </label>

    <div class="col-xs-8">
        <form:input path="birthday" type="text" class="form-control datepicker" id="birthday"/>
        <form:errors path="birthday" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="nin" class="col-xs-3 control-label">
        <spring:message code="label.idnumber"/>
    </label>

    <div class="col-xs-8">
        <form:input path="nin" type="text" class="form-control" id="nin"/>
        <form:errors path="nin" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="gender" class="col-xs-3 control-label">
        <spring:message code="label.gender"/>
    </label>

    <div class="col-xs-8">


        <div class="radio">
            <label>
                <form:radiobutton path="gender" value="1" checked="true"/> <spring:message code="label.male"/>
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="gender" value="2"/> <spring:message code="label.female"/>
            </label>
        </div>
    </div>
</div>

<div class="form-group">
    <label for="contact.addressStreet" class="col-xs-3 control-label">
        <spring:message code="label.street"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.addressStreet" type="text" class="form-control" id="contact.addressStreet"/>
        <form:errors path="contact.addressStreet" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.addressHn" class="col-xs-3 control-label">
        <spring:message code="label.addressHn"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.addressHn" type="text" class="form-control" id="contact.addressHn"/>
        <form:errors path="contact.addressHn" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.addressCity" class="col-xs-3 control-label">
        <spring:message code="label.addressCity"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.addressCity" type="text" class="form-control" id="contact.addressCity"/>
        <form:errors path="contact.addressCity" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.addressPostalcode" class="col-xs-3 control-label">
        <spring:message code="label.addressPostalcode"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.addressPostalcode" type="text" class="form-control"
                    id="contact.addressPostalcode"/>
        <form:errors path="contact.addressPostalcode" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.addressCountry" class="col-xs-3 control-label">
        <spring:message code="label.addressCountry"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.addressCountry" type="text" class="form-control" id="contact.addressCountry"
                    list="countries"/>
        <form:errors path="contact.addressCountry" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.phoneNumber" class="col-xs-3 control-label">
        <spring:message code="label.telephone"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.phoneNumber" type="text"
                    class="form-control" id="contact.phoneNumber"/>
        <form:errors path="contact.phoneNumber" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="contact.email" class="col-xs-3 control-label">
        <spring:message code="label.email"/>
    </label>

    <div class="col-xs-8">
        <form:input path="contact.email" type="text"
                    class="form-control" id="contact.email"/>
        <form:errors path="contact.email" cssClass="error"/>
    </div>
</div>

<div class="form-group">
    <label for="doctorId" class="col-xs-3 control-label">
        <spring:message code="label.doctor"/>
    </label>

    <div class="col-xs-8">

        <form:select path="doctorId" class="form-control" id="doctorId">
            <c:if test="${!empty doctors}">
                <c:forEach items="${doctors}" var="doctor">
                    <form:option
                            value="${doctor.id}"> ${doctor.contact.firstName} ${doctor.contact.lastName}</form:option>
                </c:forEach>
            </c:if>
        </form:select>


        <%--
        <form:select path="doctorId" class="form-control" id="doctorId">
            <c:forEach items="${doctors}" var="doctor">
                <c:choose>
                    <c:when test="${doctor.id == patient.doctorId}">
                        <option value="${doctor.id}"
                                selected="true"> ${doctor.contact.firstName} ${doctor.contact.lastName}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${doctor.id}"> ${doctor.contact.firstName} ${doctor.contact.lastName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>--%>
    </div>
</div>