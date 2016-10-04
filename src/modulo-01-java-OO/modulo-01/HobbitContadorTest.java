import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class HobbitContadorTest {
    @Test
    public void calculaMMC() {
        HobbitContador hobbit =  criaHobbitContador();
        assertEquals(90, hobbit.getMMC(15, 18));
        assertEquals(20, hobbit.getMMC(4, 5));
        assertEquals(60, hobbit.getMMC(12, 60));
    }
    
    @Test
    public void calculaMMCNumerosNegativos() {
        HobbitContador hobbit =  criaHobbitContador();
        assertEquals(90, hobbit.getMMC(-15, -18));
        assertEquals(20, hobbit.getMMC(4, -5));
        assertEquals(60, hobbit.getMMC(-12, 60));
    }
    
    @Test
    public void calculaMMCZeros() {
        HobbitContador hobbit =  criaHobbitContador();
        assertEquals(0, hobbit.getMMC(0, 0));
        assertEquals(0, hobbit.getMMC(0, 15));
        assertEquals(0, hobbit.getMMC(18, 0));
    }
    
    @Test
    public void calculaMDC() {
        HobbitContador hobbit =  criaHobbitContador();
        assertEquals(3, hobbit.getMDC(15, 18));
        assertEquals(1, hobbit.getMDC(4, 5));
        assertEquals(12, hobbit.getMDC(12, 60));
    }
    
    @Test
    public void calculaMDCNumerosNegativos() {
        HobbitContador hobbit =  criaHobbitContador();
        assertEquals(3, hobbit.getMDC(-15, -18));
        assertEquals(1, hobbit.getMDC(4, -5));
        assertEquals(12, hobbit.getMDC(-12, 60));
    }
    
    @Test
    public void calculaMDCZeros() {
        HobbitContador hobbit =  criaHobbitContador();
        assertEquals(0, hobbit.getMDC(0, 0));
        assertEquals(15, hobbit.getMDC(0, 15));
        assertEquals(18, hobbit.getMDC(18, 0));
    }

    @Test
    public void calculaDiferencaArrayDeParesExemploCliente() {
        ArrayList <ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        assertEquals(840,  criaHobbitContador().calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calculaDiferencaArrayVazio() {
        ArrayList <ArrayList<Integer>> arrayDePares = new ArrayList<>();
        assertEquals(0, criaHobbitContador().calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calculaDiferencaArrayDeParesDeNumerosAltos() {
        ArrayList <ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(159, 256)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1784, 28231)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12003, 657)));
        assertEquals(5257314, criaHobbitContador().calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calculaDiferencaArrayDeParesZerados() {
        ArrayList <ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        assertEquals(0, criaHobbitContador().calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calculaDiferencaArrayDeParesNegativos() {
        ArrayList <ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(-20, -5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(-18, 15)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(3, -27)));
        assertEquals(-388, criaHobbitContador().calcularDiferenca(arrayDePares));
    }
    
    @Test 
    public void obterMaiorMultiploDeTresAte10() {
        HobbitContador bolseiro = criaHobbitContador();
        assertEquals(9, bolseiro.obterMaiorMultiploDeTresAte(10));
    }
    
    @Test 
    public void obterMaiorMultiploDeTresAte20() {
        HobbitContador bolseiro = criaHobbitContador();
        assertEquals(18, bolseiro.obterMaiorMultiploDeTresAte(20));
    }
    
    @Test 
    public void obterMaiorMultiploDeTresAte33() {
        HobbitContador bolseiro = criaHobbitContador();
        assertEquals(33, bolseiro.obterMaiorMultiploDeTresAte(33));
    }
    
    @Test 
    public void obterMultiplosDeTresAte10() {
        HobbitContador bolseiro = criaHobbitContador();
        ArrayList<Integer> multiplos = bolseiro.obterMultiplosDeTresAte(10);
        // multiplos é [ 0, 3, 6, 9 ]
        ArrayList<Integer> respostaEsperada = new ArrayList<Integer>();
        respostaEsperada = new ArrayList<>(Arrays.asList(0, 3, 6, 9));
        assertEquals(respostaEsperada, multiplos);
    }
    
    @Test 
    public void obterMultiplosDeTresAte20() {
        HobbitContador bolseiro = criaHobbitContador();
        ArrayList<Integer> multiplos = bolseiro.obterMultiplosDeTresAte(20);
        // multiplos é [ 0, 3, 6, 9, 12, 15, 18]
        ArrayList<Integer> respostaEsperada = new ArrayList<Integer>();
        respostaEsperada = new ArrayList<>(Arrays.asList( 0, 3, 6, 9, 12, 15, 18));
        assertEquals(respostaEsperada, multiplos);
    }
    
    @Test 
    public void obterMultiplosDeTresAte33() {
        HobbitContador bolseiro = criaHobbitContador();
        ArrayList<Integer> multiplos = bolseiro.obterMultiplosDeTresAte(33);
        // multiplos é [ 0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33]
        ArrayList<Integer> respostaEsperada = new ArrayList<Integer>();
        respostaEsperada = new ArrayList<>(Arrays.asList(0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33));
        assertEquals(respostaEsperada, multiplos);
    }
    
    private HobbitContador criaHobbitContador() {
        return new HobbitContador();
    }
}
