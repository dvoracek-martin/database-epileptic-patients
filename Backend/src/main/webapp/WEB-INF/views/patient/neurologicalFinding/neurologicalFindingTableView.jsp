<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${neurologicalFinding.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3"><spring:message code="label.hemisphereDominance"/></th>
            <td class="col-xs-9"><spring:message code="label.hemisphereDominance.${neurologicalFinding.hemisphereDominance}"/></td>
            <%--  <th class="col-xs-3"><spring:message code="label.hemisphereDominance"/></th>
              <c:if test="${neurologicalFinding.hemisphereDominance==1}">
                  <td class="col-xs-9"><spring:message code="label.ambidexter"/></td>
              </c:if>
              <c:if test="${neurologicalFinding.hemisphereDominance==2}">
                  <td class="col-xs-9"><spring:message code="label.lefthander"/></td>
              </c:if>
              <c:if test="${neurologicalFinding.hemisphereDominance==3}">
                  <td class="col-xs-9"><spring:message code="label.unspecified"/></td>
              </c:if>
              <c:if test="${neurologicalFinding.hemisphereDominance==4}">
                  <td class="col-xs-9"><spring:message code="label.righthander"/></td>
              </c:if> --%>
          </tr>
           <tr>
               <th class="col-xs-3"><spring:message code="label.abnormalNeurologicalFinding"/></th>
               <td class="col-xs-9"><spring:message code="label.boolean.${neurologicalFinding.abnormalNeurologicalFinding}"/></td>
           <%--
              <th class="col-xs-3"><spring:message code="label.abnormalNeurologicalFinding"/></th>
              <c:if test="${neurologicalFinding.abnormalNeurologicalFinding==true}">
                  <td class="col-xs-9"><spring:message code="label.yes"/></td>
              </c:if>
              <c:if test="${neurologicalFinding.abnormalNeurologicalFinding==false}">
                  <td class="col-xs-9"><spring:message code="label.no"/></td>
              </c:if>--%>
          </tr>
          <tr>
              <th class="col-xs-3"><spring:message code="label.hemiparesis"/></th>
              <td class="col-xs-9"><spring:message code="label.boolean.${neurologicalFinding.hemiparesis}"/></td>
              <%--
             <th class="col-xs-3"><spring:message code="label.hemiparesis"/></th>
             <c:if test="${neurologicalFinding.hemiparesis==true}">
                 <td class="col-xs-9"><spring:message code="label.yes"/></td>
             </c:if>
             <c:if test="${neurologicalFinding.hemiparesis==false}">
                 <td class="col-xs-9"><spring:message code="label.no"/></td>
             </c:if>--%>
         </tr>
         <tr>
             <th class="col-xs-3"><spring:message code="label.visualFieldDefect"/></th>
             <td class="col-xs-9"><spring:message code="label.boolean.${neurologicalFinding.visualFieldDefects}"/></td>
             <%--
             <th class="col-xs-3"><spring:message code="label.visualFieldDefects"/></th>
             <c:if test="${neurologicalFinding.visualFieldDefects==true}">
                 <td class="col-xs-9"><spring:message code="label.yes"/></td>
             </c:if>
             <c:if test="${neurologicalFinding.visualFieldDefects==false}">
                 <td class="col-xs-9"><spring:message code="label.no"/></td>
             </c:if>--%>
         </tr>
         <tr>
             <th class="col-xs-3"><spring:message code="label.comment"/></th>
             <c:choose>
                 <c:when test="${empty neurologicalFinding.comment}">
                     <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                 </c:when>
                 <c:otherwise>
                     <td class="col-xs-9">${neurologicalFinding.comment}</td>
                 </c:otherwise>
             </c:choose>
         </tr>
        </tbody>
    </table>
</div>