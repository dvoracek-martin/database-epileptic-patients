<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL1.NEW303>

	<jsp:attribute name="title">
      Domovská stránka
    </jsp:attribute>

	<jsp:body>
	<div style="border-bottom: 2px solid black">
		<h1>
			<spring:message code="label.news" />
		</h1>
	</div>
		<div style="margin: 10px">
			<c:forEach items="${newsMessages}" var="newsMessage">
			<div>
				
					<div class="navbar">
						<div class="navbar-inner">
							<ul id="nav-list" class="nav pull-left">
									<li class="brand">${newsMessage.date }</li>
								</ul>
								<sec:authorize ifAnyGranted="ROLE_ADMIN">
									<ul id="nav-list" class="nav pull-right">
										<li>
											<div class="btn-group">
							  					<a class="btn btn-info dropdown-toggle"
													data-toggle="dropdown" href="#">
							    					<spring:message code="label.manage" /><span
													class="caret"></span>
							  					</a>
							  					
							  					<ul class="dropdown-menu">
							    					<li><a href="#messageEdit${newsMessage.id}"
														role="button" data-toggle="modal"><spring:message
																code="label.edit" /></a></li>
							    					<li><a
														href="#messageDeleteConfirm${newsMessage.id}"
														role="button" data-toggle="modal"><spring:message
																code="label.delete" /></a></li>
							  					</ul>
							  					
											</div>
												</li>		
							  		</ul>
								</sec:authorize>
												
						</div>
			
				</div>
				<p>${newsMessage.message}</p>
			</div>
				
				<!-- Modal window>: message delete confirmation -->
				<div id="messageDeleteConfirm${newsMessage.id}"
						class="modal hide fade" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
						<h3 id="myModalLabel1">
								<spring:message code="label.messageDeletion" />
							</h3>
					</div>
					<div class="modal-body">
						<p>
								<spring:message code="label.messageDeleteContent" />
							</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">
								<spring:message code="label.no" />
							</button>
						<a class="btn btn-primary"
								href="<c:url value="/news/${newsMessage.id}/delete"/>"><spring:message
									code="label.yes" /></a>
					</div>
				</div>

				<!-- Modal window>: message edit window -->
				<div id="messageEdit${newsMessage.id}" class="modal hide fade"
						tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
						aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
						<h3 id="myModalLabel">
								<spring:message code="label.messageEditing" />
							</h3>
					</div>
					<!-- Form to edit message -->
					<form:form method="POST" modelAttribute="emptyMessage"
							action="/GENEPI/news/${newsMessage.id}/edit"
							commandName="emptyMessage">
						<div class="modal-body">
							<form:input type="" path="message" class="input-block-level"
									value="${newsMessage.message}" />
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">
									<spring:message code="label.cancel" />
								</button>
							<button class="btn btn-small btn-primary" type="submit">
									<spring:message code="label.edit" />
								</button>
						</div>
					</form:form>
				</div>


				<script>
					var messageID = $
					{
						newsMessage.id
					};
					$('#messageDeleteConfirm' + messageID).modal({
						show : false
					})

					$('#messageEdit' + messageID).modal({
						show : false
					})
				</script>
															
			</c:forEach>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<a class="btn btn-info" href="#messageCreate" role="button"
						data-toggle="modal"><spring:message code="label.addMessage" /></a>
</sec:authorize>
				
			
		</div>
		
		<!-- Modal window>: message create window -->
		<div id="messageCreate" class="modal hide fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
				<h3 id="myModalLabel">
						<spring:message code="label.messageCreation" />
					</h3>
			</div>
			
			<!-- Form to create message -->
			<form:form method="POST" modelAttribute="emptyMessage"
					action="/GENEPI/news/create" commandName="emptyMessage">
				<div class="modal-body">
					<form:textarea path="message" class="input-block-level" style="resize:vertical;"/>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">
							<spring:message code="label.cancel" />
						</button>
					<button class="btn btn-primary" type="submit">
							<spring:message code="label.create" />
						</button>
				</div>
			</form:form>
		</div>

		<script>
			var messageID = $
			{
				newsMessage.id
			};

			$('#messageCreate').modal({
				show : false
			})
		</script>

</jsp:body>
</t:menuLVL1.NEW303>