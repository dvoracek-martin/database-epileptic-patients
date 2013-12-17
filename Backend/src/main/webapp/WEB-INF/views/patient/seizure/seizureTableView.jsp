<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${seizure.id}" class="panel-collapse collapse <c:if test="${count == 0}">in</c:if> ">
    <div class="panel-body">
        <table class="table">
            <tbody>

            <tr>
                <th class="col-xs-3"><spring:message code="label.seizureFrequency"/></th>
                <c:if test="${seizure.seizureFrequency==1}">
                    <td class="col-xs-9"><spring:message code="label.daily"/></td>
                </c:if>
                <c:if test="${seizure.seizureFrequency==2}">
                    <td class="col-xs-9"><spring:message code="label.weekly"/></td>
                </c:if>
                <c:if test="${seizure.seizureFrequency==3}">
                    <td class="col-xs-9"><spring:message code="label.monthly"/></td>
                </c:if>
                <c:if test="${seizure.seizureFrequency==4}">
                    <td class="col-xs-9"><spring:message code="label.lessThanMonthly"/></td>
                </c:if>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.seizureFrequency"/> Sekundárně generalizované</th>
                <c:if test="${seizure.secondarilyGeneralizedSeizure==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${seizure.secondarilyGeneralizedSeizure==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.seizureFrequency"/> Status epilepticus</th>
                <c:if test="${seizure.statusEpilepticus==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${seizure.statusEpilepticus==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.seizureFrequency"/> nonepilepticSeizures</th>
                <c:if test="${seizure.nonepilepticSeizures==true}">
                    <td><spring:message code="label.yes"/></td>
                </c:if>
                <c:if test="${seizure.nonepilepticSeizures==false}">
                    <td><spring:message code="label.no"/></td>
                </c:if>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.seizureFrequency"/> seizure_occurrence</th>
                <c:if test="${seizure.seizureOccurrence==0}">
                    <td><spring:message code="label.yes"/> both</td>
                </c:if>
                <c:if test="${seizure.seizureOccurrence==1}">
                    <td><spring:message code="label.no"/> sleep</td>
                </c:if>
                <c:if test="${seizure.seizureOccurrence==2}">
                    <td><spring:message code="label.no"/> both</td>
                </c:if>
            </tr>

            <tr>
                <th class="col-xs-3"><spring:message code="label.comment"/></th>
                <c:choose>
                    <c:when test="${empty seizure.comment}">
                        <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                    </c:when>
                    <c:otherwise>
                        <td>${seizure.comment}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
                <td colspan="2">
                    <%@include file="detail/seizureDetailTableView.jsp" %>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>