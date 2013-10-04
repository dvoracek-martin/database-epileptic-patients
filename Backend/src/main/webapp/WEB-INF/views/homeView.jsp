<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      Domovská stránka
    </jsp:attribute>
	<jsp:attribute name="header">
      PŘEHLED
    </jsp:attribute>
    
	<jsp:body>
	<div style="border-bottom: 2px solid black">
		<h1>
			<spring:message code="label.news" />
		</h1>
	</div>
	<sec:authorize ifAnyGranted="ROLE_USER">
		<div style="margin: 10px">
			<c:forEach items="${news}" var="message">
			<div style="border-bottom: 2px solid black">
				<h3>${message.date }</h3>
				<p>${message.message }</p>
			</div>
			</c:forEach>
		</div>
	</sec:authorize>
</jsp:body>
</t:menuLVL2>