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
<title>Přihlašovací stránka</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.css" />"
	rel="stylesheet">
</head>
<style type="text/css">

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: transparent;
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

 </style>
<body>
	<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
		<td><a href="<c:url value="/login"/>"></a></td>
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
		<!-- shall go to the homepage or better logout the user? -->
		<c:redirect url="/" />
	</sec:authorize>

	<sec:authorize var="loggedIn" access="isAuthenticated()" />

	<!-- main strip -->
	<div class="container-fluid">
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="brand" href="#">GENEPI</a>
				<div class="nav-collapse collapse">
					<ul id="nav-list" class="nav pull-right">
						<li><a href="?lang=cs">CZ</a></li>
						<li><a href="?lang=en">EN</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- box of testing login -->
		
		<!-- login form -->
		<div class="container" style="padding-top: 10em">
			<form class="form-signin" name="f" action="j_spring_security_check" method="post">
				<h1>
					<spring:message code="label.login" />
				</h1>
				<input type="text" id="username" class="input-block-level"
					name="j_username" placeholder="<spring:message code="label.username" />" autofocus>
				<input type="password" id="password" name="j_password"
					class="input-block-level" placeholder="<spring:message code="label.password" />">
				<label class="checkbox">
					<input type="checkbox" name="_spring_security_remember_me" /><spring:message code="label.rememberMe" />
				</label>
				<button class="btn btn-large btn-primary" type="submit"><spring:message code="label.login" /></button>
				
			
			</form>
		</div>
		
		<div style="width: 330px; margin: auto">
			<input type="button" id="visibleLoginData" value="zobrazit přihlašovací údaje" onclick="loginDataVisibility()">	
			<table id="loginData" style="display: none">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Role</th>
				</tr>

				<tr>
					<td>sue</td>
					<td>suepassword</td>
					<td>ROLE_USER</td>
				</tr>
				<tr>
					<td>hom</td>
					<td>hompassword</td>
					<td>ROLE_USER, ROLE_DOCTOR</td>
				</tr>
			</table>
		</div>
			
		

	
	

	<!-- box for contact 
	<div class="container" id="contact" style="margin-left: 5em">
		<div class="span4" id="contact-info" style="margin-left: 5em">
			<div>
				<h3>Kontaktujte nás!</h3>
			</div>
			<div>
				<div style="float: right; margin-left: 2em">
					<img src="<c:url value="/resources/img/genepi.png"/>" />
				</div>
				<p>Pokud zaznamenáváte problémy s přihlášením, tak nás neváhejte
					kontaktovat na naší adrese či využijte formulář vpravo.</p>
				<p>
					<a id="address" href="mailto:admin@genepi.com">admin@genepi.com</a>
				</p>
				<p>____________________________</p>
				<p>GENEPI, &copy; 2013, FIT CVUT</p>
			</div>
		</div>

		<!-- box with contact form 
		<div class="span4" id="contact-form">
			<form class="form-horizontal">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="name"></label>
						<div class="controls">
							<input class="input-xlarge" type="text" id="name"
								placeholder="Jméno a příjmení">
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
								placeholder="Předmět">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="message"></label>
						<div class="controls">
							<textarea class="input-xlarge" rows="3" id="message"
								placeholder="Text zprávy"></textarea>
						</div>
					</div>
					<div class="form-actions"
						style="background: white; border-color: white">
						<button type="submit" class="btn btn-primary">Odeslat</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>-->

	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
<script>
function loginDataVisibility() {
	if(document.getElementById("loginData").style.display=="none") {
		document.getElementById("loginData").style.display="block";
		document.getElementById("visibleLoginData").value="skrýt přihlašovací údaje";
	} else {
		document.getElementById("loginData").style.display="none";
		document.getElementById("visibleLoginData").value="zobrazit přihlašovací údaje";
	}
}
</script>
</html>