public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome) {
        //super();
        //TO-DO: revisar, possível gambi.
        this.nome = nome;
    }
    
    public void ganharExperiencia() {
        super.experiencia += 2;
    }
    
    public void adicionarItem(Item item) {
        String descricaoItem = item.getDescricao();
        if ("Espada de aço valiriano".equals(descricaoItem) || "Arco e Flecha de Vidro".equals(descricaoItem))
            super.adicionarItem(item);
    }
    
    public Item getArco() {
        //TO-DO: possível gambiarra
        for (Item itemAtual : this.inventario.getItens()) {
            if ("Arco e Flecha de Vidro".equals(itemAtual.getDescricao()))
                return itemAtual;
        }
        return null;
    }
    
    public Item getFlecha() {
        //TO-DO: possível gambiarra
        return this.getArco();
    }
}
