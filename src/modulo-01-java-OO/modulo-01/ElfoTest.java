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
    
    @Test
    public void elfoAtiraFlechasDemais(){
        //Act
        Elfo elfoDoTeste = new Elfo("Cassio");
        for (int i = 0; i < 43; i++)
            elfoDoTeste.atirarFlecha();
        //Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(42, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoAtiraFlechaEmDwarf(){
        //Act
        Elfo elfoDoTeste = new Elfo("Lordaeron");
        Dwarf dwarfDoTeste = new Dwarf();
        elfoDoTeste.atirarFlecha(dwarfDoTeste);
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(100, dwarfDoTeste.getVida());
    }
    
    @Test
    public void elfoAtiraFlechaEmVariosDwarfs(){
        // Arrange
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf [] dwarves = new Dwarf [10];
        for (int i = 0; i < 10; i++)
            dwarves[i] = new Dwarf();
        //Act
        for (Dwarf d : dwarves) {
            elfoDoTeste.atirarFlecha(d);
        }
        // Assert
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(10, elfoDoTeste.getExperiencia());
        for (Dwarf d : dwarves) {
            assertEquals(100, d.getVida());
        }
    }
}