public class Domicilio {
    private String Direccion;
    private String Localidad;
    private String Departamento;

    public Domicilio(String Direccion, String Localidad, String Departamento) {
        this.Direccion = Direccion;
        this.Localidad = Localidad;
        this.Departamento = Departamento;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getLocalidad() {
        return this.Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public String getDepartamento() {
        return this.Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

}
