import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OrdenarElfos {

    public static List<Elfo> getElfosVerdesENoturnosVivosEComFlechas (List<Elfo> atacantes) {
        return atacantes.stream().filter( e -> e.getStatus().equals(Status.VIVO) &&
                                          e.getFlecha().getQuantidade() > 0 &&
                                          e instanceof ElfoVerde || 
                                          e instanceof ElfoNoturno ).collect(Collectors.toList());
    }

    public static List<Elfo> getElfosVerdesVivos (List<Elfo> atacantes) {
        return atacantes.stream().filter(e -> e instanceof ElfoVerde).collect(Collectors.toList());
    }

    public static List<Elfo> getElfosNoturnosVivos (List<Elfo> atacantes) {
        return atacantes.stream().filter(e -> e.getStatus().equals(Status.VIVO) && 
                e instanceof ElfoNoturno).collect(Collectors.toList());
    }
    
    public static void ordenarPorQuantidadeDeFlechas(List<Elfo> atacantes) {
        Elfo atual;
        for (int i = 1; i < atacantes.size(); i++){
            atual = atacantes.get(i);
            int quantidadeFlechasAtual = atual.getFlecha().getQuantidade();
            int j;
            for (j = i - 1; j >= 0 && quantidadeFlechasAtual > atacantes.get(j).getFlecha().getQuantidade(); j--){
                atacantes.set(j + 1, atacantes.get(j));
            }
            atacantes.set(j + 1, atual);
        }   
    }

}
