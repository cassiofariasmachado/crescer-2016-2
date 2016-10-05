public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome) {
        this(nome, 42);
    }
    
    public ElfoVerde(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }
    
    public void ganharExperiencia() {
        super.experiencia += 2;
    }
    
    public void adicionarItem(Item item) {
        String descricaoItem = item.getDescricao();
        if ("Espada de aço valiriano".equals(descricaoItem) || "Arco de Vidro".equals(descricaoItem) || "Flecha de Vidro".equals(descricaoItem))
            super.adicionarItem(item);
    }
    
    public void inicializarInventario(int quantidadeFlechas) {
        this.inventario.adicionarItem(new Item("Arco de Vidro", 1));
        this.inventario.adicionarItem(new Item("Flecha de Vidro", quantidadeFlechas <= 0 ? 42 : quantidadeFlechas));
    }
}
