<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      <spring:message code="label.allusers" />
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.allusers" />
    </jsp:attribute>
	<jsp:attribute name="script">
   		</jsp:attribute>

	<jsp:body>
	<div class="span5">
	<h2>
		<spring:message code="label.allusers" />
	</h2>
</div>
<div>
	<h3>
		<a href="<c:url value="/user/create" />" style="text-decoration: none"><spring:message
						code="label.newuser" /></a>
	</h3>
</div>


<c:forEach items="${userList}" var="user">


	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="<c:url value="/user/${user.id}/overview" />">${user.username}</a>
			<ul class="nav">
				<li><a href="<c:url value="/user/${user.id}/edit" />"><spring:message
									code="label.editdata" /></a></li>
				<li><a href="<c:url value="/user/${user.id}/edit-roles" />"><spring:message
									code="label.editRoles" /></a></li>
				<li><a
							href="<c:url value="/user/${user.id}/change-password" />"><spring:message
									code="label.changePassword" /></a></li>
									
				<li><a href="#userDeleteConfirm${user.id}" role="button" class="btn"
							data-toggle="modal"><spring:message
									code="label.deleteUser" /></a></li>
			</ul>
		</div>
	</div>

	<!-- Modal window>: user delete confirmation -->
<div id="userDeleteConfirm${user.id}" class="modal hide fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
<h3 id="myModalLabel">User deletion</h3>
</div>
<div class="modal-body">
<p>Do you really wnat ot delete this user?</p>
</div>
<div class="modal-footer">
<button class="btn" data-dismiss="modal" aria-hidden="true">NO</button>
<a class="btn btn-primary" href="<c:url value="/user/${user.id}/delete"/>">YES</a>

</div>
</div>
<script>
var userID = ${user.id};
	$('#userDeleteConfirm'+userID).modal({
		show: false
	})
</script>
</c:forEach>

	</jsp:body>
</t:menuLVL2>

