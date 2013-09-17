<%@ tag description="menu LVL1" pageEncoding="UTF-8"%>

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
<%@ attribute name="menuLVL2" fragment="true"%>
<%@ attribute name="script" fragment="true"%>

<!-- template section -->
<t:layout>

	<jsp:attribute name="title">
	<jsp:invoke fragment="title" />
	</jsp:attribute>

	<jsp:attribute name="head">
	<jsp:invoke fragment="head" />
	</jsp:attribute>

	<jsp:attribute name="header">
	<jsp:invoke fragment="header" />
	</jsp:attribute>

	<jsp:attribute name="menuLVL1">
	<jsp:invoke fragment="menuLVL2" />
		<li class="nav-header">Jazyk</li>
		<li><a href="?lang=cs">CZ</a></li>
		<li><a href="?lang=en">EN</a></li>
	</jsp:attribute>

	<jsp:attribute name="script">
	<jsp:invoke fragment="script" />
	</jsp:attribute>

	<jsp:body>
        <jsp:doBody />
    </jsp:body>



</t:layout>
