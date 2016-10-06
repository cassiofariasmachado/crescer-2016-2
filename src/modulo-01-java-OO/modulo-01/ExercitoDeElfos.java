import java.util.ArrayList;

public class ExercitoDeElfos {
    ArrayList<Elfo> exercito = new ArrayList<>();
    
    public Elfo[] getExercito() { 
        return exercito.toArray(new Elfo[exercito.size()]); 
    } 
    
    public void alistar(Elfo novoSoldado) {
        if (novoSoldado instanceof ElfoVerde || novoSoldado instanceof ElfoNoturno )
            this.exercito.add(novoSoldado);
    }
    
    public Elfo buscar(String nome) {
        for (Elfo soldadoAtual : this.exercito) {
            if ( ( (Elfo)soldadoAtual ).getNome().equals(nome) )
                return soldadoAtual;
        }
        return null;
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> exercitoComEsseStatus = new ArrayList<>();
        for (Elfo soldadoAtual : this.exercito) {
            if (soldadoAtual.getStatus().equals(status) )
                exercitoComEsseStatus.add(soldadoAtual);
        }
        return exercitoComEsseStatus;
    }
}