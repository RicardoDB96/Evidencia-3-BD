package evidencia.pkg3.bd.CustomLists.Alumnos;

/**
 *
 * @author Ricardo
 */
public class Alumno {

    String nombre, carrera, estatus;

    public String getNombre() {
        return nombre;
    }
    
    public Alumno() {
    }

    public Alumno(String nombre, String carrera, String estatus) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.estatus = estatus;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
