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

    <jsp:attribute name="script">
     	<script>
     		function prepareEdit(messageID) {
     			$('#editForm').attr( 'action','/GENEPI/news/'+messageID+'/edit');
     			var message=$("#message"+messageID).html();
     			$("#editContent").val(message);
     		}

            function prepareDelete(messageID) {
                $('#confirmDelete').attr( 'href','/GENEPI/news/'+messageID+'/delete')
            }

     		function cleanEdit() {
     			$("#editContent").val("");
     		}

            function cleanCreate() {
                $("#createContent").val("");
            }
     	</script>
    </jsp:attribute>

	<jsp:body>
	<div class="row">
    	<div class="col-xs-6">
        	<h2>
        		<spring:message code="label.news" />
        	</h2>				
      	</div>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <div class="col-xs-6">
                <h3 class="pull-right">
                     <a data-toggle="modal" data-target="#create">Přidat zprávu</a>
                </h3>
            </div>
        </sec:authorize>
    </div>

    <div class="panel-group" id="accordion">
    	<c:forEach items="${newsMessages}" var="newsMessage">
    		<div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <span>
                            ${newsMessage.date}
                        </span>
							  	
						<sec:authorize ifAnyGranted="ROLE_ADMIN">	  					
							<a class="pull-right" data-toggle="modal" data-target="#delete" onclick="prepareDelete(${newsMessage.id})">
	                            <span class="glyphicon glyphicon-remove-circle"></span> delete
	                        </a>
	                        <a class="pull-right" data-toggle="modal" data-target="#edit" onclick="prepareEdit(${newsMessage.id})">
	                            <span class="glyphicon glyphicon-edit"></span> edit&nbsp;
	                        </a>
                        </sec:authorize>					
                    </h4>
                </div>
                <div class="panel-collapse collapse in">
    				<div class="panel-body">
        				<table class="table">
            				<tbody>
            					<tr><p id="message${newsMessage.id}">${newsMessage.message}</p></tr>
            				</tbody>
            			</table>
            		</div>
            	</div>
            </div>
    	</c:forEach>
    </div>

    <div class="modal fade" id="edit">
		<div class="modal-dialog">
		  	<div class="modal-content">
		      	<div class="modal-header">
		        	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        	<h4 class="modal-title"><spring:message code="label.messageEditing" /></h4>
		      	</div>
		      	<form:form id="editForm" method="POST" modelAttribute="emptyMessage"
                                                        action="/GENEPI/news/${newsMessage.id}/edit"
                                                        commandName="emptyMessage">
			      	<div class="modal-body">
						<form:input type="text" path="message" class="form-control" id="editContent"/>	
			      	</div>
			      	<div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal" onclick="cleanEdit()">Close</button>
			        	<button type="submit" class="btn btn-primary">Save changes</button>
			      	</div>
			   	</form:form>
		    </div>
		</div>
	</div>

    <div class="modal fade" id="delete">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Smaz zprávu</h4>
                </div>

                <div class="modal-body">
                    <h5>Opravdu chcete smazat zprávu?</h5>  
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Ne</button>
                    <a id="confirmDelete" class="btn btn-primary" href="">Ano</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="create">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Přidat novou zprávu</h4>
                </div>

                <form:form method="POST" modelAttribute="emptyMessage"
                   action="/GENEPI/news/create" commandName="emptyMessage">

                    <div class="modal-body">
                        <form:input type="text" path="message" class="form-control" id="createContent"/>  
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="cleanCreate()">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

</jsp:body>
</t:menuLVL1.NEW303>