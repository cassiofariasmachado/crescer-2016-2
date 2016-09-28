import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }

    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlecha() {
        // Act
        Elfo elfoDoTeste = new Elfo("Vereesa");
        // Assert
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlecha() {
        // Act
        Elfo elfoDoTeste = new Elfo("Alleria");
        elfoDoTeste.atirarFlecha();
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoAtiraVariasFlechas() {
        // Arrange
        int numeroDeFlechas = 10;
        int restante = 42 - numeroDeFlechas;
        // Act
        Elfo elfoDoTeste = new Elfo("Sylvanas");
        for (int i = 0; i < numeroDeFlechas; i++)
            elfoDoTeste.atirarFlecha();
        // Assert
        assertEquals(restante, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(numeroDeFlechas, elfoDoTeste.getExperiencia());
    }
}