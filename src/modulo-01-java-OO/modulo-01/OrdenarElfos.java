import java.util.List;
import java.util.ArrayList;

public class OrdenarElfos {
    
    public static List<Elfo> getElfosVerdesENoturnosVivos (List<Elfo> atacantes) {
        ArrayList<Elfo> elfos = new ArrayList<Elfo>();
        for (Elfo elfo : atacantes) { 
            if (elfo.getStatus().equals(Status.VIVO)) {
                if (elfo instanceof ElfoVerde) {
                    elfos.add(0, elfo);
                    continue;
                }
                if (elfo instanceof ElfoNoturno) {
                    elfos.add(elfo);
                }
            }
        }
        return elfos;
    }
    
}
