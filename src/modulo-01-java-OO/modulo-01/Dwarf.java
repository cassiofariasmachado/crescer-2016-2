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
    
    public void perderVida() {
        this.vida -= 10;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
    
    public double getNumeroSorte() {
        double valor = 101.0;
        if (this.vida >= 80 && this.vida <= 90 && dataNascimento.ehBissexto())  
            valor *= -33;
        if (!dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) 
            valor = (valor * 33) % 100;
        return valor;
    }
}
    