public class Elfo extends Personagem {
    private static int CONTADOR_ELFOS ;
    
    {
        this.vida = 100.;
        Elfo.CONTADOR_ELFOS++;
    }
    
    public Elfo(String nome) {
        // Chamando outro construtor 
        this(nome, 42);
    }

    public Elfo(String nome, int quantidadeFlechas) {
        super (nome, quantidadeFlechas);
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Elfo.CONTADOR_ELFOS--;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }
    
    public static int getContadorElfos() {
        return Elfo.CONTADOR_ELFOS;
    }
    
    public void atirarFlecha(Dwarf dwarf){
        boolean temFlecha = this.getFlecha() != null && this.getFlecha().getQuantidade() > 0;
        if (temFlecha) {
            this.getFlecha().setQuantidade(this.getFlecha().getQuantidade() - 1);
            this.ganharExperiencia();
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

    protected void inicializarInventario(int quantidadeFlechas) {
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas <= 0 ? 42 : quantidadeFlechas));
    }
    
    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

