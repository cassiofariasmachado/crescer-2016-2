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
        CestoDeLembas cestoFrodo = new CestoDeLembas(2);
        CestoDeLembas cestoSam = new CestoDeLembas(6);
        // Assert
        assertEquals(false, cestoFrodo.podeDividirEmPares());
        assertEquals(true, cestoSam.podeDividirEmPares());   
    }
    
}
