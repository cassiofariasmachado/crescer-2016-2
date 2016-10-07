

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest {
    
    @Test
    public void ordenaAtaqueQueNaoEstaEmOrdem() {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                                              new ElfoVerde("Elfo verde"), 
                                              new ElfoVerde("Elfo verde"), 
                                              new ElfoNoturno("Elfo noturno") );
        List<Elfo> atacantesEmOrdem = new NoturnosPorUltimo().getOrdemDeAtaque(atacantes, null);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(3) instanceof ElfoNoturno);
        assertTrue(verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(4, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueQueJaEstaEmOrdem() {
        List<Elfo> atacantes = Arrays.asList( new ElfoVerde("Elfo verde"), 
                                              new ElfoNoturno("Elfo noturno") );
        List<Elfo> atacantesEmOrdem = new NoturnosPorUltimo().getOrdemDeAtaque(atacantes, null);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoNoturno);
        assertTrue(verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(2, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueQueTemElfosMortos() {
        List<Elfo> atacantes = Arrays.asList( this.criaElfoNoturnoEMataEle(), 
                                              new ElfoVerde("Elfo verde"), 
                                              new ElfoNoturno("Elfo noturno"),
                                              new ElfoVerde("Elfo verde"),
                                              this.criaElfoNoturnoEMataEle(),
                                              new ElfoNoturno("Elfo noturno") );
        List<Elfo> atacantesEmOrdem = new NoturnosPorUltimo().getOrdemDeAtaque(atacantes, null);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(4, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueQueNaoTemElfos() {
        List<Elfo> atacantes = Arrays.asList();
        List<Elfo> atacantesEmOrdem = new NoturnosPorUltimo().getOrdemDeAtaque(atacantes, null);
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
