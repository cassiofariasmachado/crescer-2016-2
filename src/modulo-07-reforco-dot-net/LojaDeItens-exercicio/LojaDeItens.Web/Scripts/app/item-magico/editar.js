var itemMagicoEditar = {};


itemMagicoEditar.sucessoNoCadastro = function (resposta) {
    alert(resposta.Mensagem);
}

itemMagicoEditar.falhaNoCadastro = function (resposta) {
    alert(resposta.responseJSON.Mensagem);
}