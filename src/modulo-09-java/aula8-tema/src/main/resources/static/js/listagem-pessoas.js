class ListagemPessoas {

    constructor() {
        this.registrarBinds();
        this.registarEvents();
    }

    registrarBinds() {
        this.pessoaRest = new PessoaRest();
        this.$formPessoa = $("#form-pessoa");
        this.$listagemPessoas = $("#listagem-pessoas");
        this.$inputNome = $("#nome");
        this.$inputNascimento = $("#nascimento");
        this.$inputIdade = $("#idade");
        this.$inputVlPessoa = $("#vlPessoa");
    }

    registarEvents() {
        this.cadastrarPessoa();
        this.listarPessoas();
    }

    cadastrarPessoa() {
        this.$formPessoa.submit(event => {
            var pessoa = new Pessoa(
                    this.$inputNome.val(),
                    this.$inputNascimento.val(),
                    this.$inputIdade.val(),
                    this.$inputVlPessoa.val());
            this.pessoaRest.save(pessoa)
                    .then(response => {
                        this.listarPessoas();
                    })
                    .fail(reject => {
                        reject.forEach(r => {
                            $("#" + r.field).after("<span class=\"help - block\">" + r.defaultMessage + "</span>");
                        });
                        if (event.preventDefault) {
                            event.preventDefault();
                        }
                        return false;
                    });
        });
    }

    listarPessoas() {
        this.pessoaRest.listarPessoas()
                .then(response => {
                    this.$listagemPessoas.html(response);
                });
    }
}







