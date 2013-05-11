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
 <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  
</head>
<body>
	
	<div class="container-fluid">
		<div class="navbar-wrapper" id="home">
			<div class="container">
	
				<div class="navbar navbar-inverse">
					<div class="navbar-inner">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <a class="brand" href="#">GENEPI - PREHLED</a>
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
	
	  
        <div class="span3">
          <div class="well sidebar-nav">
           <a href="/GENEPI/" >  <img  class="photo1" width=2560  height=1600 src="resources/img/logo.png" alt="logo" style= margin: 1em;
    border-radius: 2.5em;/> </a>
        </div>

        <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Pacienti</li>
              <li><a href="patientsList">Kartoteka pacientu</a></li>
              <li><a href="#" data-toggle="tooltip" data-placement="top" title="Tooltip on top">Pokrocile vyhledavani</a></li>
              <li class="nav-header">Uzivatel: <%=username%></li>
              <li><a href="myProfile">Profil</a></li>
              <li><a href="j_spring_security_logout">Odhlasit</a></li>
              <li class="nav-header">Jazyk</li>
            </ul>
          </div><!--/.well -->
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
          
           

    	
      

    </div>
    
    <div class="span3">
    	<div id="copyright">
        			<p>GENEPI, &copy 2013, FIT CVUT</p>
		</div>
	</div>
	
	<script>
	function goBack()
 	 {
  	window.history.back()
  	}
	</script>
    
    <script
		src="resources/js/bootstrap-popover.js"></script>   
	<script
		src="resources/js/jquery.js"></script>
	<script
		src="resources/js/bootstrap-dropdown.js"></script>
	<script
		src="resources/js/application.js"></script>


</body>
</html>