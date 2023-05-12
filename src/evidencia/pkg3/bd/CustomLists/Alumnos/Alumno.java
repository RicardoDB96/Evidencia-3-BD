package evidencia.pkg3.bd.CustomLists.Alumnos;

import evidencia.pkg3.bd.Conexion;
import evidencia.pkg3.bd.HomeFrame;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Ricardo
 */
public class Alumno {

    ObjectId id;
    String nombre, apellidos, carrera, estatus;
    Date birth;
    Conexion conn;
    HomeFrame home;

    public Alumno() {
    }

    public Alumno(ObjectId id, Conexion conn, HomeFrame frm, String nombre, String apellidos, Date birth, String carrera, String estatus) {
        this.id = id;
        this.conn = conn;
        this.home = frm;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.birth = birth;
        this.carrera = carrera;
        this.estatus = estatus;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    public HomeFrame getHome() {
        return home;
    }

    public void setHome(HomeFrame home) {
        this.home = home;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }
    
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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
