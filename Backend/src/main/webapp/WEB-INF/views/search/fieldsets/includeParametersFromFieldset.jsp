<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset>
    <legend>
        <spring:message code="label.includeParametersFrom"/>
    </legend>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="anamnesis"/>
        <jsp:param name="messageCode" value="anamnesis"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="seizure"/>
        <jsp:param name="messageCode" value="seizures"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="pharmacotherapy"/>
        <jsp:param name="messageCode" value="pharmacotherapy"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="neurologicalFinding"/>
        <jsp:param name="messageCode" value="neurologicalFinding"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="neuropsychology"/>
        <jsp:param name="messageCode" value="neuropsychology"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="diagnosticTestScalpEeg"/>
        <jsp:param name="messageCode" value="diagnosticTestScalpEeg"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMri"/>
        <jsp:param name="messageCode" value="diagnosticTestMri"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="invasiveTestEeg"/>
        <jsp:param name="messageCode" value="invasiveTestIeeg"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="invasiveTestEcog"/>
        <jsp:param name="messageCode" value="invasiveTestECoG"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="operation"/>
        <jsp:param name="messageCode" value="operation"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="histology"/>
        <jsp:param name="messageCode" value="histology"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="complication"/>
        <jsp:param name="messageCode" value="complication"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="outcome"/>
        <jsp:param name="messageCode" value="outcome"/>
    </jsp:include>

</fieldset>