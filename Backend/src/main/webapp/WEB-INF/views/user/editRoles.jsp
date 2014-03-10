<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/validation.css"/>" rel="stylesheet">
	 <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.editUser"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script>
            $(function () {
                $('#sortable1, #sortable2').sortable({
                    connectWith: '.connected'
                });
            });
        </script>
    </jsp:attribute>

    <jsp:body>
        <%-- <style>
             #demos section {
                 overflow: hidden;
             }

             .sortable {
                 width: 310px;
                 -webkit-user-select: none;
                 -moz-user-select: none;
                 -ms-user-select: none;
                 user-select: none;
             }

             .sortable.grid {
                 overflow: hidden;
             }

             .sortable li {
                 list-style: none;
                 border: 1px solid #CCC;
                 background: #F6F6F6;
                 color: #1C94C4;
                 margin: 5px;
                 padding: 5px;
                 height: 22px;
             }

             .sortable.grid li {
                 line-height: 80px;
                 float: left;
                 width: 80px;
                 height: 80px;
                 text-align: center;
             }

             .handle {
                 cursor: move;
             }

             .sortable.connected {
                 width: 200px;
                 min-height: 100px;
                 float: left;
             }

             li.disabled {
                 opacity: 0.5;
             }

             li.highlight {
                 background: #FEE25F;
             }

             li.sortable-placeholder {
                 border: 1px dashed #CCC;
                 background: none;
             }
         </style>--%>


        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.editRoles"/>
                </h2>
            </div>
        </div>

        <div class="row">

        <div class="col-xs-6">
            <label>Dostupné role</label>
            <ul id="sortable1" class="connected sortable list"
                style="border-style: solid; border-width: 5px; border-color: CornflowerBlue;">

                <c:forEach var="possibleRole" items="${listOfPossibleRoles}">
                    <li draggable="true">${possibleRole.authority}
                        <input class="btn" type="hidden" name="role"
                               value="${possibleRole.id}">
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="col-xs-6">
        <label>Moje role</label>
        <form:form method="POST" action="/GENEPI/user/${user.id }/edit-roles">


            <ul id="sortable2" class="connected sortable list"
                style="border-style: solid; border-width: 5px; border-color: CornflowerBlue;">
                <c:forEach var="role" items="${user.roles}">
                    <li draggable="true">${role.authority}
                        <input class="btn" type="hidden" name="role"
                               value="${role.id}">
                    </li>
                </c:forEach>
            </ul>
            </div>
            </div>
            <div class="row">
            <div class="col-xs-12">
            <input type="submit" value="uložit" class="btn btn-primary">
        </form:form>
        </div>
        </div>
    </jsp:body>
</t:menuLVL1>
