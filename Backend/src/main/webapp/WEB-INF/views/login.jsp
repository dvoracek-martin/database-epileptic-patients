<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Login Page</title>
<link rel="stylesheet" href="resources/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="GENEPI team">
<!--  <meta http-equiv="refresh" content ="0; url=j_spring_security_logout"-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-bottom: 40px;
	padding-top: 100px;
	color: #5a5a5a;
}

/* Remove border and change up box shadow for more contrast */
.navbar .navbar-inner {
	border: 0;
	-webkit-box-shadow: 0 2px 10px rgba(0, 0, 0, .25);
	-moz-box-shadow: 0 2px 10px rgba(0, 0, 0, .25);
	box-shadow: 0 2px 10px rgba(0, 0, 0, .25);
}

/* Downsize the brand/project name a bit */
.navbar .brand {
	padding: 14px 20px 16px;
	/* Increase vertical padding to match navbar links */
	font-size: 16px;
	font-weight: bold;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .5);
}

/* Navbar links: increase padding for taller navbar */
.navbar .nav>li>a {
	padding: 15px 20px;
}

/* Offset the responsive button for proper vertical alignment */
.navbar .btn-navbar {
	margin-top: 10px;
}

.marketing .span4 {
	text-align: center;
}

.marketing h2 {
	font-weight: normal;
}

.marketing .span4 p {
	margin-left: 10px;
	margin-right: 10px;
}

/* Featurettes
    ------------------------- */
.featurette-divider {
	margin: 10px 0; /* Space out the Bootstrap <hr> more */
}

.featurette {
	padding-top: 120px;
	/* Vertically center images part 1: add padding above and below text. */
	overflow: hidden;
	/* Vertically center images part 2: clear their floats. */
}

.featurette-image {
	margin-top: -120px;
	/* Vertically center images part 3: negative margin up the image the same amount of the padding to center it. */
}

/* Give some space on the sides of the floated elements so text doesn't run right into it. */
.featurette-image.pull-left {
	margin-right: 0px;
}

.featurette-image.pull-right {
	margin-left: 0px;
}

/* Thin out the marketing headings */
.featurette-heading {
	font-size: 50px;
	font-weight: 300;
	line-height: 1;
	letter-spacing: -1px;
}

/* CUSTOMIZE THE NAVBAR
    -------------------------------------------------- */

/* Special class on .container surrounding .navbar, used for positioning it into place. */
.navbar-wrapper {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	z-index: 10;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
	margin-bottom: -90px;
	/* Negative margin to pull up carousel. 90px is roughly margins and height of navbar. */
}

.navbar-wrapper .navbar {
	
}

/* Remove border and change up box shadow for more contrast */
.navbar .navbar-inner {
	border: 0;
	-webkit-box-shadow: 0 2px 10px rgba(0, 0, 0, .25);
	-moz-box-shadow: 0 2px 10px rgba(0, 0, 0, .25);
	box-shadow: 0 2px 10px rgba(0, 0, 0, .25);
}

/* Downsize the brand/project name a bit */
.navbar .brand {
	padding: 14px 20px 16px;
	/* Increase vertical padding to match navbar links */
	font-size: 16px;
	font-weight: bold;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .5);
}

/* Navbar links: increase padding for taller navbar */
.navbar .nav>li>a {
	padding: 15px 20px;
}

/* Offset the responsive button for proper vertical alignment */
.navbar .btn-navbar {
	margin-top: 10px;
}

/* MARKETING CONTENT
    -------------------------------------------------- */

/* Center align the text within the three columns below the carousel */
.marketing .span4 {
	text-align: center;
}

.marketing h2 {
	font-weight: normal;
}

.marketing .span4 p {
	margin-left: 10px;
	margin-right: 10px;
}

/* Featurettes
    ------------------------- */
.featurette-divider {
	margin: 80px 0; /* Space out the Bootstrap <hr> more */
}

.featurette {
	padding-top: 120px;
	/* Vertically center images part 1: add padding above and below text. */
	overflow: hidden;
	/* Vertically center images part 2: clear their floats. */
}

.featurette-image {
	margin-top: -120px;
	/* Vertically center images part 3: negative margin up the image the same amount of the padding to center it. */
}

/* Give some space on the sides of the floated elements so text doesn't run right into it. */
.featurette-image.pull-left {
	margin-right: 40px;
}

.featurette-image.pull-right {
	margin-left: 40px;
}

/* Thin out the marketing headings */
.featurette-heading {
	font-size: 50px;
	font-weight: 300;
	line-height: 1;
	letter-spacing: -1px;
}
</style>
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="resources/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="resources/ico/favicon.png">


</head>
<body>
	<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
		<td><a href="<c:url value="/login"/>">Login</a></td>
	</sec:authorize>
	<!--<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
		<!-- shall go to the homepage or better logout the user? 
		<td><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></td>
	</sec:authorize>-->
	
	<sec:authorize var="loggedIn" access="isAuthenticated()"/>
	
	<c:choose>
		<c:when test="${loggedIn}">
			<!--td><a href="<c:url value="/j_spring_security_logout"/>">Logout2</a></td-->
				<td><a href="<c:url value="/j_spring_security_logout"/>">Logout3</a></td>
		</c:when>
	</c:choose>
	
	

 
 
 

	<!-- NAVBAR
    ================================================== -->
	<div class="navbar-wrapper" id="home">
		<!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
		<div class="container">

			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - LOGIN PAGE</a>
					<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
					<div class="nav-collapse collapse">
						<ul id="nav-list" class="nav pull-right">
							<li><a href="#contact-info">Contact</a></li>
						</ul>
					</div>
				</div>
				<!-- /.navbar-inner -->
			</div>
			<!-- /.navbar -->

		</div>
		<!-- /.container -->
	</div>
	<!-- /.navbar-wrapper -->



	<div style="width: 330px; margin: auto;">
		<h1>Login Page</h1>

		<table>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Role</th>
			</tr>
			<tr>
				<td>adam</td>
				<td>adampassword</td>
				<td>ROLE_USER</td>
			</tr>
			<tr>
				<td>jane</td>
				<td>janepassword</td>
				<td nowrap>ROLE_USER, ROLE_ADMIN</td>
			</tr>
			<tr>
				<td>sue</td>
				<td>suepassword</td>
				<td>ROLE_USER, ROLE_EDIT</td>
			</tr>
		</table>
		<br />
		<div class="form">
			<form name="f" action="j_spring_security_check" method="post">
				<input type="text" id="username" class="input-block-level"
					name="j_username" placeholder="Username"> <input
					type="password" id="password" name="j_password"
					class="input-block-level" placeholder="Password">
				<button class="btn btn-large btn-primary" type="submit">Sign
					in</button>
			</form>
		</div>
	</div>


	<div id="wrapper" style="width: 100%; text-align: center">
		<img src="resources/img/genepi.png" />
	</div>

		<!-- ABOUT & UPDATES -->
		<!--<div class="row-fluid" id="about">

			<div class="span6">
				<h2 class="page-title" id="scroll_up">
					About <a href="#home" class="arrow-top"> <img
						src="resources/img/arrow-top.png">
					</a>
				</h2>

				<p>Supercool app
					blahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah</p>
				<p>Another blahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah</p>
				<p>Another blahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah</p>
				<p>Another blahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah</p>
				<p>Another blahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah</p>
				<p>Another blahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblah
					blahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblahblah</p>
			</div>

			<div class="span6 updates" id="updates">
				<h2 class="page-title" id="scroll_up">
					Updates <a href="#home" class="arrow-top"> <img
						src="resources/img/arrow-top.png">
					</a>
				</h2> -->

				<!-- UPDATES & RELEASE NOTES -->

				<!--<h3 class="version">Version 1.2</h3>
				<span class="release-date">Released on April 28th, 2012</span>
				<ul>
					<li><span class="label new">NEW</span>Challenge a Friend</li>
					<li><span class="label fix">FIX</span>Fixed 'Resume Game' Bug</li>
				</ul>
				<hr>

				<h3 class="version">Version 1.1</h3>
				<span class="release-date">Released on January 28th, 2012</span>
				<ul>
					<li><span class="label fix">FIX</span>Various Bug Fixes</li>
					<li><span class="label new">NEW</span>Graphics for Retina
						Display</li>
				</ul>
				<hr>

				<h3 class="version">Version 1.0</h3>
				<span class="release-date">Released on January 10th, 2012</span>
				<ul>
					<li><span class="label label-info">NEW</span>Initial Release</li>
				</ul>

			</div>

		</div>-->
		</br> </br> </br> </br> </br> </br> 

		<!-- CONTACT -->
		<div class="row-fluid" id="contact">
<div style="display:none">
			<h2 class="page-title" id="scroll_up" >
				Kontakt <a href="#home" class="arrow-top"> <img
					src="resources/img/arrow-top.png">
				</a>
			</h2>
</div>
			<!-- CONTACT INFO -->
			<div class="span4" id="contact-info"  border-left: 20px">
				<h3>Kontaktujte nas!</h3>
				<p>Pokud zaznamenavate problemy s prihlasenim kontaktujte nas na adrese dole.</p>
				<p>Nebo vyuzijte formular vpravo.
				<p>
				<p>
					<a href="mailto:admin@genepi.com">admin@genepi.com</a>
				</p>
			</div>

			<!-- CONTACT FORM -->
			<div class="span7" id="contact-form" margin-left: 5pt">
				<form class="form-horizontal">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="name"></label>
							<div class="controls">
								<input class="input-xlarge" type="text" id="name"
									placeholder="Jmeno a prijmeni">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="email"></label>
							<div class="controls">
								<input class="input-xlarge" type="text" id="email"
									placeholder="Email">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="subject"></label>
							<div class="controls">
								<input class="input-xlarge" type="text" id="subject"
									placeholder="Predmet">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="message"></label>
							<div class="controls">
								<textarea class="input-xlarge" rows="3" id="message"
									placeholder="Text zpravy"></textarea>
							</div>
						</div>
						<div  class="form-actions" style="background:white;border-color:white">
							<button type="submit" class="btn btn-primary">ODESLAT</button>
						</div>
					</fieldset>
				</form>
			</div>

		</div>



		<!-- FOOTER -->
		<div class="footer container container-fluid">

			<!-- COPYRIGHT - EDIT HOWEVER YOU WANT! -->
			<div id="copyright">
				GENEPI, &copy 2013, FIT CVUT
			</div>


		</div>

	</div>
	<!-- /.container -->



	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery.js">
		
	</script>
	<script src="resources/js/bootstrap-transition.js"></script>
	<script src="resources/js/bootstrap-alert.js"></script>
	<script src="resources/js/bootstrap-modal.js"></script>
	<script src="resources/js/bootstrap-dropdown.js"></script>
	<script src="resources/js/bootstrap-scrollspy.js"></script>
	<script src="resources/js/bootstrap-tab.js"></script>
	<script src="resources/js/bootstrap-tooltip.js"></script>
	<script src="resources/js/bootstrap-popover.js"></script>
	<script src="resources/js/bootstrap-button.js"></script>
	<script src="resources/js/bootstrap-collapse.js"></script>
	<script src="resources/js/bootstrap-carousel.js"></script>
	<script src="resources/js/bootstrap-typeahead.js"></script>
	<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap-collapse.js"></script>
	<script src="resources/js/bootstrap-scrollspy.js"></script>
	<script src="resources/js/jquery.mousewheel-3.js"></script>
	<script src="resources/js/jquery.fancybox-1.3.js"></script>
	<script src="resources/js/init.js"></script>

	<script>
		!function($) {
			$(function() {
				// carousel demo
				$('#myCarousel').carousel()
			})
		}(window.jQuery)
	</script>

</body>
</html>

