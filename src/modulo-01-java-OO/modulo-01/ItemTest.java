import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    @Test
    public void testaCriacaoDeItens(){
        // Arrange and Act
        Item item = criaUmItemComUmaUnidade();
        // Assert
        assertEquals("Cantil", item.getDescricao());
        assertEquals(1, item.getQuantidade());
    }

    @Test
    public void somatorioAteQuantidadeDoItemComQuantidadeIgualAUm() {
        assertEquals(1, criaUmItemComUmaUnidade().getSomatorioAteQuantidade());
    }

    @Test
    public void somatorioAteQuantidadeDoItemComQuantidadeIgualATres() {
        assertEquals(6, criaUmItemComTresUnidades().getSomatorioAteQuantidade());
    }

    @Test
    public void somatorioAteQuantidadeDoItemComQuantidadeIgualACinco() {
        assertEquals(15, criaUmItemComCincoUnidades().getSomatorioAteQuantidade());
    }

    @Test
    public void somatorioAteQuantidadeDoItemComQuantidadeIgualATresNegativo() {
        assertEquals(6, criaUmItemComTresUnidadesNegativas().getSomatorioAteQuantidade());
    }

    @Test
    public void somatorioAteQuantidadeDoItemComQuantidadeIgualACincoNegativo() {
        assertEquals(15, criaUmItemComCincoUnidadesNegativas().getSomatorioAteQuantidade());
    }

    @Test
    public void aumentaEm1000UnidadesQuantidadeItem(){
        // Arrange and Act
        Item item = criaUmItemComUmaUnidade();
        item.aumentar1000Unidades();
        // Assert
        assertEquals("Cantil", item.getDescricao());
        assertEquals(1001, item.getQuantidade());
    }

    @Test
    public void aumentaEm1000UnidadesQuantidadeDeDoisItens(){
        // Arrange and Act
        Item item1 = criaUmItemComUmaUnidade();
        Item item2 = criaUmItemComUmaUnidade();
        item1.aumentar1000Unidades();
        item2.aumentar1000Unidades();
        // Assert
        assertEquals("Cantil", item1.getDescricao());
        assertEquals(1001, item1.getQuantidade());
        assertEquals("Cantil", item2.getDescricao());
        assertEquals(1001, item2.getQuantidade());
    }

    @Test
    public void aumentaEm1000UnidadesAQuantidadeDeUmItemPossuindoDois(){
        // Arrange and Act
        Item item1 = criaUmItemComUmaUnidade();
        Item item2 = criaUmItemComUmaUnidade();
        item1.aumentar1000Unidades();
        // Assert
        assertEquals("Cantil", item1.getDescricao());
        assertEquals(1001, item1.getQuantidade());
        assertEquals("Cantil", item2.getDescricao());
        assertEquals(1, item2.getQuantidade());
    }

    @Test
    public void aumentaQuantidadeDoItemComQuantidadeIgualATresEm1000VezesOSomatorio(){
        // Arrange and Act
        Item item = criaUmItemComTresUnidades();
        item.aumentar1000VezesSomaUnidadeDoItem();
        // Assert
        assertEquals(6003, item.getQuantidade());
    }

    @Test
    public void aumentaQuantidadeDoItemComQuantidadeIgualACincoEm1000VezesOSomatorio(){
        // Arrange and Act
        Item item = criaUmItemComCincoUnidades();
        item.aumentar1000VezesSomaUnidadeDoItem();
        // Assert
        assertEquals(15005, item.getQuantidade());
    }

    @Test
    public void aumentaQuantidadeDoItemComQuantidadeIgualAMenosTresEm1000VezesOSomatorio(){ //troca negativo
        // Arrange and Act
        Item item = criaUmItemComTresUnidadesNegativas();
        item.aumentar1000VezesSomaUnidadeDoItem();
        // Assert
        assertEquals(5997, item.getQuantidade());
    }

    @Test
    public void aumentaQuantidadeDoItemComQuantidadeIgualAMenosCincoEm1000VezesOSomatorio(){ //troca negativo
        // Arrange and Act
        Item item = criaUmItemComCincoUnidadesNegativas();
        item.aumentar1000VezesSomaUnidadeDoItem();
        // Assert
        assertEquals(14995, item.getQuantidade());
    }

    @Test
    public void igualdadeDeItens() {
        assertEquals(new Item("Espada Z", 1), new Item("Espada Z", 1));
    }

    private Item criaUmItemComUmaUnidade() {
        return new Item("Cantil", 1);
    }

    private Item criaUmItemComTresUnidades() {
        return new Item("Garrafa de vinho", 3);
    }

    private Item criaUmItemComCincoUnidades() {
        return new Item("Cerveja bem gelada", 5);
    }

    private Item criaUmItemComTresUnidadesNegativas() {
        return new Item("Garrafa de vinho vazia", -3);
    }

    private Item criaUmItemComCincoUnidadesNegativas() {
        return new Item("Cerveja bem gelada vazia", -5);
    }
}
