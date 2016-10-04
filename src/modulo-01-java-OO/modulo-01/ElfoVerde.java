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
        if ("Espada de aço valiriano".equals(descricaoItem) || "Arco de Vidro".equals(descricaoItem) || "Flecha de Vidro".equals(descricaoItem))
            super.adicionarItem(item);
    }
    
    public Item getFlecha() {
        for (Item itemAtual : this.inventario.getItens()) {
            if ("Flecha de Vidro".equals(itemAtual.getDescricao()))
                return itemAtual;
        }
        return null;
    }
    
    public Item getArco() {
        for (Item itemAtual : this.inventario.getItens()) {
            if ("Arco de Vidro".equals(itemAtual.getDescricao()))
                return itemAtual;
        }
        return null;
    }
}
