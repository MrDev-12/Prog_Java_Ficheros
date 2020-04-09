
package dam105t2_ficheros;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Dam105t2e714 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");

        boolean eof = false;

        double sumaTemps = 0;

        int cantTemps = 0;
        
        try (
            
            FileInputStream fis = new FileInputStream("archivos" + File.separator + "fich12.dat");

            BufferedInputStream bfis = new BufferedInputStream(fis);

            DataInputStream dis = new DataInputStream(bfis);
        
        ) {

            System.out.print("Introduce una fecha inicial: ");
            LocalDateTime fechaIni = LocalDateTime.parse(teclado.nextLine(), formato);

            System.out.print("Introduce una fecha final: ");
            LocalDateTime fechaFin = LocalDateTime.parse(teclado.nextLine(), formato);

            while (eof == false) {

                String cadfecha = dis.readUTF();

                double temp = dis.readDouble();

                LocalDateTime fecha = LocalDateTime.parse(cadfecha, formato);

                if(fecha.isAfter(fechaIni) && fecha.isBefore(fechaFin)) {

                    sumaTemps += temp;

                    cantTemps++;

                }

            }

            double tempMedia = sumaTemps / cantTemps;

            System.out.println("La temperatura media entre las fechas es " + tempMedia);

        } catch (EOFException e) {

            eof = true;

        } catch (IOException ex) {

            System.err.printf("%nError: %s", ex.getMessage());

        }
        
    }
    
}