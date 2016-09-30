public class IrishDwarf {
    private String nome;
    private int vida;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    private Status status;
    private Inventario inventario;

    public IrishDwarf (String nome){
        this (nome, new DataTerceiraEra(1, 1, 1));
    }

    public IrishDwarf (String nome, DataTerceiraEra data){
        this.nome = nome;
        this.vida = 110;
        this.dataNascimento = data;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
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
    
    public void tentarSorte() {
        double numeroSorte = getNumeroSorte();
        if (numeroSorte == -3333.) {
            this.inventario.aumentar1000VezesSomatorioAUnidadeDosItens();
        }
    }
}
