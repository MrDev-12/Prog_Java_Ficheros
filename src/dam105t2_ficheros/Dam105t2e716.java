
package dam105t2_ficheros;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;


public class Dam105t2e716 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        int dias = 1;

        LocalDate fechaHora = LocalDate.parse("2020-01-01");
        
        try (
            
            FileOutputStream fos = new FileOutputStream("archivos" + File.separator + "fich16.dat");

            BufferedOutputStream bfos = new BufferedOutputStream(fos);

            DataOutputStream dos = new DataOutputStream(bfos);
        
        ) {

            while(dias <= 366) {           // El año 2020 es bisiesto
                
                int temp = (int) (Math.random() * 40) + 0;

                dos.writeUTF(fechaHora.toString());

                dos.writeInt(temp);

                // Después de añadir los datos al fichero

                fechaHora = fechaHora.plusDays(1);

                dias++;

            }

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }

        // Acceso a los Datos --- No funciona correctamente!!!

        System.out.println("Introduce el día y mes de la fecha que quieres consultar:");
        String dia = teclado.nextLine();
        String mes = teclado.nextLine();
        
        int TAM_REGISTRO = 2 + 10 + 8;   // 2 Bytes Cabecera String + 10 Bytes Tamaño String + 8 Bytes Integer

        try (

            RandomAccessFile raf = new RandomAccessFile("archivos" + File.separator + "fich16.dat", "r");
        
        ) {

            raf.seek((Integer.parseInt(dia) - 1) * TAM_REGISTRO);

            System.out.println("La temperatura es de: " + raf.readInt());

        } catch (IOException ex) {

            System.err.printf("%nError: %s", ex.getMessage());

        }
        
    }
    
}