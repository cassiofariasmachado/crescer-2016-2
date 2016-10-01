import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class HobbitContadorTest {
    @Test
    public void calculaMMC() {
        HobbitContador hobbit = new HobbitContador(); 
        assertEquals(90, hobbit.getMMC(15, 18));
        assertEquals(20, hobbit.getMMC(4, 5));
        assertEquals(60, hobbit.getMMC(12, 60));
    }

    @Test
    public void calculaDiferenca() {
        ArrayList <ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        HobbitContador contador = new HobbitContador();
        assertEquals(840, contador.calcularDiferenca(arrayDePares));
    }
}
