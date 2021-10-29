import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * Nombre de clase: Persona
 *
 * Esta define las personas
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */


public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate FchaNacimiento; 
    /**
     *
     * Constructor
     *
     * @param nombre El parámetro nombre define el nombre que va a tener la
     * Persona
     * @param apellido El parámetro nombapellidore define el apellido que va a
     * tener la Persona
     * @param dni El parámetro dni define el dni que va a tener la Persona
     * @param FchaNacimiento El parámetro FchaNacimiento define el
     * FchaNacimiento que va a tener la Persona
     *
     */
    public Persona(String nombre, String apellido, int dni, String FchaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        setFchaNacimiento(FchaNacimiento);
    }
    /**
     *
     * Constructor
     *
     * @param nombre El parámetro nombre define el nombre que va a tener la
     * Persona
     * @param apellido El parámetro nombapellidore define el apellido que va a
     * tener la Persona
     * @param dni El parámetro dni define el dni que va a tener la Persona
     * @param FchaNacimiento El parámetro FchaNacimiento define el
     * FchaNacimiento que va a tener la Persona
     *
     */
    public Persona(String nombre, String apellido, int dni, LocalDate FchaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.FchaNacimiento = FchaNacimiento;
    }
    /**
     *
     * Método que devuelve el nombre
     *
     * @return el nombre
     *
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * Método que Define el Nombre de la Persona
     *
     * @param nombre El parámetro nombre define el nombre que va a tener la
     * Persona
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * Método que devuelve el apellido
     * 
     * @return el apellido
     * 
     */
    public String getApellido() {
        return this.apellido;
    }
    /**
     * 
     * Método que Define el apellido de la Persona
     * 
     * @param apellido El parámetro apellido define el apellido que va a tener la Persona
     * 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * 
     * Método que devuelve el dni
     * 
     * @return el dni
     * 
     */
    public int getDni() {
        return this.dni;
    }
    /**
     * 
     * Método que Define el dni de la Persona
     * 
     * @param dni El parámetro dni define el dni que va a tener la Persona
     * 
     */
    public void setDni(int dni) {
        this.dni = dni;
    }
    /**
     * 
     * Método que devuelve la FchaNacimiento
     * 
     * @return la FchaNacimiento
     * 
     */
    public LocalDate getFchaNacimiento() {
        return this.FchaNacimiento;
    }
 /**
     * 
     * Método que Define La fecha de nacimiento de la Persona
     * 
     * @param Fecha El parámetro Fecha define la Fecha de nacimiento que va a tener la Persona
     * 
     */
    public void setFchaNacimiento(String Fecha) {
        String entrada[] = Fecha.split("/");
        int anio = Integer.parseInt(entrada[2]);
        int mes = Integer.parseInt(entrada[1]);
        int dia = Integer.parseInt(entrada[0]);
        this.FchaNacimiento = this.FchaNacimiento.of(anio, mes, dia);
    }

    /**
     *
     * Método que asegura que dos personas no sean iguales
     *
     * @param o El parámetro o es el objeto a comparar
     *
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && dni == persona.dni && Objects.equals(FchaNacimiento, persona.FchaNacimiento);
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre()+
            ", apellido='" + getApellido()+
            ", dni='" + getDni();
    }

}
