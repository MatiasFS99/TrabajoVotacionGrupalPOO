import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

/**
 *
 * Nombre de clase: ElectorInscripto
 *
 * Esta define los electores inscriptos que son aquellos que pueden votar, donde votan
 * que mesas, donde viven, si votaron
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class ElectorInscripto extends Persona {

    private Domicilio Domicilio;
    private String LugarVotacion;
    private MesaElectoral mesaAsignada = null;
    private Boolean voto = false;

    /**
     *
     * Constructor
     *
     * @param nombre El parámetro nombre define el nombre que va a tener el
     * ElectorInscripto
     * @param apellido El parámetro nombapellidore define el apellido que va a
     * tener el ElectorInscripto
     * @param dni El parámetro dni define el dni que va a tener el
     * ElectorInscripto
     * @param FchaNacimiento Fecha de nacimiento de manera (dd/MM/yyyy)
     * @param domicilio El parámetro domicilio define el domicilio que va a
     * tener el ElectorInscripto
     * @param lugarVotacion El parámetro lugarVotacion define el lugarVotacion
     * que va a tener que ir a votar el ElectorInscripto
     *
     */
    public ElectorInscripto(String nombre, String apellido, int dni, String FchaNacimiento, Domicilio domicilio, String lugarVotacion) {
        super(nombre, apellido, dni, FchaNacimiento);
        this.Domicilio = domicilio;
        this.LugarVotacion = lugarVotacion;
    }

    /**
     *
     * Constructor
     *
     * @param persona El parámetro persona hereda de persona nombre,
     * apellido,dni, fchanacimiento
     *
     * @param domicilio El parámetro domicilio define el domicilio que va a
     * tener el ElectorInscripto
     * @param lugarVotacion El parámetro lugarVotacion define el lugarVotacion
     * que va a tener que ir a votar el ElectorInscripto
     *
     */
    public ElectorInscripto(Persona persona, Domicilio domicilio, String lugarVotacion) {
        super(persona.getNombre(), persona.getApellido(), persona.getDni(), persona.getFchaNacimiento());
        this.Domicilio = domicilio;
        this.LugarVotacion = lugarVotacion;
    }

    /**
     *
     * Método que devuelve la Mesa asignada para la votacion del elector
     *
     * @return la mesa para votar
     *
     */
    public MesaElectoral getMesaAsignda() {
        return this.mesaAsignada;
    }

    /**
     *
     * Método que Define la Mesa en la que debera votar
     *
     * @param mesa El parámetro mesa define la mesa que debera ir a votar el
     * Elector
     *
     */
    public void setMesaAsignada(MesaElectoral mesa) {
        this.mesaAsignada = mesa;
    }

    /**
     *
     * Método que devuelve el domicilio del elector
     *
     * @return el domicilio del elector
     *
     */
    public Domicilio getDomicilio() {
        return this.Domicilio;
    }

    /**
     *
     * Método que Define el Domicilio del elector
     *
     * @param Domicilio El Domicilio mesa define la Domicilio del Elector
     *
     */
    public void setDomicilio(Domicilio Domicilio) {
        this.Domicilio = Domicilio;
    }

    /**
     *
     * Método que devuelve el LugarVotacion del elector
     *
     * @return el LugarVotacion del elector
     *
     */
    public String getLugarVotacion() {
        return this.LugarVotacion;
    }

    /**
     *
     * Método que Define el LugarVotacion del elector
     *
     * @param LugarVotacion El LugarVotacion define el LugarVotacion del Elector
     *
     */
    public void setLugarVotacion(String LugarVotacion) {
        this.LugarVotacion = LugarVotacion;
    }

    /**
     *
     * Método que devuelve si voto o no del elector
     *
     * @return true/false "Voto/NoVoto"
     *
     */
    public Boolean getVoto() {
        return this.voto;
    }

    /**
     *
     * Método que devuelve la edad del elector
     *
     * @return la edad del elector
     *
     */
    public long getEdad() {
        LocalDate FActual = LocalDate.now(ZoneId.of("America/Buenos_Aires"));
        long years = java.time.temporal.ChronoUnit.YEARS.between(this.getFchaNacimiento(), FActual);
        return years;
    }

    /**
     *
     * Método que Define el voto del elector para que no pueda votar dos veces
     *
     */
    public void setVoto() {
        this.voto = true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ElectorInscripto)) {
            return false;
        }
        ElectorInscripto electorInscripto = (ElectorInscripto) o;
        return Objects.equals(Domicilio, electorInscripto.Domicilio) && Objects.equals(LugarVotacion, electorInscripto.LugarVotacion);
    }

    /**
     *
     * Método evita que el elector pueda votar mas de una vez
     *
     */
    public boolean equals(int dni) {
        return (this.getDni() == dni);
    }

    public String toString() {
        return this.getNombre() + "-" + this.getApellido() + "-" + this.getDni();
    }

}
