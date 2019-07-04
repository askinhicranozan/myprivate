$(document).ready(function () {

    $("#customerForm").submit(function (event) {

        event.preventDefault();
//içi yazılacak.Metodları cagırdım
    

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/listCustomer",
            data: JSON.stringify(policyForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "Ajax Cevap"
                    + JSON.stringify(data, null, 4);
                $('#feedback').html(json);

            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/updateCustomer",
            data: JSON.stringify(policyForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "Ajax Cevap"
                    + JSON.stringify(data, null, 4);
                $('#feedback').html(json);

            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });
        

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/deleteCustomer",
            data: JSON.stringify(policyForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "Ajax Cevap"
                    + JSON.stringify(data, null, 4);
                $('#feedback').html(json);

            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

    });

});