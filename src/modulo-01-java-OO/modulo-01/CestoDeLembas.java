public class CestoDeLembas{
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
     
    public boolean podeDividirEmPares(){
        if (lembas % 2 == 0 && lembas > 2)
            return true;
        return false;
    }
}