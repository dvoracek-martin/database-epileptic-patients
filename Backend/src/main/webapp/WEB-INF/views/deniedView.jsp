<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="title">
      <spring:message code="label.permissionDenied"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.permissionDenied"/>
    </jsp:attribute>

    <jsp:body>

        <div style="width: 330px; margin: auto; padding-top: 10em">
            <div class="span6">
                <img class="photo1" width=2560 height=1600
                     src="<c:url value="/resources/img/watch_out.png"/>"/>
            </div>

        </div>
    </jsp:body>
</t:menuLVL1>


