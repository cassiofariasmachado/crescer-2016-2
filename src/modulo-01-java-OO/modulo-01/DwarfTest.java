import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {

    @Test
    public void dwarfNasceComNome() {
        // Act
        Dwarf thorin = new Dwarf("Thorin", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals("Thorin", thorin.getNome());
    }

    @Test
    public void dwarfNasceCom110DeVida() {
        // Act
        Dwarf falstad = new Dwarf("Thorin");
        //Assert
        assertEquals(110, falstad.getVida(), 0.);
    }

    @Test
    public void dwarfNasceVivo() {
        // Act and Assert
        assertEquals(Status.VIVO, new Dwarf("AnaoToSemCriatividade").getStatus());
    }

    @Test
    public void dwarwesNascemVivos() {
        // Act and Assert
        for (int i = 0; i < 10; i++)
            assertEquals(Status.VIVO, new Dwarf("AnaoToSemCriatividade").getStatus());
    }

    @Test
    public void dwarfNaoNasceMorto() {
        // Act and Assert
        assertFalse(Status.MORTO.equals(new Dwarf("AnaoToSemCriatividade").getStatus()));
    }

    @Test
    public void dwarfNasceComInventario() {
        // Arrange
        Dwarf dwarf = new Dwarf("Dwarf");
        // Act and Assert
        assertTrue(dwarf.getInventario() instanceof Inventario);
        assertEquals(0, dwarf.getInventario().getItens().size());
    }

    @Test
    public void dwarfNasceComDataNascimentoPadrao() {
        // Act
        Dwarf gimli = new Dwarf("Thorin");
        // Assert
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }

    @Test
    public void dwarfNasceComDataNascimento() {
        // Act
        Dwarf gimli = new Dwarf("Thorin", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals(18, gimli.getDataNascimento().getDia());
        assertEquals(2, gimli.getDataNascimento().getMes());
        assertEquals(1014, gimli.getDataNascimento().getAno());
    }

    @Test
    public void dwarfNaoRecebeFlechadaENaoGanhaExperiencia() {
        // Arrange
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(12, 12, 2011));
        // Act
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        // Assert
        assertEquals(110, dwarf.getVida(), 0.);
        assertEquals(0, dwarf.getExperiencia());
    }

    @Test
    public void dwarfNaoRecebeFlechadaEGanhaExperiencia() {
        // Arrange
        Dwarf dwarf = new Dwarf("Nome", new DataTerceiraEra(12, 12, 2012));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        // Act
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        // Assert
        assertEquals(90, dwarf.getVida(), 0.);
        assertEquals(2, dwarf.getExperiencia());
    }

    @Test
    public void dwarfRecebeFlechadaEPerdeVida() {
        // Arrange
        Dwarf dwarf = new Dwarf("Qualquer", new DataTerceiraEra(12, 12, 2011));
        // Act 
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        // Assert
        assertEquals(101, dwarf.getNumeroSorte(), 0);
        assertEquals(0, dwarf.getExperiencia());
        assertEquals(100, dwarf.getVida(), 0.);
    }

    @Test
    public void dwarfRecebeFlechadasEPerdeMuitaVida() {
        // Arrange
        Dwarf anaoToSemCriatividade = new Dwarf("SemCriatividade");
        // Act
        for (int i = 0; i < 10; i++)
            new Elfo("ElfoToSemCriatividade").atirarFlecha(anaoToSemCriatividade);
        // Assert
        assertEquals (10, anaoToSemCriatividade.getVida(), 0.);
    }

    @Test
    public void dwarfRecebeFlechadasEPerdeMuitaVidaMesmo() {
        // Arrange
        Dwarf anaoToSemCriatividade = new Dwarf("SemCriatividade");
        // Act
        for (int i = 0; i < 20; i++)
            new Elfo("ElfoToSemCriatividade").atirarFlecha(anaoToSemCriatividade);
        // Assert
        assertEquals (0, anaoToSemCriatividade.getVida(), 0.);
    }

    @Test
    public void dwarfRecebeFlechadasEMorre() {
        // Arrange
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        // Act
        for (int i = 0; i < 12; i++)
            elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(Status.MORTO, dwarf.getStatus());
    }

    @Test
    public void dwarfRecebeFlechadasMasNaoMorre() {
        // Arrange
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        // Act
        for (int i = 0; i < 5; i++)
            elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(Status.VIVO, dwarf.getStatus());
    }

    @Test
    public void dwarfRecebeFlechadasEFicaComZeroDeVida() {
        // Arrange
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        // Act
        for (int i = 0; i < 11; i++)
            elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(0, dwarf.getVida(), 0.);
    }

    @Test
    public void dwarfRecebeFlechadasEFicaComVidaNegativa() {
        // Arrange
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        // Act
        for (int i = 0; i < 12; i++)
            elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(0, dwarf.getVida(), 0.);
    }

    @Test
    public void dwarfTemSorteAnoBissextoEVida90() {
        // Arrange
        Dwarf azarado = new Dwarf("nome", new DataTerceiraEra(12, 12, 2012));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(-3333, azarado.getNumeroSorte(), 0);
    }

    @Test
    public void dwarfTemSorteAnoNaoBissextoENomeSeixas() {
        // Arrange
        Dwarf azarado = new Dwarf("Seixas", new DataTerceiraEra(12, 12, 2011));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(33, azarado.getNumeroSorte(), 0);
    }

    @Test
    public void dwarfTemSorteAnoNaoBissextoENomeMeireles() {
        // Arrange
        Dwarf azarado = new Dwarf("Meireles", new DataTerceiraEra(12, 12, 2011));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(33, azarado.getNumeroSorte(), 0);
    }

    @Test
    public void dwarfTemSorteInicial() {
        // Arrange
        Dwarf azarado = new Dwarf("Silva", new DataTerceiraEra(12, 12, 2011));
        // Act and Assert
        assertEquals(101, azarado.getNumeroSorte(), 0);
    }

    @Test
    public void dwarfAdicionaItemNoInventario() {
        // Arrange
        Dwarf dwarf = new Dwarf("Zangado");
        Item item = new Item("Mosquete", 1);
        // Act
        dwarf.adicionarItem(item);
        // Assert
        assertEquals(1, dwarf.getInventario().getItens().size());
        assertEquals(item, dwarf.getInventario().getItens().get(0));
        assertEquals(1, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfPerdeItemDoInventario() {
        // Arrange
        Dwarf dwarf = new Dwarf("Zangado");
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
    public void dwarfGanha1000Pocoes() {
        Dwarf leprechaun = new Dwarf("Leprechaun", new DataTerceiraEra(12, 12, 2016));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        leprechaun.adicionarItem(new Item("Poção de Vida", 2));
        leprechaun.tentarSorte();
        assertEquals(1002, leprechaun.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfGanha10000Pocoes() {
        Dwarf leprechaun = new Dwarf("Leprechaun", new DataTerceiraEra(12, 12, 2016));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        leprechaun.adicionarItem(new Item("Poção de Vida", 2));
        for (int i = 0; i < 10; i++)
            leprechaun.tentarSorte();
        assertEquals(10002, leprechaun.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfGanha1000DeTodosItens() {
        Dwarf leprechaun = new Dwarf("Leprechaun", new DataTerceiraEra(12, 12, 2016));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        for (int i = 0; i < 10; i++)
            leprechaun.adicionarItem(new Item("Poção de Vida", 2));
        leprechaun.tentarSorte();
        for (int i = 0; i < 10; i++)
            assertEquals(1002, leprechaun.getInventario().getItens().get(i).getQuantidade());
    }

    @Test
    public void dwarfGanha2000DeTodosItens() {
        Dwarf leprechaun = new Dwarf("Leprechaun", new DataTerceiraEra(12, 12, 2016));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        for (int i = 0; i < 10; i++)
            leprechaun.adicionarItem(new Item("Poção de Vida", 2));
        leprechaun.tentarSorte();
        leprechaun.tentarSorte();
        for (int i = 0; i < 10; i++)
            assertEquals(2002, leprechaun.getInventario().getItens().get(i).getQuantidade());
    }

    @Test
    public void dwarfNaoGanha1000DeTodosItens() {
        Dwarf leprechaun = new Dwarf("Leprechaun", new DataTerceiraEra(12, 12, 2016));
        for (int i = 0; i < 10; i++)
            leprechaun.adicionarItem(new Item("Poção de Vida", 2));
        leprechaun.tentarSorte();
        for (int i = 0; i < 10; i++)
            assertEquals(2, leprechaun.getInventario().getItens().get(i).getQuantidade());
    }

    @Test
    public void dwarfNaoTemItensParaGanhar1000DeTodosItens() {
        Dwarf leprechaun = new Dwarf("Leprechaun", new DataTerceiraEra(12, 12, 2016));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(leprechaun);
        leprechaun.tentarSorte();
        assertEquals(0, leprechaun.getInventario().getItens().size());
    }
}