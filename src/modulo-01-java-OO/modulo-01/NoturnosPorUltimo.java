import java.util.List;
import java.util.ArrayList;

public class NoturnosPorUltimo implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        ArrayList<Elfo> elfosQueAtacarao = new ArrayList<>();
        for (Elfo elfo : atacantes) {
            if (elfo.getStatus().equals(Status.VIVO)) {
                if (elfo instanceof ElfoVerde)
                    elfosQueAtacarao.add(0, elfo);
                if (elfo instanceof ElfoNoturno)
                    elfosQueAtacarao.add(elfo);
            }
        }
        return elfosQueAtacarao;
    }
    
}
