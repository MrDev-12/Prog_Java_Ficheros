
package dam105t2_ficheros;

import java.io.*;
import java.util.Scanner;



public class Dam105t2e708 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        File f = new File("archivos" + File.separator + "alumnos.csv");

        String nom;
        
        try (
            
            FileWriter fw = new FileWriter(f);
            
            BufferedWriter bfw = new BufferedWriter(fw);
        
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

                    bfw.write(nom); bfw.write(";");

                    bfw.write(fechaNac); bfw.write(";");

                    bfw.write(Double.toString(nota1)); bfw.write(";");

                    bfw.write(Double.toString(nota2)); bfw.write(";");

                    bfw.write(Double.toString(nota3)); bfw.write(";");

                    bfw.newLine();

                }

            } while (!nom.equals("Z"));

        } catch (IOException ex) {

            System.err.printf("Error: %s", ex.getMessage());

        }
        
    }
    
}