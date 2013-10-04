<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      Domovská stránka
    </jsp:attribute>
	<jsp:attribute name="header">
      PŘEHLED
    </jsp:attribute>
    
	<jsp:body>
	<div style="border-bottom: 2px solid black">
		<h1>
			<spring:message code="label.news" />
		</h1>
	</div>
	<sec:authorize ifAnyGranted="ROLE_USER">
		<div style="margin: 10px">
			<c:forEach items="${newsMessages}" var="newsMessage">
			<div>
				
					<div class="navbar">
						<div class="navbar-inner">
							<ul id="nav-list" class="nav pull-left">
									<li class="brand">${newsMessage.date }</li>
								</ul>
									<ul id="nav-list" class="nav pull-right">
										<li>
											<div class="btn-group">
							  					<a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="#">
							    					Action<span class="caret"></span>
							  					</a>
							  					<ul class="dropdown-menu">
							    					<li><a href="<c:url value="/news/${newsMessage.id}/edit" />"><spring:message code="label.edit"/></a></li>
							    					<li><a href="<c:url value="/news/${newsMessage.id}/delete" />"><spring:message code="label.delete"/></a></li>
							  					</ul>
											</div>
										</li>
									</ul>							
						</div>
			
				</div>
				<p>${message.message }</p>
			</div>
			</c:forEach>
		</div>
	</sec:authorize>
</jsp:body>
</t:menuLVL2>