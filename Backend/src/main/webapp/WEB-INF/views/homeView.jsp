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
			<div style="border-bottom: 2px solid black">
				<h3>12.5.2013</h3>
				<p>Podpora pro širší škálu prohlížečů byla doplněna.</p>
			</div>

			<div style="border-bottom: 2px solid black">
				<h3>10.9.2013</h3>
				<p>Beta verze byla předvedena.</p>
			</div>
		</div>
	</sec:authorize>
</jsp:body>
</t:menuLVL2>