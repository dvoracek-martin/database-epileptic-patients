<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!-- import of controllers -->
<%@ page import="cz.cvut.fit.genepi.controllers.*"%>
<!-- import of modelsImpl -->
<%@ page import="cz.cvut.fit.genepi.models.*"%>
<!--  import of list -->
<%@ page import=" java.util.List" %>

<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Home Page</title>
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <style type="text/css">
  table.patients {
  width: 90%;
  margin: 0px auto;
}

table.patients td {
  padding: 0px 5px 0px 5px;
}

table.patients td.head {
  font-weight: bold;
  text-align: center;
}
</style>
  
  
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
				 <a href="/GENEPI/" >  <img  class="photo1" width=2560  height=1600 src="resources/img/logo.png" alt="logo" style= margin: 1em;
    border-radius: 2.5em;/> </a>
        	</div>
		
          
			<div class="well sidebar-nav">
            	<ul class="nav nav-list">
            	  <li class="nav-header">Pacienti</li>
             	 <li><a href="patientsList">Kartoteka pacientu</a></li>
             	 <li><a href="underConstruction">Pokrocile vyhledavani</a></li>
             	 <li class="nav-header">Uzivatel: <%=username%></li>
             	 <li><a href="myProfile">Profil</a></li>
             	 <li><a href="j_spring_security_logout">Odhlasit</a></li>
             	 <li class="nav-header">Jazyk</li>
            	</ul>
          	</div>
			
		</div>
		
		<% 
		// creation of patientsListController
		PatientsListController patientsListController = new PatientsListController();
		// gets list of patients in the database
		List<PatientDAO> patients = patientsListController.findAll(); 
		// creation of patientOverviewController
		PatientOverviewController patientOverviewController = new PatientOverviewController();
		%>
      	
		<div class="span9">
			<div class="hero-unit">
            		<div style="border-bottom: 2px solid black">
            			<h2 style="display: inline; text-align: left">Kartoteka pacientu</h2>
            			<h3 style="display: inline; text-align: right"><a href="createPatient" style="text-decoration: none">Novy pacient</a></h3>
            		</div>
            		<table class="patients">
            		 <tr class="head">
				        <td>Príjmení</td>
				        <td>Jmeno</td>
				        <td>Rodne císlo</td>
				        <td>Ulice, c.p.</td>
				        <td>Mesto</td>
    				</tr>	
    			
    				<% 
    				// this cycle prints into the table information about patients
    				for (PatientDAO patient : patients) {
	 					out.print("<tr>"+
    							  "\t<td>none</td>\n"+/*patientOverviewController.findContactByID(patient.getId()).getLastName()+*/	
    							  "\t<td>none</td>\n"+/*patientOverviewController.findContactByID(patient.getId()).getFirstName()+*/
    							  "\t<td>"+
    							  "<form name=\"patientOverview\" action=\"patientOverview\" method=\"post\">"+
    							  "<input type=\"hidden\" id=\"id\" name=\"id\" value=\""+patient.getId()+"\">"+
    							  "<button class=\"btn btn-small btn-primary\" type=\"submit\">"+patient.getBirthday().toString()+"</button></form></td>\n"+
	 						      "\t<td>none</td>\n"+/*patientOverviewController.findContactByID(patient.getId()).getAddressHn()+*/
    							  "\t<td>none</td>\n" /*+patientOverviewController.findContactByID(patient.getId()).getAddressCity()*/);
	 				}%>
            		</table>
			</div>
		</div>
	</div>
	
	<div id="copyright">
        		<p>GENEPI, &copy 2013, FIT CVUT</p>
	</div>
	
</body>
</html>

    
