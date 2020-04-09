
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;


public class Dam105t2e707 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        System.out.print("Introduce la ruta del fichero: ");
        String ruta = teclado.nextLine();

        Integer [] array = infoFichero(ruta);

        if(array != null) {

            System.out.println("--- Información Fichero ---");

            System.out.println("Número de caracteres del fichero: " + array[0]);

            System.out.println("Número de palabras del fichero: " + array[1]);

            System.out.println("Número de líneas del fichero: " + array[2]);

        }

        else {

            System.out.println("El fichero indicado no existe");

        }
        
    }

    public static Integer [] infoFichero(String rutaFichero) {
        
        Integer [] arrayInfo = new Integer[3];

        File f = new File(rutaFichero);

        if (f.exists() == true) {
            
            String cadena;

            arrayInfo[0] = (int) f.length();
            
            try (
                
                FileReader fr = new FileReader(f);
                
                BufferedReader bfr = new BufferedReader(fr);
            
            ) {
                
                int contPalabras = 0;

                int contLineas = 0;

                while((cadena = bfr.readLine()) != null) {
                    
                    contLineas++;

                    for (int i = 0; i < cadena.length(); i++) {
                        
                        if(cadena.charAt(i) == ' ') {

                            contPalabras++;   // Cuenta las palabras que tienen a continuación un espacio

                        }

                    }

                    contPalabras++; // Cuenta la última palabra de cada línea, ya que no se
                                   // incluiría antes porque no hay espacio final

                }

                arrayInfo[1] = contPalabras;

                arrayInfo[2] = contLineas;

            } catch (IOException ex) {

                System.err.printf("Error: %s", ex.getMessage());

            }
            
            return arrayInfo;

        }

        else {

            return null;

        }

    }
    
}