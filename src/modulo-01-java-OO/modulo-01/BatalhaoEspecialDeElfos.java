import java.util.*;

public class BatalhaoEspecialDeElfos implements Exercito {
    private HashMap<String, ArrayList<Elfo>> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoPorStatus = new HashMap<>();

    public Elfo[] getExercito(){
        ArrayList<Elfo> resultado = new ArrayList<>(); 
        for (ArrayList<Elfo> listas : exercito.values()) { 
            resultado.addAll(listas); 
        } 
        return resultado.toArray(new Elfo[resultado.size()]); 
    }

    public void alistar(Elfo elfo) throws NaoPodeAlistarException {
        if (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno) {
            ArrayList<Elfo> elfosComEsteNome = exercito.get(elfo.getNome()); 
            boolean aindaNaoTemElfoComEsteNome = elfosComEsteNome == null; 
            if (aindaNaoTemElfoComEsteNome) { 
                elfosComEsteNome = new ArrayList<>(); 
                exercito.put(elfo.getNome(), elfosComEsteNome); 
            } 
            elfosComEsteNome.add(elfo); 
        }
        else 
            throw new NaoPodeAlistarException();
    }

    public Elfo buscar(String nome){
        return this.exercito.containsKey(nome) ? this.exercito.get(nome).get(0) : null;
    }
    
    public ArrayList<Elfo> buscar(Status status) { 
        agruparPorStatus(); 
        return this.exercitoPorStatus.get(status); 
    }
    
    private void agruparPorStatus() { 
        this.exercitoPorStatus.clear(); 
        for (Map.Entry<String, ArrayList<Elfo>> par : this.exercito.entrySet()) { 
            for (Elfo elfo : par.getValue()) { 
                Status status = elfo.getStatus(); 
                ArrayList<Elfo> elfosDoStatus = this.exercitoPorStatus.get(status); 
                boolean aindaNaoAgrupeiPorEsteStatus = elfosDoStatus == null; 
                if (aindaNaoAgrupeiPorEsteStatus) { 
                    elfosDoStatus = new ArrayList<>(); 
                    this.exercitoPorStatus.put(status, elfosDoStatus); 
                } 
                elfosDoStatus.add(elfo); 
            } 
        } 
    } 
    
    public void atacar() {
        System.out.println("Batalhão especial lacrando"); 
    }
}
