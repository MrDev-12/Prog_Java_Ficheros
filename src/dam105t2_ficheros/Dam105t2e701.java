
package dam105t2_ficheros;

import java.io.*;


public class Dam105t2e701 {

    public static void main(String[] args) {

        BufferedWriter bfw = null;
        
        try {

            File f = new File("archivos\\fich01.txt");

            FileWriter fw = new FileWriter(f);

            bfw = new BufferedWriter(fw);
            
            bfw.write("Mi país es España");
            bfw.newLine();

            bfw.write("Ártico Polar Norte");
            bfw.newLine();

            bfw.write("Ñú como Animal");

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }

        finally {

            try{
                
                if (bfw != null) { bfw.close(); }
            
            } catch(IOException e) {

                System.err.printf("Error: %s", e.getMessage());
            
            }

        }
        
    }
    
}