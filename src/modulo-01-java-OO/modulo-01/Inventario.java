import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens = new ArrayList<>();

    public ArrayList<Item> getItens(){
        return this.itens;
    }

    public void adicionarItem (Item item) {
        itens.add(item);
    }

    public void removerItem (Item item) {
        itens.remove(item);
    }

    public void ordenarItens() {
        this.ordenarItens(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenarItens(TipoOrdenacao ordem) {
        Item atual;
        boolean ascendente = ordem == TipoOrdenacao.ASCENDENTE;
        for (int i = 1; i < itens.size(); i++){
            atual = itens.get(i);
            int quantidadeItemAtual = atual.getQuantidade();
            int j;
            for (j = i - 1; j >= 0 && (ascendente ? quantidadeItemAtual < itens.get(j).getQuantidade() : quantidadeItemAtual > itens.get(j).getQuantidade()); j--){
                itens.set(j + 1, itens.get(j));
            }
            itens.set(j + 1, atual);
        }   
    }

    public Item buscar (String descricao) {
        for (Item itemAtual : itens)
            if (descricao.equals(itemAtual.getDescricao()))
                return itemAtual;
        return null;
    }

    public void unir (Inventario inventario) {
        for (Item itemAtual : inventario.getItens())
            this.itens.add(itemAtual);
    }
    
    public Inventario diferenciar (Inventario inventario) {
        // TO-DO: revisar e fazer mais testes
        Inventario retorno = new Inventario();
        for (Item itemAtual : this.getItens())
            if (!inventario.getItens().contains(itemAtual))
                retorno.adicionarItem(itemAtual);
        return retorno;
    }

    public void aumentar1000UnidadesDosItens() {
        for (Item itemAtual : itens)
            itemAtual.aumentar1000Unidades();
    }

    public void aumentar1000VezesSomaUnidadesDosItens() {
        for (Item itemAtual : itens)
            itemAtual.aumentar1000VezesSomaUnidadeDoItem();
    }

    public String getDescricoesItens() {
        if (!itens.isEmpty()) {
            return getDescricoesItens(0);
        }
        return "";
    }

    private String getDescricoesItens(int indice) {
        String descricaoIndice = itens.get(indice).getDescricao();
        if (indice == itens.size() - 1)
            return descricaoIndice;
        return descricaoIndice + "," + getDescricoesItens(indice + 1);
    }

    public int getMediaQuantidades(){
        int quantidadeTotalItens = this.getSomatorioQuantidades();
        return quantidadeTotalItens == 0 ? 0 : quantidadeTotalItens / itens.size();
    }

    public int getSomatorioQuantidades() {
        int quantidadeTotalItens = 0;
        for (Item itemAtual : itens) {
            quantidadeTotalItens += itemAtual.getQuantidade();
        }
        return quantidadeTotalItens;
    }

    public Item retornarItemMaisPopular(){
        if (!itens.isEmpty()){
            int indice = 0;
            int quantidade = 0;
            for (int i = 0; i < itens.size(); i++) {
                if (quantidade < itens.get(i).getQuantidade()){
                    indice = i;
                    quantidade = itens.get(i).getQuantidade();
                }
            }
            return itens.get(indice);
        }
        return null;
    }
}