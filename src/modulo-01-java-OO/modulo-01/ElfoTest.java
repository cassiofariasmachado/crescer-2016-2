import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest {    
    @After
    // Executa após cada cenário de testes.
    public void tearDown() {
        System.gc();
    }

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
    public void elfoNasceCom100DeVida() {
        assertEquals(100, new Elfo("Legolas").getVida(), 0.);
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
    public void elfoNasceInformandoFlechas(){
        Elfo elfoDoTeste = new Elfo("Legolas", 10);
        assertEquals(10, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNasceComQuantidadeFlechasPadraoInformandoFlechasNegativas(){
        Elfo elfoDoTeste = new Elfo("Legolas", -10);
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNasceComQuantidadedFlechasPadraoInformandoZeroFlechas(){
        Elfo elfoDoTeste = new Elfo("Legolas", 0);
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNasceComStatusVivo(){
        assertEquals(Status.VIVO, new Elfo("Legolas").getStatus());
    }

    @Test
    public void elfoNasceComInventario(){
        Elfo elfo = new Elfo("Dwarf");
        assertTrue(elfo.getInventario() instanceof Inventario);
        assertEquals(2, elfo.getInventario().getItens().size());
    }

    @Test
    public void elfoNasceComArcoEFlechaNoInventario(){
        Elfo elfo = new Elfo("Dwarf");
        assertEquals(2, elfo.getInventario().getItens().size());
        assertEquals("Arco", elfo.getInventario().getItens().get(0).getDescricao());
        assertEquals("Flechas", elfo.getInventario().getItens().get(1).getDescricao());
    }

    @Test
    public void atualizaContadorDeNascimentoDeUmElfo() {
        new Elfo("Dwarf");
        assertEquals(1, Elfo.getContadorElfos());
    }

    @Test
    public void atualizaContadorDeNascimentoDeTresElfos() {
        for (int i = 0; i < 3; i++)
            new Elfo("Dwarf");
        assertEquals(3, Elfo.getContadorElfos());
    }

    @Test
    public void atualizaContadorDeNascimentoDeTresElfosDiversos() {
        new Elfo("");
        new ElfoVerde("");
        new ElfoNoturno("");
        assertEquals(3, Elfo.getContadorElfos());
    }

    @Test
    public void atualizaContadorDeNascimentoDeDezElfos() {
        for (int i = 0; i < 10; i++)
            new Elfo("Dwarf");
        assertEquals(10, Elfo.getContadorElfos());
    }

    @Test
    public void elfoAtiraFlecha() {
        // Act
        Elfo elfoDoTeste = new Elfo("Alleria");
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoAtiraVariasFlechas() {
        // Arrange
        int numeroDeFlechasDisparadas = 10;
        int restante = 42 - numeroDeFlechasDisparadas;
        // Act
        Elfo elfoDoTeste = new Elfo("Sylvanas");
        for (int i = 0; i < numeroDeFlechasDisparadas; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Assert
        assertEquals(restante, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(numeroDeFlechasDisparadas, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoAtiraFlechasDemais(){
        //Act
        Elfo elfoDoTeste = new Elfo("Cassio");
        for (int i = 0; i < 43; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        //Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(42, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoAtiraFlechaEmDwarf(){
        //Act
        Elfo elfoDoTeste = new Elfo("Lordaeron");
        Dwarf dwarfDoTeste = new Dwarf("SemCriatividade");
        elfoDoTeste.atirarFlecha(dwarfDoTeste);
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(100, dwarfDoTeste.getVida(), 0.);
    }

    @Test
    public void elfoAtiraFlechaEmVariosDwarfs(){
        // Arrange
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf [] dwarves = new Dwarf [10];
        for (int i = 0; i < 10; i++)
            dwarves[i] = new Dwarf("SemCriatividade");
        //Act
        for (Dwarf d : dwarves) {
            elfoDoTeste.atirarFlecha(d);
        }
        // Assert
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(10, elfoDoTeste.getExperiencia());
        for (Dwarf d : dwarves) {
            assertEquals(100, d.getVida(), 0.);
        }
    }

    @Test
    public void elfoViraString(){
        // Assert
        Elfo elfoDoTeste = new Elfo("Legolas");
        // Act
        String elfoEmString = elfoDoTeste.toString();
        // Arrange
        assertEquals("Legolas possui 42 flechas e 0 níveis de experiência.", elfoEmString);
    }

    @Test
    public void doisElfosViramString(){
        // Assert
        Elfo elfoDoTeste1 = new Elfo("Legolas");
        Elfo elfoDoTeste2 = new Elfo("Cassio");
        // Act
        String elfoEmString1 = elfoDoTeste1.toString();
        String elfoEmString2 = elfoDoTeste2.toString();
        // Arrange
        assertEquals("Legolas possui 42 flechas e 0 níveis de experiência.", elfoEmString1);
        assertEquals("Cassio possui 42 flechas e 0 níveis de experiência.", elfoEmString2);
    }

    @Test
    public void variosElfosViramString(){
        // Assert
        Elfo [] elfosDoTeste = new Elfo[10];
        // Act
        for (int i = 0; i < 10; i++){
            elfosDoTeste[i] = new Elfo("Elfo" + i);
            String[] elfoEmStringArray = elfosDoTeste[i].toString().split(" ");
            // Arrange
            assertEquals("Elfo" + i, elfoEmStringArray[0]);
            assertEquals("possui", elfoEmStringArray[1]);
            assertEquals("42", elfoEmStringArray[2]);
            assertEquals("flechas", elfoEmStringArray[3]);
            assertEquals("e", elfoEmStringArray[4]);
            assertEquals("0", elfoEmStringArray[5]);
            assertEquals("níveis", elfoEmStringArray[6]);
            assertEquals("de", elfoEmStringArray[7]);
            assertEquals("experiência.", elfoEmStringArray[8]);
        }
    }

    @Test
    public void elfoAtiraFlechaEViraString(){
        // Assert
        Elfo elfoDoTeste = new Elfo("Legolas");
        elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Act
        String elfoEmString = elfoDoTeste.toString();
        // Arrange
        assertEquals("Legolas possui 41 flechas e 1 nível de experiência.", elfoEmString);
    }

    @Test
    public void elfoAtira41FlechasEViraString(){
        // Assert
        Elfo elfoDoTeste = new Elfo("Legolas");
        for (int i = 0; i < 41; i++)
            elfoDoTeste.atirarFlecha(new Dwarf("SemCriatividade"));
        // Act
        String elfoEmString = elfoDoTeste.toString();
        // Arrange
        assertEquals("Legolas possui 1 flecha e 41 níveis de experiência.", elfoEmString);
    }
}


