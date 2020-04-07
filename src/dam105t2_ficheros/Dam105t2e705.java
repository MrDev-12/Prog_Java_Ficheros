
package dam105t2_ficheros;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;



public class Dam105t2e705 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        File f = new File("archivos" + File.separator + "fich04.txt");

        if (f.exists() == true) {

            File fbak = new File("archivos" + File.separator + "fich04.bak");
            
            try {

                Files.copy(f.toPath(), fbak.toPath());

            } catch (IOException ex) {

                System.err.printf("Error: %s", ex.getMessage());

            }

        }

        else {

            try {

                f.createNewFile();

            } catch (IOException ex) {

                System.err.printf("Error: %s", ex.getMessage());

            }

        }

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