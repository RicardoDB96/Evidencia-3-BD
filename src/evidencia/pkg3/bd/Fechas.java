package evidencia.pkg3.bd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Fechas {
    
    // Metodo para formatear correctamente las fechas
    // En serio odio formatear fechas
    public LocalDate formatLocalDate(String fecha) {
        // Define el formato de la cadena de texto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Analiza la cadena y obtén un objeto LocalDate
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        return localDate;
    }
}
