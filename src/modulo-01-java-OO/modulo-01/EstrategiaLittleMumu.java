import java.util.List;
import java.util.ArrayList;

public class EstrategiaLittleMumu implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        // Faz uma cópia dos lista de atacantes para não mexer diretamente nela.
        ArrayList<Elfo> atacantesCopia = new ArrayList<>(atacantes);
        ArrayList<Elfo> elfosEmOrdem = new ArrayList<>();
        // Conta a quantidade de elfos válidos e dopois calcula 30% disso.
        int elfosValidos = this.getElfosValidos(atacantesCopia);
        int limiteDeElfosNoturnos = (int) (elfosValidos * 0.3);
        // Ordena a cópia dos atacantes pela quantidade de flechas dos elfos (descendente).
        this.ordenarAtaquePorQuantidadeDeFlechas(atacantesCopia);
        // Ordena o ataque adicionando os elfos verdes e os noturnos até o limite.
        for (Elfo elfo : atacantesCopia) {
            if (elfo.getStatus().equals(Status.VIVO) && elfo.getFlecha().getQuantidade() > 0) {
                if (elfo instanceof ElfoVerde)
                    elfosEmOrdem.add(elfo);
                if (elfo instanceof ElfoNoturno && limiteDeElfosNoturnos > 0) {
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
    
    private void ordenarAtaquePorQuantidadeDeFlechas(List<Elfo> elfos) {
        Elfo atual;
        for (int i = 1; i < elfos.size(); i++){
            atual = elfos.get(i);
            int quantidadeFlechasAtual = atual.getFlecha().getQuantidade();
            int j;
            for (j = i - 1; j >= 0 && quantidadeFlechasAtual > elfos.get(j).getFlecha().getQuantidade(); j--){
                elfos.set(j + 1, elfos.get(j));
            }
            elfos.set(j + 1, atual);
        }   
    }
}
