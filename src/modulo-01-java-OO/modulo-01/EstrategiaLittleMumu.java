import java.util.List;
import java.util.ArrayList;

public class EstrategiaLittleMumu implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        ArrayList<Elfo> elfosEmOrdem = new ArrayList<>();
        if (atacantes.isEmpty())
            return elfosEmOrdem;
        List<Elfo> elfos = OrdenarElfos.getElfosVerdesENoturnosVivosEComFlechas(atacantes);
        int limiteDeElfosNoturnos = (int) (elfos.size() * 0.3);
        OrdenarElfos.ordenarPorQuantidadeDeFlechas(elfos);
        for (Elfo elfo : elfos) {
            if (elfo instanceof ElfoNoturno) {
                if (limiteDeElfosNoturnos <= 0)
                    continue;
                limiteDeElfosNoturnos--;
            }
            elfosEmOrdem.add(elfo);
        }
        return elfosEmOrdem;
    }
    
}
