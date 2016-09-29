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
        if( this.dataNascimento.ehBissexto() ) {
            if (this.vida >= 80 && this.vida <= 90)
                valor *= -33;
        }
        else if ( this.nome.equals("Seixas") || this.nome.equals("Meireles") ) 
                    valor = valor * 33 % 100;
        return valor;
    }
    
    public void receberFlecha(){
        double numeroSorte = this.getNumeroSorte();
        //numeroSorte menor que zero apenas ganha experiencia
        if ( numeroSorte < 0 ) 
            this.experiencia += 2;
        //numeroSorte maior que zero apenas    
        if( numeroSorte > 100 )
                this.vida -= 10; 
        //numeroSorte maior que 0 e menor e igual 100
    }
}
    