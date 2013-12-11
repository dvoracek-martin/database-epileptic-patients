<%@ tag description="menu LVL3" pageEncoding="UTF-8"%>

<%-- Taglib section --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<%-- Attribute section --%>
<%@ attribute name="title" fragment="true"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="script" fragment="true"%>

<%-- Template section --%>
<t:menuLVL1.NEW303>

	<jsp:attribute name="title">
		<%-- Hook for filling title of page --%>
	<jsp:invoke fragment="title" />
	</jsp:attribute>

	<jsp:attribute name="head">
		<%-- Hook for adding something to HEAD --%>
	<jsp:invoke fragment="head" />
	</jsp:attribute>


	<jsp:attribute name="menuLVL2">
	<div class="panel panel-default">
					<div class="panel-heading">
				<spring:message code="label.patient" />: ${patient.contact.firstName } ${patient.contact.lastName }
			</div>
					<div class="panel-body">
						<ul >
						<li><a
						href="<c:url value="/patient/${patient.id}/overview" />">Přehled</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/anamnesis/list" />">Anamnéza</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/seizure/list" />">Záchvaty</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">Farmakoterapie</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/neurologicalFinding/list" />">Neurologické nálezy</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">Neuropsychologie</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/neuropsychology-old/list" />">Neuropsychologie - Old</a></li>
					<li>Diagnostické testy
					
						<ul>
							<li><a
								href="<c:url value="/patient/${patient.id}/diagnosticTestScalpEEG/list" />">Skalpové EEG</a></li>
							<li><a
								href="<c:url value="/patient/${patient.id}/diagnosticTestMRI/list" />">Neurozobraz. testy</a></li>
						</ul>
					</li>
					<li>Invazivní testy
					
						<ul>
							<li><a
								href="<c:url value="/patient/${patient.id}/invasiveTestECOG/list" />">ECoG</a></li>
							<li><a
								href="<c:url value="/patient/${patient.id}/invasiveTestEEG/list" />">iEEG</a></li>
							<li><a
								href="<c:url value="/patient/${patient.id}/invasiveTestCorticalMapping/list" />">Kortikální mapování</a></li>
						</ul>
					</li>
					<li><a
						href="<c:url value="/patient/${patient.id}/operation/list" />">Operace</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/histology/list" />">Histologie</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/complication/list" />">Komplikace</a></li>
					<li><a
						href="<c:url value="/patient/${patient.id}/outcome/list" />">Outcome</a></li>
						</ul>
					</div>
				</div>					
	</jsp:attribute>

	<jsp:attribute name="script">
		<%-- Hook for adding something to Script section --%>
	<jsp:invoke fragment="script" />
	</jsp:attribute>

	<jsp:body>
        <jsp:doBody />
    </jsp:body>

</t:menuLVL1.NEW303>