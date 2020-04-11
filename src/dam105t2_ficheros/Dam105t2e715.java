
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;


public class Dam105t2e715 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        System.out.print("Introduce la ruta del archivo: ");
        String fich = teclado.nextLine();

        System.out.println("1 - Archivo BMP");
        System.out.println("2 - Archivo JPG");
        
        System.out.print("Que tipo de archivo es: ");
        int tipoF = teclado.nextInt();

        boolean resul = comprobarTipoArchivo(fich, tipoF);

        if(resul == true) {

            System.out.println("El valor de la cabecera que identifica al archivo seleccionado COINCIDE");

        }

        else {

            System.out.println("El valor de la cabecera que identifica al archivo seleccionado NO COINCIDE");

        }
        
    }

    public static boolean comprobarTipoArchivo(String fichero, int tipoFich) {

        // Bytes BMP -> 42 4D

        String [] arrayBMP = new String [] {"42", "4D"};

        // Bytes JPG -> FF D8 FF

        String [] arrayJPG = new String [] {"FF", "D8", "FF"};

        //

        boolean coincide = true;
        
        try (
            
            FileInputStream fis = new FileInputStream(fichero);

            BufferedInputStream bfis = new BufferedInputStream(fis);

            DataInputStream dis = new DataInputStream(bfis);
        
        ) {

            if(tipoFich == 1) {

                for (int i = 0; i < arrayBMP.length; i++) {
                
                    byte b = dis.readByte();

                    String hexa = String.format("%02X", b);

                    if(!hexa.equals(arrayBMP[i])) {

                        coincide = false;

                    }

                }

            }
            
            if(tipoFich == 2) {

                for (int i = 0; i < arrayJPG.length; i++) {
                
                    byte b = dis.readByte();

                    String hexa = String.format("%02X", b);

                    if(!hexa.equals(arrayJPG[i])) {

                        coincide = false;

                    }

                }

            }

        } catch (IOException ex) {

            System.err.printf("%nError: %s", ex.getMessage());

        }

        return coincide;
        
    }
    
}