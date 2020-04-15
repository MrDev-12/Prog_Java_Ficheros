
package dam105t2_ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Dam105t2e718 {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        ArrayList <Trabajador_v2> arrayTrabajadores = new ArrayList<>();

        File f = new File("archivos" + File.separator + "fich17.dat");

        boolean eof = false;

        try (
            
            FileInputStream fis = new FileInputStream(f);

            BufferedInputStream bufis = new BufferedInputStream(fis);

            ObjectInputStream ois = new ObjectInputStream(bufis);
        
        ) {

            while(eof == false) { // otra opcion sería: while (bufis.available() > 0)

                arrayTrabajadores.add((Trabajador_v2)ois.readObject());
            
            }

        } catch (EOFException e) {

            eof = true;

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }

        for (int i = 0; i < arrayTrabajadores.size(); i++) {
            
            System.out.println(arrayTrabajadores.get(i).toString());

        }
        
    }
    
}