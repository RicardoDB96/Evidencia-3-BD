package evidencia.pkg3.bd.CustomLists.Carreras;

/**
 *
 * @author Ricardo
 */
public class Carrera {

    String carrera, descripcion, departamento;
    
    public Carrera() {
    }

    public Carrera(String carrera, String descripcion, String departamento) {
        this.carrera = carrera;
        this.descripcion = descripcion;
        this.departamento = departamento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
