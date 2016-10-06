import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class BatalhaoEspecialDeElfosTest{
    @Test
    public void retornaExercitoComoArray() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        exercito.alistar(elfo);
        assertEquals("Verdao", exercito.getExercito()[0].getNome());
    }
    
    @Test
    public void retornaExercitoDeDoisElfosComoArray() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        ElfoVerde elfo2 = new ElfoVerde("Azulao");
        exercito.alistar(elfo);
        exercito.alistar(elfo2);
        for (Elfo e : exercito.getExercito())
            assertTrue("Azulao".equals(e.getNome()) || "Verdao".equals(e.getNome()));
    }
    
    @Test
    public void alistaUmElfoVerde() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("Verdao"));
    }
    
    @Test
    public void alistaUmElfoNoturno() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("BlackElfo");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("BlackElfo"));
    }
    
    @Test
    public void alistaUmElfoComum() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        Elfo elfo = new Elfo("Elfo sem clã");
        exercito.alistar(elfo);
        assertNull(exercito.buscar("Elfo sem clã"));
    }
    
    @Test
    public void buscaElfosVivosNoExercito() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
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
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
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
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
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
    
    private boolean verificaStatusDoExercito(ArrayList<Elfo> exercitoComEsseStatus, Status status){
        if (exercitoComEsseStatus.isEmpty()) return false;
        for (Elfo elfoAtual : exercitoComEsseStatus) {
            if (!elfoAtual.getStatus().equals(status))
                return false;
        }
        return true;
    }
}
