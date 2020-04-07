
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;


public class Dam105t2e706 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        File f = new File("archivos" + File.separator + "fich04.txt");

        String cadena;
        
        try (
            
            FileReader fr = new FileReader(f);
            
            BufferedReader bfr = new BufferedReader(fr);
        
        ) {

            while((cadena = bfr.readLine()) != null) {

                System.out.printf("%s\n", cadena.toUpperCase());

            }

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}