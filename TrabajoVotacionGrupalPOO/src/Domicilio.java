
/**
 *
 * Nombre de clase: Domicilio
 *
 * Esta define los domicilios de personas candidatos y electores inscriptos
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */
public class Domicilio {

    private String Direccion;
    private String Localidad;
    private String Departamento;

    /**
     *
     * Constructor
     *
     * @param Domicilio El parámetro Direccion define la Direccion que va a
     * tener el Circuito
     *
     * @param Localidad El parámetro Localidad define la Localidad que va a
     * tener el Domicilio
     *
     * * @param Departamento El parámetro Departamento define la Departamento
     * que va a tener el Domicilio
     *
     */
    public Domicilio(String Direccion, String Localidad, String Departamento) {
        this.Direccion = Direccion;
        this.Localidad = Localidad;
        this.Departamento = Departamento;
    }

    /**
     *
     * Método que devuelve el Direccion
     *
     * @return el Direccion
     *
     */
    public String getDireccion() {
        return this.Direccion;
    }

    /**
     *
     * Método que Define la Direccion de Domicilio
     *
     * @param Direccion El parámetro Direccion define el Direccion que va a
     * tener el Domicilio
     *
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     *
     * Método que devuelve el Localidad
     *
     * @return el Localidad
     *
     */
    public String getLocalidad() {
        return this.Localidad;
    }

    /**
     *
     * Método que Define la Localidad de Domicilio
     *
     * @param Localidad El parámetro Localidad define el Localidad que va a
     * tener el Domicilio
     *
     */
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    /**
     *
     * Método que devuelve el Departamento
     *
     * @return el Departamento
     *
     */
    public String getDepartamento() {
        return this.Departamento;
    }

    /**
     *
     * Método que Define el Departamento de Domicilio
     *
     * @param Departamento El parámetro Departamento define el Departamento que
     * va a tener el Domicilio
     *
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

}
