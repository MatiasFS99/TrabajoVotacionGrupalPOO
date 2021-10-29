import java.util.List;
import java.util.Objects;

/**
 *
 * Nombre de clase: Lista
 *
 * Esta define las listas con su nombre numero lista de candidatos y partido politico al que pertenece
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class Lista {

    private String nombre;
    private int NroDeLista;
    private List<Candidato> candidatos;
    private PartidoPoliticoAlianza partido;

    /**
     *
     * Constructor
     *
     * @param nombre El parámetro nombre define el nombre que va a tener el
     * Lista
     * @param NroDeLista El parámetro NroDeLista define el NroDeLista que va a
     * tener el Lista
     * @param partido El parámetro partido define el partido al que va a
     * pertenecer que va a tener el Lista
     * @param candidatos El parámetro candidatos define los candidatos que va a
     * tener el Lista
     *
     */
    public Lista(String nombre, int NroDeLista, PartidoPoliticoAlianza partido, List<Candidato> candidatos) {
        this.nombre = nombre;
        this.NroDeLista = NroDeLista;
        this.candidatos = candidatos;
        this.partido = partido;
    }

    /**
     *
     * Método que devuelve el nombre de la lista
     *
     * @return el nombre
     *
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * Método que Define el nombre de la lista
     *
     * @param nombre El parámetro nombre define el nombre que tendra la lista
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Método que devuelve el NroDeLista de la lista
     *
     * @return el NroDeLista
     *
     */
    public int getNroDeLista() {
        return this.NroDeLista;
    }

    /**
     *
     * Método que Define el NroDeLista de la lista
     *
     * @param NroDeLista El parámetro NroDeLista define el NroDeLista que tendra
     * la lista
     *
     */
    public void setNroDeLista(int NroDeLista) {
        this.NroDeLista = NroDeLista;
    }

    /**
     *
     * Método que devuelve la lista de candidatos
     *
     * @return lista de candidatos
     *
     */
    public List<Candidato> getCandidatos() {
        return this.candidatos;
    }

    /**
     *
     * Método que Define la lista de candidatos
     *
     * @param candidatos El parámetro candidatos define los candidatos que
     * tendra la lista
     *
     */
    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    /**
     *
     * Método que Define el candidato
     *
     * @param candidato El parámetro candidato define el candidato que tendra la
     * lista
     *
     */
    public void setCandidatos(Candidato candidato) {
        this.candidatos.add(candidato);
    }

    /**
     *
     * Método que devuelve el partido que representara la lista
     *
     * @return partido que representa
     *
     */
    public PartidoPoliticoAlianza getPartido() {
        return this.partido;
    }

    /**
     *
     * Método que Define el partido que representara la lista
     *
     * @param part El parámetro part define el part que representara la lista
     *
     */
    public void setPartido(PartidoPoliticoAlianza part) {
        this.partido = part;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    /**
     *
     * Método que asegura que dos listas no puedan tener el mismo candidato
     *
     * @param o El parámetro o es el objeto a comparar
     *
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Lista)) {
            return false;
        }
        Lista lista = (Lista) o;
        return Objects.equals(nombre, lista.nombre) && NroDeLista == lista.NroDeLista && Objects.equals(candidatos, lista.candidatos) && Objects.equals(partido, lista.partido);
    }

}
