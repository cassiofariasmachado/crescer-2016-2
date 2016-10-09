// Classes final não podem ser herdadas/extendidas.
// Java: public final class 
// C#: public sealed class 
public class Dwarf extends Personagem{
    private final DataTerceiraEra dataNascimento; 
    public final static double ALTURA_MAXIMA = 1.32;

    {
        this.vida = 110;
    }

    public Dwarf (String nome) {
        this(nome, new DataTerceiraEra(1, 1, 1));
    }

    public Dwarf (String nome, DataTerceiraEra data) {
        super (nome, 0);
        this.dataNascimento = data;
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }

    public double getNumeroSorte() {
        double valorInicial = 101.0;
        if(this.dataNascimento.ehBissexto())
            if (this.vida >= 80 && this.vida <= 90)
                return valorInicial * -33;
        if ("Seixas".equals(this.nome) || "Meireles".equals(this.nome)) 
            return valorInicial * 33 % 100;
        return valorInicial;
    }

    public void receberFlecha(){
        double numeroSorte = this.getNumeroSorte();
        // Se o numeroSorte menor que zero apenas ganha experiencia.
        if ( numeroSorte < 0 ) {
            this.ganharExperiencia();
            return;
        }
        // Se o numeroSorte maior que 100.
        if( numeroSorte > 100 ) {
            this.vida = this.vida - 10 < 0 ? 0 : this.vida - 10; // Se vida - 10 menor que 0, vida recebe 0.
            this.status = this.vida == 0 ? Status.MORTO : Status.VIVO; // Se vida igual a zero, mata Dwarf.
        }
        // Se numeroSorte maior ou igual a 0 e menor e igual 100, não faz nada.
    }

    public void tentarSorte() {
        double numeroSorte = this.getNumeroSorte();
        if (numeroSorte == -3333.) {
            this.inventario.aumentar1000UnidadesDosItens();
        }
    }

    public void ganharExperiencia() {
        this.experiencia += 2;
    }

    protected void inicializarInventario(int quantidadeFlechas) {
    }
}