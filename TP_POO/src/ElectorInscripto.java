import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public class ElectorInscripto extends Persona {
    private Domicilio Domicilio;
    private String LugarVotacion;
    private MesaElectoral mesaAsignada = null;
    private Boolean voto = false;

    public ElectorInscripto(String nombre, String apellido, int dni, String FchaNacimiento, Domicilio domicilio, String lugarVotacion) {
        super(nombre, apellido, dni, FchaNacimiento);
        this.Domicilio = domicilio;
        this.LugarVotacion = lugarVotacion;
    }

    public ElectorInscripto(Persona persona, Domicilio domicilio, String lugarVotacion) {
        super(persona.getNombre(), persona.getApellido(), persona.getDni(), persona.getFchaNacimiento());
        this.Domicilio = domicilio;
        this.LugarVotacion = lugarVotacion;
    }

    public MesaElectoral getMesaAsignda(){
        return this.mesaAsignada;
    }

    public void setMesaAsignada(MesaElectoral mesa){
        this.mesaAsignada = mesa;
    }

    public Domicilio getDomicilio() {
        return this.Domicilio;
    }

    public void setDomicilio(Domicilio Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getLugarVotacion() {
        return this.LugarVotacion;
    }

    public void setLugarVotacion(String LugarVotacion) {
        this.LugarVotacion = LugarVotacion;
    }

    public Boolean getVoto(){
        return this.voto;
    }

    public long getEdad(){
        LocalDate FActual = LocalDate.now(ZoneId.of("America/Buenos_Aires"));
        long years = java.time.temporal.ChronoUnit.YEARS.between(this.getFchaNacimiento(),FActual);
        return years;
    }

    public void setVoto(){
        this.voto = true;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ElectorInscripto)) {
            return false;
        }
        ElectorInscripto electorInscripto = (ElectorInscripto) o;
        return Objects.equals(Domicilio, electorInscripto.Domicilio) && Objects.equals(LugarVotacion, electorInscripto.LugarVotacion);
    }

    public boolean equals(int dni){
        return (this.getDni()==dni);
    }

    public String toString(){
        return this.getNombre()+"-"+this.getApellido()+"-"+this.getDni();
    }

}
