import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest {
    
    @Test
    public void cestoTemLembas(){
        // Arrange
        int lembas = 22;
        // Act
        CestoDeLembas cestoSam = new CestoDeLembas(lembas);
        // Assert
        assertEquals(lembas, cestoSam.getLembas());
    }
    
    @Test
    public void testaPodeDividirEmPares(){
        // Act
        CestoDeLembas cestoSmeagol = new CestoDeLembas(0);
        CestoDeLembas cestoFrodo = new CestoDeLembas(2);
        CestoDeLembas cestoSam = new CestoDeLembas(6);
        CestoDeLembas cestoGimli = new CestoDeLembas(8);
        CestoDeLembas cestoThorin = new CestoDeLembas(9);
        CestoDeLembas cestoGandalf = new CestoDeLembas(10);
        // Assert
        assertFalse(cestoSmeagol.podeDividirEmPares());
        assertFalse(cestoFrodo.podeDividirEmPares());
        assertTrue(cestoSam.podeDividirEmPares());
        assertTrue(cestoGimli.podeDividirEmPares());
        assertFalse(cestoThorin.podeDividirEmPares()); 
        assertTrue(cestoGandalf.podeDividirEmPares()); 
    }
    
}
