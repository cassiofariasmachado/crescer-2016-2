import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {
    @Test
    public void elfoVerdeAtiraUmaFlecha() {
        // Act
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Alleria");
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(3, elfoDoTeste.getExperiencia());
        assertEquals(95., elfoDoTeste.getVida(), .0);
    }
    
    @Test
    public void elfoNoturnoAtiraDuasFlechas() {
        // Act
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Alleria");
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
        assertEquals(77.37809375, elfoDoTeste.getVida(), .0);
    }
    
    @Test
    public void elfoNoturnoComVidaNegativaAtira1000FlechasEMorre() {
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Sylvanas");
        elfoDoTeste.getFlecha().setQuantidade(1000);
        Dwarf dwarf = new Dwarf("SemCriatividade");
        // Act
        for (int i = 0; i < 1000; i++)
            elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(3000, elfoDoTeste.getExperiencia());
        assertEquals(Status.MORTO, elfoDoTeste.getStatus());
    }
}
