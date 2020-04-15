
package dam105t2_ficheros;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Dam105t2e719 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        long numMov = 0;

        float cEstLlam = 0, cMinLlam = 0, cConsMB = 0, saldo = 0;

        Properties config = new Properties();

        File f = new File("archivos" + File.separator + "configMovil.props");
        
        if (f.exists() == true) {

            try {

                System.out.println("--- El fichero configMovil.props ya existe ---");

                config.load(new FileInputStream(f));

                System.out.println("Número de Móvil actual: " + config.getProperty("numeroMovil"));

                System.out.print("Introduce el nuevo Número de Móvil: ");
                numMov = teclado.nextLong();

                System.out.println("Coste de Establecimiento de Llamada actual: " + config.getProperty("costeEstablecLlamada"));
                
                System.out.print("Introduce el nuevo Coste de Establecimiento de Llamada: ");
                cEstLlam = teclado.nextFloat();

                System.out.println("Coste por Minuto de Llamada actual: " + config.getProperty("costeMinutoLlamada"));
                
                System.out.print("Introduce el nuevo Coste por Minuto de Llamada: ");
                cMinLlam = teclado.nextFloat();

                System.out.println("Coste de Consumo por MB actual: " + config.getProperty("costeConsumoMB"));
                
                System.out.print("Introduce el nuevo Coste de Consumo por MB: ");
                cConsMB = teclado.nextFloat();

                System.out.println("Saldo del Móvil actual: " + config.getProperty("saldo"));
                
                System.out.print("Introduce el nuevo Saldo del Móvil: ");
                saldo = teclado.nextFloat();
                
            } catch (IOException ioe) {

                ioe.printStackTrace();
    
            }
            
        }

        else {

            System.out.print("Introduce el Número de Móvil: ");
            numMov = teclado.nextLong();
            
            System.out.print("Introduce el Coste de Establecimiento de Llamada: ");
            cEstLlam = teclado.nextFloat();
            
            System.out.print("Introduce el Coste por Minuto de Llamada: ");
            cMinLlam = teclado.nextFloat();
            
            System.out.print("Introduce el Coste de Consumo por MB: ");
            cConsMB = teclado.nextFloat();
            
            System.out.print("Introduce el Saldo del Móvil: ");
            saldo = teclado.nextFloat();

        }

        config.setProperty("numeroMovil", Long.toString(numMov));
        config.setProperty("costeEstablecLlamada", Float.toString(cEstLlam));
        config.setProperty("costeMinutoLlamada", Float.toString(cMinLlam));
        config.setProperty("costeConsumoMB", Float.toString(cConsMB));
        config.setProperty("saldo", Float.toString(saldo));
        
        try {

            config.store(new FileOutputStream(f), "Configuracion MovilPrepago");
            

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }
        
    }
    
}