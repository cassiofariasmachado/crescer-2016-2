import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class AtaqueIntercalado implements Estrategia {
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ExercitoDesproporcionalException {
        ArrayList<Elfo> elfosQueAtacarao = new ArrayList<Elfo>();
        // Se o a lista de atacantes recebida for vazia, encerra a execução retornando uma lista vazia.
        if (atacantes.isEmpty()) 
            return elfosQueAtacarao;
        ArrayList<Elfo> elfos = this.agrupaElfosVerdesENoturnos(atacantes);
        // Verifica se o se o elfo do meio da lista é um elfo verde, se for significa que existem mais elfos verdes que noturnos, então começa pelos verdes.
        // Se não, começa pelos noturnos.
        int meioDaLista = elfos.size() / 2;
        boolean elfoAnteriorVerde = false;
        // Vai removendo da lista de elfos até esvaziá-la.
        while (!elfos.isEmpty()) {
            if (elfoAnteriorVerde) {
                int ultimo = elfos.size() - 1;
                elfosQueAtacarao.add(elfos.remove(ultimo));
                elfoAnteriorVerde = false;
            }
            else{
                elfosQueAtacarao.add(elfos.remove(0));
                elfoAnteriorVerde = true;
            } 
        }
        return elfosQueAtacarao;
        }
    
    private ArrayList<Elfo> agrupaElfosVerdesENoturnos(List<Elfo> atacantes) throws ExercitoDesproporcionalException {
        // Agrupa os elfos vivos por tipo: elfos verdes no começo e elfos noturnos no fim.
        ArrayList<Elfo> elfos = new ArrayList<Elfo>();
        // Conta a quantidade de cada tipo de elfo.
        int contadorVerdes = 0;
        int contadorNoturnos = 0;
        for (Elfo elfo : atacantes) { 
            if (elfo.getStatus().equals(Status.VIVO)) {
                if (elfo instanceof ElfoVerde) {
                    elfos.add(0, elfo);
                    contadorVerdes++;
                    continue;
                }
                if (elfo instanceof ElfoNoturno) {
                    elfos.add(elfo);
                    contadorNoturnos++;
                }
            }
        }
        // Se a diferença entre a quantidade de elfos for maior que um para mais ou para menos lança exception, senão retorna os elfos agrupados por tipo.
        if (contadorVerdes != contadorNoturnos)
            throw new ExercitoDesproporcionalException();
        return elfos;
    }
}
    