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


    /* trigger events */
    anamnesisCheckbox.click();
    anamnesisCheckbox.click();

    seizureCheckbox.click();
    seizureCheckbox.click();


});