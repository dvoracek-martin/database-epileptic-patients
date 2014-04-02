<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="title">
      Search Results
    </jsp:attribute>


    <jsp:body>
        <c:choose>
            <c:when test="${isEmpty}">
                no result
            </c:when>
            <c:otherwise>

                <div class="text-center">
                    <ul class="pagination">
                        <li><a class="start" href="#">&laquo;</a></li>
                        <li><a class="prev" href="#">&lsaquo;</a></li>
                        <c:forEach var="i" begin="1" end="${pages}">
                            <li><a href="#">${i}</a></li>
                        </c:forEach>
                        <li class="next-li"><a class="next" href="#">&rsaquo;</a></li>
                        <li><a class="end" href="#">&raquo;</a></li>
                    </ul>
                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <td>
                                <b><spring:message code="label.firstname"/></b>
                            </td>
                            <td>
                                <b><spring:message code="label.lastname"/></b>
                            </td>
                            <td>
                                <b><spring:message code="label.birthIdentificationNumber"/></b>
                            </td>
                            <td>
                                <b><spring:message code="label.address"/></b>
                            </td>
                            <td>
                                <b><spring:message code="label.addressCity"/></b>
                            </td>
                        </tr>
                        </thead>
                        <tbody id="patientList">

                        <c:set value="0" var="count"/>

                        <c:forEach items="${patients}" var="patient">

                        <c:if test="${count % 20 == 0}">

                        <div id="page-${count}">

                            </c:if>

                            <tr class="clickable-row" href="<c:url value="/patient/${patient.id}/overview" />">
                                <td>
                                        ${patient.contact.firstName}
                                </td>
                                <td>
                                        ${patient.contact.lastName}
                                </td>
                                <td>
                                        ${patient.nin}
                                </td>
                                <c:choose>
                                    <c:when test="${empty patient.contact.addressStreet}">
                                        <td></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>
                                                ${patient.contact.addressStreet}, ${patient.contact.addressHn}
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                                <td>
                                        ${patient.contact.addressCity}
                                </td>
                            </tr>
                            </c:forEach>
                                <%--  <c:forEach items="${patientList}" var="patient">
                                      <tr class="clickable-row" href="<c:url value="/patient/${patient.id}/overview" />">
                                          <td>
                                                  ${patient.contact.firstName}
                                          </td>
                                          <td>
                                                  ${patient.contact.lastName}
                                          </td>
                                          <td>
                                                  ${patient.nin}
                                          </td>
                                          <c:choose>
                                              <c:when test="${empty patient.contact.addressStreet}">
                                                  <td></td>
                                              </c:when>
                                              <c:otherwise>
                                                  <td>
                                                          ${patient.contact.addressStreet}, ${patient.contact.addressHn}
                                                  </td>
                                              </c:otherwise>
                                          </c:choose>
                                          <td>
                                                  ${patient.contact.addressCity}
                                          </td>
                                      </tr>
                                  </c:forEach> --%>
                        </tbody>
                    </table>
                </div>

                <div class="text-center">
                    <ul class="pagination">
                        <li><a class="start" href="#">&laquo;</a></li>
                        <li><a class="prev" href="#">&lsaquo;</a></li>
                        <c:forEach var="i" begin="1" end="${pages}">
                            <li><a href="#">${i}</a></li>
                        </c:forEach>
                        <li class="next-li"><a class="next" href="#">&rsaquo;</a></li>
                        <li><a class="end" href="#">&raquo;</a></li>
                    </ul>
                </div>


            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:menuLVL1>