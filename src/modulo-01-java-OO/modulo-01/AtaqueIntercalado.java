import java.util.List;
import java.util.Arrays;

public class AtaqueIntercalado implements Estrategia {

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ExercitoDesproporcionalException {
        // TO-DO: revisar, possível simplificação.
        int contadores [] = this.getContadoresDeElfosVerdesENoturnos(atacantes);
        int diferencaContadores = contadores[0] - contadores[1];
        if (diferencaContadores > 1 || diferencaContadores < -1)
            throw new ExercitoDesproporcionalException();
        Elfo[] elfosQueAtacarao = new Elfo[ contadores[0] + contadores[1] ];
        int indiceVerdes = diferencaContadores == -1 ? 1 : 0;
        int indiceNoturnos = diferencaContadores == -1 ? 0 : 1;
        for (Elfo elfo : atacantes) {
            if (elfo.getStatus().equals(Status.VIVO)) {
                if (elfo instanceof ElfoVerde) {
                    elfosQueAtacarao [indiceVerdes] = elfo;
                    indiceVerdes += 2;
                }
                if (elfo instanceof ElfoNoturno) {
                    elfosQueAtacarao [indiceNoturnos] = elfo;
                    indiceNoturnos += 2;
                }
            }
        }
        return Arrays.asList(elfosQueAtacarao);
    }
    
    private int[] getContadoresDeElfosVerdesENoturnos(List<Elfo> elfos) {
        int contadorVerdes = 0;
        int contadorNoturnos = 0;
        for (Elfo elfo : elfos) {
            if (elfo.getStatus().equals(Status.VIVO)) {
                if (elfo instanceof ElfoVerde)
                    contadorVerdes++;
                if (elfo instanceof ElfoNoturno)
                    contadorNoturnos++;
            }
        }
        return new int[] {contadorVerdes, contadorNoturnos};
    }      
}


