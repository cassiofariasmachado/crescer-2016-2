public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;

    public Elfo(String n) {
        // Chamando outro construtor 
        this(n, 42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", quantidadeFlechas <= 0 ? 42 : quantidadeFlechas);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return arco;
    }
    
    public Item getFlecha(){
        return flecha;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public void atirarFlecha(Dwarf dwarf){
        if (flecha.getQuantidade() > 0 && dwarf.receberFlecha()) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.perderVida();
        }
    }
    
    public String toString(){
        boolean flechaNoSingular = flecha.getQuantidade() == 1; 
        boolean nivelNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
        this.nome, 
        this.flecha.getQuantidade(), 
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


