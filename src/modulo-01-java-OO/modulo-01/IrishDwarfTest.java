import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest {

    @Test
    public void irishDwarvesNascemComNome() {
        // Arrange and Act
        IrishDwarf irishIrishDwarf = new IrishDwarf("IrishDwarf", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals("IrishDwarf", irishIrishDwarf.getNome());
    }

    @Test
    public void irishDwarvesNascemCom110DeVida(){
        //Act
        IrishDwarf falstad = new IrishDwarf("SemCriatividade");
        //Assert
        assertEquals(110, falstad.getVida(), 0.);
    }

    @Test
    public void irishDwarvesNascemComZeroDeExperiencia(){
        //Act
        IrishDwarf falstad = new IrishDwarf("SemCriatividade");
        //Assert
        assertEquals(0, falstad.getExperiencia());
    }

    @Test
    public void irishDwarvesNascemComDataNascimento(){
        // Arrange and Act
        IrishDwarf gimli = new IrishDwarf("IrishDwarf", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals(18, gimli.getDataNascimento().getDia());
        assertEquals(2, gimli.getDataNascimento().getMes());
        assertEquals(1014, gimli.getDataNascimento().getAno());
    }

    @Test
    public void irishdwarvesNascemComDataNascimentoPadrao(){
        // Arrange and Act
        IrishDwarf gimli = new IrishDwarf("SemCriatividade");
        // Assert
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }

    @Test
    public void irishDwarvesNascemVivo() {
        assertEquals(Status.VIVO, new IrishDwarf("AnaoToSemCriatividade").getStatus());
    }

    @Test
    public void irishDwarvesNascemVivos() {
        for (int i = 0; i < 10; i++)
            assertEquals(Status.VIVO, new IrishDwarf("AnaoToSemCriatividade").getStatus());
    }

    @Test
    public void irishDwarvesNaoNascemMorto() {
        assertFalse(Status.MORTO.equals(new IrishDwarf("AnaoToSemCriatividade").getStatus()));
    }

    @Test
    public void irishDwarvesNascemComInventario(){
        IrishDwarf dwarf = new IrishDwarf("IrishDwarf");
        assertTrue(dwarf.getInventario() instanceof Inventario);
        assertEquals(0, dwarf.getInventario().getItens().size());
    }
    
    
    @Test
    public void irishDwarfAdicionaItemNoInventario(){
        // Arrange
        IrishDwarf dwarf = new IrishDwarf("Zangado");
        Item item = new Item("Mosquete", 1);
        // Act
        dwarf.adicionarItem(item);
        // Assert
        assertEquals(1, dwarf.getInventario().getItens().size());
        assertEquals(item, dwarf.getInventario().getItens().get(0));
        assertEquals(1, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfPerdeItemDoInventario(){
        // Arrange
        IrishDwarf dwarf = new IrishDwarf("Zangado");
        Item item1 = new Item("Mosquete", 1);
        Item item2 = new Item("Pistola", 10);
        dwarf.adicionarItem(item1);
        dwarf.adicionarItem(item2);
        // Act
        dwarf.perderItem(item1);
        // Assert
        assertEquals(1, dwarf.getInventario().getItens().size());
        assertEquals(item2, dwarf.getInventario().getItens().get(0));
        assertEquals(10, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.receberFlecha();
        dwarf.receberFlecha();
        dwarf.receberFlecha();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidadeNegativaComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", -5));
        dwarf.receberFlecha();
        dwarf.receberFlecha();
        dwarf.receberFlecha();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
}
