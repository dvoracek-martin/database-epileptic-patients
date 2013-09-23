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
				<li><a
							href="<c:url value="/user/${user.id}/change-password" />"><spring:message
									code="label.changePassword" /></a></li>
				<li><a href="<c:url value="/underConstruction"/>"><spring:message
									code="label.deleteUser" /></a></li>
			</ul>
		</div>
	</div>

</c:forEach>
	</jsp:body>
</t:menuLVL2>

