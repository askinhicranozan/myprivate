$(document).ready(function () {

    $("#policyForm").submit(function (event) {

        event.preventDefault();

        var policyForm = {}
        policyForm["customerId"] = $("#customerId").val();
        policyForm["description"] = $("#description").val();
        policyForm["productType"] = $("#productType").val();
        policyForm["productName"] = $("#productName").val();
        policyForm["time"] = $("#time").val();
        policyForm["price"] = $("#price").val();
      

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/savePolicy",
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