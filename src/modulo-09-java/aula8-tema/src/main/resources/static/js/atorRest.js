class AtorRest {

    save(ator) {
        return $.ajax({type: "POST",
            contentType: "application/json",
            url: "rest/ator",
            data: JSON.stringify(ator),
            dataType: 'json'});
    }

    listarAtores() {
        return $.get("ator/listarAtores");
    }
}


