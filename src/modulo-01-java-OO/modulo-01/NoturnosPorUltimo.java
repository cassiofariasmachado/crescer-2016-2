import java.util.List;
import java.util.ArrayList;

public class NoturnosPorUltimo implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        return OrdenarElfos.getElfosVerdesENoturnosVivos(atacantes);
    }
    
}
