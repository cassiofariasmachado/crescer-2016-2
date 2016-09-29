import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    
    @Test
    public void dwarvesNascemCom110DeVida(){
        //Act
        Dwarf falstad = new Dwarf("SemCriatividade");
        //Assert
        assertEquals(110, falstad.getVida());
    }
    
    @Test
    public void dwarvesNascemComDataNascimentoPadrao(){
        // Arrange and Act
        Dwarf gimli = new Dwarf("SemCriatividade");
        // Assert
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarvesNascemComDataNascimento(){
        // Arrange and Act
        Dwarf gimli = new Dwarf("nome", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals(18, gimli.getDataNascimento().getDia());
        assertEquals(2, gimli.getDataNascimento().getMes());
        assertEquals(1014, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarvesNascemComNome() {
        // Arrange and Act
        Dwarf thorin = new Dwarf("Thorin", new DataTerceiraEra(18, 2, 1014));
        // Assert
        assertEquals("Thorin", thorin.getNome());
    }
    
    @Test
    public void dwarvesPerdemVida() {
        // Arrange and Act
        Dwarf gimli = new Dwarf("SemCriatividade");
        new Elfo("Legolas").atirarFlecha(gimli);
        // Assert
        assertEquals (100, gimli.getVida());
    }
    
    @Test
    public void dwarvesPerdemMuitaVida() {
        // Arrange and Act
        Dwarf anaoToSemCriatividade = new Dwarf("SemCriatividade");
        for (int i = 0; i < 10; i++)
            new Elfo("ElfoToSemCriatividade").atirarFlecha(anaoToSemCriatividade);
        // Assert
        assertEquals (10, anaoToSemCriatividade.getVida());
    }
    
    @Test
    public void dwarvesPerdemMuitaVidaMesmo() {
        // Arrange and Act
        Dwarf anaoToSemCriatividade = new Dwarf("SemCriatividade");
        for (int i = 0; i < 20; i++)
            new Elfo("ElfoToSemCriatividade").atirarFlecha(anaoToSemCriatividade);
        // Assert
        assertEquals (0, anaoToSemCriatividade.getVida());
    }
    
    @Test
    public void dwarfTemSorteAnoBissextoEVida90(){
        // Arrange
        Dwarf azarado = new Dwarf("nome", new DataTerceiraEra(12, 12, 2012));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(-3333, azarado.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfTemSorteAnoNaoBissextoENomeSeixas(){
        // Arrange
        Dwarf azarado = new Dwarf("Seixas", new DataTerceiraEra(12, 12, 2011));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(33, azarado.getNumeroSorte(), 0);
    }
    
    
    @Test
    public void dwarfTemSorteAnoNaoBissextoENomeMeireles(){
        // Arrange
        Dwarf azarado = new Dwarf("Meireles", new DataTerceiraEra(12, 12, 2011));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(azarado);
        // Act and Assert
        assertEquals(33, azarado.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfTemSorteInicial(){
        // Arrange
        Dwarf azarado = new Dwarf("Silva", new DataTerceiraEra(12, 12, 2011));
        // Act and Assert
        assertEquals(101, azarado.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfNaoRecebeFlechaENaoGanhaExperiencia(){
        // Arrange
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(12, 12, 2011));
        dwarf.receberFlecha();
        // Act and Assert
        assertEquals(110, dwarf.getVida());
        assertEquals(0, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfNaoRecebeFlechaEGanhaExperiencia(){
        // Arrange
        Dwarf dwarf = new Dwarf("Nome", new DataTerceiraEra(12, 12, 2012));
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        new Elfo("ElfoToSemCriatividade").atirarFlecha(dwarf);
        dwarf.receberFlecha();
        // Act and Assert
        assertEquals(90, dwarf.getVida());
        assertEquals(2, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfRecebeFlecha(){
        // Arrange
        Dwarf dwarf = new Dwarf("Qualquer", new DataTerceiraEra(12, 12, 2011));
        // Act 
        dwarf.receberFlecha();
        // Act and Assert
        assertEquals(101, dwarf.getNumeroSorte(), 0);
        assertEquals(0, dwarf.getExperiencia());
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void dwarfNasceVivo() {
        assertEquals(Status.VIVO, new Dwarf("AnaoToSemCriatividade").getStatus());
    }
    
    @Test
    public void dwarvesNascemVivos() {
        for (int i = 0; i < 10; i++)
            assertEquals(Status.VIVO, new Dwarf("AnaoToSemCriatividade").getStatus());
    }
    
    @Test
    public void dwarfNaoNasceMorto() {
        assertFalse(Status.MORTO.equals(new Dwarf("AnaoToSemCriatividade").getStatus()));
    }
    
    @Test
    public void dwarfMorre() {
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        for (int i = 0; i < 12; i++)
            elfo.atirarFlecha(dwarf);
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfRecebeFlechadasMasNaoMorre() {
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        for (int i = 0; i < 5; i++)
            elfo.atirarFlecha(dwarf);
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfFicaComZeroDeVidaEContinua() {
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        for (int i = 0; i < 11; i++)
            elfo.atirarFlecha(dwarf);
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void dwarfNaoFicaComVidaNegativa() {
        Dwarf dwarf = new Dwarf("AnaoToSemCriatividade");
        Elfo elfo = new Elfo("ElfoToSemCriatividade");
        for (int i = 0; i < 12; i++)
            elfo.atirarFlecha(dwarf);
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void dwarfNasceComInventario(){
        Dwarf dwarf = new Dwarf("Dwarf");
        assertTrue(dwarf.getInventario() instanceof Inventario);
        assertEquals(0, dwarf.getInventario().getItens().size());
    }
    
    @Test
    public void dwarfAdicionaItemNoInventario(){
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
    public void dwarfPerdeItemDoInventario(){
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
}