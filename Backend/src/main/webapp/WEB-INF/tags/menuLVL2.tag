<%@ tag description="menu LVL2" pageEncoding="UTF-8"%>

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
<%@ attribute name="menuLVL3" fragment="true"%>
<%@ attribute name="script" fragment="true"%>

<!-- template section -->
<t:menuLVL1>
	<jsp:attribute name="title">
	<jsp:invoke fragment="title" />
	</jsp:attribute>
	<jsp:attribute name="head">
	<jsp:invoke fragment="head" />
	</jsp:attribute>
	<jsp:attribute name="header">
	<jsp:invoke fragment="header" />
	</jsp:attribute>
	<jsp:attribute name="menuLVL2">
	<jsp:invoke fragment="menuLVL3" />
		<li class="nav-header">Pacienti</li>
		<li><a href="<c:url value="/patient/list"/>">Kartotéka pacientů</a></li>
		<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
		<li class="nav-header">Uživatel:</li>
		<li><a href="<c:url value="/profile"/>">Profil</a></li>
		<li><a href="j_spring_security_logout">Odhlásit</a></li>
		<li class="nav-header">Administrace:</li>
		<li><a href="<c:url value="/user/list"/>">Uživatelé</a></li>
	</jsp:attribute>

	<jsp:attribute name="script">
	<jsp:invoke fragment="script" />
	</jsp:attribute>

	<jsp:body>
        <jsp:doBody />
    </jsp:body>

</t:menuLVL1>