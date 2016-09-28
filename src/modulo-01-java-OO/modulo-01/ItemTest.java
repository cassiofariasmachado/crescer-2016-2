import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    
    @Test
    public void testaCriacaoDeItens(){
        // Arrange
        String descricao = "Cantil";
        int quantidade = 1;
        // Act
        Item cantil = new Item (descricao, quantidade);
        // Assert
        assertEquals(descricao, cantil.getDescricao());
        assertEquals(quantidade, cantil.getQuantidade());
    }
}
