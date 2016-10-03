public class Item {
    private String descricao;
    private int quantidade;
    
    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public int getSomatorioAteQuantidade() {
        return this.getSomatorioAteQuantidade(Math.abs(this.quantidade));
    }
    
    public void aumentar1000Unidades() {
        this.quantidade += 1000;
    }
    
    public void aumentar1000VezesSomaUnidadeDoItem() {
        this.quantidade += this.getSomatorioAteQuantidade() * 1000;
    }
    
    private int getSomatorioAteQuantidade(int n) {
        // Utilizando PA
        return Math.abs(n * (n + 1)) / 2;
    }
}






