public class Dwarf{
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf (){
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public Dwarf (String nome, DataTerceiraEra data){
        this.nome = nome;
        this.vida = 110;
        this.dataNascimento = data;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public int getVida(){
        return this.vida;
    }
}