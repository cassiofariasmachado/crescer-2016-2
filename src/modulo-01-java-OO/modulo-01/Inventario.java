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
    
    public void aumentar1000UnidadesDosItens(){
        for (Item itemAtual : itens)
                itemAtual.aumentar1000Unidades();
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