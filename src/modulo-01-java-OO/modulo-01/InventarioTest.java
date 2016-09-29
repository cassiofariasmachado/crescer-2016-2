import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {
    
    @Test
    public void adicionarItemNoInventario(){
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item("Mosquete", 1);
        // Act
        inventario.adicionarItem(item);
        // Assert
        assertEquals(1, inventario.getItens().size());
        assertEquals(item, inventario.getItens().get(0));
        assertEquals(1, inventario.getItens().get(0).getQuantidade());
    }
    
    @Test
    public void adicionarVariosItensNoInventario(){
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item("Mosquete", 3);
        // Act
        for(int i = 0; i < 10; i++)
            inventario.adicionarItem(item);
        // Assert
        assertEquals(10, inventario.getItens().size());
        assertEquals(item, inventario.getItens().get(0));
        assertEquals(item, inventario.getItens().get(9));
        assertEquals(3, inventario.getItens().get(0).getQuantidade());
        assertEquals(3, inventario.getItens().get(9).getQuantidade());
    }
    
    @Test
    public void removerItemDoInventario(){
        // Arrange
        Inventario inventario = new Inventario();
        Item mosquete = new Item("Mosquete", 1);
        Item pistola = new Item("Pistola", 1);
        inventario.adicionarItem(mosquete);
        inventario.adicionarItem(pistola);
        // Act
        inventario.removerItem(mosquete);
        // Assert
        assertEquals(1, inventario.getItens().size());
        assertEquals(pistola, inventario.getItens().get(0));
        assertEquals(1, inventario.getItens().get(0).getQuantidade());
    }
    
    @Test
    public void removerItemDuplicadoDoInventario(){
        // Arrange
        Inventario inventario = new Inventario();
        Item mosquete1 = new Item("Mosquete", 1);
        Item mosquete2 = new Item("Mosquete", 100);
        inventario.adicionarItem(mosquete1);
        inventario.adicionarItem(mosquete2);
        // Act
        inventario.removerItem(mosquete1);
        // Assert
        assertEquals(1, inventario.getItens().size());
        assertEquals(mosquete2, inventario.getItens().get(0));
        assertEquals(100, inventario.getItens().get(0).getQuantidade());
    }
    
    @Test
    public void removerVariosItensNoInventario(){
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item("Mosquete", 3);
        // Act
        for(int i = 0; i < 10; i++)
            inventario.adicionarItem(item);
        for(int i = 0; i < 5; i++)
            inventario.removerItem(item);
        // Assert
        assertEquals(5, inventario.getItens().size());
        assertEquals(item, inventario.getItens().get(0));
        assertEquals(item, inventario.getItens().get(4));
        assertEquals(3, inventario.getItens().get(0).getQuantidade());
        assertEquals(3, inventario.getItens().get(4).getQuantidade());
    }
}
