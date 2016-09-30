import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    
    @Test
    public void testaCriacaoDeItens(){
        // Arrange and Act
        Item cantil = criaUmItem();
        // Assert
        assertEquals("Cantil", cantil.getDescricao());
        assertEquals(1, cantil.getQuantidade());
    }
    
    @Test
    public void aumenta1000UnidadesQuantidadeItem(){
        // Arrange and Act
        Item cantil = criaUmItem();
        cantil.aumentar1000Unidades();
        // Assert
        assertEquals("Cantil", cantil.getDescricao());
        assertEquals(1001, cantil.getQuantidade());
    }
    
    @Test
    public void aumenta1000UnidadesQuantidadeDeDoisItens(){
        // Arrange and Act
        Item cantil1 = criaUmItem();
        Item cantil2 = criaUmItem();
        cantil1.aumentar1000Unidades();
        cantil2.aumentar1000Unidades();
        // Assert
        assertEquals("Cantil", cantil1.getDescricao());
        assertEquals(1001, cantil1.getQuantidade());
        assertEquals("Cantil", cantil2.getDescricao());
        assertEquals(1001, cantil2.getQuantidade());
    }
    
    @Test
    public void aumenta1000UnidadesQuantidadeDeUmItemPossuindoDois(){
        // Arrange and Act
        Item cantil1 = criaUmItem();
        Item cantil2 = criaUmItem();
        cantil1.aumentar1000Unidades();
        // Assert
        assertEquals("Cantil", cantil1.getDescricao());
        assertEquals(1001, cantil1.getQuantidade());
        assertEquals("Cantil", cantil2.getDescricao());
        assertEquals(1, cantil2.getQuantidade());
    }
    
    private Item criaUmItem() {
        return new Item("Cantil", 1);
    }
}
