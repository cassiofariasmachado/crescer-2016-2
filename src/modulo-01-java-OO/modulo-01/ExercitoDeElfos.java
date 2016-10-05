import java.util.ArrayList;

public class ExercitoDeElfos extends Exercito {
    
    public void alistar(Object novoSoldado) {
        if (novoSoldado instanceof ElfoVerde || novoSoldado instanceof ElfoNoturno )
            this.exercito.add(novoSoldado);
    }
    
    public Object buscar(String nome) {
        for (Object soldadoAtual : this.exercito) {
            if ( ( (Elfo)soldadoAtual ).getNome().equals(nome) )
                return soldadoAtual;
        }
        return null;
    }
}
