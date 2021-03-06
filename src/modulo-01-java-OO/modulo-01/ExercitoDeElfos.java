import java.util.ArrayList;

public class ExercitoDeElfos implements Exercito {
    ArrayList<Elfo> exercito = new ArrayList<>();
    
    public Elfo[] getExercito() { 
        return exercito.toArray(new Elfo[exercito.size()]); 
    } 
    
    public void alistar(Elfo novoSoldado) throws NaoPodeAlistarException {
        boolean podeAlistar = novoSoldado instanceof ElfoVerde || novoSoldado instanceof ElfoNoturno;
        if (!podeAlistar)
            throw new NaoPodeAlistarException();
        this.exercito.add(novoSoldado);  
    }
    
    public Elfo buscar(String nome) {
        for (Elfo soldadoAtual : this.exercito) {
            if ( soldadoAtual.getNome().equals(nome) )
                return soldadoAtual;
        }
        return null;
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> exercitoComEsseStatus = new ArrayList<>();
        for (Elfo soldadoAtual : this.exercito) {
            if ( soldadoAtual.getStatus().equals(status) )
                exercitoComEsseStatus.add(soldadoAtual);
        }
        return exercitoComEsseStatus;
    }
    
    public void atacar() { 
        System.out.println("Exército normal atacando"); 
    } 
}