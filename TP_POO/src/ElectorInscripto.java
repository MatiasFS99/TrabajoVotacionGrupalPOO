import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public class ElectorInscripto {
    private Persona persona;
    private Domicilio Domicilio;
    private String LugarVotacion;
    private MesaElectoral mesaAsignada = null;
    private Boolean voto = false;

    public ElectorInscripto(Persona persona, Domicilio domicilio, String lugarVotacion) {
        this.persona = persona;
        this.Domicilio = domicilio;
        this.LugarVotacion = lugarVotacion;
    }

    public MesaElectoral getMesaAsignda(){
        return this.mesaAsignada;
    }

    public void setMesaAsignada(MesaElectoral mesa){
        this.mesaAsignada = mesa;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        long years = java.time.temporal.ChronoUnit.YEARS.between(this.persona.getFchaNacimiento(),FActual);
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
        return Objects.equals(persona, electorInscripto.persona) && Objects.equals(Domicilio, electorInscripto.Domicilio) && Objects.equals(LugarVotacion, electorInscripto.LugarVotacion);
    }

    public boolean equals(int dni){
        return (this.persona.getDni()==dni);
    }

    public String toString(){
        return this.persona.getNombre()+"-"+this.persona.getApellido()+"-"+this.persona.getDni();
    }

}
