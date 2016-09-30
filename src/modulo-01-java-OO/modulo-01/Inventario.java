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
    
    public String getDescricoesItens() {
        if (itens.size() > 0) {
            String retorno = itens.get(0).getDescricao();
            for (int i = 1; i < itens.size(); i++)
                retorno += "," + itens.get(i).getDescricao();
                return retorno;
        }
        return "";
    }
}