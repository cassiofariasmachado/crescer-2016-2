import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    
    @Test
    public void dwarvesNascemCom110DeVida(){
        //Act
        Dwarf falstad = new Dwarf();
        //Assert
        assertEquals(110, falstad.getVida());
    }
    
    @Test
    public void dwarvesNascemComDataNascimentoPadrao(){
        // Arrange and Act
        Dwarf gimli = new Dwarf();
        // Assert
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarvesNascemComDataNascimento(){
        // Arrange and Act
        Dwarf gimli = new Dwarf("nome", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals(18, gimli.getDataNascimento().getDia());
        assertEquals(2, gimli.getDataNascimento().getMes());
        assertEquals(1014, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarvesNascemComNome() {
        // Arrange and Act
        Dwarf thorin = new Dwarf("Thorin", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals("Thorin", thorin.getNome());
    }
    
    @Test
    public void dwarvesPerdemVida() {
        // Arrange and Act
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        // Assert
        assertEquals (100, gimli.getVida());
    }
    
    @Test
    public void dwarvesPerdemMuitaVida() {
        // Arrange and Act
        Dwarf anaoToSemCriatividade = new Dwarf();
        for (int i = 0; i < 10; i++)
            anaoToSemCriatividade.perderVida();
        // Assert
        assertEquals (10, anaoToSemCriatividade.getVida());
    }
    
    @Test
    public void dwarvesPerdemMuitaVidaMesmo() {
        // Arrange and Act
        Dwarf anaoToSemCriatividade = new Dwarf();
        for (int i = 0; i < 20; i++)
            anaoToSemCriatividade.perderVida();
        // Assert
        assertEquals (-90, anaoToSemCriatividade.getVida());
    }
}
