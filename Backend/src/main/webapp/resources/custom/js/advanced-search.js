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


    /* trigger events */
    anamnesisCheckbox.click();
    anamnesisCheckbox.click();


});