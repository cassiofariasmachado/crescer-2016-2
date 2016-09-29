public class Elfo {
    private String nome;
    private Inventario inventario;
    private int experiencia;
    private Status status;
    
    public Elfo(String n) {
        // Chamando outro construtor 
        this(n, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        this.inventario = new Inventario();
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas <= 0 ? 42 : quantidadeFlechas));
        status = Status.VIVO;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return this.inventario.getItens().get(0);
    }
    
    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public void atirarFlecha(Dwarf dwarf){
        if (getFlecha().getQuantidade() > 0) {
            getFlecha().setQuantidade(getFlecha().getQuantidade() - 1);
            dwarf.receberFlecha();
            experiencia++;
        }
    }
    
    public String toString(){
        boolean flechaNoSingular = getFlecha().getQuantidade() == 1; 
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


