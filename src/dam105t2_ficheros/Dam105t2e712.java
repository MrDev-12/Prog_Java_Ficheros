
package dam105t2_ficheros;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Dam105t2e712 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");

        double temp;
        
        try (
            
            FileOutputStream fos = new FileOutputStream("archivos" + File.separator + "fich12.dat");

            BufferedOutputStream bfos = new BufferedOutputStream(fos);

            DataOutputStream dos = new DataOutputStream(bfos);
        
        ) {

            do {
                
                System.out.print("Introduce la temperatura a registrar: ");
                temp = teclado.nextDouble();

                if(temp != -999) {

                    System.out.println("Introduce la fecha y hora: ");
                    System.out.println("Formato: 'dd/MM/yyyy-HH:mm:ss' ");

                    teclado.nextLine();
                    String fechaYhora = teclado.nextLine();

                    try {

                        LocalDateTime fechaHora = LocalDateTime.parse(fechaYhora, formato);

                        dos.writeDouble(temp);

                        dos.writeUTF(fechaYhora);

                    } catch (DateTimeParseException e) {

                        System.out.println("El formato de la fecha introducida no es válido");

                        System.out.println("Vuelve a introducir una temperatura y una fecha");

                    }

                }                

            } while (temp != -999);

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}