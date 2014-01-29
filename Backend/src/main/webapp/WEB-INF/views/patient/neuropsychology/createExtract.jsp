<div style="border: 1px solid gray; padding: 1em; margin: 2em">
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileAttention"><strong>Pozornost</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileAttention" id="neuropsychologicalProfileAttention" type="text"
                     class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileExecutiveFunction"><strong>Exekutivní
        funkce</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileExecutiveFunction" id="neuropsychologicalProfileExecutiveFunction"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileCognitiveSpeed"><strong>Kognitivní
        rychlost</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileCognitiveSpeed" id="neuropsychologicalProfileCognitiveSpeed"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileSpeechExpressively"><strong>Řeč
        expresivně</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileSpeechExpressively" id="neuropsychologicalProfileSpeechExpressively"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                Norma
            </form:option>
            <form:option value="2">
                Porucha řeči
            </form:option>
            <form:option value="3">
                Porucha výslovnosti
            </form:option>
            <form:option value="4">
                Anomie
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileSpeechUnderstanding"><strong>Řeč -
        porozumnění</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileSpeechUnderstanding"
                     id="neuropsychologicalProfileSpeechUnderstanding" type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileMemoryOperating"><strong>Paměť -
        operační</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileMemoryOperating" id="neuropsychologicalProfileMemoryOperating"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileMemoryVerbal"><strong>Paměť - verbální</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileMemoryVerbal" id="neuropsychologicalProfileMemoryVerbal" type="text"
                     class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileMemoryNonverbal"><strong>Paměť -
        neverbální</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileMemoryNonverbal" id="neuropsychologicalProfileMemoryNonverbal"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileMemoryLearning"><strong>Paměť - učení</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileMemoryLearning" id="neuropsychologicalProfileMemoryLearning"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfilePerceptionSpeech"><strong>Vnímání - řeči</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfilePerceptionSpeech" id="neuropsychologicalProfilePerceptionSpeech"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                Norma
            </form:option>
            <form:option value="2">
                Porucha fonematického sluchu
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfilePerceptionVisual"><strong>Vnímání -
        vizuální</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfilePerceptionVisual" id="neuropsychologicalProfilePerceptionVisual"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfilePerceptionSpatial"><strong>Vnímání - prostorové</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfilePerceptionSpatial" id="neuropsychologicalProfilePerceptionSpatial"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileMotorSkillsDexterity"><strong>Motorika - zručnost a
        plánování pohybů</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileMotorSkillsDexterity"
                     id="neuropsychologicalProfileMotorSkillsDexterity" type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
<div class="control-group">
    <label class="control-label" for="neuropsychologicalProfileMotorCoordination"><strong>Motorika - motorická
        koordinace</strong></label>

    <div class="controls">
        <form:select path="neuropsychologicalProfileMotorCoordination" id="neuropsychologicalProfileMotorCoordination"
                     type="text" class="input-large">
            <form:option value="0">
                -
            </form:option>
            <form:option value="1">
                <spring:message code="label.deficit"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.boundDeficit"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.overAverage"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.aboveAverage"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.notIdentified"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.belowAverage"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.average"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.hardDeficit"/>
            </form:option>
        </form:select>
    </div>
</div>
</div>
  				