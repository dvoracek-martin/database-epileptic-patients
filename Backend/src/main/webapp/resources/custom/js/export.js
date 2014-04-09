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

    $("#tree").tree({
        onCheck: { node: 'expand' },
        onUncheck: { node: 'collapse' },
        dnd:false,
        collapseUiIcon: 'ui-icon-plus',
        expandUiIcon: 'ui-icon-minus',
        leafUiIcon: 'ui-icon-bullet'
    });

});