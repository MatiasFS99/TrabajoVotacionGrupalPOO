import java.util.List;

/**
 *
 * Nombre de clase: Circuito
 *
 * Esta define los Circuitos que contienen un indicador entero y una lista que
 * almacena la cantidad actual de mesas creadas
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class Circuito {

    private int numero;
    private List<MesaElectoral> mesas;

    /**
     *
     * Constructor
     *
     * @param numero El parámetro numero define el numero que va a tener el
     * Circuito
     * @param mesas El parámetro mesas define la cantidad de mesas tener el
     * Circuito
     *
     */
    public Circuito(int numero, List<MesaElectoral> mesas) {
        this.numero = numero;
        this.mesas = mesas;
    }

    /**
     *
     * Método que devuelve el numero
     *
     * @return el numero
     *
     */

    public int getNumero() {
        return this.numero;
    }

    /**
     *
     * Método que Define el numero de circuito
     *
     * @param numero El parámetro numero define el numero que va a tener el
     * circuito
     *
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * Método que devuelve el mesas
     *
     * @return las mesas
     *
     */
    public List<MesaElectoral> getMesas() {
        return this.mesas;
    }

    /**
     *
     * Método que crea una nueva lista de mesas
     *
     * @param mesas El parámetro mesas define la lista de mesas a asignar
     *
     */
    public void setMesas(List<MesaElectoral> mesas) {
        this.mesas = mesas;
    }

    /**
     *
     * Método que añade a una lista existente
     *
     * @param mesa El parámetro mesa agrega la mesa agrega la mesa a la lista 
     * de mesas del circuito
     *
     */
    public void setMesas(MesaElectoral mesa) {
        this.mesas.add(mesa);
    }

    public String toString() {
        return "Circuito " + this.numero;
    }
}
