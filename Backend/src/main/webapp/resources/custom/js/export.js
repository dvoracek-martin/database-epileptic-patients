$(document).ready(function () {

    $("#saveButton").click(function () {
        $('#exportForm')
            .attr('action',
            '/GENEPI/export/save');
    });

    $("#genericConfigurationsDeleteButton").click(function () {
        $('#genericConfigurationsForm')
            .attr('action',
            '/GENEPI/export/delete');
    });

    $("#userConfigurationsDeleteButton").click(function () {
        $('#userConfigurationsForm')
            .attr('action',
            '/GENEPI/export/delete');
    });

});