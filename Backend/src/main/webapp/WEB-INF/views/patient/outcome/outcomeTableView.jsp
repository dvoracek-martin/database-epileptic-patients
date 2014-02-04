






----------
<div class="accordion">
<c:set var="count" value="0" scope="page"/>
<c:forEach items="${patient.operationList}" var="operation">
<c:if test="${operation.status==0}">
<c:set var="count" value="${count + 1}" scope="page"/>
<div>
<div class="accordion-heading">
    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${operation.id}">
        <strong><spring:message code="label.operationOf"/>:</strong> ${operation.date}
    </a>
</div>

<div id="collapse${operation.id}" class="accordion-body collapse">

<div class="accordion-inner">
<table class="table">
<thead>
<tr class="success">
    <td></td>
    <td><b>Seizure outcome</b></td>
    <td><b>AED</b></td>
    <td><b>EEG</b></td>
    <td><b>MRI</b></td>
    <td><b><spring:message code="label.neuropsychology"/></b></td>
    <td></td>
</tr>
</thead>
<tbody>
<tr>
    <td><b>6 měsíců</b></td>
    <c:set var="count2" value="0" scope="page"/>
    <c:forEach items="${operation.outcomeList}" var="outcome">
        <c:if test="${outcome.distance==6}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:if test="${outcome.seizureOutcome==1}">
                <td>0</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==2}">
                <td>IA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==3}">
                <td>IB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==4}">
                <td>IC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==5}">
                <td>ID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==6}">
                <td>IIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==7}">
                <td>IIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==8}">
                <td>IIC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==9}">
                <td>IID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==10}">
                <td>IIIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==11}">
                <td>IIIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==12}">
                <td>IV</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==13}">
                <td>V</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==14}">
                <td>VI</td>
            </c:if>

            <c:if test="${outcome.aed==1}">
                <td><spring:message code="label.reduced"/></td>
            </c:if>
            <c:if test="${outcome.aed==2}">
                <td><spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==3}">
                <td><spring:message code="label.notDropped"/></td>
            </c:if>

            <c:if test="${outcome.eeg==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.eeg==2}">
                <td><spring:message code="label.spikes"/></td>
            </c:if>
            <c:if test="${outcome.eeg==3}">
                <td><spring:message code="label.noSpikes"/></td>
            </c:if>

            <c:if test="${outcome.mri==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.mri==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <c:if test="${outcome.neuropsychology==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.neuropsychology==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <td><a><spring:message code="label.editRecord"/></a></td>
        </c:if>
    </c:forEach>
    <c:if test="${count2==0}">
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td><a href="<c:url value="/patient/${patientID}/outcome/create?distance=6&operation=${operation.id}" />">
            <spring:message code="label.addRecord"/>
        </a></td>
    </c:if>
</tr>

<tr>
    <td><b>1 rok</b></td>
    <c:set var="count2" value="0" scope="page"/>
    <c:forEach items="${operation.outcomeList}" var="outcome">
        <c:if test="${outcome.distance==12}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:if test="${outcome.seizureOutcome==1}">
                <td>0</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==2}">
                <td>IA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==3}">
                <td>IB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==4}">
                <td>IC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==5}">
                <td>ID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==6}">
                <td>IIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==7}">
                <td>IIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==8}">
                <td>IIC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==9}">
                <td>IID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==10}">
                <td>IIIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==11}">
                <td>IIIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==12}">
                <td>IV</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==13}">
                <td>V</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==14}">
                <td>VI</td>
            </c:if>

            <c:if test="${outcome.aed==1}">
                <td><spring:message code="label.notDropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==2}">
                <td><spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==3}">
                <td><spring:message code="label.reduced"/></td>
            </c:if>

            <c:if test="${outcome.eeg==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.eeg==2}">
                <td><spring:message code="label.spikes"/></td>
            </c:if>
            <c:if test="${outcome.eeg==3}">
                <td><spring:message code="label.noSpikes"/></td>
            </c:if>

            <c:if test="${outcome.mri==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.mri==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <c:if test="${outcome.neuropsychology==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.neuropsychology==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <td><a><spring:message code="label.editRecord"/></a></td>
        </c:if>
    </c:forEach>
    <c:if test="${count2==0}">
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td><a href="<c:url value="/patient/${patientID}/outcome/create?distance=12&operation=${operation.id}" />">
            <spring:message code="label.addRecord"/>
        </a></td>
    </c:if>
</tr>

<tr>
    <td><b>2 rok</b></td>
    <c:set var="count2" value="0" scope="page"/>
    <c:forEach items="${operation.outcomeList}" var="outcome">
        <c:if test="${outcome.distance==24}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:if test="${outcome.seizureOutcome==1}">
                <td>0</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==2}">
                <td>IA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==3}">
                <td>IB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==4}">
                <td>IC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==5}">
                <td>ID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==6}">
                <td>IIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==7}">
                <td>IIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==8}">
                <td>IIC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==9}">
                <td>IID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==10}">
                <td>IIIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==11}">
                <td>IIIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==12}">
                <td>IV</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==13}">
                <td>V</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==14}">
                <td>VI</td>
            </c:if>

            <c:if test="${outcome.aed==1}">
                <td>ne<spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==2}">
                <td><spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==3}">
                <td><spring:message code="label.reduced"/></td>
            </c:if>

            <c:if test="${outcome.eeg==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.eeg==2}">
                <td><spring:message code="label.spikes"/></td>
            </c:if>
            <c:if test="${outcome.eeg==3}">
                <td><spring:message code="label.noSpikes"/></td>
            </c:if>

            <c:if test="${outcome.mri==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.mri==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <c:if test="${outcome.neuropsychology==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.neuropsychology==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <td><a><spring:message code="label.editRecord"/></a></td>
        </c:if>
    </c:forEach>
    <c:if test="${count2==0}">
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td><a href="<c:url value="/patient/${patientID}/outcome/create?distance=24&operation=${operation.id}" />">
            <spring:message code="label.addRecord"/>
        </a></td>
    </c:if>
</tr>

<tr>
    <td><b>5 let</b></td>
    <c:set var="count2" value="0" scope="page"/>
    <c:forEach items="${operation.outcomeList}" var="outcome">
        <c:if test="${outcome.distance==60}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:if test="${outcome.seizureOutcome==1}">
                <td>0</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==2}">
                <td>IA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==3}">
                <td>IB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==4}">
                <td>IC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==5}">
                <td>ID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==6}">
                <td>IIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==7}">
                <td>IIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==8}">
                <td>IIC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==9}">
                <td>IID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==10}">
                <td>IIIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==11}">
                <td>IIIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==12}">
                <td>IV</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==13}">
                <td>V</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==14}">
                <td>VI</td>
            </c:if>

            <c:if test="${outcome.aed==1}">
                <td>ne<spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==2}">
                <td><spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==3}">
                <td><spring:message code="label.reduced"/></td>
            </c:if>

            <c:if test="${outcome.eeg==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.eeg==2}">
                <td><spring:message code="label.spikes"/></td>
            </c:if>
            <c:if test="${outcome.eeg==3}">
                <td><spring:message code="label.noSpikes"/></td>
            </c:if>

            <c:if test="${outcome.mri==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.mri==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <c:if test="${outcome.neuropsychology==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.neuropsychology==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <td><a><spring:message code="label.editRecord"/></a></td>
        </c:if>
    </c:forEach>
    <c:if test="${count2==0}">
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td><a href="<c:url value="/patient/${patientID}/outcome/create?distance=60&operation=${operation.id}" />">
            <spring:message code="label.addRecord"/>
        </a></td>
    </c:if>
</tr>

<tr>
    <td><b>10 let</b></td>
    <c:set var="count2" value="0" scope="page"/>
    <c:forEach items="${operation.outcomeList}" var="outcome">
        <c:if test="${outcome.distance==120}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:if test="${outcome.seizureOutcome==1}">
                <td>0</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==2}">
                <td>IA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==3}">
                <td>IB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==4}">
                <td>IC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==5}">
                <td>ID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==6}">
                <td>IIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==7}">
                <td>IIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==8}">
                <td>IIC</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==9}">
                <td>IID</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==10}">
                <td>IIIA</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==11}">
                <td>IIIB</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==12}">
                <td>IV</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==13}">
                <td>V</td>
            </c:if>
            <c:if test="${outcome.seizureOutcome==14}">
                <td>VI</td>
            </c:if>

            <c:if test="${outcome.aed==1}">
                <td>ne<spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==2}">
                <td><spring:message code="label.dropped"/></td>
            </c:if>
            <c:if test="${outcome.aed==3}">
                <td><spring:message code="label.reduced"/></td>
            </c:if>

            <c:if test="${outcome.eeg==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.eeg==2}">
                <td><spring:message code="label.spikes"/></td>
            </c:if>
            <c:if test="${outcome.eeg==3}">
                <td><spring:message code="label.noSpikes"/></td>
            </c:if>

            <c:if test="${outcome.mri==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.mri==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <c:if test="${outcome.neuropsychology==1}">
                <td><spring:message code="label.notDone"/></td>
            </c:if>
            <c:if test="${outcome.neuropsychology==2}">
                <td><spring:message code="label.done"/></td>
            </c:if>

            <td><a><spring:message code="label.editRecord"/></a></td>
        </c:if>
    </c:forEach>
    <c:if test="${count2==0}">
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td><a href="<c:url value="/patient/${patient.id}/outcome/create?distance=120&operation=${operation.id}" />">
            <spring:message code="label.addRecord"/>
        </a></td>
    </c:if>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</c:if>
</c:forEach>