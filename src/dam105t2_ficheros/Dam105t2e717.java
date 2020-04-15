
package dam105t2_ficheros;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Dam105t2e717 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        ArrayList <Trabajador_v2> arrayTrabajadores = new ArrayList<>();

        arrayTrabajadores.add(new Asalariado_v2(15, "Alfredo", LocalDate.parse("1945-03-02"), 900));

        arrayTrabajadores.add(new Asalariado_v2(10, "Ramón", LocalDate.parse("1976-12-20"), 3200));

        arrayTrabajadores.add(new ConsultorExterno_v2(24, "Ana", LocalDate.parse("1999-10-13"), 108));

        arrayTrabajadores.add(new ConsultorExterno_v2(19, "Juan", LocalDate.parse("1990-11-19"), 720));

        arrayTrabajadores.add(new ConsultorExterno_v2(04, "Sara", LocalDate.parse("1981-08-24"), 849));
        
        try (
            
            FileOutputStream fos = new FileOutputStream("archivos" + File.separator + "fich17.dat", false);

            // No se pueden añadir objetos a un archivo existente, por lo que
            // habrá que vaciar el contenido previo si lo hubiese

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            ObjectOutputStream oos = new ObjectOutputStream(bos);
        
        ) {

            for (int i = 0; i < arrayTrabajadores.size(); i++) {

                oos.writeObject(arrayTrabajadores.get(i));
                
            }

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}