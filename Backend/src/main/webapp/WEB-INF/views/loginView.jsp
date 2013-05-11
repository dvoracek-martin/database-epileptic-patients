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
		<link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="GENEPI team">
		<link href="resources/css/bootstrap2.2.css" rel="stylesheet">
		
		<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
		<!-- <link href="resources/css/login-page.css" rel="stylesheet"> -->
	</head>
	<body>
			<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
			   <td><a href="<c:url value="/login"/>"></a></td>
			</sec:authorize>
			<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
				<!-- shall go to the homepage or better logout the user? -->
				<c:redirect url="/" />
			</sec:authorize>
			
			<sec:authorize var="loggedIn" access="isAuthenticated()"/> 
		
		<!-- main strip --> 
		<div class="container-fluid">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> 
					<a class="brand" href="#">GENEPI - PRIHLASENI</a>
					<div class="nav-collapse collapse">
						<ul id="nav-list" class="nav pull-right">
							<li><a href="#contact">Kontakt</a></li>
						</ul>
					</div>
				</div>	
			</div>
		</div>
		
		<!-- box of testing login -->
		<div style="width: 330px; margin: auto; padding-top: 10em">
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
			<br/>
			<h1>Prihlaseni</h1>
			<!-- login form -->
			<div class="form" style="border: 0 solid white">
				<form name="f" action="j_spring_security_check" method="post">
					<input type="text" id="username" class="input-block-level"
						name="j_username" placeholder="Prihlasovaci jmeno"> <input
						type="password" id="password" name="j_password"
						class="input-block-level" placeholder="Heslo">
					<button class="btn btn-large btn-primary" type="submit">Prihlasit</button>
				</form>
			</div>
		</div>
			
		<!-- box for contact -->
		<div class="row-fluid" id="contact" style="padding-top: 25em">
			<div class="span4" id="contact-info" style="margin-left: 5em">
					<div>
						<h3>Kontaktujte nas!</h3>
					</div>
					<div>
						<div style=" float: right; margin-left: 2em">
							<img src="resources/img/genepi.png" />
						</div>
						<p>Pokud zaznamenavate problemy s prihlasenim kontaktujte nas na adrese dole.</p>
						<p>Nebo vyuzijte formular vpravo.
						<p>
						<p>
							<a href="mailto:admin@genepi.com">admin@genepi.com</a>
						</p>
						<p>____________________________</p>
						<p>GENEPI, &copy 2013, FIT CVUT</p>
					</div>
				</div>
	
				<!-- box with contact form -->
				<div class="span4" id="contact-form">
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
	
		<!-- Javascripts imports -->
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