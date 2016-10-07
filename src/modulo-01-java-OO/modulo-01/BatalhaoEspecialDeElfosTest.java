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
        assertEquals(elfo, exercito.getExercito()[0]);
    }
    
    @Test
    public void retornaExercitoDeDoisElfosComoArray() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        ElfoVerde elfo2 = new ElfoVerde("Azulao");
        exercito.alistar(elfo);
        exercito.alistar(elfo2);
        Elfo[] elfos = exercito.getExercito(); 
        assertTrue(contem(elfos, elfo)); 
        assertTrue(contem(elfos, elfo2)); 
    }
    
    @Test
    public void alistaUmElfoVerdeEBusca() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("Verdao"));
    }
    
    @Test
    public void alistaUmElfoNoturnoEBusca() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("BlackElfo");
        exercito.alistar(elfo);
        assertEquals(elfo, exercito.buscar("BlackElfo"));
    }
    
    @Test
    public void alistaUmElfoComumEBusca() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        Elfo elfo = new Elfo("Elfo sem clã");
        exercito.alistar(elfo);
        assertNull(exercito.buscar("Elfo sem clã"));
    }
    
    @Test
    public void buscaElfosVivosNoExercito() {
        BatalhaoEspecialDeElfos exercito = new BatalhaoEspecialDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo");
        ElfoVerde elfo2 = new ElfoVerde("GreenElfo");
        ElfoVerde elfo3 = new ElfoVerde("GreenElfo");
        ElfoVerde elfo4 = new ElfoVerde("GreenElfo");
        ElfoVerde elfo5 = new ElfoVerde("GreenElfo");
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
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo", 90);
        ElfoNoturno elfo2 = new ElfoNoturno("BlackElfo", 90);
        ElfoNoturno elfo3 = new ElfoNoturno("BlackElfo", 90);
        ElfoVerde elfo4 = new ElfoVerde("GreenElfo");
        ElfoVerde elfo5 = new ElfoVerde("GreenElfo");
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
        ElfoNoturno elfo1 = new ElfoNoturno("BlackElfo");
        ElfoNoturno elfo2 = new ElfoNoturno("BlackElfo");
        ElfoNoturno elfo3 = new ElfoNoturno("BlackElfo");
        ElfoVerde elfo4 = new ElfoVerde("GreenElfo");
        ElfoVerde elfo5 = new ElfoVerde("GreenElfo");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        assertNull(exercito.buscar(Status.MORTO));
    }
    
    private boolean contem(Elfo[] elfos, Elfo elfo) { 
        for (int i = 0; i < elfos.length; i++) { 
            if (elfos[i].equals(elfo)) { 
                return true; 
            } 
        } 
        return false; 
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
