<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:layout>

	<jsp:attribute name="title">
      <spring:message code="label.permissionDenied"/>
    </jsp:attribute>

    <jsp:body>
        <h1><spring:message code="label.permissionDenied"/></h1>
    </jsp:body>
</t:layout>