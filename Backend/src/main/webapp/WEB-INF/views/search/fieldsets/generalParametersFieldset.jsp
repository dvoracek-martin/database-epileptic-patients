<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="doctors"
             scope="request"
             type="java.util.List"/>

<fieldset>
    <legend>
        <spring:message code="label.generalParameters"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientGender">
            <spring:message code="label.gender"/>
        </label>

        <div id="patientGender" class="col-xs-8">

            <form:radiobutton id="patientGender1" path="patientGender" value="1"/>
            <label for="patientGender1">
                <spring:message code="label.male"/>
            </label>

            <form:radiobutton id="patientGender2" path="patientGender" value="2"/>
            <label for="patientGender2">
                <spring:message code="label.female"/>
            </label>

            <form:radiobutton id="patientGender3" path="patientGender" value="3" checked="true"/>
            <label for="patientGender3">
                <spring:message code="label.notDistinguish"/>
            </label>
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeFilter">
            <spring:message code="label.ageFilter"/>
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
            <spring:message code="label.age"/>
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
        <label class="col-xs-4 control-label" for="patientAgeEpilepsyFilter">
            <spring:message code="label.ageEpilepsyFilter"/>
        </label>

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
            <spring:message code="label.ageAtTheBeginningOfEpilepsy"/>
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

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="verified"/>
        <jsp:param name="messageCode" value="verified"/>
    </jsp:include>

</fieldset>