import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    
    @Test
    public void dwarvesNascemCom110DeVida(){
        //Act
        Dwarf falstad = new Dwarf("SemCriatividade");
        //Assert
        assertEquals(110, falstad.getVida());
    }
    
    @Test
    public void dwarvesNascemComDataNascimentoPadrao(){
        // Arrange and Act
        Dwarf gimli = new Dwarf("SemCriatividade");
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
        Dwarf gimli = new Dwarf("SemCriatividade");
        new Elfo("Legolas").atirarFlecha(gimli);
        // Assert
        assertEquals (100, gimli.getVida());
    }
    
    @Test
    public void dwarvesPerdemMuitaVida() {
        // Arrange and Act
        Dwarf anaoToSemCriatividade = new Dwarf("SemCriatividade");
        for (int i = 0; i < 10; i++)
            new Elfo("ElfoToSemCriatividade").atirarFlecha(anaoToSemCriatividade);
        // Assert
        assertEquals (10, anaoToSemCriatividade.getVida());
    }
    
    @Test
    public void dwarvesPerdemMuitaVidaMesmo() {
        // Arrange and Act
        Dwarf anaoToSemCriatividade = new Dwarf("SemCriatividade");
        for (int i = 0; i < 20; i++)
            new Elfo("ElfoToSemCriatividade").atirarFlecha(anaoToSemCriatividade);
        // Assert
        assertEquals (-90, anaoToSemCriatividade.getVida());
    }
    
    @Test
    public void dwarfTemSorteAnoBissextoEVida90(){
        // Arrange
        Dwarf azarado = new Dwarf("nome", new DataTerceiraEra(12, 12, 2012));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(-3333, azarado.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfTemSorteAnoNaoBissextoENomeSeixas(){
        // Arrange
        Dwarf azarado = new Dwarf("Seixas", new DataTerceiraEra(12, 12, 2011));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(33, azarado.getNumeroSorte(), 0);
    }
    
    
    @Test
    public void dwarfTemSorteAnoNaoBissextoENomeMeireles(){
        // Arrange
        Dwarf azarado = new Dwarf("Meireles", new DataTerceiraEra(12, 12, 2011));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(33, azarado.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfTemSorteInicial(){
        // Arrange
        Dwarf azarado = new Dwarf("Silva", new DataTerceiraEra(12, 12, 2011));
        // Act and Assert
        assertEquals(101, azarado.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfNaoRecebeFlechaENaoGanhaExperiencia(){
        // Arrange
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(12, 12, 2011));
        dwarf.receberFlecha();
        // Act and Assert
        assertEquals(110, dwarf.getVida());
        assertEquals(0, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfNaoRecebeFlechaEGanhaExperiencia(){
        // Arrange
        Dwarf dwarf = new Dwarf("Nome", new DataTerceiraEra(12, 12, 2012));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        dwarf.receberFlecha();
        // Act and Assert
        assertEquals(90, dwarf.getVida());
        assertEquals(2, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfRecebeFlecha(){
        // Arrange
        Dwarf dwarf = new Dwarf("Qualquer", new DataTerceiraEra(12, 12, 2011));
        // Act 
        dwarf.receberFlecha();
        // Act and Assert
        assertEquals(101, dwarf.getNumeroSorte(), 0);
        assertEquals(0, dwarf.getExperiencia());
        assertEquals(100, dwarf.getVida());
    }
}