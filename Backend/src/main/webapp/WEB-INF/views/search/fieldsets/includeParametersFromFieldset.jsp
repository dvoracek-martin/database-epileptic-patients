<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset>
    <legend>
        <spring:message code="label.includeParametersFrom"/>
    </legend>

    <div class="checkbox col-xs-offset-4">
        <label>
            <input id="checkAll" type="checkbox">  <spring:message code="label.checkUncheckAll"/>
        </label>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="anamnesis"/>
        <jsp:param name="messageCode"
                   value="anamnesis"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="seizure"/>
        <jsp:param name="messageCode"
                   value="seizures"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="pharmacotherapy"/>
        <jsp:param name="messageCode"
                   value="pharmacotherapy"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="neurologicalFinding"/>
        <jsp:param name="messageCode"
                   value="neurologicalFinding"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="neuropsychology"/>
        <jsp:param name="messageCode"
                   value="neuropsychology"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="diagnosticTestScalpEeg"/>
        <jsp:param name="messageCode"
                   value="diagnosticTestScalpEeg"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="diagnosticTestMri"/>
        <jsp:param name="messageCode"
                   value="diagnosticTestMri"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="invasiveTestEeg"/>
        <jsp:param name="messageCode"
                   value="invasiveTestIeeg"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="invasiveTestEcog"/>
        <jsp:param name="messageCode"
                   value="invasiveTestECoG"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="invasiveTestCorticalMapping"/>
        <jsp:param name="messageCode"
                   value="invasiveTestCorticalMapping"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="operation"/>
        <jsp:param name="messageCode"
                   value="operation"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="histology"/>
        <jsp:param name="messageCode"
                   value="histology"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="complication"/>
        <jsp:param name="messageCode"
                   value="complication"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="outcome"/>
        <jsp:param name="messageCode"
                   value="outcome"/>
        <jsp:param name="className"
                   value="check-all"/>
    </jsp:include>

</fieldset>