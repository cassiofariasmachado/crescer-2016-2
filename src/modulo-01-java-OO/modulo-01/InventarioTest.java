import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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

    @Test
    public void inventarioImprimeDescricoes() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 1));
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 1));
        assertEquals("Adaga,Escudo,Bracelete",inventario.getDescricoesItens());
    }

    @Test
    public void inventarioImprimeMuitasDescricoes() {
        Inventario inventario = new Inventario();
        for (int i = 0; i < 10; i++)
            inventario.adicionarItem(new Item("Adaga", 1));
        assertEquals("Adaga,Adaga,Adaga,Adaga,Adaga,Adaga,Adaga,Adaga,Adaga,Adaga",inventario.getDescricoesItens());
    }

    @Test
    public void inventarioImprimeDescricaoVaziaQuandoListaVazia() {
        Inventario inventario = new Inventario();
        assertEquals("",inventario.getDescricoesItens());
    }

    @Test
    public void retornaItemMaisPopDeInventario() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 1));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 3));
        assertEquals("Bracelete",inventario.retornarItemMaisPopular().getDescricao());
        assertEquals(3,inventario.retornarItemMaisPopular().getQuantidade());
    }

    @Test
    public void retornaItemMaisPopDeInventarioComMuitosItens() {
        Inventario inventario = new Inventario();
        for (int i = 0; i < 10; i++)
            inventario.adicionarItem(new Item("Adaga", 50));
        inventario.adicionarItem(new Item("Escudo", 100000000));
        assertEquals("Escudo",inventario.retornarItemMaisPopular().getDescricao());
        assertEquals(100000000,inventario.retornarItemMaisPopular().getQuantidade());
    }

    @Test
    public void retornaItemMaisPopDeInventarioComUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 50));
        assertEquals("Adaga",inventario.retornarItemMaisPopular().getDescricao());
        assertEquals(50,inventario.retornarItemMaisPopular().getQuantidade());
    }

    @Test
    public void retornaItemMaisPopDuplicadoDeInventario() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 1));
        inventario.adicionarItem(new Item("Escudo", 3));
        inventario.adicionarItem(new Item("Bracelete", 3));
        assertEquals("Escudo",inventario.retornarItemMaisPopular().getDescricao());
        assertEquals(3,inventario.retornarItemMaisPopular().getQuantidade());
    }

    @Test
    public void naoRetornaItemMaisPopPoisInventarioVazio() {
        Inventario inventario = new Inventario();
        assertFalse(new Item("Arco", 1).equals(inventario.retornarItemMaisPopular()));
    }

    @Test
    public void aumentarEm1000TodosItensInventario3Itens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 1));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 3));
        inventario.aumentar1000UnidadesDosItens();
        assertEquals(1001,inventario.getItens().get(0).getQuantidade());
        assertEquals(1002,inventario.getItens().get(1).getQuantidade());
        assertEquals(1003,inventario.getItens().get(2).getQuantidade());
    }

    @Test
    public void aumentarEm1000TodosItensInventarioCom10Itens(){
        Inventario inventario = new Inventario();
        for(int i = 0; i < 10; i++)
            inventario.adicionarItem(new Item("Adaga", 1));
        inventario.aumentar1000UnidadesDosItens();
        for(int i = 0; i < 10; i++)
            assertEquals(1001, inventario.getItens().get(i).getQuantidade());
    }

    @Test
    public void aumentarEm1000TodosItensInventarioVazio(){
        Inventario inventario = new Inventario();
        inventario.aumentar1000UnidadesDosItens();
        assertEquals(0, inventario.getItens().size());
    }

    @Test
    public void aumentaQuantidadeDeCadaItemComQuantidadeIgualATresEm1000VezesOSomatorio() {
        // Arrange and Act
        Inventario inventario = criarInventarioComDezItensComQuantidadeIgualATres();
        inventario.aumentar1000VezesSomaUnidadesDosItens();
        // Assert
        for (Item item : inventario.getItens())
            assertEquals(6003, item.getQuantidade());
    }

    @Test
    public void aumentaQuantidadeDeCadaItemComQuantidadeIgualACincoEm1000VezesOSomatorio() {
        // Arrange and Act
        Inventario inventario = criarInventarioComDezItensComQuantidadeIgualACinco();
        inventario.aumentar1000VezesSomaUnidadesDosItens();
        // Assert
        for (Item item : inventario.getItens())
            assertEquals(15005, item.getQuantidade());
    }

    @Test
    public void aumentaQuantidadeDeCadaItemComQuantidadeIgualAZeroEm1000VezesOSomatorio() {
        // Arrange and Act
        Inventario inventario = criarInventarioComDezItensComQuantidadeIgualAZero();
        inventario.aumentar1000VezesSomaUnidadesDosItens();
        // Assert
        for (Item item : inventario.getItens())
            assertEquals(0, item.getQuantidade());
    }

    @Test
    public void ordenaInventarioComTresItensNaOrdemDescrescentePassandoTipoOrdenacaoAscendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 1));
        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemAscendente(inventario));
    }

    @Test
    public void ordenaInventarioComTresItensNaOrdemCrescentePassandoTipoOrdenacaoAscendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 1));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 3));
        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemAscendente(inventario));
    }

    @Test
    public void ordenaInventarioComTresItensNaOrdemAleatoriaPassandoTipoOrdenacaoAscendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 2));
        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemAscendente(inventario));
    }

    @Test
    public void ordenaInventarioComDezItensNaOrdemDescrescentePassandoTipoOrdenacaoAscendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Bracelete", 10));
        inventario.adicionarItem(new Item("Adaga", 9));
        inventario.adicionarItem(new Item("Escudo", 8));
        inventario.adicionarItem(new Item("Bracelete", 7));
        inventario.adicionarItem(new Item("Adaga", 6));
        inventario.adicionarItem(new Item("Escudo", 5));
        inventario.adicionarItem(new Item("Bracelete", 4));
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 1));
        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemAscendente(inventario));
    }

    @Test
    public void naoOrdenaInventarioComTresItensNaOrdemAleatoriaPassandoTipoOrdenacaoAscendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 2));
        assertFalse(verificaSeInvenatarioEstaOrdemAscendente(inventario));
    }

    @Test
    public void ordenaInventarioComTresItensNaOrdemDescrescentePassandoTipoOrdenacaoDescendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 1));
        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemDescendente(inventario));
    }

    @Test
    public void ordenaInventarioComTresItensNaOrdemCrescentePassandoTipoOrdenacaoDescendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 1));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 3));
        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);
        boolean  d = verificaSeInvenatarioEstaOrdemDescendente(inventario);
        assertTrue(verificaSeInvenatarioEstaOrdemDescendente(inventario));
    }

    @Test
    public void ordenaInventarioComTresItensNaOrdemAleatoriaPassandoTipoOrdenacaoDescendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 2));
        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemDescendente(inventario));
    }

    @Test
    public void ordenaInventarioComDezItensNaOrdemDescrescentePassandoTipoOrdenacaoDescendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Bracelete", 10));
        inventario.adicionarItem(new Item("Adaga", 9));
        inventario.adicionarItem(new Item("Escudo", 8));
        inventario.adicionarItem(new Item("Bracelete", 7));
        inventario.adicionarItem(new Item("Adaga", 6));
        inventario.adicionarItem(new Item("Escudo", 5));
        inventario.adicionarItem(new Item("Bracelete", 4));
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 1));
        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);
        assertTrue(verificaSeInvenatarioEstaOrdemDescendente(inventario));
    }

    @Test
    public void naoOrdenaInventarioComTresItensNaOrdemAleatoriaPassandoTipoOrdenacaoDescendente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 2));
        assertFalse(verificaSeInvenatarioEstaOrdemDescendente(inventario));
    }

    @Test
    public void buscaEEncontraItemEmInventarioComTresItens() {
        Inventario inventario = new Inventario();
        Item adaga = new Item("Adaga", 3);
        inventario.adicionarItem(adaga);
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 2));
        assertTrue(adaga.equals(inventario.buscar("Adaga")));
    }

    @Test
    public void buscaENaoEncontraItemEmInventarioComTresItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 3));
        inventario.adicionarItem(new Item("Escudo", 1));
        inventario.adicionarItem(new Item("Bracelete", 2));
        assertTrue(inventario.buscar("Pistola") == null);
    }

    @Test
    public void buscaENaoEncontraItemEmInventarioVazio() {
        Inventario inventario = new Inventario();
        assertTrue(inventario.buscar("Pistola") == null);
    }

    @Test
    public void retornaMediaDaQuantidadeDosItensDoCliente() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 3));
        inventario.adicionarItem(new Item("Poção HP", 4));
        inventario.adicionarItem(new Item("Lança", 2));
        int mediaQtds = inventario.getMediaQuantidades();
        // mediaQtds => 3
        assertEquals(3, mediaQtds);
    }
    
    @Test
    public void retornaMediaDaQuantidadeDosItensDeInventarioQualquer() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 6));
        inventario.adicionarItem(new Item("Poção HP", 0));
        inventario.adicionarItem(new Item("Lança", 12));
        int mediaQtds = inventario.getMediaQuantidades();
        // mediaQtds => 6
        assertEquals(6, mediaQtds);
    }
    
    @Test
    public void retornaMediaDaQuantidadeDosItensInventarioDeItensComZeroDeQuantidade() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 0));
        inventario.adicionarItem(new Item("Poção HP", 0));
        inventario.adicionarItem(new Item("Lança", 0));
        int mediaQtds = inventario.getMediaQuantidades();
        // mediaQtds => 0
        assertEquals(0, mediaQtds);
    }
    
    @Test
    public void retornaMediaDaQuantidadeDosItensInventarioVazio() {
        Inventario inventario = new Inventario();
        int mediaQtds = inventario.getMediaQuantidades();
        // mediaQtds => 0
        assertEquals(0, mediaQtds);
    }

    private boolean verificaSeInvenatarioEstaOrdemAscendente(Inventario inventario) {
        ArrayList<Item> itens = inventario.getItens();
        int quantidadeItemAnterior = itens.get(0).getQuantidade();
        for (Item itemAtual : itens) {
            int quantidadeItemAtual = itemAtual.getQuantidade();
            if (quantidadeItemAtual < quantidadeItemAnterior)
                return false;
            quantidadeItemAnterior = quantidadeItemAtual;
        }
        return true;
    }

    private boolean verificaSeInvenatarioEstaOrdemDescendente(Inventario inventario) {
        ArrayList<Item> itens = inventario.getItens();
        int quantidadeItemAnterior = itens.get(0).getQuantidade();
        for (Item itemAtual : itens) {
            int quantidadeItemAtual = itemAtual.getQuantidade();
            if (quantidadeItemAtual > quantidadeItemAnterior)
                return false;
            quantidadeItemAnterior = quantidadeItemAtual;
        }
        return true;
    }

    private Inventario criarInventarioComDezItensComQuantidadeIgualATres(){
        Inventario inventario = new Inventario();
        for (int i = 0; i < 10; i++)
            inventario.adicionarItem(new Item("Diamantes da Lucy", 3));
        return inventario;
    }

    private Inventario criarInventarioComDezItensComQuantidadeIgualACinco(){
        Inventario inventario = new Inventario();
        for (int i = 0; i < 10; i++)
            inventario.adicionarItem(new Item("Diamantes da Lucy", 5));
        return inventario;
    }

    private Inventario criarInventarioComDezItensComQuantidadeIgualAZero(){
        Inventario inventario = new Inventario();
        for (int i = 0; i < 10; i++)
            inventario.adicionarItem(new Item("Diamantes da Lucy", 0));
        return inventario;
    }
}
