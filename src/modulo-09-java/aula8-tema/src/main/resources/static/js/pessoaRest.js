class PessoaRest {

    save(pessoa) {
        return $.ajax({type: "POST",
            contentType: "application/json",
            url: "rest/pessoa",
            data: JSON.stringify(pessoa),
            dataType: 'json'});
    }

    listarPessoas() {
        return $.get("pessoa/listarPessoas");
    }
}