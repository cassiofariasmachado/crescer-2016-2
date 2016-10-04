public class Personagem {
    protected String nome;
    protected int vida;
    protected int experiencia;
    protected Status status;
    protected Inventario inventario;
    
    public Personagem() {
        //TO-DO: revisar, possível gambi.
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }
    
    public Personagem(String nome) {
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }

    public Status getStatus() {
        return this.status;
    }
    
    public void ganharExperiencia() {
        this.experiencia++;
    }
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.removerItem(item);
    }
}
