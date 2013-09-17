<%@ tag description="menu LVL3" pageEncoding="UTF-8"%>

<!-- taglib section -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<!-- attribute section -->
<%@ attribute name="title" fragment="true"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="script" fragment="true"%>

<!-- template section -->
<t:menuLVL2>
	<jsp:attribute name="title">
	<jsp:invoke fragment="title" />
	</jsp:attribute>
	<jsp:attribute name="head">
	<jsp:invoke fragment="head" />
	</jsp:attribute>
	<jsp:attribute name="header">
	<jsp:invoke fragment="header" />
	</jsp:attribute>
	<jsp:attribute name="menuLVL3">
				<ul class="nav nav-list">
					<li class="nav-header">Číslo pacienta:</li>
					<li><a
					href="<c:url value="/patient/${patient.id}/overview" />">Přehled</a></li>
					<li><a
					href="<c:url value="/patient/${patient.id}/anamnesis/list" />">Anamnéza</a></li>
					<li><a href="underConstruction">Farmakoterapie</a></li>
					<li><a href="underConstruction">Neurologické nálezy</a></li>
					<li><a href="underConstruction">Neuropsychologie</a></li>
					<li><a href="underConstruction">(Neuropsychologie - old)</a></li>
					<li><a href="underConstruction">Diagnostické testy</a></li>
					<li><a href="underConstruction">Neuropsychologie</a></li>
					<li>
						<ul>
							<li><a href="underConstruction">Skalpové EEG</a></li>
							<li><a href="underConstruction">Neurozobraz. testy</a></li>
						</ul>
					</li>
					<li><a href="underConstruction">Invazivní testy</a></li>
					<li>
						<ul>
							<li><a href="underConstruction">ECoG</a></li>
							<li><a href="underConstruction">iEEG</a></li>
							<li><a href="underConstruction">Kortikalní mapovaní</a></li>
						</ul>
					</li>
					<li><a href="underConstruction">Operace</a></li>
					<li><a href="underConstruction">Komplikace</a></li>
					<li><a href="underConstruction">Outcome</a></li>
				</ul>
	</jsp:attribute>

	<jsp:attribute name="script">
	<jsp:invoke fragment="script" />
	</jsp:attribute>

	<jsp:body>
        <jsp:doBody />
    </jsp:body>

</t:menuLVL2>