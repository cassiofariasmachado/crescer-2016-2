import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class AtaqueIntercalado implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ExercitoDesproporcionalException {
        ArrayList<Elfo> elfosQueAtacarao = new ArrayList<>();
        // TO-DO: revisar, talvez possa ser simplificado ainda mais..
        // Se o a lista de atacantes recebida for vazia, encerra a execução retornando uma lista vazia.
        if (atacantes.isEmpty()) 
            return elfosQueAtacarao;
        // Armazena na variável elfos somentes elfos noturnos e verdes vivos.
        List<Elfo> elfos = OrdenarElfos.getElfosVerdesENoturnosVivos(atacantes);
        // Se atacantes não forem 50% elfos verdes e 50% elfos noturnos lança exceção.
        if (this.ehExercitoDesproporcional(elfos))
            throw new ExercitoDesproporcionalException();
        // Começa sempre pelos elfos verdes.
        boolean elfoAnteriorVerde = false;
        // Vai removendo da lista de elfos até esvaziá-la.
        while (!elfos.isEmpty()) {
            if (elfoAnteriorVerde) {
                int ultimo = elfos.size() - 1;
                elfosQueAtacarao.add(elfos.remove(ultimo));
                elfoAnteriorVerde = false;
            }
            else{
                elfosQueAtacarao.add(elfos.remove(0));
                elfoAnteriorVerde = true;
            } 
        }
        return elfosQueAtacarao;
    }
    
    private boolean ehExercitoDesproporcional(List<Elfo> atacantes) {
        int contadorVerdes = 0;
        int contadorNoturnos = 0;
        for (Elfo elfo : atacantes) {
            if (elfo instanceof ElfoVerde)
                contadorVerdes++;
            if (elfo instanceof ElfoNoturno)
                contadorNoturnos++;
        }
        return contadorVerdes != contadorNoturnos;
    }
        
}
    