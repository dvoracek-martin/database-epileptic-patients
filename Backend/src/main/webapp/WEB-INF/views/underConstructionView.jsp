<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="description" content="">
<meta name="author" content="GENEPI team">
<title>Přístup odepřen</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.css" />"
	rel="stylesheet">
</head>
<body>

	<!-- main strip -->
	<div class="container-fluid">
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">V rekonstrukci</a>
				<div class="nav-collapse collapse">
					<ul id="nav-list" class="nav pull-right">
						<li><a href="<c:url value="/login" />">GENEPI</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div style="width: 330px; margin: auto; padding-top: 10em">
			<h1>Tato stránka se právě rekonstruuje. Co nevidět bude k dispozici.</h1>

	</div>

	<!-- Javascripts imports -->
	<script src="<c:url value="resources/js/jquery.js" />"></script>
	<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
</body>
</html>