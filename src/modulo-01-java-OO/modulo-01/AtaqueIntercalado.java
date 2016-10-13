import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class AtaqueIntercalado implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ExercitoDesproporcionalException {
        ArrayList<Elfo> elfosQueAtacarao = new ArrayList<>();
        if (atacantes.isEmpty()) 
            return elfosQueAtacarao;
        List<Elfo> elfosVerdes = OrdenarElfos.getElfosVerdesVivos(atacantes);
        List<Elfo> elfosNoturnos = OrdenarElfos.getElfosNoturnosVivos(atacantes);
        if ( elfosVerdes.size() != elfosNoturnos.size() )
            throw new ExercitoDesproporcionalException();
        while (!elfosVerdes.isEmpty() && !elfosNoturnos.isEmpty()) {
            elfosQueAtacarao.add(elfosVerdes.remove(0));
            elfosQueAtacarao.add(elfosNoturnos.remove(0)); 
        }
        return elfosQueAtacarao;
    }
    
}
    