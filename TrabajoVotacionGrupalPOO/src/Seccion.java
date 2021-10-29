import java.util.List;

/**
 *
 * Nombre de clase: Seccion
 *
 * Esta define las secciones que son abarcadas por distritos
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class Seccion {
    private String nombrePartido;
    private String nombreProvincia;
    private int comunaBSAS = 0;
    private boolean provincia;
    private List<Circuito> circuitos;
    /**
     *
     * Constructor
     *
     * @param nombrePartido El par�metro nombrePartido define el nombrePartido
     * que va a petenecer la seccion
     * @param nombreProvincia El par�metro nombreProvincia define el
     * nombreProvincia a la que va a pertenecer la Seccion

     * @param circuitos El par�metro circuitos define los circuitos que va a
     * tener la Seccion
     */
    public Seccion(String nombrePartido, String nombreProvincia, List<Circuito> circuitos) {
        this.nombrePartido = nombrePartido;
        this.nombreProvincia = nombreProvincia;
        this.circuitos = circuitos;
        this.provincia = true;
    }
    /**
     *
     * Constructor
     * @param nombrePartido El par�metro nombrePartido define el nombrePartido
     * que va a petenecer la seccion
     * @param comunaBSAS El par�metro comunaBSAS define la
     * comunaBSAS a la que va a pertenecer la Seccion
     * @param circuitos El par�metro circuitos define los circuitos que va a
     * tener la Seccion
     */
    public Seccion(String nombrePartido, int comunaBSAS, List<Circuito> circuitos) {
        this.nombrePartido = nombrePartido;
        this.comunaBSAS = comunaBSAS;
        this.circuitos = circuitos;
        this.provincia = false;
    }
    /**
     *
     * M�todo que devuelve el nombre del Partido
     *
     * @return el nombre del Partido
     *
     */
    public String getNombrePartido() {
        return this.nombrePartido;
    }

    /**
     *
     * M�todo que Define el Nombre del Partido que pertenece la seccion
     *
     * @param nombrePartido El par�metro nombrePartido define el nombrePartido
     * que va a pertenecer la seccion
     *
     */
    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }
        /**
     *
     * M�todo que devuelve el nombre del nombreProvincia
     *
     * @return el nombre del nombreProvincia
     *
     */
    public String getNombreProvincia() {
        return this.nombreProvincia;
    }
        /**
     *
     * M�todo que Define el Nombre de la  Provincia que pertenece la seccion
     *
     * @param nombreProvincia El par�metro nombreProvincia define el nombre de la Provincia
     * que va a pertenecer la seccion
     *
     */
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }
            /**
     *
     * M�todo que devuelve el nombre de los circuitos que pertenecen a la seccion
     *
     * @return los circuitos pertenecientes a la seccion
     *
     */
    public List<Circuito> getCircuitos(){
        return this.circuitos;
    }
    /**
     *
     * M�todo que crea una nueva lista de circuitos pertenecientes a la seccion
     *
     * @param circuitos El par�metro circuitos define la lista de circuitos a
     * asignar que pertenecen a la seccion
     *
     */
    public void setCircuitos(List<Circuito> circuitos){
        this.circuitos = circuitos;
    }
        /**
     *
     * M�todo que a�ade a una lista de circuito existente
     *
     * @param circuito El par�metro circuito agrega el circuito a la lista de
     * circuitos existente
     *
     */
    public void setCircuitos(Circuito circuito){
        this.circuitos.add(circuito);
    }

    /**
     *
     * M�todo que devuelve el numero de comunaBSAS al que pertenece a la seccion
     *
     * @return el numero entero "codigo" de la comunaBSAS que pertenece la
     * seccion
     *
     */
    public int getComunaBSAS() {
        return this.comunaBSAS;
    }

    /**
     *
     * M�todo define el codigo entero de la comunaBSAS a la que pertenece la
     * seccion
     *
     * @param comunaBSAS El par�metro comunaBSAS define el valor entero que
     * identifica la comunaBSAS a la que pertenece la seccion
     *
     */
    public void setComunaBSAS(int comunaBSAS) {
        this.comunaBSAS = comunaBSAS;
    }
        /**

     * funcion para saber si es una seccion de una provincia o comuna de caba

     * @return verdaero si es seccion de provincia, falso es una comuna
     */
    public boolean esProvincia(){
        return this.provincia;
    }

    public String toString(){
        return this.nombrePartido;
    }
}