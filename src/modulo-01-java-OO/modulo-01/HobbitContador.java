import java.util.ArrayList;

public class HobbitContador {
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        int diferenca = 0;
        for (ArrayList<Integer> parAtual : arrayDePares)
            diferenca += getProdutoPar(parAtual) - getMMCPar(parAtual); 
        return diferenca;
    }
    
    public int getProdutoPar(ArrayList<Integer> par) {
        return par.get(0) * par.get(1);
    }
    
    public int getMMCPar(ArrayList<Integer> par) {
        return this.getMMC(par.get(0),par.get(1));
    }
    
    public int getMMC(int x, int y) {
        return x * y / this.getMDC(x, y);
    }
    
    public int getMDC(int x, int y) {
        if (y == 0)
            return x;
        return this.getMDC(y, x % y);
    }
}

