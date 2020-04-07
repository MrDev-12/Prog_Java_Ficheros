
package dam105t2_ficheros;

import java.io.*;


public class Dam105t2e703 {

    public static void main(String[] args) {

        File f = new File("archivos" + File.separator + "fich03.txt");
        
        try (
            
            FileOutputStream fos =new FileOutputStream(f, true);

            OutputStreamWriter osw = new OutputStreamWriter(fos,"ISO-8859-1");
            
            BufferedWriter bfw = new BufferedWriter(osw);
        
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