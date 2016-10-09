import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {
    @After
    // Executa após cada cenário de teste.
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void elfoNoturnoAtiraUmaFlecha() {
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Alleria");
        // Act
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(3, elfoDoTeste.getExperiencia());
        assertEquals(95., elfoDoTeste.getVida(), .0);
    }
    
    @Test
    public void elfoNoturnoAtiraDuasFlechas() {
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Alleria");
        // Act
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(6, elfoDoTeste.getExperiencia());
        assertEquals(90.25, elfoDoTeste.getVida(), .0);
    }

    @Test
    public void elfoNoturnoAtiraCincoFlechas() {
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Sylvanas");
        // Act
        for (int i = 0; i < 5; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(37, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(15, elfoDoTeste.getExperiencia());
        assertEquals(77.3, elfoDoTeste.getVida(), 0.09);
    }
    
    @Test
    public void elfoNoturnoAtira90FlechasEMorre() {
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Sylvanas", 90);
        Dwarf dwarf = new Dwarf("SemCriatividade");
        // Act
        for (int i = 0; i < 90; i++)
            elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(270, elfoDoTeste.getExperiencia());
        assertEquals(Status.MORTO, elfoDoTeste.getStatus());
    }
    
    @Test 
    public void elfoNoturnoNaoAtiraSeEstaMorto() { 
        // Arrange
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Harakiri", 91);
        // Act
        for (int i = 0; i < 91; i++) 
            elfoSuiçida.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1))); 
        // Assert
        assertEquals(1, elfoSuiçida.getFlecha().getQuantidade());
        assertEquals(270, elfoSuiçida.getExperiencia());
        assertEquals(Status.MORTO, elfoSuiçida.getStatus());
    } 
    
    @Test 
    public void elfoNoturnoNaoAtiraSeNaoTemFlechas() { 
        // Arrange
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Harakiri", 3);
        // Act
        for (int i = 0; i < 5; i++) 
            elfoSuiçida.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1))); 
        // Assert
        assertEquals(0, elfoSuiçida.getFlecha().getQuantidade());
        assertEquals(9, elfoSuiçida.getExperiencia());
        assertEquals(Status.VIVO, elfoSuiçida.getStatus());
    } 
}
