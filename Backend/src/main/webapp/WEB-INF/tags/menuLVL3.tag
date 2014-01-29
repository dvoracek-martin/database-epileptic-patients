<%@ tag description="menu LVL3" pageEncoding="UTF-8" %>

<!-- taglib section -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!-- attribute section -->
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="script" fragment="true" %>

<!-- template section -->
<t:menuLVL2>
	<jsp:attribute name="title">
	<jsp:invoke fragment="title"/>
	</jsp:attribute>
	<jsp:attribute name="head">
	<jsp:invoke fragment="head"/>
	</jsp:attribute>
	<jsp:attribute name="header">
	<jsp:invoke fragment="header"/>
	</jsp:attribute>
	<jsp:attribute name="menuLVL3">
				<ul class="nav nav-list">
                    <li class="nav-header">Číslo pacienta:</li>
                    <li><a
                            href="<c:url value="/patient/${patient.id}/overview" />">Přehled</a></li>
                    <li><a
                            href="<c:url value="/patient/${patient.id}/anamnesis/list" />">Anamnéza</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/seizure/list" />">Záchvaty</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">Farmakoterapie</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/neurologicalFinding/list" />">Neurologické
                        nálezy</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">Neuropsychologie</a>
                    </li>
                    <li><a href="<c:url value="/patient/${patient.id}/neuropsychology-old/list" />">Neuropsychologie -
                        Old</a></li>
                    <li style="color: DodgerBlue">Diagnostické testy</li>
                    <li>
                        <ul>
                            <li><a href="<c:url value="/patient/${patient.id}/diagnosticTestScalpEEG/list" />">Skalpové
                                EEG</a></li>
                            <li><a href="<c:url value="/patient/${patient.id}/diagnosticTestMRI/list" />">Neurozobraz.
                                testy</a></li>
                        </ul>
                    </li>
                    <li style="color: DodgerBlue">Invazivní testy</li>
                    <li>
                        <ul>
                            <li><a href="<c:url value="/patient/${patient.id}/invasiveTestECOG/list" />">ECoG</a></li>
                            <li><a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/list" />">iEEG</a></li>
                            <li><a href="<c:url value="/patient/${patient.id}/invasiveTestCorticalMapping/list" />">Kortikální
                                mapování</a></li>
                        </ul>
                    </li>
                    <li><a href="<c:url value="/patient/${patient.id}/operation/list" />">Operace</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/histology/list" />">Histologie</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/complication/list" />">Komplikace</a></li>
                    <li><a href="<c:url value="/patient/${patient.id}/outcome/list" />">Outcome</a></li>
                </ul>
	</jsp:attribute>

	<jsp:attribute name="script">
	<jsp:invoke fragment="script"/>
	</jsp:attribute>

    <jsp:body>
        <jsp:doBody/>
    </jsp:body>

</t:menuLVL2>