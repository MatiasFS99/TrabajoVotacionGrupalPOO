/**
 * 
 * Nombre de clase: Candidato
 * 
 * Esta define los atributos
 * 
 * 
 * @version: 28/10/2021/A
 * 
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 * 
 */

public class Candidato extends Persona {
    private Cargo cargo;
    private Domicilio domicilio;

    /**
     * 
     * Constructor
     * 
     * @param nombre         El parámetro nombre define el nombre que va a tener el
     *                       candidato
     * @param apellido       El parámetro nombapellidore define el apellido que va a
     *                       tener el candidato
     * @param dni            El parámetro dni define el dni que va a tener el
     *                       candidato
     * @param FchaNacimiento El parámetro FchaNacimiento define el FchaNacimiento
     *                       que va a tener el candidato
     * @param cargo          El parámetro cargo define el cargo que va a tener el
     *                       candidato
     * @param domicilio      El parámetro domicilio define el domicilio que va a
     *                       tener el candidato
     */

    public Candidato(String nombre, String apellido, int dni, String FchaNacimiento, Cargo cargo, Domicilio domicilio) {
        super(nombre, apellido, dni, FchaNacimiento);
        this.cargo = cargo;
        this.domicilio = domicilio;
    }

    /**
     * 
     * Método que devuelve el domicilio
     * 
     * @return el domicilio
     * 
     */
    public Domicilio getDomicilio() {
        return this.domicilio;
    }

    /**
     * 
     * Método que Define el domicilio
     * 
     * @param domicilio El parámetro domicilio define el domicilio que va a tener el
     *                  candidato
     * 
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * 
     * Método que devuelve el cargo
     * 
     * @return el cargo
     * 
     */
    public Cargo getCargo() {
        return this.cargo;
    }

    /**
     * 
     * Método que Define el cargo
     * 
     * @param cargo El parámetro cargo define el cargo que va a tener el candidato
     * 
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String toString() {
    	return this.getNombre()+" - "+this.getApellido();
    }
}