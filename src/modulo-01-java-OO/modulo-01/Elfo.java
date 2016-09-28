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
    
    public void atirarFlecha() {
        if (flecha.getQuantidade() > 0) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        }
    }
    
    public void atirarFlecha(Dwarf dwarf){
        if (flecha.getQuantidade() > 0) {
            atirarFlecha();
            dwarf.setVida(dwarf.getVida() - 10);
        }
    }
    
    public String toString(){
        return nome + " possui " + flecha.getQuantidade() + " flechas e " + experiencia + " níveis de experiência.";
    }
    
    /*public void atirarFlechaRefactory() {
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}


