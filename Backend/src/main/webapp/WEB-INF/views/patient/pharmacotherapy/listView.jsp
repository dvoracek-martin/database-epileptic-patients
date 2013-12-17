<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL2.NEW303>

<jsp:attribute name="title">
      <spring:message code="label.pharmacotherapy"/>
    </jsp:attribute>


    <jsp:attribute name="script">
    	
	</jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.pharmacotherapy"/>
        </h2>

    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/create" />">
                <spring:message code="label.addRecord"/></a>
        </h3>
    </div>
</div>

<%@include file="../patientDetails.jsp" %>

<h1>typ anamneza</h1>

<table style="margin-bottom: 0px; background-color: rgb(245, 245, 245)" class="table">
    <tbody>
    <tr>
        <th class="col-xs-8"><a data-toggle="collapse" href="#collapseOne">Zaznam za dne: 12.11.2013</a>
        </th>

        <th class="col-xs-2"> <span class="glyphicon glyphicon-edit"></span> edit</th>
        <th class="col-xs-2"> <span class="glyphicon glyphicon-remove-circle"></span> delete</th>
    </tr>
    </tbody>
</table>

<div  id="collapseOne" class="collapse in">
    <table style="background-color: rgb(245, 245, 245)" class="table">
        <tr>
            <td class="col-xs-4">Epilepsie v rodine</td>
            <td colspan="3" class="col-xs-8">Ano</td>
        </tr>
        <tr>
            <td class="col-xs-4">prenatal</td>
            <td colspan="3" class="col-xs-8">NE</td>
        </tr>
    </table>
</div>

<table style="margin-bottom: 0px" class="table">
    <tbody>
    <tr>
        <th class="col-xs-8"><a data-toggle="collapse" href="#collapseTwo">Zaznam za dne: 10.11.2013</a>
        </th>

        <th class="col-xs-2"> <span class="glyphicon glyphicon-edit"></span> edit</th>
        <th class="col-xs-2"> <span class="glyphicon glyphicon-remove-circle"></span> delete</th>
    </tr>
    </tbody>
</table>

<div id="collapseTwo" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">Epilepsie v rodine</td>
            <td colspan="3" class="col-xs-8">Ano</td>
        </tr>
        <tr>
            <td class="col-xs-4">prenatal</td>
            <td colspan="3" class="col-xs-8">NE</td>
        </tr>
    </table>
</div>

<h1>typ farmakoterapie</h1>
<%-- 2 --%>
<table style="margin-bottom: 0px" class="table">
    <tr>
        <th class="col-xs-2">Datum</th>
        <th class="col-xs-2">Lecivo</th>
        <th class="col-xs-2">Efektivita</th>
        <th class="col-xs-2"> Pri opreaci</th>
        <th class="col-xs-4"></th>
    </tr>
</table>

<table style="margin-bottom: 0px; background-color: rgb(245, 245, 245)"  class="table">
    <tr>
        <td class="col-xs-2"><a data-toggle="collapse" href="#collapseThree">06.08.2013</a></td>
        <td class="col-xs-2"> DFG</td>
        <td class="col-xs-2">rezsitentni</td>
        <td class="col-xs-2"> ANO</td>
        <td class="col-xs-2"><span class="glyphicon glyphicon-edit"></span>Upravit</td>
        <td class="col-xs-2">  <span class="glyphicon glyphicon-remove-circle"></span>Odstranit</td>
    </tr>
</table>
<div style="background-color: rgb(245, 245, 245)" id="collapseThree" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">Koment</td>
            <td colspan="3" class="col-xs-8">bergerhger45thkjnrtjgnrsuhjgnrjfuhkgnsdrujfnusfrhnjgkujsndfgiokusdrtniudrtng</td>
        </tr>
    </table>
</div>

<table style="margin-bottom: 0px"  class="table">
    <tr>
        <td class="col-xs-2"><a data-toggle="collapse" href="#collapseFour">06.08.2013</a></td>
        <td class="col-xs-2"> DFG</td>
        <td class="col-xs-2">rezsitentni</td>
        <td class="col-xs-2"> ANO</td>
        <td class="col-xs-2"><span class="glyphicon glyphicon-edit"></span>Upravit</td>
        <td class="col-xs-2">  <span class="glyphicon glyphicon-remove-circle"></span>Odstranit</td>
    </tr>
</table>
<div id="collapseFour" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">Koment</td>
            <td colspan="3" class="col-xs-8">bergerhger45thkjnrtjgnrsuhjgnrjfuhkgnsdrujfnusfrhnjgkujsndfgiokusdrtniudrtng</td>
        </tr>
    </table>
</div>

<%--<div class="row">
    <div class="col-xs-3">datum</div>
    <div class="col-xs-2"> lecivo</div>
    <div class="col-xs-2"> efektivita</div>
    <div class="col-xs-2"> pri operaci</div>
    <div class="col-xs-3"></div>
</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">06.10.2008</div>
                    <div class="col-xs-2"> DFG</div>
                    <div class="col-xs-2">rezsitentni</div>
                    <div class="col-xs-2"> ANO</div>
                    <div class="col-xs-1">edit</div>
                    <div class="col-xs-1"> delete</div>
                </div>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                    3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                    laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                    coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes
                    anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings
                    occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard
                    of them accusamus labore sustainable VHS.
                </div>
            </div>
        </div>


--%>
<%--
<table class="table">
    <tr>
        <td>datum</td>
        <td>lek</td>

    </tr>
    <tr>
        <td colspan="2">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <table class="table"> <tr>
                        <td><a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                           6.1
                        </a></td>
                        <td><a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                            saddfhggn
                        </a></td>

                    </tr> </table>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in">
                    <div class="panel-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                        3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                        laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                        coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes
                        anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings
                        occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard
                        of them accusamus labore sustainable VHS.
                    </div>
                </div>
            </div>
        </td>
    </tr>
</table>--%>
<%-- <table id = "accordion" class="table table-bordered">
     <thead>
     <tr>
         <td>datum</td>
         <td>lecivo</td>
     </tr>
     </thead>
     <tbody>
     <tr class="table-color">
         <td> <a data-toggle="collapse" href="#collapseOne">
            6.1
         </a>
         </td>
         <td>VGF</td>
     </tr>
     <tr id="collapseOne" class=" table-color collapse in">
         <td>cooment</td>
         <td>komentar</td>
     </tr>
     <tr>
         <td>18.1</td>
         <td>VGF</td>
     </tr>
     <tr>
         <td>cooment</td>
         <td>dalsi koment</td>
     </tr>
     <tr class="table-color">
         <td>7.11</td>
         <td>hhg</td>
     </tr>
     <tr  class="table-color">
         <td>cooment</td>
         <td>komehghnhnntar</td>
     </tr>
     </tbody>
 </table>--%>


<!-- pharmacotherapy list START -->
<%-- <div class="accordion">
     <c:set var="count" value="0" scope="page"/>
     <c:forEach items="${patient.pharmacotherapyList}" var="pharmacotherapy">
         <c:if test="${pharmacotherapy.status==0}">
             <c:set var="count" value="${count + 1}" scope="page"/>
             <div>
                 <div class="accordion-heading">
                     <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                        href="#collapse${pharmacotherapy.id}">
                         <strong><spring:message
                                 code="label.dateOfContractAward"/>:</strong> ${pharmacotherapy.date}
                     </a>
                 </div>

                 <div id="collapse${pharmacotherapy.id}" class="accordion-body collapse">

                     <div class="accordion-inner">
                         <div class="label-info"
                              style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
                             <div class="pull-right">
                                 <a class="close"
                                    href="<c:url value="/patient/${patientID}/pharmacotherapy/${pharmacotherapy.id}/hide"/>"><spring:message
                                         code="label.delete"/></a>
                             </div>
                             <div class="pull-left">
                                 <a class="close"
                                    href="<c:url value="/patient/${patientID}/pharmacotherapy/list"/>"><spring:message
                                         code="label.edit"/></a>
                             </div>
                             <br>
                         </div>
                         <table class="table">
                             <tbody>
                             <tr class="info">
                                 <td><spring:message code="label.medicines"/></td>
                                 <c:if test="${pharmacotherapy.aed==1}">
                                     <td>ACTH</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==2}">
                                     <td>CBZ</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==3}">
                                     <td>CLB</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==4}">
                                     <td>CZP</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==5}">
                                     <td>DZP</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==6}">
                                     <td>ESL</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==7}">
                                     <td>ETS</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==8}">
                                     <td>FBM</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==9}">
                                     <td>GBP</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==10}">
                                     <td>LCM</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==11}">
                                     <td>LEV</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==12}">
                                     <td>LTG</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==13}">
                                     <td>OXC</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==14}">
                                     <td>PB</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==15}">
                                     <td>PGB</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==16}">
                                     <td>PHT</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==17}">
                                     <td>PRM</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==18}">
                                     <td>RFM</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==19}">
                                     <td>STM</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==20}">
                                     <td>TGB</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==21}">
                                     <td>TPM</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==22}">
                                     <td>VGB</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==23}">
                                     <td>VPA</td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.aed==24}">
                                     <td>ZNS</td>
                                 </c:if>
                             </tr>
                             <tr class="info">
                                 <td><spring:message code="label.efficiency"/></td>
                                 <c:if test="${pharmacotherapy.efficiency==1}">
                                     <td><spring:message code="label.resistant"/></td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.efficiency==2}">
                                     <td><spring:message code="label.effective"/></td>
                                 </c:if>
                             </tr>
                             <tr class="info">
                                 <td><spring:message code="label.duringSurgery"/></td>
                                 <c:if test="${pharmacotherapy.duringSurgery==true}">
                                     <td style="column-span: 2"><spring:message code="label.yes"/></td>
                                 </c:if>
                                 <c:if test="${pharmacotherapy.duringSurgery==false}">
                                     <td><spring:message code="label.no"/></td>
                                 </c:if>
                             </tr>
                             <tr class="info">
                                 <td><spring:message code="label.comment"/></td>
                                 <c:choose>
                                     <c:when test="${empty patient.pharmacotherapyList[0].comment}">
                                         <td><spring:message code="label.noComments"/></td>
                                     </c:when>
                                     <c:otherwise>
                                         <td>${patient.pharmacotherapyList[0].comment}</td>
                                     </c:otherwise>
                                 </c:choose>
                             </tr>
                             </tbody>
                         </table>
                     </div>
                 </div>
             </div>
         </c:if>
     </c:forEach>
     <c:if test="${count==0}">
         <div class="alert alert-block">
             <button type="button" class="close" data-dismiss="alert">&times;</button>
             <h4><spring:message code="label.noRecords"/></h4>
         </div>
     </c:if>
 </div>
 --%>
<!-- pharmacotherapy list END -->
</jsp:body>
</t:menuLVL2.NEW303>


