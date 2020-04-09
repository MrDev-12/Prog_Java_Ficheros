
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;



public class Dam105t2e709 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        File f = new File("archivos" + File.separator + "alumnos.txt");

        String nom;
        
        try (
            
            FileWriter fw = new FileWriter(f);
            
            BufferedWriter bfw = new BufferedWriter(fw);
            
            PrintWriter pw = new PrintWriter(bfw, true);
        
        ) {

            do {
                
                System.out.print("Introduce el nombre del alumno: ");
                teclado.nextLine();   // Hace falta un intro al principio con
                                     // el primer nombre del alumno, después ya no
                nom = teclado.nextLine();

                if(!nom.equals("Z")) {

                    System.out.print("Introduce la fecha de nacimiento del alumno: ");
                    String fechaNac = teclado.nextLine();

                    System.out.println("Introduce las notas de la tres evaluaciones del alumno: ");
                    double nota1 = teclado.nextDouble();
                    double nota2 = teclado.nextDouble();
                    double nota3 = teclado.nextDouble();

                    pw.printf("%-100s%s%05.2f%05.2f%05.2f%n", nom, fechaNac, nota1, nota2, nota3);

                    bfw.newLine();

                }                

            } while (!nom.equals("Z"));

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}