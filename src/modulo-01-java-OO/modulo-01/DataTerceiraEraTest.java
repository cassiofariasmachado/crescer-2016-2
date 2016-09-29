import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
    
    @Test
    public void criarDataComDiaMesEAno() {
        // Arrange and Act
        DataTerceiraEra fimDoMundo = new DataTerceiraEra(21, 12, 2012);
        // Assert
        assertEquals(21, fimDoMundo.getDia());
        assertEquals(12, fimDoMundo.getMes());
        assertEquals(2012, fimDoMundo.getAno());
    }
    
    @Test
    public void testarEhBissextoAno2012() {
        // Arrange
        DataTerceiraEra fimDoMundo = new DataTerceiraEra(21, 12, 2012);
        // Act
        boolean ehBissexto = fimDoMundo.ehBissexto();
        // Assert
        assertTrue(ehBissexto);
    }
    
    @Test
    public void testarEhBissextoAno3015() {
        // Arrange
        DataTerceiraEra dataFuturo = new DataTerceiraEra(18, 9, 3015);
        // Act
        boolean ehBissexto = dataFuturo.ehBissexto();
        // Assert
        assertFalse(ehBissexto);
    }
    
    @Test
    public void testarEhBissextoAno1992() {
        // Arrange
        DataTerceiraEra dataPassado = new DataTerceiraEra(23, 03, 1992);
        // Act
        boolean ehBissexto = dataPassado.ehBissexto();
        // Assert
        assertTrue(ehBissexto);
    }
    
    @Test
    public void testarEhBissextoAno1900() {
        // Arrange
        DataTerceiraEra dataPassado = new DataTerceiraEra(23, 03, 1900);
        // Act
        boolean ehBissexto = dataPassado.ehBissexto();
        // Assert
        assertFalse(ehBissexto);
    }
    
    @Test
    public void testarEhBissextoAno3019(){
        // Arrange
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 3019);
        // Act
        boolean ehBissexto = fimDaGuerraDoAnel.ehBissexto();
        // Assert
        assertFalse(ehBissexto);
    }
}
