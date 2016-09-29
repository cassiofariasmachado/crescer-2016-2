public class Dwarf{
    private String nome;
    private int vida;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf (String nome){
        this (nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public Dwarf (String nome, DataTerceiraEra data){
        this.nome = nome;
        this.vida = 110;
        this.dataNascimento = data;
    }
    
    public void perderVida() {
        this.vida -= 10;
    }
    
    public void ganharExperiencia() {
        this.experiencia += 2;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
    
    public double getNumeroSorte() {
        double valor = 101.0;
        if (this.vida >= 80 && this.vida <= 90 && dataNascimento.ehBissexto())  
            valor *= -33;
        if (!dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) 
            valor = valor * 33 % 100;
        return valor;
    }
    
    public boolean receberFlecha(){
        double numeroSorte = this.getNumeroSorte();
        if (numeroSorte < 0) {
            this.ganharExperiencia();
            return false;
        }
        if(numeroSorte >= 0 && numeroSorte <= 100 )
            return false;
        return true;
    }
}
    