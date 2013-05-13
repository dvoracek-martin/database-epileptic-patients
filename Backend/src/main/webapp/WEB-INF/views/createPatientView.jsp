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

<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Přidat pacienta</title>
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  
  
</head>
	<body>
		<%
				User user = (User) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal();
				String username = user.getUsername();
				Collection<GrantedAuthority> authorities = user.getAuthorities();
				
				// creation of patientsListController
				CreatePatientController patientsListController = new CreatePatientController();
		         
				// gets list of patients in the database
				//List<PatientDAO> patients = patientsListController.findAll(); 
		%>
		
		<!-- box of whole page -->			
		<div class="container-fluid">
			<!--  it defines box with logo -->
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - PŘIDAT PACIENTA</a>
				</div>
				
			</div>
		
		  	<!--  it defines box with menu and logo -->
			<div class="span3">
				<div class="well sidebar-nav">
	           		<a href="/GENEPI/" >  <img  class="photo1" width=2560  height=1600 src="resources/img/logo.png" alt="logo"/> </a>
	        	</div>
				<div>
	       			<div class="well sidebar-nav">
	            		<ul class="nav nav-list">
		             		<li class="nav-header">Pacienti</li>
		             		<li><a href="patientsList">Kartotéka pacientů</a></li>
		              		<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
		              		<li class="nav-header">Uživatel: <%=username%></li>
		              		<li><a href="myProfile">Profil</a></li>
		              		<li><a href="j_spring_security_logout">Odhlásit</a></li>
		              		<li class="nav-header">Jazyk</li>
		            	</ul>
	          		</div>
	          		<!--  It block with copyright -->
			    	<div class="span3">
				    	<div id="copyright">
				        			<p>GENEPI, &copy 2013, FIT CVUT</p>
						</div>
					</div>
	          </div>
			</div>
         	
         	<!-- box with content -->
          	<div class="span9">
          		<div class="hero-unit">
            		<div style="border-bottom: 2px solid black">
            			<h2>Přidat pacienta</h2>
            		</div>
					<div class="form" style="margin: 10px; width: 60%">
						<!-- form for adding new patient -->
						<form name="createPatient" action="createdPatient" method="post">
							<b>Příjmení</b> <input type="text" id="patientSurname" class="input-block-level"
								name="patientSurname" placeholder=""> </br>
							<b>Jméno</b> <input type="text" id="patientFirstname" class="input-block-level"
								name="patientFirstname" placeholder=""> </br>
							<b>Datum narození</b> <input type="text" id="patientBirthdate" class="input-block-level"
								name="patientBirthdate" placeholder="">
							Rodné číslo<input type="text" id="patientIN" class="input-block-level"
								name="patientIN" placeholder=""> </br>
								
							<b>Pohlavní</b></br> <select id="patientSex" class="" name="patientSex">
												<option value="default">Zvolte pohlaví</option>
												<option value="man">muž</option>
												<option value="woman">žena</option>
											</select> </br>
								 
							Ulice <input type="text" id="patientStreet" class="input-block-level"
								name="patientStreet" placeholder=""> </br>
							Číslo popisné (nebo orientační) <input type="text" id="patientLRN" class="input-block-level"
								name="patientLRN" placeholder=""> </br> 
							Město <input type="text" id="patientCity" class="input-block-level"
								name="patientCity" placeholder=""> </br>
							PSČ <input type="text" id="patientZIP" class="input-block-level"
								name="patientZIP" placeholder=""> </br>
							Stát <input type="text" id="patientCountry" class="input-block-level"
								name="patientCountry" placeholder=""> </br>
							Telefon <input type="text" id="patientPhone" class="input-block-level"
								name="patientPhone" placeholder=""> </br>
							E-mail <input type="text" id="patientMail" class="input-block-level"
								name="patientMail" placeholder="" value="@"> </br>
							
							<b>Ošetřující lékař</b></br> <select id="patientDoctor" class="" name="patientDoctor">
												<option value="default">Zvolte lékaře</option>
												<option value="hlavni">hlavní</option>
											</select> </br>
							<button class="btn btn-small btn-primary" type="submit">Přidat</button>	
						</form>
					</div>
          		</div>
          	</div>         
		</div>
	
		<!-- Javascripts imports -->
		<script
			src="resources/js/jquery.js"></script>
		<script
			src="resources/js/bootstrap-dropdown.js"></script>
		<script
			src="resources/js/application.js"></script>
	</body>
</html>