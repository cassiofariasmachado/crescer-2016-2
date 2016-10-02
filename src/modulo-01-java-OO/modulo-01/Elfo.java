public class Elfo {
    private String nome;
    private Inventario inventario;
    private int experiencia;
    private Status status;

    public Elfo(String nome) {
        // Chamando outro construtor 
        this(nome, 42);
    }

    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        this.inventario = new Inventario();
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas <= 0 ? 42 : quantidadeFlechas));
        this.status = Status.VIVO;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public Status getStatus(){
        return this.status;
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void atirarFlecha(Dwarf dwarf){
        int quantidadeFlechas = this.getFlecha().getQuantidade();
        if (quantidadeFlechas > 0) {
            this.getFlecha().setQuantidade(quantidadeFlechas - 1);
            this.experiencia++;
            dwarf.receberFlecha();
        }
    }

    public String toString(){
        boolean flechaNoSingular = this.getFlecha().getQuantidade() == 1; 
        boolean nivelNoSingular = this.experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.", 
            this.nome, 
            this.getFlecha().getQuantidade(), 
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            nivelNoSingular ? "nível" : "níveis");
        // return this.nome + " possui " + this.flecha.getQuantidade() + " flechas e " + this.experiencia + " níveis de experiência.";
    }

    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

