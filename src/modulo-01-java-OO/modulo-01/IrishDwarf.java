public class IrishDwarf extends Dwarf {

    public IrishDwarf (String nome) {
        this(nome, new DataTerceiraEra(1, 1, 1));
    }

    public IrishDwarf (String nome, DataTerceiraEra data) {
        super(nome, data);
    }
    
    public void tentarSorte() {
        double numeroSorte = this.getNumeroSorte();
        if (numeroSorte == -3333.) {
            this.inventario.aumentar1000VezesSomaUnidadesDosItens();
        }
    }
}
