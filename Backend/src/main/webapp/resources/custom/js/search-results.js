$(document).ready(function () {

    var pageNumberSel = $(".page-number");
    var pageSel = $(".page");
    var activePageId = 1;
    var pagesCount = $("#pagesCount").val();

    pageSel.hide();
    $("#page-1").show();
    $(".pager-elem-1").addClass("active");

    pageNumberSel.click(function () {
        var pageElem=$(".pager-elem-" + activePageId);
        pageElem.removeClass("active");
        activePageId = $(this).data("page-number");
        pageSel.hide();
        $("#page-" + activePageId).show();
        pageElem.addClass("active");
    });

    $(".start").click(function () {
        var pageElem=$(".pager-elem-" + activePageId);
        pageElem.removeClass("active");
        activePageId = 1;
        pageElem.addClass("active");
        pageSel.hide();
        $("#page-" + activePageId).show();

    });

    $(".end").click(function () {
        var pageElem=$(".pager-elem-" + activePageId);
        pageElem.removeClass("active");
        activePageId = pagesCount;
        pageElem.addClass("active");
        pageSel.hide();
        $("#page-" + activePageId).show();
    });


    $(".next").click(function () {
        if (pagesCount != activePageId) {
            var pageElem=$(".pager-elem-" + activePageId);
            pageElem.removeClass("active");
            activePageId++;
            pageElem.addClass("active");
            pageSel.hide();
            $("#page-" + activePageId).show();
        }
    });


    $(".prev").click(function () {
        if (activePageId != 1) {
            var pageElem=$(".pager-elem-" + activePageId);
            pageElem.removeClass("active");
            activePageId--;
            pageElem.addClass("active");
            pageSel.hide();
            $("#page-" + activePageId).show();
        }
    });

});