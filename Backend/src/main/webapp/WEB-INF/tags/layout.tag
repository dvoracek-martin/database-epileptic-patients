<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>

<!-- taglib section -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!-- attribute section -->
<%@ attribute name="title" fragment="true"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="menuLVL1" fragment="true"%>
<%@ attribute name="script" fragment="true"%>

<!-- template section -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="description" content="">
<meta name="author" content="GENEPI team">
<title><jsp:invoke fragment="title" /></title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.css" />"
	rel="stylesheet">
<jsp:invoke fragment="head" />
</head>
<body>
	<div class="container-fluid">

		<!-- header section (header hook)-->
		<div id="header" class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">GENEPI - <jsp:invoke
						fragment="header" /></a>
			</div>
		</div>

		<!-- body section -->
		<div id="body">
			<div class="span3">

				<!-- logo section -->
				<div class="well sidebar-nav">
					<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
						src="<c:url value="/resources/img/logo.png"/>" alt="logo" />
					</a>
				</div>

				<!-- menu section (menuLVL1 hook) -->
				<div id="menu" class="well sidebar-nav">
					<ul class="nav nav-list">
						<jsp:invoke fragment="menuLVL1" />
					</ul>
				</div>
			</div>

			<!-- content section (doBody hook) -->
			<div id="content" class="span9">
				<div class="hero-unit"><jsp:doBody /></div>
			</div>

		</div>

		<!-- footer section -->
		<div id="footer" class="span9">
			<p>GENEPI, &copy; 2013, FIT CVUT</p>
		</div>

	</div>

	<!-- script section (script hook)-->
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<jsp:invoke fragment="script" />

</body>
</html>