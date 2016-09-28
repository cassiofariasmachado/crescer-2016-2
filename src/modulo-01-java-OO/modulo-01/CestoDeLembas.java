public class CestoDeLembas{
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
     
    public boolean podeDividirEmPares(int quantidade){
        if (quantidade % 2 == 0 && quantidade > 2)
            return true;
        return false;
    }
}