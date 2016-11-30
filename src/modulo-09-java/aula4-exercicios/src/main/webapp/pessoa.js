function findAll() {
    $.get('pessoa').then(function (response) {
        $('#lista-pessoas').html(response);
    });
};

findAll();