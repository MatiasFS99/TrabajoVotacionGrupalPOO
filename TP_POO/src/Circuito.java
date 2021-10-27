import java.util.List;

public class Circuito {
    private int numero;
    private List<MesaElectoral> mesas;

    public Circuito(int numero, List<MesaElectoral> mesas) {
        this.numero = numero;
        this.mesas = mesas;
    }


    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<MesaElectoral> getMesas() {
        return this.mesas;
    }

    public void setMesas(List<MesaElectoral> mesas) {
        this.mesas = mesas;
    }

    public void setMesas(MesaElectoral mesa){
        this.mesas.add(mesa);
    }
    public String toString(){
        return "Circuito "+this.numero;
    }
}
