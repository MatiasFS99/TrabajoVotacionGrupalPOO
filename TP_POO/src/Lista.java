import java.util.List;

public class Lista {
    private String nombre;
    private int NroDeLista;
    private List<Candidato> candidatos;

    public Lista(String nombre, int NroDeLista, List<Candidato> candidatos) {
        this.nombre = nombre;
        this.NroDeLista = NroDeLista;
        this.candidatos = candidatos;
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
}
