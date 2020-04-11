
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;


public class Dam105t2e710 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        File f = new File("archivos" + File.separator + "alumnos.txt");

        String cadena;
        
        try (
            
            FileReader fr = new FileReader(f);
            
            BufferedReader bfr = new BufferedReader(fr);
        
        ) {

            int alumAprob = 0;

            int mejorNota = 0;

            String mejorAlum = "";

            while((cadena = bfr.readLine()) != null) {

                int posUltCaracter = cadena.length();

                String cadNota1 = cadena.substring(posUltCaracter - 15, posUltCaracter - 10);
                String cadNota2 = cadena.substring(posUltCaracter - 10, posUltCaracter - 5);
                String cadNota3 = cadena.substring(posUltCaracter - 5, posUltCaracter);

                double nota1 = Double.parseDouble(cadNota1.replace(',', '.'));
                double nota2 = Double.parseDouble(cadNota2.replace(',', '.'));
                double nota3 = Double.parseDouble(cadNota3.replace(',', '.'));

                int notaFinal = (int) Math.round((nota1 * 0.20) + (nota2 * 0.30) + (nota3 * 0.50));

                if(notaFinal >= 5) {
                    
                    alumAprob++;

                }

                if(notaFinal >= mejorNota) {

                    mejorAlum.equals(cadena.substring(0, 99));

                }

            }

            System.out.println("Alumnos Aprobados: " + alumAprob);

            System.out.println("Mejor Alumno: " + mejorAlum);
            
            System.out.println("Mejor Nota: " + mejorNota);

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}