public class Candidato extends Persona {
    private Cargo cargo;
    private Domicilio domicilio;

    public Candidato(String nombre, String apellido, int dni, String FchaNacimiento,Cargo cargo, Domicilio domicilio) {
        super(nombre, apellido, dni, FchaNacimiento);
        this.cargo = cargo;
        this.domicilio = domicilio;
    }
    
    public Domicilio getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    public String toString() {
    	return this.getNombre()+" - "+this.getApellido();
    }
    
}
