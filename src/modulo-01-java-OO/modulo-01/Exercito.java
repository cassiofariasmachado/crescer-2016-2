import java.util.ArrayList;

public abstract class Exercito {
    protected ArrayList<Object> exercito = new ArrayList<Object>();
    
    abstract void alistar(Object novoSoldado);
    
    abstract Object buscar(String nome);
    
    abstract ArrayList<Object> buscar(Status status);
    
}
