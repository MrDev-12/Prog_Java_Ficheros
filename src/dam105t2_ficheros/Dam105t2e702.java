
package dam105t2_ficheros;

import java.io.*;


public class Dam105t2e702 {

    public static void main(String[] args) {

        File f = new File("archivos" + File.separator + "fich02.txt");
        
        try (
            
            FileWriter fw = new FileWriter(f);
            
            BufferedWriter bfw = new BufferedWriter(fw);
        
        ) {

            bfw.write("Mi país es España");
            bfw.newLine();

            bfw.write("Ártico Polar Norte");
            bfw.newLine();

            bfw.write("Ñú como Animal");

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}