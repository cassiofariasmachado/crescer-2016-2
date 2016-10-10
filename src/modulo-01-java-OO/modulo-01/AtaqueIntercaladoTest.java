import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest {

    @Test
    public void ordenaAtaqueComQuantidadeDeVerdesENoturnosIguais() throws ExercitoDesproporcionalException{
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoNoturno("Elfo noturno") );
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(3) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(4, atacantesEmOrdem.size());
    }

    @Test(expected=ExercitoDesproporcionalException.class)
    public void ordenaAtaqueComUmElfoVerdeAMais() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"),
                new ElfoNoturno("Elfo noturno"),
                new ElfoVerde("Elfo Verde") );
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(3) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(4) instanceof ElfoVerde);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(5, atacantesEmOrdem.size());
    }

    @Test(expected=ExercitoDesproporcionalException.class)
    public void ordenaAtaqueComUmElfoNoturnoAMais() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"),
                new ElfoNoturno("Elfo noturno"),
                new ElfoNoturno("Elfo noturno") );
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
    }

    @Test(expected=ExercitoDesproporcionalException.class)
    public void ordenaAtaqueComApenasElfoVerdes() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"),
                new ElfoVerde("Elfo verde"),
                new ElfoVerde("Elfo verde"));
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
    }

    @Test(expected=ExercitoDesproporcionalException.class)
    public void ordenaAtaqueComApenasElfoNoturnos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoNoturno("Elfo noturno"),
                new ElfoNoturno("Elfo noturno"),
                new ElfoNoturno("Elfo noturno"));
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
    }

    @Test(expected=ExercitoDesproporcionalException.class)
    public void ordenaAtaqueComDoisElfoVerdesAMais() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"),
                new ElfoVerde("Elfo verde"),
                new ElfoNoturno("Elfo noturno"),
                new ElfoVerde("Elfo verde"));
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
    }

    @Test(expected=ExercitoDesproporcionalException.class)
    public void ordenaAtaqueComDoisElfoNoturnosAMais() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"),
                new ElfoNoturno("Elfo noturno"),
                new ElfoNoturno("Elfo noturno"),
                new ElfoNoturno("Elfo noturno"));
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
    }

    @Test
    public void ordenaAtaqueComDoisElfoNoturnosMortos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                new ElfoVerde("Elfo verde"), 
                new ElfoVerde("Elfo verde"),
                this.criaElfoNoturnoEMataEle(),
                new ElfoNoturno("Elfo noturno"),
                this.criaElfoNoturnoEMataEle());
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(3) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(4, atacantesEmOrdem.size());
    }

    @Test
    public void ordenaAtaqueQueNaoTemElfos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList();
        List<Elfo> atacantesEmOrdem = new AtaqueIntercalado().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.isEmpty());
    }

    private boolean verificaSeTodosElfosEstaoVivos(List<Elfo> elfos) {
        for (Elfo elfo : elfos) {
            if (elfo.getStatus().equals(Status.MORTO))
                return false;
        }
        return true;
    }

    private ElfoNoturno criaElfoNoturnoEMataEle() {
        ElfoNoturno elfo = new ElfoNoturno("Elfo Noturno", 90);
        for (int i = 0; i < 90; i++) 
            elfo.atirarFlecha(new Dwarf(""));
        return elfo;
    }
}
