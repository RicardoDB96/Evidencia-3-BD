package evidencia.pkg3.bd;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoSecurityException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import java.util.ArrayList;
import javax.swing.JLabel;
import org.bson.Document;

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
            String uri = "mongodb://"+ username + ":" + password + "@localhost:27017/?authMechanism=SCRAM-SHA-1&authSource=Universidad";
            
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
    
    public void getAllStudentData() {
        // Referencia de la base de datos
        MongoCollection<Document> students = client.getDatabase("Universidad").getCollection("Alumnos");
        students.find().forEach(student -> System.out.println(student.toJson()));
    }
    
    // Ingresar un documento a la colección Carrera
    public boolean addCareerData(Document career, JLabel error) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> careers = client.getDatabase("Universidad").getCollection("Carrera");
        
        // Ingreso del documento con lo datos ingresados
        try {
            careers.insertOne(career);
            return true;
        } catch (MongoWriteException e) {
            if (e.getCode() == 11000) {
                error.setVisible(true);
                System.out.println("La carrera ya existe");
            } else {
                System.out.println(e);
            }
        } catch (MongoException e) {
            System.out.println(e);
        }
        return false;
    }
    
    // Recuperar la información de la colección Carrera
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
    
    // Recuperar el _id de un Departamento
    public int getDeptData(String dept) {
        // Referencia de la base de datos y de la colección
        MongoCollection<Document> depts = client.getDatabase("Universidad").getCollection("Departamento");
        
        Document filtro = new Document("departamento", dept);
        
        int idDepartamento;
        // Creación del cursos para recorrer los departamentos
        try (MongoCursor<Document> cursor = depts.find(filtro).projection(Projections.include("_id", "departamento")).limit(1).iterator()) {
            
            idDepartamento = -1;
            if (cursor.hasNext()) {
                Document documento = cursor.next();
                idDepartamento = documento.getInteger("_id");
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
}
