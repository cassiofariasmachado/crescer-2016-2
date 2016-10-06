import java.util.*;

public class BatalhaoEspecialDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<>();

    public Elfo[] getExercito(){
        return this.exercito.values().toArray(new Elfo[exercito.size()]);
    }
    
    public void alistar(Elfo elfo){
        if (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            this.exercito.put(elfo.getNome(), elfo);
    }

    public Elfo buscar(String nome){
        return this.exercito.get(nome);
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> retorno = new ArrayList<Elfo>();
        for (Elfo elfo : this.exercito.values())
            if(elfo.getStatus().equals(status))
                 retorno.add(elfo);
        return retorno;
    }
}
