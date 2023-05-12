package evidencia.pkg3.bd.CustomLists.Alumnos;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Ricardo
 */
public class Alumno {

    ObjectId id;
    String nombre, apellidos, carrera, estatus, email, phone, address;
    Date birth;

    public Alumno() {
    }

    public Alumno(ObjectId id, String nombre, String apellidos, Date birth, String carrera, String estatus, String email, String phone, String address) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.birth = birth;
        this.carrera = carrera;
        this.estatus = estatus;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
