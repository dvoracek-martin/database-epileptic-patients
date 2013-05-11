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
<%@ page import=" java.lang.*" %>
<%@ page import=" java.io.*" %>

<%@ page import=" java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Created patient</title>
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  
  
</head>
<body>
	<div class="navbar-wrapper" id="created_anamnesis">
		<div class="container">

			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - VYTVORENY PACIENT</a>
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
          </div><!--/.well -->
         </div>
         
         <% 
		// creation of patientsListController
		CreateAnamnesisController createAnamnesisController = new CreateAnamnesisController();
		// gets list of patients in the database
		//List<PatientDAO> patients = patientsListController.findAll(); 
		%>
		
		<% 
		
		String string = request.getParameter("anamnesisDate");
		String string1 = request.getParameter("anamnesisEpStart");
		int anaFZ = 0;
		int anaIS = 0;
		int anaES = 0;
		int anaFE = 0;
		int anaPR = 0;
		int anaFI = 0;
		int anaZA = 0;
		int anaUR = 0;
		int anaOP = 0;
		int anaPM = 0;
		if(request.getParameter("anamnesisFirstZ")=="ON"){
			anaFZ=1;
		}
		if(request.getParameter("anamnesisInfSpas")=="ON"){
			anaIS=1;
		}
		if(request.getParameter("anamnesisEpiSyn")=="ON"){
			anaES=1;
		}
		if(request.getParameter("anamnesisFamilyEp")=="ON"){
			anaFE=1;
		}
		if(request.getParameter("anamnesisPren")=="ON"){
			anaPR=1;
		}
		if(request.getParameter("anamnesisFib")=="ON"){
			anaFI=1;
		}
		if(request.getParameter("anamnesisZan")=="ON"){
			anaZA=1;
		}
		if(request.getParameter("anamnesisUra")=="ON"){
			anaUR=1;
		}
		if(request.getParameter("anamnesisOper")=="ON"){
			anaOP=1;
		}
		if(request.getParameter("anamnesisPMD")=="ON"){
			anaPM=1;
		}
		try{
			Date date = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(string);
			Date date1 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(string1);
			//createAnamnesisController.createNewAnamnesis(date, 1,1, date1, anaFZ, anaIS, anaES, anaFE, anaPR, anaFI, anaZA, anaUR, anaOP, anaPM, request.getParameter("anamnesisNonCNS").toString(), request.getParameter("anamnesisCom"), 0, 1, 1);
		}catch(java.text.ParseException ex){ out.println("Incorect format of date of birth ");
		%>
		  <jsp:forward page="createAnamnesisView.jsp"/>
		<%
		}
		%>
		
		
					
					
		<div class="span9">
          <div class="hero-unit">
            <div>
            		<h2 class="pull-left">Anamnéza</h2>
            		</br>
            		</br>
					<table style="border: 1px solid black">
						<tbody>
							<tr>
								<th>Cislo pacienta: </th>
									<td>Nevyplneno</td>

								<th>Rodne cislo: </th>
									<td>Nevyplneno</td>

								<th>Adresa: </th>
									<td>Nevyplneno</td>

							</tr>
							<tr>
								<th>Telefon: </th>
									<td>Nevyplneno</td>
									
								<th>Vek:</th>
									<td>Nevyplneno</td>

								<th>Pohlavi:</th>
									<td>Nevyplneno</td>
							</tr>
							
			                 <tr>
			                 	<th>Email:</th>
									<td>Nevyplneno</td>
									
								<th>Vek pri zacatku epilepsie:</th>
									<td>Nevyplneno</td>

								<th>Osetrujici lekar:</th>
									<td>Nevyplneno</td>

							</tr>
						</tbody>
					</table>
				</div>
            <p>
                Epilepsie v rodine :
            	<%
                    if(request.getParameter("anamnesisFamilyEp")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
            <p>
                Prenatalni rizika :
            	<%
                    if(request.getParameter("anamnesisPren")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
            <p>
                Fibrilni krece : 
            	<%
                    if(request.getParameter("anamnesisFib")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
            <p>
                Zanet CNS : 
            	<%
                    if(request.getParameter("anamnesisZan")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
            <p>
                Uraz CNS :
            	<%
                    if(request.getParameter("anamnesisUra")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
            <p>
                Operace CNS :   
            	<%
                    if(request.getParameter("anamnesisOper")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
             <p>
                Casna PMD retardace :   
            	<%
                    if(request.getParameter("anamnesisPMD")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
             <p>
                Zacatek epilepsie : <% out.println(request.getParameter("anamnesisEpStart")); %>   
            </p>
             <p>
                Prvni zachvat s horeckou :   
            	 <%
                    if(request.getParameter("anamnesisFirstZ")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
             <p>
                Infantilni spasmy : 
                <%
                    if(request.getParameter("anamnesisInfSpas")==null){
                    	out.println("NE");
                    }else{
                	out.println("ANO");
                    }
                 %> 
            </p>
             <p>
                Epilepticky syndrom : 
                <% 
                	out.println(request.getParameter("anamnesisEpiSyn")); 
                %>   
            </p>
            <p>
                Non CNS komorbidita : <% out.println(request.getParameter("anamnesisNonCNS")); %>   
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
