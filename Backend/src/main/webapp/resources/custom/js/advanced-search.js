$(document).ready(function () {

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