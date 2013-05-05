<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Home Page</title>

  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  
</head>
<body>
	<!-- <ul class="nav nav-tabs">
		<li class="active"><a href="#">Home</a></li>
		<li><a href="#">About</a></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">FrontEnd<b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#">Twitter Bootstrap</a></li>
				<li><a href="#">Google Plus API</a></li>
				<li><a href="#">HTML5</a></li>
				<li class="divider"></li>
				<li><a href="#">Examples</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">BackEnd<b class="caret bottom-up"></b></a>
			<ul class="dropdown-menu bottom-up pull-right">
				<li><a href="#">PHP</a></li>
				<li><a href="#">MySQL</a></li>
				<li><a href="#">PostgreSQL</a></li>
				<li class="divider"></li>
				<li><a href="#">Live Demos</a></li>
			</ul></li>			
	</ul>
	-->
	
	<div class="navbar-wrapper" id="home">
		<!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
		<div class="container">

			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - PATIENT</a>
					<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
			
				</div>
				<!-- /.navbar-inner -->
			</div>
			<!-- /.navbar -->

		</div>
		<!-- /.container -->
	</div>
	<!-- /.navbar-wrapper -->
	
	
	<!-- <P>The time on the server is ${serverTime}.</P>  -->

	<%
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername();
		Collection<GrantedAuthority> authorities = user.getAuthorities();
	%>
	<!-- <form name="foo" action="foo" method="post">
		<input name="fieldName" type="text" /> <input type="submit"
			value="Submit">
	</form> -->
	
	 <div class="container-fluid">
      
      
        <div class="span3">
          <div class="well sidebar-nav">
          </br></br></br></br></br></br></br></br></br></br></br></br></br>
          <h1><a href="#" style="text-decoration: none">FN MOTOL</a></h1>
        </div>
		
		<div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Pacienti</li>
              <li><a href="#">Kartoteka pacientu</a></li>
              <li><a href="#">Pokrocile vyhledavani</a></li>
              <li class="nav-header">Uzivatel: <%=username%></li>
              <li><a href="profile">Profil</a></li>
              <li><a href="j_spring_security_logout">Odhlasit</a></li>
              <li class="nav-header">Jazyk</li>
            </ul>
          </div><!--/.well -->
          
        <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Pacienti</li>
              <li><a href="#">Kartoteka pacientu</a></li>
              <li><a href="#">Pokrocile vyhledavani</a></li>
              <li class="nav-header">Uzivatel: <%=username%></li>
              <li><a href="profile">Profil</a></li>
              <li><a href="j_spring_security_logout">Odhlasit</a></li>
              <li class="nav-header">Jazyk</li>
            </ul>
          </div><!--/.well -->
        <div id="copyright">
        <p>GENEPI, &copy 2013, FIT CVUT
        </div>
      </div>
        <div class="span9">
          <div class="hero-unit">
            <div style="border-bottom: 2px solid black"><h1>News!</h1></div>
            <div style="margin: 10px">
            <p> Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! 
            Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! 
            Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! 
            Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! 
            Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! Keep out! 
			</p>
			</div>
          </div>
          </div>

    
      