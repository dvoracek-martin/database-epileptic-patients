<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      <spring:message code="label.cardFile" />
    </jsp:attribute>
	<jsp:attribute name="header">
     <spring:message code="label.cardFile" />
    </jsp:attribute>

	<jsp:body>
	<div class="span5">
					<h2>
						<spring:message code="label.cardFile" />
					</h2>
				</div>
				<div>
					<h3>
						<a href="<c:url value="/patient/create" />"
					style="text-decoration: none"><spring:message
						code="label.addpatient" /></a>
					</h3>
				</div>


				<c:forEach items="${patientList}" var="patient">


					<div class="navbar">
						<div class="navbar-inner">
							<a class="brand"
						href="<c:url value="/patient/${patient.id}/overview" />">${patient.contact.firstName}
								${patient.contact.lastName}</a>
							<ul class="nav">
								<li class="divider-vertical"><a
							href="<c:url value="/patient/${patient.id}/anamnesis/list" />"><spring:message
									code="label.anamnesis" /></a></li>
								<li class="divider-vertical"><a
							href="<c:url value="/patient/${patient.id}/export" />"><spring:message
									code="label.export" /></a></li>
								<li class="divider-vertical"><a
							href="<c:url value="/underConstruction" />"><spring:message
									code="label.edit" /></a></li>
							</ul>
						</div>
					</div>

				</c:forEach>
	</jsp:body>
</t:menuLVL2>



