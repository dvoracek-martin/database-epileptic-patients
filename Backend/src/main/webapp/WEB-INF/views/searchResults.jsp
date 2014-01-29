<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

	<jsp:attribute name="title">
      Search Results
    </jsp:attribute>
	<jsp:attribute name="header">
      
    </jsp:attribute>

    <jsp:body>
        <c:forEach items="${patients}" var="patient">
            ${patient.contact.firstName}
        </c:forEach>
    </jsp:body>
</t:menuLVL2>