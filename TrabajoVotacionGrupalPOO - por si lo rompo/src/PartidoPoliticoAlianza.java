import java.util.List;

public class PartidoPoliticoAlianza {
    private String nombre;
    private List<PartidoPoliticoAlianza> lista = null;

    public PartidoPoliticoAlianza(String nombre, List<PartidoPoliticoAlianza> lista) {
        this.nombre = nombre;
        this.lista = lista;
    }
    
    public List<PartidoPoliticoAlianza> getLista(){
        return this.lista;
    }

    public void setLista(List<PartidoPoliticoAlianza> lista){
        this.lista = lista;
    }

    public void setLista(PartidoPoliticoAlianza partido){
        this.lista.add(partido);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}