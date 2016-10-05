import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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
    
    @Test
    public void buscaElfosVivosNoExercito() {
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
        assertTrue(verificaStatusDoExercito(exercito.buscar(Status.VIVO), Status.VIVO));
    }
    
    @Test
    public void buscaElfosMortosNoExercito() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo",90);
        ElfoNoturno elfo2 = new ElfoNoturno("Verdao",90);
        ElfoNoturno elfo3 = new ElfoNoturno("Queria Ser Vermelho",90);
        ElfoVerde elfo4 = new ElfoVerde("Queria Ser Azul");
        ElfoVerde elfo5 = new ElfoVerde("Verdao");
        for(int i = 0; i < 90; i++) {
            elfo1.atirarFlecha(new Dwarf(""));
            elfo2.atirarFlecha(new Dwarf(""));
            elfo3.atirarFlecha(new Dwarf(""));
        }
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        assertTrue(verificaStatusDoExercito(exercito.buscar(Status.MORTO), Status.MORTO));
    }
    
    @Test
    public void buscaElfosMortosEmExercitoQueNaoTem() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo",90);
        ElfoNoturno elfo2 = new ElfoNoturno("Verdao",90);
        ElfoNoturno elfo3 = new ElfoNoturno("Queria Ser Vermelho",90);
        ElfoVerde elfo4 = new ElfoVerde("Queria Ser Azul");
        ElfoVerde elfo5 = new ElfoVerde("Verdao");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        assertFalse(verificaStatusDoExercito(exercito.buscar(Status.MORTO), Status.MORTO));
    }
    
    private boolean verificaStatusDoExercito(ArrayList<Object> exercitoComEsseStatus, Status status){
        if (exercitoComEsseStatus.isEmpty()) return false;
        for (Object objetoAtual : exercitoComEsseStatus) {
            if (!((Elfo)objetoAtual).getStatus().equals(status))
                return false;
        }
        return true;
    }

    
}
