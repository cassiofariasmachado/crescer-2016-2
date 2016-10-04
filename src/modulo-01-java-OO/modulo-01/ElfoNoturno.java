public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        boolean temFlecha = this.getFlecha() != null && this.getFlecha().getQuantidade() > 0;
        if (temFlecha) {
            super.atirarFlecha(dwarf);
            this.vida -= this.vida*0.05; //elfo noturno 5% perde vida
            this.status = this.vida <= 0.9 ? status.MORTO : status.VIVO; // elfo noturno morre
        }
    }
    
    public void ganharExperiencia() {
        this.experiencia += 3;
    }
    
    /*
     * 5.2: Atualmente (antes do patch 5.3, hehe), elfos noturnos não podem morrer, pois
     * este comportamento ainda não foi definido, a única verificação de morte era feita 
     * com o dwarf que recebia a flechada.
     */
}
