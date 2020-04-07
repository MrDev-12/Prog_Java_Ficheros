
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;


public class Dam105t2e704 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        File f = new File("archivos" + File.separator + "fich04.txt");

        String txt;
        
        try (
            
            FileWriter fw = new FileWriter(f);
            
            BufferedWriter bfw = new BufferedWriter(fw);
        
        ) {

            do {
                
                System.out.print("Introduce un texto: ");
                txt = teclado.nextLine();

                bfw.write(txt);
                bfw.newLine();

            } while (!txt.equals("fin"));

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}