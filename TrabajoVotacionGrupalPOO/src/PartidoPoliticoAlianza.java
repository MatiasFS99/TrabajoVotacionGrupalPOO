import java.util.List;

/**
 *
 * Nombre de clase: PartidoPoliticoAlianza
 *
 * Esta define los partidos politicos o alianzas
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class PartidoPoliticoAlianza {

    private String nombre;
    private List<PartidoPoliticoAlianza> lista = null;

    /**
     *
     * Constructor
     *
     * @param nombre El parámetro nombre define el nombre que va a tener el
     * partido o alianza
     *
     * @param lista El parámetro lista define las listas que va a tener el
     * Partido
     *
     */
    public PartidoPoliticoAlianza(String nombre, List<PartidoPoliticoAlianza> lista) {
        this.nombre = nombre;
        this.lista = lista;
    }

    /**
     *
     * Método que devuelve las listas del partido o alianza
     *
     * @return listas que forman parte del partido o alianza
     *
     */
    public List<PartidoPoliticoAlianza> getLista() {
        return this.lista;
    }

    /**
     *
     * Método que crea una nueva lista de partido o alianza
     *
     * @param lista El parámetro lista define la lista de partidos o alianzas a
     * asignar
     *
     */
    public void setLista(List<PartidoPoliticoAlianza> lista) {
        this.lista = lista;
    }

    /**
     *
     * Método que añade a una lista existente
     *
     * @param partido El parámetro partido agrega el partido a la lista de
     * partidos o alianzas
     *
     */
    public void setLista(PartidoPoliticoAlianza partido) {
        this.lista.add(partido);
    }

    /**
     *
     * Método que devuelve el nombre del partido o alianza
     *
     * @return nombre del partido o alianza
     *
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * Método que define el nombre de un partido politico o alianza
     *
     * @param nombre El parámetro nombre define el nombre del partido politico o
     * alianza
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
