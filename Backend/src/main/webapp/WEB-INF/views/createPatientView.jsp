<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="cz.cvut.fit.genepi.controllers.*"%>
<!-- import of modelsImpl -->
<%@ page import="cz.cvut.fit.genepi.models.*"%>
<!--  import of list -->
<%@ page import=" java.util.*" %>
<%@ page import=" java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Create patient</title>
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  
  
</head>
<body>
	<div class="navbar-wrapper" id="create_patient">
		<div class="container">

			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - VYTVORENI PACIENTA</a>
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
          <h1><a href="/GENEPI/" style="text-decoration: none">FN MOTOL</a></h1>
        </div>

        <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Pacienti</li>
              <li><a href="patientsList">Kartoteka pacientu</a></li>
              <li><a href="#">Pokrocile vyhledavani</a></li>
              <li class="nav-header">Uzivatel: <%=username%></li>
              <li><a href="myProfile">Profil</a></li>
              <li><a href="j_spring_security_logout">Odhlasit</a></li>
              <li class="nav-header">Jazyk</li>
            </ul>
          </div><!--/.well -->
         </div>
         
         <% 
		// creation of patientsListController
		CreatePatientController patientsListController = new CreatePatientController();
		// gets list of patients in the database
		//List<PatientDAO> patients = patientsListController.findAll(); 
		%>
         
          <div class="span9">
          <div class="hero-unit">
            <div style="border-bottom: 2px solid black"><h1>Zalozit pacienta</h1></div>
			<div class="form" style="margin: 10px; width: 40%">
			<form name="createPatient" action="createPatient" method="post">
				<b>Prijmeni</b> <input type="text" id="patientSurname" class="input-block-level"
					name="patientSurname" placeholder=""> </br>
				<b>Jmeno</b> <input type="text" id="patientFirstname" class="input-block-level"
					name="patientFirstname" placeholder=""> </br>
				<b>Datum narozeni</b> <input type="text" id="patientBirthdate" class="input-block-level"
					name="patientBirthdate" placeholder=""> </br>
				Rodne cislo <input type="text" id="patientIN" class="input-block-level"
					name="patientIN" placeholder=""> </br>
					
				<b>Pohlavi</b></br> <select id="patientSex" class="" name="patientSex">
									<option value="default">Zvolte pohlavi</option>
									<option value="man">Muz</option>
									<option value="woman">Zena</option>
								</select> </br>
					 
				Ulice <input type="text" id="patientStreet" class="input-block-level"
					name="patientStreet" placeholder=""> </br>
				Cislo popisne/orientacni <input type="text" id="patientLRN" class="input-block-level"
					name="patientLRN" placeholder=""> </br> 
				Mesto <input type="text" id="patientCity" class="input-block-level"
					name="patientCity" placeholder=""> </br>
				PSC <input type="text" id="patientZIP" class="input-block-level"
					name="patientZIP" placeholder=""> </br>
				Stat <input type="text" id="patientCountry" class="input-block-level"
					name="patientCountry" placeholder=""> </br>
				Telefon <input type="text" id="patientPhone" class="input-block-level"
					name="patientPhone" placeholder=""> </br>
				E-mail <input type="text" id="patientMail" class="input-block-level"
					name="patientMail" placeholder="" value="@"> </br>
				
				<b>Osetrujici lekar</b></br> <select id="patientDoctor" class="" name="patientDoctor">
									<option value="default">Zvolte lekare</option>
									<option value="man">hlavni</option>
								</select> </br>
				<button class="btn btn-small btn-primary" type="submit">Zalozit
					in</button>
					<%
					String string = "January 2, 2010";
					Date date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(string);
					patientsListController.createNewPatient("patientSurname", date, "patientSex", 1, 0, 0, 0, 0); 
					%>
			</form>
		</div>
          </div>
          </div>
          
          
	</div>

   
    
    <div class="span3">
    	<div id="copyright">
        			<p>GENEPI, &copy 2013, FIT CVUT</p>
		</div>
	</div>
	
	
        
	<!-- 
	<h2>User Info:</h2>
	<div style="font-size: 15px">
		<label>Username:</label> <strong><%=username%></strong><br /> <label>Roles:</label>
		<strong> <%
 	for (GrantedAuthority ga : authorities) {
 		out.print(ga.getAuthority() + ", ");
 	}
 %>
		</strong><br />
	</div>
	
	<h2>Spring 3.2.x Security Namespace Configuration (URL Security)</h2>
	<br /> You can only access this page if you have
	<a href="admin">ROLE_ADMIN admin/admin.jsp</a>
	<br /> You can only access this page if you have
	<a href="edit">ROLE_EDIT edit/edit.jsp</a>

	<h2>Spring 3.2.x Method Security</h2>
	<h3>Invoking Server Side Methods:</h3>
	The following links invoke methods on a server side Spring Controller.
	They all return back a JSON string which you'll see in your browser.
	<ol>
		<li>You must have <strong>ROLE_USER</strong> to invoke this
			method: <a
			href="http://localhost:8080/spring-security/data/userRoleOnly">DataService.userRoleOnlyMethod()</a></li>
		<li>You must have <strong>ROLE_ADMIN</strong> to invoke this
			method: <a
			href="http://localhost:8080/spring-security/data/adminRoleOnly">DataService.adminRoleOnlyMethod()</a></li>
		<li>You must have <strong>ROLE_EDIT</strong> to invoke this
			method: <a
			href="http://localhost:8080/spring-security/data/editRoleOnly">DataService.editRoleOnlyMethod()</a></li>
		<li>You can invoke this method with any of these roles <strong>ROLE_USER,
				ROLE_EDIT, ROLE_ADMIN</strong> to invoke this method: <a
			href="http://localhost:8080/spring-security/data/allRoles">DataService.allRolesMethod()</a></li>
		<li>This method has <strong>no security</strong>: <a
			href="http://localhost:8080/spring-security/data/open">DataService.unprotectedMethod()</a></li>
		<li>You need <strong>ROLE_USER</strong> to invoke this method and
			it will return a JSON string of the <code>org.springframework.security.core.userdetails.User</code>
			object: <a href="http://localhost:8080/spring-security/data/userInfo">DataService.getUserInfo()</a></li>
	</ol>

	<a href="j_spring_security_logout">Login as a different user.</a>
 -->
	<script
		src="resources/js/jquery.js"></script>
	<script
		src="resources/js/bootstrap-dropdown.js"></script>
	<script
		src="resources/js/application.js"></script>


</body>
</html>