import java.util.List;
import java.util.Objects;

public class Lista {
    private String nombre;
    private int NroDeLista;
    private List<Candidato> candidatos;
    private PartidoPoliticoAlianza partido;

    public Lista(String nombre, int NroDeLista,PartidoPoliticoAlianza partido, List<Candidato> candidatos) {
        this.nombre = nombre;
        this.NroDeLista = NroDeLista;
        this.candidatos = candidatos;
        this.partido = partido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroDeLista() {
        return this.NroDeLista;
    }

    public void setNroDeLista(int NroDeLista) {
        this.NroDeLista = NroDeLista;
    }

    public List<Candidato> getCandidatos(){
        return this.candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos){
        this.candidatos = candidatos;
    }

    public void setCandidatos(Candidato candidato){
        this.candidatos.add(candidato);
    }

    public PartidoPoliticoAlianza getPartido(){
        return this.partido;
    }

    public void setPartido(PartidoPoliticoAlianza part){
        this.partido = part;
    }


    @Override
    public String toString() {
        return getNombre();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lista)) {
            return false;
        }
        Lista lista = (Lista) o;
        return Objects.equals(nombre, lista.nombre) && NroDeLista == lista.NroDeLista && Objects.equals(candidatos, lista.candidatos) && Objects.equals(partido, lista.partido);
    }

}
