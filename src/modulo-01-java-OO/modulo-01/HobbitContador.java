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
}

