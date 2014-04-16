<%@ tag description="menu LVL3" pageEncoding="UTF-8" %>

<%-- Taglib section --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<%-- Attribute section --%>
<%@ attribute name="title"
              fragment="true" %>
<%@ attribute name="head"
              fragment="true" %>
<%@ attribute name="header"
              fragment="true" %>
<%@ attribute name="script"
              fragment="true" %>

<%-- Template section --%>
<t:menuLVL1>

	<jsp:attribute name="title">
		<%-- Hook for filling title of page --%>
        <jsp:invoke fragment="title"/>
	</jsp:attribute>

	<jsp:attribute name="head">
		<%-- Hook for adding something to HEAD --%>
        <jsp:invoke fragment="head"/>
	</jsp:attribute>


	<jsp:attribute name="menuLVL2">
	<div class="panel panel-default">
        <div class="panel-heading">
            <spring:message code="label.patient"/>: ${patient.contact.firstName } ${patient.contact.lastName }
        </div>
        <div class="panel-body">
            <ul>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/overview" />">
                        <spring:message code="label.overview"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/anamnesis/list" />">
                        <spring:message code="label.anamnesis"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/seizure/list" />">
                        <spring:message code="label.seizures"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">
                        <spring:message code="label.pharmacotherapy"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/neurological-finding/list" />">
                        <spring:message code="label.neurologicalFindings"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">
                        <spring:message code="label.neuropsychology"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/neuropsychology-old/list" />">
                        <spring:message code="label.neuropsychology"/> - old
                    </a>
                </li>
                <li>
                    <spring:message code="label.diagnosticTests"/>
                    <ul>
                        <li>
                            <a href="<c:url value="/patient/${patient.id}/diagnostic-test-scalp-eeg/list" />">
                                <spring:message code="label.scalpEeg"/>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/list" />">
                                <spring:message code="label.neuroImagingTests"/>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <spring:message code="label.invasiveTests"/>
                    <ul>
                        <li>
                            <a href="<c:url value="/patient/${patient.id}/invasive-test-ecog/list" />">
                                ECoG
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value="/patient/${patient.id}/invasive-test-eeg/list" />">
                                iEEG
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/list" />">
                                <spring:message code="label.corticalMapping"/>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/operation/list" />">
                        <spring:message code="label.operation"/>
                    </a>
                </li>
                <li><a href="<c:url value="/patient/${patient.id}/histology/list" />">
                    <spring:message code="label.histology"/>
                </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/complication/list" />">
                        <spring:message code="label.complication"/>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/patient/${patient.id}/outcome/list" />">
                        <spring:message code="label.outcome"/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</jsp:attribute>

<jsp:attribute name="script">
    <%-- Hook for adding something to Script section --%>
    <jsp:invoke fragment="script"/>
	</jsp:attribute>

    <jsp:body>
        <jsp:doBody/>
    </jsp:body>

</t:menuLVL1>