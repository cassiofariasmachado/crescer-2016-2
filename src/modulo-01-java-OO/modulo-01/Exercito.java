import java.util.ArrayList; 
 
public interface Exercito { 
    Elfo[] getExercito(); 
    void alistar(Elfo elfo); 
    Elfo buscar(String nome); 
    ArrayList<Elfo> buscar(Status status); 
    void atacar(); 
}