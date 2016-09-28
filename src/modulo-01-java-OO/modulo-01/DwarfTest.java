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
}
