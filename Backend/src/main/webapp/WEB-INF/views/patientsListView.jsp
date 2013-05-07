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
	<div class="navbar-wrapper" id="home">
		<div class="container">

			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - KARTOTEKA</a>
				</div>
			</div>
		</div>
	</div>

	<%
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername();
		Collection<GrantedAuthority> authorities = user.getAuthorities();
	%>
	
	<div class="container-fluid">
      
        <div class="span3">
			<div class="well sidebar-nav">
				</br></br></br></br></br></br></br></br></br></br></br></br></br>
          		<h1><a href="/fit/" style="text-decoration: none">FN MOTOL</a></h1>
        	</div>
		
          
			<div class="well sidebar-nav">
            	<ul class="nav nav-list">
              		<li class="nav-header">Pacienti</li>
              		<li><a href="#">Kartoteka pacientu</a></li>
              		<li><a href="#">Pokrocile vyhledavani</a></li>
              		<li class="nav-header">Uzivatel: <%=username%></li>
              		<li><a href="profile">Profil</a></li>
              		<li><a href="j_spring_security_logout">Odhlasit</a></li>
              		<li>
              			<div class="btn-group">
  							<button class="btn">Jazyk</button>
  							<button class="btn dropdown-toggle" data-toggle="dropdown">
    							<span class="caret"></span>
  							</button>
  							<ul class="dropdown-menu">
   								<li><a href="#">Czech</a></li>
   								<li><a href="#">Czech</a></li>
  							</ul>
						</div>
              		</li>
            	</ul>
			</div>
			
		</div>
      	
		<div class="span9">
			<div class="hero-unit">
           		<div>
            		<h2 class="pull-left">Kartoteka pacientu</h2>
            		<h3 class="pull-right"><a href="createPatient">Novy pacient</a></h3>
				</div>
			</div>
		</div>
	</div>
	<div id="copyright">
        		<p>GENEPI, &copy 2013, FIT CVUT</p>
	</div>
</body>
</html>

    
