$(document).ready(function () {

    /* form submition */
    var advancedSearchFormSel = $("#advancedSearchForm");

    $("#saveButton").click(function () {
        advancedSearchFormSel.attr('action', '/GENEPI/advanced-search/save');
        advancedSearchFormSel.submit();
    });

    /* section checkbox variables */
    var anamnesisCheckbox = $("#anamnesis");

    anamnesisCheckbox.click(function () {
        var anamnesisFieldset = $("#anamnesisFieldset");
        if ($(this).prop("checked")) {
            anamnesisFieldset.show();
        } else {
            anamnesisFieldset.hide();
        }
    });

    var seizureCheckbox = $("#seizure");

    seizureCheckbox.click(function () {
        var seizureFieldset = $("#seizureFieldset");
        if ($(this).prop("checked")) {
            seizureFieldset.show();
        } else {
            seizureFieldset.hide();
        }
    });

    var pharmacotherapyCheckbox = $("#pharmacotherapy");

    pharmacotherapyCheckbox.click(function () {
        var pharmacotherapyFieldset = $("#pharmacotherapyFieldset");
        if ($(this).prop("checked")) {
            pharmacotherapyFieldset.show();
        } else {
            pharmacotherapyFieldset.hide();
        }
    });

    var neurologicalFindingCheckbox = $("#neurologicalFinding");

    neurologicalFindingCheckbox.click(function () {
        var neurologicalFindingFieldset = $("#neurologicalFindingFieldset");
        if ($(this).prop("checked")) {
            neurologicalFindingFieldset.show();
        } else {
            neurologicalFindingFieldset.hide();
        }
    });

    var neuropsychologyCheckbox = $("#neuropsychology");

    neuropsychologyCheckbox.click(function () {
        var neuropsychologyFieldset = $("#neuropsychologyFieldset");
        if ($(this).prop("checked")) {
            neuropsychologyFieldset.show();
        } else {
            neuropsychologyFieldset.hide();
        }
    });

    var diagnosticTestScalpEegCheckbox = $("#diagnosticTestScalpEeg");

    diagnosticTestScalpEegCheckbox.click(function () {
        var diagnosticTestScalpEegFieldset = $("#diagnosticTestScalpEegFieldset");
        if ($(this).prop("checked")) {
            diagnosticTestScalpEegFieldset.show();
        } else {
            diagnosticTestScalpEegFieldset.hide();
        }
    });

    var diagnosticTestMriCheckbox = $("#diagnosticTestMri");

    diagnosticTestMriCheckbox.click(function () {
        var diagnosticTestMriFieldset = $("#diagnosticTestMriFieldset");
        if ($(this).prop("checked")) {
            diagnosticTestMriFieldset.show();
        } else {
            diagnosticTestMriFieldset.hide();
        }
    });

    var invasiveTestEegCheckbox = $("#invasiveTestEeg");

    invasiveTestEegCheckbox.click(function () {
        var  invasiveTestEegFieldset = $("#invasiveTestEegFieldset");
        if ($(this).prop("checked")) {
            invasiveTestEegFieldset.show();
        } else {
            invasiveTestEegFieldset.hide();
        }
    });

    var invasiveTestEcogCheckbox = $("#invasiveTestEcog");

    invasiveTestEcogCheckbox.click(function () {
        var  invasiveTestEcogFieldset = $("#invasiveTestEcogFieldset");
        if ($(this).prop("checked")) {
            invasiveTestEcogFieldset.show();
        } else {
            invasiveTestEcogFieldset.hide();
        }
    });

    var invasiveTestCorticalMappingCheckbox = $("#invasiveTestCorticalMapping");

    invasiveTestCorticalMappingCheckbox.click(function () {
        var  invasiveTestCorticalMappingFieldset = $("#invasiveTestCorticalMappingFieldset");
        if ($(this).prop("checked")) {
            invasiveTestCorticalMappingFieldset.show();
        } else {
            invasiveTestCorticalMappingFieldset.hide();
        }
    });

    var operationCheckbox = $("#operation");

    operationCheckbox.click(function () {
        var  operationFieldset = $("#operationFieldset");
        if ($(this).prop("checked")) {
            operationFieldset.show();
        } else {
            operationFieldset.hide();
        }
    });

    var histologyCheckbox = $("#histology");

    histologyCheckbox.click(function () {
        var  histologyFieldset = $("#histologyFieldset");
        if ($(this).prop("checked")) {
            histologyFieldset.show();
        } else {
            histologyFieldset.hide();
        }
    });

    var complicationCheckbox = $("#complication");

    complicationCheckbox.click(function () {
        var  complicationFieldset = $("#complicationFieldset");
        if ($(this).prop("checked")) {
            complicationFieldset.show();
        } else {
            complicationFieldset.hide();
        }
    });

    var outcomeCheckbox = $("#outcome");

    outcomeCheckbox.click(function () {
        var  outcomeFieldset = $("#outcomeFieldset");
        if ($(this).prop("checked")) {
            outcomeFieldset.show();
        } else {
            outcomeFieldset.hide();
        }
    });


    /* trigger events */
    anamnesisCheckbox.click();
    anamnesisCheckbox.click();

    seizureCheckbox.click();
    seizureCheckbox.click();

    pharmacotherapyCheckbox.click();
    pharmacotherapyCheckbox.click();

    neurologicalFindingCheckbox.click();
    neurologicalFindingCheckbox.click();

    neuropsychologyCheckbox.click();
    neuropsychologyCheckbox.click();

    diagnosticTestScalpEegCheckbox.click();
    diagnosticTestScalpEegCheckbox.click();

    diagnosticTestMriCheckbox.click();
    diagnosticTestMriCheckbox.click();

    invasiveTestEegCheckbox.click();
    invasiveTestEegCheckbox.click();

    invasiveTestEcogCheckbox.click();
    invasiveTestEcogCheckbox.click();

    invasiveTestCorticalMappingCheckbox.click();
    invasiveTestCorticalMappingCheckbox.click();

    operationCheckbox.click();
    operationCheckbox.click();

    histologyCheckbox.click();
    histologyCheckbox.click();

    complicationCheckbox.click();
    complicationCheckbox.click();

    outcomeCheckbox.click();
    outcomeCheckbox.click();

});