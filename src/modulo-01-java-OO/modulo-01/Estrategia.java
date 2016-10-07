import java.util.List;

public interface Estrategia {
    
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos);
    
}
