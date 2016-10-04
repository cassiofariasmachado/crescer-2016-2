import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest {
    @Test
    public void elfoVerdeNasceComArcoDeVidroEFlechaDeVidro() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        // Assert
        assertEquals("Arco de Vidro", elfoDoTeste.getArco().getDescricao());
        assertEquals("Flecha de Vidro", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoVerdeGanhaEspadaDeAcoValiriano() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        Item espada = new Item("Espada de aço valiriano", 1);
        elfoDoTeste.adicionarItem(espada);
        // Assert
        assertTrue(elfoDoTeste.getInventario().getItens().contains(espada));
    }
    
    @Test
    public void elfoVerdeNaoGanhaItemQualquer() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        Item itemQualquer = new Item("Qualquer item, ele nao ganha mesmo, muahahahahaha", 1);
        elfoDoTeste.adicionarItem(itemQualquer);
        // Assert
        assertFalse(elfoDoTeste.getInventario().getItens().contains(itemQualquer));
    }
    
    @Test
    public void elfoVerdeAtiraUmaFlecha() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        elfoDoTeste.adicionarItem(new Item("Arco e Flecha de Vidro", 40));
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoVerdeNaoAtiraFlechaPoisNaoTemFlecha() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria", 1);
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoVerdeAtiraDezFlechas() {
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Sylvanas");
        elfoDoTeste.adicionarItem(new Item("Arco e Flecha de Vidro", 40));
        // Act
        for (int i = 0; i < 10; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(20, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoVerdeAtira43Flechas(){
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Sylvanas");
        elfoDoTeste.adicionarItem(new Item("Arco e Flecha de Vidro", 42));
        // Act
        for (int i = 0; i < 43; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(84, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoVerdeAtiraFlechaEmDwarf(){
        //Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Lordaeron");
        elfoDoTeste.adicionarItem(new Item("Arco e Flecha de Vidro", 42));
        Dwarf dwarfDoTeste = new Dwarf("SemCriatividade");
        elfoDoTeste.atirarFlecha(dwarfDoTeste);
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
        assertEquals(100, dwarfDoTeste.getVida());
    }

    @Test
    public void elfoVerdeAtiraFlechaEmVariosDwarfs(){
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Legolas");
        elfoDoTeste.adicionarItem(new Item("Arco e Flecha de Vidro", 42));
        Dwarf [] dwarves = new Dwarf [10];
        for (int i = 0; i < 10; i++)
            dwarves[i] = new Dwarf("SemCriatividade");
        //Act
        for (Dwarf d : dwarves) {
            elfoDoTeste.atirarFlecha(d);
        }
        // Assert
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(20, elfoDoTeste.getExperiencia());
        for (Dwarf d : dwarves) {
            assertEquals(100, d.getVida());
        }
    }
}