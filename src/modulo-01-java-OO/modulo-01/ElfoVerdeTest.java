import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest {
    @Test
    public void elfoVerdeGanhaArcoDeVidro() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro", 1));
        // Assert
        assertTrue(elfoDoTeste.getArco() != null);
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
    
    @Test
    public void elfoVerdeGanhaFlechaDeVidro() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro", 40));
        // Assert
        assertTrue(elfoDoTeste.getFlecha() != null);
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
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
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro", 1));
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro", 40));
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(39, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
    }
    
    @Test
    public void elfoVerdeNaoAtiraFlechaPoisNaoTemArcoEFlecha() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Alleria");
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertTrue(elfoDoTeste.getFlecha() == null);
        assertTrue(elfoDoTeste.getArco() == null);
        assertEquals(0, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoVerdeAtiraDezFlechas() {
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Sylvanas");
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro", 1));
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro", 40));
        // Act
        for (int i = 0; i < 10; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(30, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(20, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoVerdeAtira43Flechas(){
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Sylvanas");
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro", 1));
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro", 42));
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
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro", 1));
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro", 42));
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
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro", 1));
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro", 42));
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
