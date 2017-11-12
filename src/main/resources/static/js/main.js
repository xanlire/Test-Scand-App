$(document).ready(function () {
    $('#get').click(function () {

        var mytable = $('<table/>',{
            class:'mytable'
        }).append(
            $('<thead/>'),
            $('<tfoot/>'),
            $('<tbody/>')
        );

        $.ajax({
            url: '/getCompanies',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                $.each(data, function () {
                    var cell = $('<tr/>');
                    $.each(this, function (attr, value) {
                        cell.append($('<td/>').append(value));
                    })
                    $("tbody", mytable).append(cell);
                })
                $('#resultTable').append(mytable);
            }
        })
    })
})