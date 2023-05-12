package evidencia.pkg3.bd;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoSecurityException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;
import evidencia.pkg3.bd.CustomLists.Alumnos.Alumno;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Ricardo
 */
public class Conexion {

    MongoClient client = null;

    // Función para logearse en la base de datos, dando error si no es correcto
    public boolean loginToDB(String username, String password, JLabel error) {
        // Manejador de errores de datos invalidos
        try {
            // Dirreción de MongoDB con el usuario y contraseña ingresado
            String uri = "mongodb://" + username + ":" + password + "@localhost:27017/?authMechanism=SCRAM-SHA-1&authSource=Universidad";

            client = MongoClients.create(uri);

            // Prueba de correcta autentificación
            client.getDatabase("Universidad").createCollection("Alumnos");

            // Usuario y contraseña validos
            error.setVisible(false);
            return true;
        } catch (MongoSecurityException e) { // Datos de inicio de sesión invalidos
            System.out.println("Datos invalidos");
            error.setText("Usuario o contraseña invalido");
        } catch (IllegalArgumentException e) { // No se ingreso valores en algun campo
            System.out.println("Ingrese un usuario y contraseña");
            error.setText("Ingrese un usuario/contraseña");
        } catch (MongoCommandException e) { // Usuario y contraseña validos
            System.out.println("La colección ya existe");
            error.setVisible(false);
            return true;
        }

        // No se puedo ingresar con un usuario valido
        error.setVisible(true);
        return false;
    }

    // Ingresar un documento a la colección Alumnos
    public boolean addStudentData(Document student, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> students = client.getDatabase("Universidad").getCollection("Alumnos");

        // Intento de ingreso del documento con lo datos ingresados
        try {
            students.insertOne(student);
            return true;// Fue exitoso el Insert
        } catch (MongoWriteException e) {
            if (e.getCode() == 11000) {// Error de duplicación, en este caso no deberia de ocurrir
                error.setVisible(true);
                System.out.println("El alumno ya existe");
            } else {// Error general al ingresar datos
                System.out.println(e);
            }
        } catch (MongoException e) {// Error de MongoDB
            System.out.println(e);
        }
        return false;// Ocurrio un error en el Insert
    }

    // Recuperar la información de un Alumno
    public ObjectId getIdStudentData(Alumno student) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> status = client.getDatabase("Universidad").getCollection("Alumnos");

        // Obtener datos del alumno de la clase
        String nombre = student.getNombre();
        String apellidos = student.getApellidos();
        Date birth = student.getBirth();
        ObjectId career = getIdCareerData(student.getCarrera());
        ObjectId estatus = getIdStatusData(student.getEstatus());

        // Documento para realizar el filtro
        Document filtro = new Document();

        // Ingresamos los datos del filtro
        filtro.append("nombre", nombre);
        filtro.append("apellidos", apellidos);
        filtro.append("fechaNacimiento", birth);
        filtro.append("carrera", career);
        filtro.append("estatus", estatus);

        ObjectId id;

        // Creación del cursos para recorrer las Carrera
        try (MongoCursor<Document> cursor = status.find(filtro).projection(Projections.include("_id", "nombre", "apellidos", "carrera", "fechaNacimiento", "estatus")).limit(1).iterator()) {
            id = null;
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                id = documento.getObjectId("_id");
                System.out.println("AlumnoID: " + id);
            } else {
                System.out.println("Id de alumno no encontrado");
            }
            cursor.close();
        }
        return id;
    }

    // Recuperar la información de un Alumno
    public Document getStudentData(ObjectId id) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> status = client.getDatabase("Universidad").getCollection("Alumnos");

        // Buscamos el alumno segun el id que tenemos
        Document filtro = new Document("_id", id);

        // Documento del alumno
        Document alumno = new Document();

        // Creación del cursos para recorrer las Carrera
        try (MongoCursor<Document> cursor = status.find(filtro).projection(
                Projections.include("_id", "nombre", "apellidos", "carrera",
                        "fechaNacimiento", "estatus", "email", "telefono", "direccion"))
                .limit(1).iterator()) {
            
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                alumno = documento;
                System.out.println("Alumno: " + alumno);
            } else {
                System.out.println("Alumno no encontrado");
            }
            cursor.close();
        }
        return alumno;
    }

    // Leer la informacion de la coleccion Alumnos
    public ArrayList<Document> getAllStudentData() {
        // Referencia de la base de datos y de la coleccion Alumnos
        MongoCollection<Document> students = client.getDatabase("Universidad").getCollection("Alumnos");

        // Guardar datos de Alumnos en una ArrayList
        ArrayList alumnos = students.find().projection(Projections.include("id", "nombre", "apellidos", "fechaNacimiento", "carrera", "estatus")).into(new ArrayList<>());

        return alumnos;
    }

    // Ingresar un documento a la colección Carrera
    public boolean addCareerData(Document career, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> careers = client.getDatabase("Universidad").getCollection("Carrera");

        // Ingreso del documento con lo datos ingresados
        try {
            careers.insertOne(career);
            return true;// Fue exitoso el Insert
        } catch (MongoWriteException e) {// Error de duplicación de carrera
            if (e.getCode() == 11000) {
                error.setVisible(true);
                System.out.println("La carrera ya existe");
            } else {// Error general al ingresar datos
                System.out.println(e);
            }
        } catch (MongoException e) {// Error de MongoDB
            System.out.println(e);
        }
        return false;// Ocurrio un error en el Insert
    }

    // Recuperar el _id de una Carrera
    public ObjectId getIdCareerData(String carrera) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> career = client.getDatabase("Universidad").getCollection("Carrera");

        // Buscamos el id segun la carrera que tenemos
        Document filtro = new Document("carrera", carrera);

        ObjectId idCarrera;
        // Creación del cursos para recorrer las Carreras
        try (MongoCursor<Document> cursor = career.find(filtro).projection(Projections.include("_id", "carrera")).limit(1).iterator()) {

            idCarrera = null;
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                idCarrera = documento.getObjectId("_id");
                System.out.println("ID de carrera: " + idCarrera);
            } else {
                System.out.println("ID de carrera no encontrado");
            }
            cursor.close();
        }
        // Retornamos el valor de _id, -1 si fue erroneo
        // Retornamos el ID correspondiente si fue exitoso
        return idCarrera;
    }

    // Recuperar la información de la colección Carrera
    public String getCareerData(ObjectId id) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> status = client.getDatabase("Universidad").getCollection("Carrera");

        // Id que buscamos
        Document filtro = new Document("_id", id);

        String carrera;
        // Creación del cursos para recorrer las Carrera
        try (MongoCursor<Document> cursor = status.find(filtro).projection(Projections.include("_id", "carrera", "descripcion", "departamento")).limit(1).iterator()) {

            carrera = "";
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                carrera = documento.getString("carrera");
                System.out.println("Carrera: " + carrera);
            } else {
                System.out.println("Carrera no encontrado");
            }
            cursor.close();
        }
        return carrera;
    }

    // Recuperar la informacion de las carreras
    public ArrayList<Document> getAllCareerData() {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> careers = client.getDatabase("Universidad").getCollection("Carrera");

        // Guardar datos de id y carrera en una ArrayList
        ArrayList carreras = careers.find().projection(Projections.include("id", "carrera", "descripcion", "departamento")).into(new ArrayList<>());

        return carreras;
    }

    // Ingresar un documento a la colección Departamento
    public boolean addDeptData(Document dept, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> depts = client.getDatabase("Universidad").getCollection("Departamento");

        // Ingreso del documento con lo datos ingresados
        try {
            depts.insertOne(dept);
            return true;
        } catch (MongoWriteException e) {
            if (e.getCode() == 11000) {
                error.setVisible(true);
                System.out.println("El departamento ya existe");
            } else {
                System.out.println(e);
            }
        } catch (MongoException e) {
            System.out.println(e);
        }
        return false;
    }

    // Recuperar la información de la colección Departamento
    public String getDeptData(ObjectId id) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> depts = client.getDatabase("Universidad").getCollection("Departamento");

        // Id que buscamos
        Document filtro = new Document("_id", id);

        String dept;
        // Creación del cursos para recorrer las Carrera
        try (MongoCursor<Document> cursor = depts.find(filtro).projection(Projections.include("_id", "departamento")).limit(1).iterator()) {

            dept = "";
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                dept = documento.getString("departamento");
                System.out.println("Departamento: " + dept);
            } else {
                System.out.println("Departamento no encontrado");
            }
            cursor.close();
        }
        return dept;
    }

    // Recuperar el _id de un Departamento
    public ObjectId getDeptData(String dept) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> depts = client.getDatabase("Universidad").getCollection("Departamento");

        Document filtro = new Document("departamento", dept);

        ObjectId idDepartamento;
        // Creación del cursos para recorrer los departamentos
        try (MongoCursor<Document> cursor = depts.find(filtro).projection(Projections.include("_id", "departamento")).limit(1).iterator()) {

            idDepartamento = null;
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                idDepartamento = documento.getObjectId("_id");
                System.out.println("ID del departamento: " + idDepartamento);
            } else {
                System.out.println("Departamento no encontrado");
            }
            cursor.close();
        }
        return idDepartamento;
    }

    // Recuperar la información de la colección Departamento
    public ArrayList<Document> getAllDeptData() {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> depts = client.getDatabase("Universidad").getCollection("Departamento");

        // Guardar datos de id y departamento en una ArrayList
        ArrayList departamentos = depts.find().projection(Projections.include("_id", "departamento")).into(new ArrayList<>());

        return departamentos;
    }

    // Ingresar un documento a la colección Estatus
    public boolean addStatusData(Document status, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> estatus = client.getDatabase("Universidad").getCollection("Estatus");

        // Ingreso del documento con lo datos ingresados
        try {
            estatus.insertOne(status);
            return true;
        } catch (MongoWriteException e) {
            if (e.getCode() == 11000) {
                error.setVisible(true);
                System.out.println("El estatus ya existe");
            } else {
                System.out.println(e);
            }
        } catch (MongoException e) {
            System.out.println(e);
        }
        return false;
    }

    // Recuperar el _id de un Estatus
    public ObjectId getIdStatusData(String estatus) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> status = client.getDatabase("Universidad").getCollection("Estatus");

        Document filtro = new Document("estatus", estatus);

        ObjectId idStatus;
        // Creación del cursos para recorrer los Estatus
        try (MongoCursor<Document> cursor = status.find(filtro).projection(Projections.include("_id", "estatus")).limit(1).iterator()) {

            idStatus = null;
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                idStatus = documento.getObjectId("_id");
                System.out.println("ID del estatus: " + idStatus);
            } else {
                System.out.println("Estatus no encontrado");
            }
            cursor.close();
        }
        // Retornamos el valor de _id, -1 si fue erroneo
        // Retornamos el ID correspondiente si fue exitoso
        return idStatus;
    }

    // Recuperar la información de la colección Carrera
    public String getStatusData(ObjectId id) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> status = client.getDatabase("Universidad").getCollection("Estatus");

        Document filtro = new Document("_id", id);

        String estatus;
        // Creación del cursos para recorrer las Carrera
        try (MongoCursor<Document> cursor = status.find(filtro).projection(Projections.include("_id", "estatus")).limit(1).iterator()) {

            estatus = "";
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                estatus = documento.getString("estatus");
                System.out.println("Estatus: " + estatus);
            } else {
                System.out.println("Estatus no encontrado");
            }
            cursor.close();
        }
        return estatus;
    }

    // Recuperar la información de la colección Estatus
    public ArrayList<Document> getAllStatusData() {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> status = client.getDatabase("Universidad").getCollection("Estatus");

        // Guardar datos de id y estatus en una ArrayList
        ArrayList estatus = status.find().projection(Projections.include("_id", "estatus")).into(new ArrayList<>());

        return estatus;
    }

    // Ingresar un documento a la colección Carrera
    public boolean deleteStudentData(String student, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> carrera = client.getDatabase("Universidad").getCollection("Carrera");

        // Crear el filtro para el documento a borrar
        Bson filtro = Filters.eq("carrera", student);

        try {
            DeleteResult result = carrera.deleteOne(filtro);

            if (result.getDeletedCount() == 1) {
                System.out.println("Se borro exitosamente la carrera: " + student);
                return true;
            } else {
                error.setText("No se encontro ninguna carrera con ese nombre");
                error.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;// Ocurrio un error en el Insert
    }

    // Ingresar un documento a la colección Carrera
    public boolean deleteCareerData(String career, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> carrera = client.getDatabase("Universidad").getCollection("Carrera");

        // Crear el filtro para el documento a borrar
        Bson filtro = Filters.eq("carrera", career);

        try {
            DeleteResult result = carrera.deleteOne(filtro);

            if (result.getDeletedCount() == 1) {
                System.out.println("Se borro exitosamente la carrera: " + career);
                return true;
            } else {
                error.setText("No se encontro ninguna carrera con ese nombre");
                error.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;// Ocurrio un error en el Insert
    }

    // Ingresar un documento a la colección Carrera
    public boolean deleteDeptData(String dept, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> depts = client.getDatabase("Universidad").getCollection("Departamento");

        // Crear el filtro para el documento a borrar
        Bson filtro = Filters.eq("departamento", dept);

        try {
            DeleteResult result = depts.deleteOne(filtro);

            if (result.getDeletedCount() == 1) {
                System.out.println("Se borro exitosamente el departamento: " + dept);
                return true;
            } else {
                error.setText("No se encontro ningún departamento con ese nombre");
                error.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;// Ocurrio un error en el Insert
    }

    // Ingresar un documento a la colección Carrera
    public boolean deleteStatusData(String status, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> estatus = client.getDatabase("Universidad").getCollection("Estatus");

        // Crear el filtro para el documento a borrar
        Bson filtro = Filters.eq("estatus", status);

        try {
            DeleteResult result = estatus.deleteOne(filtro);

            if (result.getDeletedCount() == 1) {
                System.out.println("Se borro exitosamente el estatus: " + status);
                return true;
            } else {
                error.setText("No se encontro ningún estado con ese nombre");
                error.setVisible(true);
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }

        return false;// Ocurrio un error en el Insert
    }
}
