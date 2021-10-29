import java.util.List;

public class Seccion {
    private String nombrePartido;
    private String nombreProvincia;
    private int comunaBSAS = 0;
    private boolean provincia;
    private List<Circuito> circuitos;

    public Seccion(String nombrePartido, String nombreProvincia, List<Circuito> circuitos) {
        this.nombrePartido = nombrePartido;
        this.nombreProvincia = nombreProvincia;
        this.circuitos = circuitos;
        this.provincia = true;
    }

    public Seccion(String nombrePartido, int comunaBSAS, List<Circuito> circuitos) {
        this.nombrePartido = nombrePartido;
        this.comunaBSAS = comunaBSAS;
        this.circuitos = circuitos;
        this.provincia = false;
    }

    public String getNombrePartido() {
        return this.nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    public String getNombreProvincia() {
        return this.nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public List<Circuito> getCircuitos(){
        return this.circuitos;
    }

    public void setCircuitos(List<Circuito> circuitos){
        this.circuitos = circuitos;
    }

    public void setCircuitos(Circuito circuito){
        this.circuitos.add(circuito);
    }

    public int getComunaBSAS() {
        return this.comunaBSAS;
    }

    public void setComunaBSAS(int comunaBSAS) {
        this.comunaBSAS = comunaBSAS;
    }
    
    public boolean esProvincia(){
        return this.provincia;
    }

    public String toString(){
        return this.nombrePartido;
    }
}