import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest {
    
    @Test
    public void alistaUmElfoVerde() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("Verdao"));
    }
    
    @Test
    public void alistaUmElfoNoturno() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("BlackElfo");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("BlackElfo"));
    }
    
    @Test
    public void alistaUmElfoComum() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo = new Elfo("Elfo sem clã");
        exercito.alistar(elfo);
        assertTrue(exercito.buscar("Elfo sem clã") == null);
    }
    
    @Test
    public void buscaElfoNoExercitoComElfosDeNomesIguais() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo");
        ElfoVerde elfo2 = new ElfoVerde("Verdao");
        ElfoVerde elfo3 = new ElfoVerde("Queria Ser Vermelho");
        ElfoVerde elfo4 = new ElfoVerde("Queria Ser Azul");
        ElfoVerde elfo5 = new ElfoVerde("Verdao");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        assertEquals(elfo2, exercito.buscar("Verdao"));
    }
    
    @Test
    public void buscaElfoNoExercitoRetornaPrimeiroDeElfosIguais() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo");
        ElfoVerde elfo2 = new ElfoVerde("Verdao");
        ElfoVerde elfo3 = new ElfoVerde("Queria Ser Vermelho");
        ElfoVerde elfo4 = new ElfoVerde("Queria Ser Azul");
        ElfoVerde elfo5 = new ElfoVerde("Verdao");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        assertFalse(elfo5.equals(exercito.buscar("Verdao")));
    }
    
}
