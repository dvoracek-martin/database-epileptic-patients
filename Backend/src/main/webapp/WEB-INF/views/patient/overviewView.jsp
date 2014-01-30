<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

<jsp:attribute name="title">
      <spring:message code="label.patient"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.patient"/>
        </h2>

    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a id="export" href="<c:url value="/patient/${patient.id}/export" />">
                <spring:message code="label.exportPatient"/>
            </a>
        </h3>
    </div>
</div>

<%@include file="patientDetails.jsp" %>

<!-- print out latest anamnesis START -->
<%--<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.anamnesis"/>
        </h2>

    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/anamnesis/create" />"><spring:message
                    code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.anamnesisList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <div class="panel-group" id="accordion">

        <c:set var="anamnesis" value="${patient.anamnesisList[0]}" scope="page"/>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapse${anamnesis.id}">
                        Zadano dne: ${anamnesis.date}
                    </a>

                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/anamnesis/list" />">Zobrazit
                        vsechny</a>

                </h4>
            </div>
            <%@include file="anamnesis/anamnesisTableView.jsp" %>
        </div>
        <c:set var="count" value="1" scope="page"/>
    </div>
</c:otherwise>
</c:choose>
--%>

<%-- Seizure --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.seizures"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/seizure/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.seizureList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="seizure" value="${patient.seizureList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse${seizure.id}">
                        Zadano dne: ${seizure.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/seizure/list" />">
                        Zobrazit vsechny
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="seizure/seizureTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Pharmacotherapy --%>
<%--
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.pharmacotherapy"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.pharmacotherapyList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="pharmacotherapy" value="${patient.pharmacotherapyList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse${pharmacotherapy.id}">
                        Zadano dne: ${pharmacotherapy.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">
                        Zobrazit vsechny
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="pharmacotherapy/pharmacotherapyTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>
--%>

<%-- Neurological Finding --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.neurologicalFinding"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/neurological-finding/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.neurologicalFindingList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="neurologicalFinding" value="${patient.neurologicalFindingList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse${neurologicalFinding.id}">
                        Zadano dne: ${neurologicalFinding.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/neurological-finding/list" />">
                        Zobrazit vsechny
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="neurologicalFinding/neurologicalFindingTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%--
<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Záchvaty</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/seizure/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>
<c:choose>
    <c:when test="${empty patient.seizureList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                   <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.seizureList[0].date}</td>
                </tr>
                <tr class="info">
                    <td>Četnost záchvatů</td>
                    <c:if test="${patient.seizureList[0].seizureFrequencyIdcom==1}">
                        <td>Denně</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].seizureFrequencyIdcom==2}">
                        <td>Týdně</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].seizureFrequencyIdcom==3}">
                        <td>Méně než měsíčně</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].seizureFrequencyIdcom==4}">
                        <td>Měsíčně</td>
                    </c:if>
                </tr>

                <tr class="info">
                    <td>Status epilepticus</td>
                    <c:if test="${patient.seizureList[0].statusEpilepticus==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].statusEpilepticus==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>SSC klasifikace</td>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==1}">
                        <td>1. Epileptický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==2}">
                        <td>2. Aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==3}">
                        <td>2.a. Somastosenzorická aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==4}">
                        <td>2.b. Zraková aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==5}">
                        <td>2.c. Sluchová aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==6}">
                        <td>2.d. Čichová aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==7}">
                        <td>2.e. Chuťová aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==8}">
                        <td>2.f. Autonomní aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==9}">
                        <td>2.g. Epigastrická aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==10}">
                        <td>2.h. Psychická aura</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==11}">
                        <td>3. Absence</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==12}">
                        <td>4. Autonomní záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==13}">
                        <td>5. Psychomotorický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==14}">
                        <td>6. Motorický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==15}">
                        <td>6.a. Klonický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==16}">
                        <td>6.b. Tonický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==17}">
                        <td>6.c. Tonicko-klonický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==18}">
                        <td>6.d. Atonický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==19}">
                        <td>6.e. Akinetický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==20}">
                        <td>6.f. Versivní záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==21}">
                        <td>6.g. Myoklonický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==22}">
                        <td>6.h. Hypermotorický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==23}">
                        <td>6.i. Hypomotorický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==24}">
                        <td>6.j. Negativní myoklonický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==25}">
                        <td>6.k. Astatický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==26}">
                        <td>6.l. Akinetický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==27}">
                        <td>6.m. Afázický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==28}">
                        <td>6.n. Gelastický záchvat</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].sscClassificationIdcom==29}">
                        <td>7. Paroxysmální příhoda</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>ILAE klasifikace</td>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==1}">
                        <td>I.A.1. Jednoduchý parciální záchvat s motorickými symptomy</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==2}">
                        <td>I.A.2. Jednoduchý parciální záchvat s psychickými symptomy</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==3}">
                        <td>I.A.3. Jednoduchý parciální záchvat s autonomními symptomy</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==4}">
                        <td>I.A.4. Jednoduchý parciální záchvat se somatosenzorickými symptomy</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==5}">
                        <td>I.B.1. Komplexní parciální záchvat s jednoduchým parciálním záchvatem na počátku,  následovaným poruc</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==6}">
                        <td>I.B.2. Komplexní parciální záchvat s poruchou vědomí na počátku</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==7}">
                        <td>I.C. Parciální záchvat sekundárně se rozvíjející v generalizovaný</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==8}">
                        <td>II.A.1. Generalizovaný - Typická absence</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==9}">
                        <td>II.A.2. Generalizovaný - Atypická absence</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==10}">
                        <td>II.B. Generalizovaný - Myoklonický</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==11}">
                        <td>II.C. Generalizovaný - Klonický</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==12}">
                        <td>II.D. Generalizovaný - Tonický</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==13}">
                        <td>II.E. Generalizovaný - Tonicko-klonický</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==14}">
                        <td>II.F. Generalizovaný - Atonický</td>
                    </c:if>
                    <c:if test="${patient.seizureList[0].ilaeClassificationIdcom==15}">
                        <td>III. Neklasifikovaný</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.seizureList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.seizureList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/seizure/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Farmakoterapie</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>
<c:choose>
    <c:when test="${empty patient.pharmacotherapyList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                   <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.pharmacotherapyList[0].date}</td>
                </tr>
                <tr class="info">
                    <td>Léčivo</td>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==1}">
                        <td>ACTH</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==2}">
                        <td>CBZ</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==3}">
                        <td>CLB</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==4}">
                        <td>CZP</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==5}">
                        <td>DZP</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==6}">
                        <td>ESL</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==7}">
                        <td>ETS</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==8}">
                        <td>FBM</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==9}">
                        <td>GBP</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==10}">
                        <td>LCM</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==11}">
                        <td>LEV</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==12}">
                        <td>LTG</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==13}">
                        <td>OXC</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==14}">
                        <td>PB</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==15}">
                        <td>PGB</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==16}">
                        <td>PHT</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==17}">
                        <td>PRM</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==18}">
                        <td>RFM</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==19}">
                        <td>STM</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==20}">
                        <td>TGB</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==21}">
                        <td>TPM</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==22}">
                        <td>VGB</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==23}">
                        <td>VPA</td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].aedIdcom==24}">
                        <td>ZNS</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Efektivita</td>
                    <c:if test="${patient.pharmacotherapyList[0].effective==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].effective==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Při operaci</td>
                    <c:if test="${patient.pharmacotherapyList[0].duringSurgery==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.pharmacotherapyList[0].duringSurgery==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.pharmacotherapyList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.pharmacotherapyList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Neurologické nálezy</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/neurologicalFinding/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.neurologicalFindingList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                   <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.neurologicalFindingList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Dominance hemisféry</td>
                    <c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==1}">
                        <td>Ambidexter</td>
                    </c:if>
                    <c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==2}">
                        <td>Levák</td>
                    </c:if>
                    <c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==3}">
                        <td>Nespecifikováno</td>
                    </c:if>
                    <c:if test="${patient.neurologicalFindingList[0].hemisphereDominanceIdcom==4}">
                        <td>Pravák</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Abnormální neurologický nález</td>
                    <c:if test="${patient.neurologicalFindingList[0].abnormalNeurologicalFinding==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neurologicalFindingList[0].abnormalNeurologicalFinding==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Hemiparéza</td>
                    <c:if test="${patient.neurologicalFindingList[0].hemiparesis==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neurologicalFindingList[0].hemiparesis==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Defekt zorného pole</td>
                    <c:if test="${patient.neurologicalFindingList[0].visualCut==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neurologicalFindingList[0].visualCut==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Detaily neurologického nálezu</td>
                    <td>${patient.neurologicalFindingList[0].neurologicalFindingDetail}</td>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.neurologicalFindingList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.neurologicalFindingList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>

              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/neurologicalFinding/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Neuropsychologie</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/neuropsychology/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.neuropsychologyList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                   <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.neuropsychologyList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Neuropsychologické vyšetření</td>
                    <c:if test="${patient.neuropsychologyList[0].neuropsychologicalExamination==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].neuropsychologicalExamination==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Věk při neuropsychologickém vyšetření</td>
                    <td><strong>N/A</strong></td>
                </tr>
                <tr class="info">
                    <td>Inteligenční úroveň</td>
                    <c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==1}">
                        <td>Mírná mentální retardace</td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==2}">
                        <td>Naprůměrná inteligence</td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==3}">
                        <td>Podprůměrná inteligence</td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==4}">
                        <td>Průměrná inteligence</td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==5}">
                        <td>Středně těžká mentální retardace</td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].intelligenceLevelIdcom==6}">
                        <td>Těžká mentální retardace</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Specifická porucha učení</td>
                    <c:if test="${patient.neuropsychologyList[0].specificLearning==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].specificLearning==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Vývojová porucha řeči</td>
                    <c:if test="${patient.neuropsychologyList[0].developmentalLanguageDisorders==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].developmentalLanguageDisorders==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>ADHD syndrom</td>
                    <c:if test="${patient.neuropsychologyList[0].adhdSyndrome==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.neuropsychologyList[0].adhdSyndrome==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.neuropsychologyList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.neuropsychologyList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Diagnostické testy - EEG</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/diagnosticTestEEG/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.diagnosticTestEEGList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                   <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.diagnosticTestEEGList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Základní EEG aktivita</td>
                    <c:if test="${patient.diagnosticTestEEGList[0].basicEegActivityIdcom==1}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].basicEegActivityIdcom==2}">
                        <td>Pomalá</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>EEG zpomalení</td>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegSlowIdcom==1}">
                        <td>Generalizované kontinuální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegSlowIdcom==2}">
                        <td>Generalizované přerušované</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegSlowIdcom==3}">
                        <td>Lokalizované kontinuální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegSlowIdcom==4}">
                        <td>Lokalizované přerušované</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegSlowIdcom==5}">
                        <td>Žádné</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Interiktální EEG hroty</td>
                    <c:if test="${patient.diagnosticTestEEGList[0].interictalEegSpikesIdcom==1}">
                        <td>Generalizované</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].interictalEegSpikesIdcom==2}">
                        <td>Hemisferální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].interictalEegSpikesIdcom==3}">
                        <td>Multiregionální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].interictalEegSpikesIdcom==4}">
                        <td>Nelatralizovatelné</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].interictalEegSpikesIdcom==5}">
                        <td>Regionální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].interictalEegSpikesIdcom==6}">
                        <td>Žádné</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Lokalizace interiktálních EEG hrotů</td>
                    <td>${patient.diagnosticTestEEGList[0].localizationInterictalEegSpikes}</td>
                </tr>
                <tr class="info">
                    <td>EEG status epilepticus</td>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegStatusEpilepticus==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].eegStatusEpilepticus==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Sekundární bilaterální synchronie</td>
                    <c:if test="${patient.diagnosticTestEEGList[0].secondarySidedSynchrony==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].secondarySidedSynchrony==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Iktální EEG vzorce</td>
                    <c:if test="${patient.diagnosticTestEEGList[0].ictalEegPatternsIdcom==1}">
                        <td>Chybějící</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].ictalEegPatternsIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].ictalEegPatternsIdcom==3}">
                        <td>Multiregionální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].ictalEegPatternsIdcom==4}">
                        <td>Nelokalizovatelné</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestEEGList[0].ictalEegPatternsIdcom==5}">
                        <td>Regionální</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Lokalizace iktálních EEG vzorů</td>
                    <td>${patient.diagnosticTestEEGList[0].localizationIctalEegPattern}</td>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.diagnosticTestEEGList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.diagnosticTestEEGList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/diagnosticTestEEG/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Diagnostické testy - MRI</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/diagnosticTestMRI/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.diagnosticTestMRIList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.diagnosticTestMRIList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>MRI protokol</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriProtocolIdcom==1}">
                        <td>EPI 2</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriProtocolIdcom==2}">
                        <td>Standard + 1.5 mm T1w</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriProtocolIdcom==3}">
                        <td>Standardní MRI protokol</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>MRI nález</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==1}">
                        <td>Bilaterální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==3}">
                        <td>Hemisferální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==4}">
                        <td>Lobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==5}">
                        <td>Multilobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==6}">
                        <td>Neprovedeno</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==7}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mriFindingIdcom==8}">
                        <td>Postoperační</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>FDG PET</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==1}">
                        <td>Bilaterální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==3}">
                        <td>Hemisferální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==4}">
                        <td>Lobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==5}">
                        <td>Multilobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==6}">
                        <td>Neprovedeno</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==7}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fdgPetIdcom==8}">
                        <td>Postoperační</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Interiktální SPECT</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==1}">
                        <td>Bilaterální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==3}">
                        <td>Hemisferální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==4}">
                        <td>Lobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==5}">
                        <td>Multilobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==6}">
                        <td>Neprovedeno</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==7}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].interictalSpectIdcom==8}">
                        <td>Postoperační</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>FDG PET</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==1}">
                        <td>Bilaterální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==3}">
                        <td>Hemisferální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==4}">
                        <td>Lobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==5}">
                        <td>Multilobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==6}">
                        <td>Neprovedeno</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==7}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].ictaliSpectIdcom==8}">
                        <td>Postoperační</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>SISCOM</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].siscom==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].siscom==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>MRS protokol</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsProtocolIdcom==1}">
                        <td>CSI</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsProtocolIdcom==2}">
                        <td>Single voxel</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsProtocolIdcom==3}">
                        <td>Single voxel + CSI</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>MRS nález</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==1}">
                        <td>Bilaterální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==3}">
                        <td>Hemisferální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==4}">
                        <td>Lobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==5}">
                        <td>Multilobární</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==6}">
                        <td>Neprovedeno</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==7}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].mrsFinfingIdcom==8}">
                        <td>Postoperační</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>DTI</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].dti==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].dti==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Detaily DTI studie</td>
                    <td>${patient.diagnosticTestMRIList[0].detailsDtiStudie}</td>
                </tr>
                <tr class="info">
                    <td>fMRI</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].fmri==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].fmri==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Detaily fMRI</td>
                    <td>${patient.diagnosticTestMRIList[0].detailsFmri}</td>
                </tr>
                <tr class="info">
                    <td>WADA</td>
                    <c:if test="${patient.diagnosticTestMRIList[0].wada==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.diagnosticTestMRIList[0].wada==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Detaily WADA</td>
                    <td>${patient.diagnosticTestMRIList[0].detailsWada}</td>
                </tr>
                <tr class="info">
                    <td>MRI popis</td>
                    <td>${patient.diagnosticTestMRIList[0].mriDescribe}</td>
                </tr>
                <tr class="info">
                    <td>Lokalizace SPECT hypoperfuse</td>
                    <td>${patient.diagnosticTestMRIList[0].localizationSpectHypoperfuse}</td>
                </tr>
                <tr class="info">
                    <td>Lokalizace MRS abnormality</td>
                    <td>${patient.diagnosticTestMRIList[0].localizationMrsAbnormality}</td>
                </tr>
                <tr class="info">
                    <td>Lokalizace PET hypometabolismu</td>
                    <td>${patient.diagnosticTestMRIList[0].localizationPetHypometabolism}</td>
                </tr>
                <tr class="info">
                    <td>Lokalizace SPECT hyperperfuse</td>
                    <td>${patient.diagnosticTestMRIList[0].localizationSpectHyperperfuse}</td>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.diagnosticTestMRIList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.diagnosticTestMRIList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/diagnosticTestMRI/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Invazivní testy - EEG</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.invasiveTestEEGList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.invasiveTestEEGList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Invazivní monitorace</td>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveMonitoring==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveMonitoring==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Kortikální mapování</td>
                    <c:if test="${patient.invasiveTestEEGList[0].corticalMappingIdcoml==1}">
                        <td>Awake craniotomy</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].corticalMappingIdcoml==2}">
                        <td>Extraoperační elektrická stimulace</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].corticalMappingIdcoml==3}">
                        <td>Importovane funkcni mapovani</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].corticalMappingIdcoml==4}">
                        <td>Intraoperační elektrická stimulace</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].corticalMappingIdcoml==5}">
                        <td>Intraoperační elektrická stimulace + sledování intaktnosti drah</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].corticalMappingIdcoml==6}">
                        <td>Neprovedeno</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Intrakraniální elektrody</td>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==1}">
                        <td>Intracereb. + subdur. stripy + gridy</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==2}">
                        <td>Intracerebrální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==3}">
                        <td>Intracerebrální + subdurální gridy</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==4}">
                        <td>Intracerebrální + subdurální stripy</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==5}">
                        <td>Subdurální stripy</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==6}">
                        <td>Subdurání gridy</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].intracranialElectrodesIdcom==7}">
                        <td>Subdurání stripy + gridy</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Lokalizace intrakraniálních elektrod</td>
                    <td>${patient.invasiveTestEEGList[0].localizationIntracranialElectrodes}</td>
                </tr>
                <tr class="info">
                    <td>Invazivní EEG zpomalení</td>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegSlowingIdcom==1}">
                        <td>Generalizované intermitentní</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegSlowingIdcom==2}">
                        <td>Generalizované kontinuální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegSlowingIdcom==3}">
                        <td>Lokalizované intermitentní</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegSlowingIdcom==4}">
                        <td>Lokalizované kontinuální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegSlowingIdcom==5}">
                        <td>Žádné</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Invazivní EEG interiktální hroty</td>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegInterictalSpikesIdcom==1}">
                        <td>Chybějící</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegInterictalSpikesIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegInterictalSpikesIdcom==3}">
                        <td>Multiregionální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegInterictalSpikesIdcom==4}">
                        <td>Nelokalizované</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegInterictalSpikesIdcom==5}">
                        <td>Regionální</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Lokalizace invazivních EEG interiktálních hrotů</td>
                    <td>${patient.invasiveTestEEGList[0].localizationInvasiveEegInterictalSpikes}</td>
                </tr>
                <tr class="info">
                    <td>Invazivní EEG status epilepticus</td>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegStatusEpilepticus==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveEegStatusEpilepticus==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Invazivní EEG iktální vzorce</td>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveIctalEegPatternsIdcom==1}">
                        <td>Chybějící</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveIctalEegPatternsIdcom==2}">
                        <td>Fokální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveIctalEegPatternsIdcom==3}">
                        <td>Multiregionální</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveIctalEegPatternsIdcom==4}">
                        <td>Nelokalizované</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestEEGList[0].invasiveIctalEegPatternsIdcom==5}">
                        <td>Regionální</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Lokalizce invazivních EEG iktálních vzorců</td>
                    <td>${patient.invasiveTestEEGList[0].localizationInvasiveIctalEegPatterns}</td>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.invasiveTestEEGList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.invasiveTestEEGList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Invazivní testy - ECoG</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/invasiveTestECOG/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.invasiveTestECOGList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.invasiveTestECOGList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Intraoperační ECoG</td>
                    <c:if test="${patient.invasiveTestECOGList[0].intraoperativeEcog==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].intraoperativeEcog==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>ECoG pokrytí</td>
                    <td>${patient.invasiveTestECOGList[0].ecogCover}</td>
                </tr>
                <tr class="info">
                    <td>ECoG vzorce</td>
                    <c:if test="${patient.invasiveTestECOGList[0].ecogPatternsIdcom==1}">
                        <td>Bez hrotů</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].ecogPatternsIdcom==2}">
                        <td>Burst-suppression</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].ecogPatternsIdcom==3}">
                        <td>Kontinuální hroty</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].ecogPatternsIdcom==4}">
                        <td>Nespecifická abnormalita</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].ecogPatternsIdcom==5}">
                        <td>S hroty</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>ECoG po resekci</td>
                    <c:if test="${patient.invasiveTestECOGList[0].afterResectionEcogIdcom==1}">
                        <td>Bez hrotů</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].afterResectionEcogIdcom==2}">
                        <td>Neprovedena</td>
                    </c:if>
                    <c:if test="${patient.invasiveTestECOGList[0].afterResectionEcogIdcom==3}">
                        <td>S hroty</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.operationList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.invasiveTestECOGList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/invasiveTestECOG/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Operace</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/operation/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.operationList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.operationList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Typ operace</td>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==1}">
                        <td>Diskonekce</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==2}">
                        <td>Hemisferektomie</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==3}">
                        <td>Kortikální resekce</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==4}">
                        <td>Lesionektomie</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==5}">
                        <td>Rozšíření Lesionektomie</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==6}">
                        <td>Standardizované resekce</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==7}">
                        <td>Tailored resekce</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].typeOperationsIdcom==8}">
                        <td>Zákrok gamma nožem</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Rozsah operace</td>
                    <c:if test="${patient.operationList[0].rangeOperationsIdcom==1}">
                        <td>Fokální resekce</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].rangeOperationsIdcom==2}">
                        <td>Hemisferektomie</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].rangeOperationsIdcom==3}">
                        <td>Jednolobární resekce</td>
                    </c:if>
                    <c:if test="${patient.operationList[0].rangeOperationsIdcom==4}">
                        <td>Multilobární resekce</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Lokalizace operace</td>
                    <td>${patient.operationList[0].localizationOperations}</td>
                </tr>
                <tr class="info">
                    <td>MST</td>
                    <c:if test="${patient.operationList[0].mst==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.operationList[0].mst==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Kalostomie</td>
                    <c:if test="${patient.operationList[0].colostomy==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.operationList[0].colostomy==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>VNS</td>
                    <c:if test="${patient.operationList[0].vns==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.operationList[0].vns==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Datum imlantace VNS</td>
                    <td>${patient.operationList[0].VNSImplantationDate}</td>
                </tr>
                <tr class="info">
                    <td>Detail operace</td>
                    <td>${patient.operationList[0].operationDetails}</td>
                </tr>
                <tr class="info">
                    <td>Resekce kompletní</td>
                    <c:if test="${patient.operationList[0].completeResection==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.operationList[0].completeResection==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.operationList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.operationList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/operation/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Histologie</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/histology/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.histologyList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.histologyList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Histopatologie</td>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==1}">
                        <td>FCD</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==2}">
                        <td>Gliální léze</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==3}">
                        <td>HS</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==4}">
                        <td>Hamartom</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==5}">
                        <td>MCD jiná</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==6}">
                        <td>Normální</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==7}">
                        <td>Nádor</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==8}">
                        <td>Posttraumatické změny</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==9}">
                        <td>SWC</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==10}">
                        <td>TSC</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==11}">
                        <td>Vaskulární léze</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyIdcom==12}">
                        <td>Zánětlivá léze</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Klasifikace FCD</td>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==1}">
                        <td>0</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==2}">
                        <td>FCD typ lla</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==3}">
                        <td>FCD typ llb</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==4}">
                        <td>FCD typ lla</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==5}">
                        <td>FCD typ la</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==6}">
                        <td>FCD typ lb</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==7}">
                        <td>mMCD typ l</td>
                    </c:if>
                    <c:if test="${patient.histologyList[0].histopathologyClasificationIdcom==8}">
                        <td>mMCD typ ll</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.histologyList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.histologyList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/histology/list" />">Zobrazit vsechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<div>
    <div class="span4">
        <h3>Komplikace</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/complication/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.complicationList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.complicationList[0].date}</td>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.complication"/></td>
                    <c:if test="${patient.complicationList[0].complicationIdcom==1}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.0"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==2}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.aphasia"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==3}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.hemiparesis"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==4}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.other"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==5}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.paresisOfCranialNerves"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==6}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.visualFieldDefects"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==7}">
                        <td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.death"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==8}">
                        <td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.0"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==9}">
                        <td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.hemiparesis"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==10}">
                        <td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.other"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==11}">
                        <td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.paresisOfCranialNerves"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==12}">
                        <td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.visualFieldDefects"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==13}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.0"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==14}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.aphasia"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==15}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.edema"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==16}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.hemiparesis"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==17}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.hydrocefalus"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==18}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.ischemia"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==19}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.other"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==20}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.hemorrhage"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==21}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.paresisOfCranialNerves"/></td>
                    </c:if>
                    <c:if test="${patient.complicationList[0].complicationIdcom==22}">
                        <td><spring:message code="label.transitional"/> - <spring:message code="label.inflammation"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.complicationList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.complicationList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/complication/list" />">Zobrazit všechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose>

<!-- print out latest  START -->
<div>
    <div class="span4">
        <h3>Outcome</h3>
    </div>
    <div>
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/outcome/create" />"><spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.outcomeList}">
        </br></br>
          <div class="alert alert-block">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <h4>Žádný záznam!</h4>
        </div>
    </c:when>

      <c:otherwise>
        <table class="table">
               <tbody>
                <tr class="alert-info">
                          <td colspan="2"><strong>Vyšetření dne:</strong> ${patient.outcomeList[0].date}</td>
                </tr>

                <tr class="info">
                    <td>Seizure outcome</td>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==1}">
                        <td>0</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==2}">
                        <td>IA</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==3}">
                        <td>IB</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==4}">
                        <td>IC</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==5}">
                        <td>ID</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==6}">
                        <td>IIA</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==7}">
                        <td>IIB</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==8}">
                        <td>IIC</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==9}">
                        <td>IID</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==10}">
                        <td>IIIA</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==11}">
                        <td>IIIB</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==12}">
                        <td>IV</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==13}">
                        <td>V</td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].finallySeizuresIdcom==14}">
                        <td>VI</td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>EEG hroty</td>
                    <c:if test="${patient.outcomeList[0].eegSpikes==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].eegSpikes==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>AED vysazeny</td>
                    <c:if test="${patient.outcomeList[0].aedPlanted==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].aedPlanted==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>MRI provedeno</td>
                    <c:if test="${patient.outcomeList[0].mriDone==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].mriDone==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td>Neuropsychologie</td>
                    <c:if test="${patient.outcomeList[0].neuropsychology==true}">
                        <td style="column-span: 2"><spring:message code="label.yes"/></td>
                    </c:if>
                    <c:if test="${patient.outcomeList[0].neuropsychology==false}">
                        <td><spring:message code="label.no"/></td>
                    </c:if>
                </tr>
                <tr class="info">
                    <td><spring:message code="label.comment" /></td>
                    <c:choose>
                        <c:when test="${empty patient.outcomeList[0].comment}">
                            <td>Žádný</td>
                        </c:when>
                        <c:otherwise>
                            <td>${patient.outcomeList[0].comment}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
              </tbody>
        </table>
        <a href="<c:url value="/patient/${patient.id}/outcome/list" />">Zobrazit všechny</a>
        </br>
        </br>
    </c:otherwise>
</c:choose> --%>
</jsp:body>
</t:menuLVL2.NEW303>

