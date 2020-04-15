
package dam105t2_ficheros;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Dam105t2e720 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in, "ISO-8859-1");

        Properties config = new Properties();

        ArrayList <movilPrepago> arrayMoviles = new ArrayList<>();

        File f = new File("archivos" + File.separator + "configMovil.props");

        try {

            config.load(new FileInputStream(f));

            for (int i = 0; i < 5; i++) {
                
                System.out.print("Introduce el Número de Móvil: ");
                long numMov = teclado.nextLong();

                float cEstLlam = Float.parseFloat(config.getProperty("costeEstablecLlamada"));

                float cMinLlam = Float.parseFloat(config.getProperty("costeMinutoLlamada"));
                
                float cConsMB = Float.parseFloat(config.getProperty("costeConsumoMB"));

                float saldo = Float.parseFloat(config.getProperty("saldo"));

                arrayMoviles.add(new movilPrepago(numMov, cEstLlam, cMinLlam, cConsMB, saldo));

            }
            
        } catch (IOException ioe) {

            ioe.printStackTrace();

        }

        float totalSaldos = 0;

        for (int i = 0; i < arrayMoviles.size(); i++) {
            
            totalSaldos += arrayMoviles.get(i).getSaldo();

        }
        
        System.out.println("La suma total de los Saldos es de: " + totalSaldos);

    }
    
}