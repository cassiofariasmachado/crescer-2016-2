public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        if (this.status == Status.VIVO && this.getFlecha().getQuantidade() > 0) {
            super.atirarFlecha(dwarf);
            this.vida *= 0.95; // Elfo noturno perde 5% vida
            this.status = (int)this.vida == 0 ? status.MORTO : status.VIVO; // Se vida igual a zero, elfo morre
        }
    }
    
    public void ganharExperiencia() {
        this.experiencia += 3;
    }
    
    /*
     * 5.2: Atualmente (antes do patch 5.3), elfos noturnos não podiam morrer, pois
     * este comportamento ainda não tinha sido definido, a única verificação de morte era feita 
     * com o dwarf que recebia a flechada.
     */
}
