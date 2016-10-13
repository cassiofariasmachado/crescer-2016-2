import java.util.List;
import java.util.ArrayList;

public class NoturnosPorUltimo implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        List<Elfo> elfosVerdes = OrdenarElfos.getElfosVerdesVivos(atacantes);
        List<Elfo> elfosNoturnos = OrdenarElfos.getElfosNoturnosVivos(atacantes);
        elfosVerdes.addAll(elfosNoturnos);
        return elfosVerdes;
    }
    
}
