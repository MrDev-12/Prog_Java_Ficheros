
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;


public class Dam105t2e713 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        boolean eof = false;
        
        try (
            
            FileInputStream fis = new FileInputStream("archivos" + File.separator + "fich12.dat");

            BufferedInputStream bfis = new BufferedInputStream(fis);

            DataInputStream dis = new DataInputStream(bfis);
        
        ) {

            while (eof == false) {

                double temp = dis.readDouble();
                
                String fecha = dis.readUTF();
                
                System.out.println(temp + " -> " + fecha);

            }

        } catch (EOFException e) {

            eof = true;

        } catch (IOException ex) {

            System.err.printf("%nError: %s", ex.getMessage());

        }
        
    }
    
}