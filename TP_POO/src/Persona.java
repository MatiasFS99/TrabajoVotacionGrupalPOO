import java.time.LocalDate;
import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate FchaNacimiento; 

    public Persona(String nombre, String apellido, int dni, String FchaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        setFchaNacimiento(FchaNacimiento);
    }

    public Persona(String nombre, String apellido, int dni, LocalDate FchaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.FchaNacimiento = FchaNacimiento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFchaNacimiento() {
        return this.FchaNacimiento;
    }

    public void setFchaNacimiento(String Fecha) {
        String entrada[] = Fecha.split("/");
        int anio = Integer.parseInt(entrada[2]);
        int mes = Integer.parseInt(entrada[1]);
        int dia = Integer.parseInt(entrada[0]);
        this.FchaNacimiento = this.FchaNacimiento.of(anio, mes, dia);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && dni == persona.dni && Objects.equals(FchaNacimiento, persona.FchaNacimiento);
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre()+
            ", apellido='" + getApellido()+
            ", dni='" + getDni();
    }

}
