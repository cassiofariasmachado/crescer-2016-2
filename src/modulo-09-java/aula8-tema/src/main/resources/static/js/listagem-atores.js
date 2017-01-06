class ListagemAtores {

    constructor() {
        this.registrarBinds();
        this.registarEvents();
    }

    registrarBinds() {
        this.atorRest = new AtorRest();
        this.$formPessoa = $("#form-ator");
        this.$listagemAtores = $("#listagem-atores");
        this.$inputId = $("#id");
        this.$inputNome = $("#nome");
    }

    registarEvents() {
        this.$formPessoa.submit(event => {
            var ator = new Ator(this.$inputNome.val());

            this.atorRest.save(ator)
                    .then(response => {
                        this.atorRest.listarAtores()
                                .then(response => {
                                    this.$listagemAtores.html(response);
                                });
                    });
            if (event.preventDefault) {
                event.preventDefault();
            }
            return false;
        });

    }
}


