import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoDeElfosTest {
    @After
    // Executa após cada cenário de teste.
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void retornaExercitoComoArray() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        exercito.alistar(elfo);
        // Act and Assert
        assertEquals("Verdao", exercito.getExercito()[0].getNome());
    }
    
    @Test
    public void retornaExercitoDeDoisElfosComoArray() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        ElfoVerde elfo2 = new ElfoVerde("Azulao");
        exercito.alistar(elfo);
        exercito.alistar(elfo2);
        // Act and Assert
        assertTrue(exercito.getExercito()[0].getNome().equals("Verdao"));
        assertTrue(exercito.getExercito()[1].getNome().equals("Azulao"));
    }
    
    @Test
    public void alistaUmElfoVerde() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfo = new ElfoVerde("Verdao");
        // Act
        exercito.alistar(elfo);
        // Assert
        assertEquals(elfo, exercito.buscar("Verdao"));
    }
    
    @Test
    public void alistaUmElfoNoturno() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo = new ElfoNoturno("BlackElfo");
        // Act
        exercito.alistar(elfo);
        // Assert
        assertEquals(elfo, exercito.buscar("BlackElfo"));
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void alistaUmElfoComum() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo = new Elfo("Elfo sem clã");
        // Act
        exercito.alistar(elfo);
        // Assert
        assertNull(exercito.buscar("Elfo sem clã"));
    }
    
    @Test
    public void buscaElfoNoExercitoRetornaPrimeiroDeElfosIguais() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("Queria ser noturno");
        ElfoVerde elfo2 = new ElfoVerde("Queria ser verde");
        ElfoVerde elfo3 = new ElfoVerde("Queria ser Vermelho");
        ElfoVerde elfo4 = new ElfoVerde("Queria ser Azul");
        ElfoVerde elfo5 = new ElfoVerde("Queria ser verde");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        // Act and Assert
        assertEquals(elfo2, exercito.buscar("Queria ser verde"));
    }
    
    @Test
    public void buscaElfoNoExercitoNaoRetornaUltimoDeElfosIguais() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("Queria ser noturno");
        ElfoVerde elfo2 = new ElfoVerde("Queria ser verde");
        ElfoVerde elfo3 = new ElfoVerde("Queria ser Vermelho");
        ElfoVerde elfo4 = new ElfoVerde("Queria ser Azul");
        ElfoVerde elfo5 = new ElfoVerde("Queria ser verde");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        // Act and Assert
        assertFalse(elfo5.equals(exercito.buscar("Queria ser verde")));
    }
    
    @Test
    public void buscaElfosVivosNoExercito() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("Elfo qualquer");
        ElfoVerde elfo2 = new ElfoVerde("Elfo qualquer");
        ElfoVerde elfo3 = new ElfoVerde("Elfo qualquer");
        ElfoVerde elfo4 = new ElfoVerde("Elfo qualquer");
        ElfoVerde elfo5 = new ElfoVerde("Elfo qualquer");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        // Act and Assert
        assertTrue(verificaStatusDoExercito(exercito.buscar(Status.VIVO), Status.VIVO));
    }
    
    @Test
    public void buscaElfosMortosNoExercito() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("Elfo qualquer",90);
        ElfoNoturno elfo2 = new ElfoNoturno("Elfo qualquer",90);
        ElfoNoturno elfo3 = new ElfoNoturno("Elfo qualquer",90);
        ElfoVerde elfo4 = new ElfoVerde("Elfo qualquer");
        ElfoVerde elfo5 = new ElfoVerde("Elfo qualquer");
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
        // Act and Assert
        assertTrue(verificaStatusDoExercito(exercito.buscar(Status.MORTO), Status.MORTO));
    }
    
    @Test
    public void buscaElfosMortosEmExercitoQueNaoTem() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfo1 = new ElfoNoturno("Elfo qualquer",90);
        ElfoNoturno elfo2 = new ElfoNoturno("Elfo qualquer",90);
        ElfoNoturno elfo3 = new ElfoNoturno("Elfo qualquer",90);
        ElfoVerde elfo4 = new ElfoVerde("Elfo qualquer");
        ElfoVerde elfo5 = new ElfoVerde("Elfo qualquer");
        exercito.alistar(elfo1);
        exercito.alistar(elfo2);
        exercito.alistar(elfo3);
        exercito.alistar(elfo4);
        exercito.alistar(elfo5);
        // Act and Assert
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
