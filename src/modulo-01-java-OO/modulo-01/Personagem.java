public abstract class Personagem {
    protected String nome;
    protected double vida;
    protected int experiencia;
    protected Status status;
    protected Inventario inventario;
    
    public Personagem(String nome, int quantidadeFlechas) {
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        // chamar método inicializarInventario() aqui para que classes filhas não "esqueçam" de chama-lo
        this.inicializarInventario(quantidadeFlechas); 
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public double getVida() {
        return this.vida;
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
    
    abstract void inicializarInventario(int quantidadeFlechas);
}
