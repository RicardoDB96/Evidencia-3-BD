package evidencia.pkg3.bd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Fechas {
    
    // Metodo para formatear correctamente las fechas
    // En serio odio formatear fechas
    public Date formatDate(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date date = null;
        try {
            date = dateFormat.parse(fecha);
            System.out.println("Parsed Date: " + date);
        } catch (ParseException e) {
            System.out.println("Failed to parse the date string.");
        }
        return date;
    }
}
