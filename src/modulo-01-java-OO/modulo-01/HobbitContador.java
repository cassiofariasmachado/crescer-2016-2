import java.util.ArrayList;

public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        int diferenca = 0;
        for (ArrayList<Integer> parAtual : arrayDePares) {
            diferenca += this.getProdutoPar(parAtual) - this.getMMCPar(parAtual); 
        }
        return diferenca;
    }

    public int getProdutoPar(ArrayList<Integer> par) {
        return par.get(0) * par.get(1);
    }

    public int getMMCPar(ArrayList<Integer> par) {
        return this.getMMC(par.get(0),par.get(1));
    }

    public int getMMC(int x, int y) {
        // lcm (x, y) = |x . y| / gcd(x, y)
        if (x == 0 || y == 0)
            return 0;
        // Garantindo que são positivos (módulo)
        x = Math.abs (x);
        y = Math.abs (y);
        return x * y / this.getMDC(x, y);
    }

    public int getMDC(int x, int y) {
        // Algoritmo de euclides: 
        // gcd (x, 0) == x  
        // gcd (x, y) = gcd (y, x mod y)
        if (y == 0)
            return x;
        // Garante retorno positivo segundo propriedade: mdc(-x,y) = mdc (x,-y) = mdc (-x,-y) = mdc(x,y)
        return Math.abs(this.getMDC(y, x % y));
    }

    /* Exercício 1: Bolsomito
     * Primeiro erro: variável limite não declarada nem inicializada, poderia ser o próprio parâmetro;
     * Segundo erro: continue é desnecessário
     * Terceiro erro: seria mais performático se começasse pelo final do ArrayList, ai se substituiria o continue pelo break.
     *
     * public int obterMaiorMultiploDeTresAte(int numero) {
     *   int maior = numero;
     *   for (int i = numero; i >= 0 ; i--) {
     *       if (i % 3 == 0) {
     *           maior = i;
     *           break;
     *       }
     *   }
     *   return maior;
     * }
     * 
     *obterMaiorMultiploDeTresAte refatorado
     */
    public int obterMaiorMultiploDeTresAte(int n) {
        return n / 3 * 3;
    }

    /*
     * Exercício 2: Continua mitando
     * Primeiro erro: o ArrayList múltiplos era uma matriz;
     * Segundo erro: a condição está errada para não adicionar o número e nesse caso o break(sai realmente do laço) deveria ser um continue(volta a condição);
     * Terceiro erro: variável limite não declarada nem inicializada, poderia ser substituida pelo próprio parâmetro;
     * Quarto erro: variável i começa em 1, mas 0 é um multiplo de 3 segundo especificação do cliente;
     */
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
        ArrayList<Integer> multiplos = new ArrayList<>();
        for (int i = 0; i <= numero; i++) {
            if (i % 3 != 0) 
                continue;
            multiplos.add(i);
        }
        return multiplos;
    }
}

