$(document).ready(function () {

    /* define static selectors */
    var searchSelector = $("#search");
    var patientListSelector = $("#patientList");
    var nextSelector = $(".next-li");

    //define global variables
    var pageCount = 0;
    var pageNumber = 1;
    var searchString = "";

    //called when typing in search bar
    searchSelector.keyup(function () {

        //define dynamic selectors
        var pagerElemSelector = $(".pager-elem");

        /*define variables */
        var maxResults;

        //reset pageNumber if searchString has changed
        if (searchString != searchSelector.val()) {
            pageNumber = 1;
        }

        //fill variables
        maxResults = $(this).data("max-results");
        searchString = searchSelector.val();

        //alert("ser="+searchString +" max= "+maxResults+" pag="+pageNumber);

        $.ajax({
            type: "GET",
            url: "http://isarg.feld.cvut.cz:2001/GENEPI/patient/listSearch",
            //url: "http://localhost:8080/GENEPI/patient/listSearch",
            data: "search=" + searchString + "&maxResults=" + maxResults + "&pageNumber=" + pageNumber,
            success: function (response) {
                var obj = JSON.parse(response);
                var countOfPatients = obj.patientList.length;

                //delete content of patients list
                patientListSelector.html("");

                //fill content of patients list
                for (var i = 0; i < countOfPatients; i++) {
                    var firstName = obj.patientList[i][0].patientFirstName;
                    var lastName = obj.patientList[i][0].patientLastName;
                    var patientID = obj.patientList[i][0].patientID;
                    var nin = obj.patientList[i][0].nin;
                    var address = obj.patientList[i][0].addressStreet;
                    if (address != "") {
                        address += ", " + obj.patientList[i][0].addressHn;
                    }
                    var city = obj.patientList[i][0].addressCity;


                    patientListSelector.html(patientListSelector.html() + "<tr class='clickable-row' data-href='/GENEPI/patient/" + patientID + "/overview'><td>"
                        + firstName + "</td><td>" + lastName + "</td><td>" + nin + "</td><td>" + address + "</td><td>" + city + "</td></tr>");
                }

                //make rows in patients list clickable
                $(".clickable-row").click(function () {
                    window.document.location = $(this).data("href");
                });

                //count how many pages are need for patients matching searchString
                pageCount = Math.ceil(obj.patientsCount / maxResults);

                //remove all numbers from pager
                pagerElemSelector.remove();

                //generate numbers into pager
                for (var i = 1; i <= pageCount; i++) {
                    if (pageNumber == i) {
                        nextSelector.before('<li class="pager-elem active"><a class="page-number" href="#" data-page-number="' + i + '">' + i + '</a></li>');
                    } else {
                        nextSelector.before('<li class="pager-elem"><a class="page-number" href="#" data-page-number="' + i + '">' + i + '</a></li>');
                    }
                }

                //make numbers in pager clickable
                $(".page-number").click(function () {
                    pageNumber = $(this).data("page-number");
                    searchSelector.keyup();
                });
            },
            error: function (/*e*/) {
                alert("Error occured"/* + e*/);
            }
        });
    });

    $(".start").click(function () {
        pageNumber = 1;
        searchSelector.keyup();
    });


    $(".end").click(function () {
        pageNumber = pageCount;
        searchSelector.keyup();
    });


    $(".next").click(function () {
        if (pageCount != pageNumber) {
            pageNumber++;
            searchSelector.keyup();
        }
    });


    $(".prev").click(function () {
        if (pageNumber != 1) {
            pageNumber--;
            searchSelector.keyup();
        }
    });

    /* trigger events */
    searchSelector.keyup();
});