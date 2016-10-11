import java.util.List;
import java.util.ArrayList;

public class EstrategiaLittleMumu implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        // TO-DO: revisar, talvez possa ser simplificado ainda mais..
        ArrayList<Elfo> elfosEmOrdem = new ArrayList<>();
        if (atacantes.isEmpty())
            return elfosEmOrdem;
        // Armazena na variável elfos, os elfos verdes e noturnos vivos.
        List<Elfo> elfos = OrdenarElfos.getElfosVerdesENoturnosVivos(atacantes);
        // Calcula número de elfos válidos.
        int elfosValidos = this.getElfosValidos(elfos);
        int limiteDeElfosNoturnos = (int) (elfosValidos * 0.3);
        // Ordena ataque por quantidade de flechas.
        this.ordenarAtaquePorQuantidadeDeFlechas(elfos);
        // Adiciona elfos nos na variavel de retorno, pulando elfos sem flechas e elfos noturnos além do limite.
        for (int i = 0; i < elfos.size(); i++) {
            Elfo elfo = elfos.get(i);
            if (elfo.getFlecha().getQuantidade() <= 0) {
                continue;
            }
            if (elfo instanceof ElfoNoturno) {
                if (limiteDeElfosNoturnos <= 0)
                    continue;
                limiteDeElfosNoturnos--;
            }
            elfosEmOrdem.add(elfo);
        }
        
        return elfosEmOrdem;
    }
    
    private int getElfosValidos(List<Elfo> atacantes) {
        int contadorDeElfosValidos = 0;
        for (Elfo elfo : atacantes) {
            if (elfo.getFlecha().getQuantidade() > 0)
                contadorDeElfosValidos++;
        }
        return contadorDeElfosValidos;
    }
    
    private void ordenarAtaquePorQuantidadeDeFlechas(List<Elfo> atacantes) {
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
