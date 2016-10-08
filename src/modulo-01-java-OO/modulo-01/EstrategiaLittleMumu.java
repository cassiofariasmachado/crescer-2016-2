import java.util.List;
import java.util.ArrayList;

public class EstrategiaLittleMumu implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        ArrayList<Elfo> elfosEmOrdem = new ArrayList<>();
        int elfosValidos = this.getElfosValidos(atacantes);
        int limiteDeElfosNoturnos = (int) (elfosValidos * 0.3);
        for (Elfo elfo : atacantes) {
            if (elfo.getStatus().equals(Status.VIVO) && elfo.getFlecha().getQuantidade() > 0) {
                if (elfo instanceof ElfoVerde)
                    elfosEmOrdem.add(elfo);
                if (elfo instanceof ElfoNoturno && (int)limiteDeElfosNoturnos > 0) {
                    elfosEmOrdem.add(elfo);
                    limiteDeElfosNoturnos--;
                }
            }
        }
        return elfosEmOrdem;
    }
    
    private int getElfosValidos(List<Elfo> atacantes) {
        int contadorDeElfosValidos = 0;
        for (Elfo elfo : atacantes) {
            if (elfo.getStatus().equals(Status.VIVO) && elfo.getFlecha().getQuantidade() > 0)
                contadorDeElfosValidos++;
        }
        return contadorDeElfosValidos;
    }
}
