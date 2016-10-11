import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaLittleMumuTest {
    
    @Test
    public void ordenaAtaqueComQuantidadeDeVerdesENoturnosIguais() throws ExercitoDesproporcionalException{
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                                              new ElfoVerde("Elfo verde"), 
                                              new ElfoVerde("Elfo verde"), 
                                              new ElfoNoturno("Elfo noturno") );
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(3, atacantesEmOrdem.size());
    }
    
    public void ordenaAtaqueApenasElfoVerdes() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoVerde("Elfo verde"), 
                                              new ElfoVerde("Elfo verde"),
                                              new ElfoVerde("Elfo verde"),
                                              new ElfoVerde("Elfo verde"));
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(3) instanceof ElfoVerde);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(4, atacantesEmOrdem.size());
    }
    
    public void ordenaAtaqueApenasElfoNoturnos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                                              new ElfoNoturno("Elfo noturno"),
                                              new ElfoNoturno("Elfo noturno"),
                                              new ElfoNoturno("Elfo noturno"));
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(1, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueComDoisElfoNoturnosMortos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                                              new ElfoVerde("Elfo verde"), 
                                              new ElfoVerde("Elfo verde"),
                                              this.criaElfoNoturnoEMataEle(),
                                              new ElfoNoturno("Elfo noturno"),
                                              this.criaElfoNoturnoEMataEle());
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(3, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueComDoisElfoVerdesSemFlechas() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                                              this.criaElfoVerdeSemFlechas(),
                                              new ElfoVerde("Elfo verde"),
                                              new ElfoNoturno("Elfo noturno"),
                                              new ElfoVerde("Elfo verde"),
                                              this.criaElfoVerdeSemFlechas());
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(3, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueComDoisElfoVerdesSemFlechasEDoisElfosNoturnosMortos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno"), 
                                              this.criaElfoVerdeSemFlechas(), 
                                              this.criaElfoNoturnoEMataEle(),
                                              new ElfoVerde("Elfo verde"),
                                              this.criaElfoNoturnoEMataEle(),
                                              new ElfoNoturno("Elfo noturno"),
                                              new ElfoVerde("Elfo verde"),
                                              this.criaElfoVerdeSemFlechas());
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoNoturno);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertEquals(3, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueQueNaoTemElfos() throws ExercitoDesproporcionalException {
        List<Elfo> atacantes = Arrays.asList();
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.isEmpty());
    }
    
    @Test
    public void ordenaAtaqueElfosComQuantidadeDeFlechasDiferentes() throws ExercitoDesproporcionalException{
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno", 10), 
                                              new ElfoVerde("Elfo verde", 5), 
                                              new ElfoVerde("Elfo verde", 3), 
                                              new ElfoNoturno("Elfo noturno", 4) );
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoVerde);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertTrue(this.verificaOrdemDeElfosComMaisFlechas(atacantesEmOrdem));
        assertEquals(3, atacantesEmOrdem.size());
    }
    
    @Test
    public void ordenaAtaqueElfosComQuantidadeDeFlechasOrdenadasNaOrdemCrescente() throws ExercitoDesproporcionalException{
        List<Elfo> atacantes = Arrays.asList( new ElfoNoturno("Elfo noturno", 2), 
                                              new ElfoVerde("Elfo verde", 10), 
                                              new ElfoVerde("Elfo verde", 13), 
                                              new ElfoNoturno("Elfo noturno", 22) );
        List<Elfo> atacantesEmOrdem = new EstrategiaLittleMumu().getOrdemDeAtaque(atacantes);
        assertTrue(atacantesEmOrdem.get(0) instanceof ElfoNoturno);
        assertTrue(atacantesEmOrdem.get(1) instanceof ElfoVerde);
        assertTrue(atacantesEmOrdem.get(2) instanceof ElfoVerde);
        assertTrue(this.verificaSeTodosElfosEstaoVivos(atacantesEmOrdem));
        assertTrue(this.verificaOrdemDeElfosComMaisFlechas(atacantesEmOrdem));
        assertEquals(3, atacantesEmOrdem.size());
    }
    
    private boolean verificaSeTodosElfosEstaoVivos(List<Elfo> elfos) {
        for (Elfo elfo : elfos) {
            if (elfo.getStatus().equals(Status.MORTO))
                return false;
        }
        return true;
    }
    
    private boolean verificaOrdemDeElfosComMaisFlechas(List<Elfo> elfos) {
        int quantidadeDeFlechasAnterior = 0;
        for (int i = elfos.size() - 1; i >= 0; i--) {
            int quantidadeDeFlechasAtual = elfos.get(i).getFlecha().getQuantidade();
            if (quantidadeDeFlechasAnterior > quantidadeDeFlechasAtual)
                return false;
            quantidadeDeFlechasAnterior = quantidadeDeFlechasAtual;
        }
        return true;
    }

    private ElfoNoturno criaElfoNoturnoEMataEle() {
        ElfoNoturno elfo = new ElfoNoturno("Elfo Noturno", 90);
        for (int i = 0; i < 90; i++) 
            elfo.atirarFlecha(new Dwarf(""));
        return elfo;
    }
    
    private ElfoNoturno criaElfoVerdeSemFlechas() {
        ElfoNoturno elfo = new ElfoNoturno("Elfo Noturno", 1);
        elfo.atirarFlecha(new Dwarf(""));
        return elfo;
    }
}
