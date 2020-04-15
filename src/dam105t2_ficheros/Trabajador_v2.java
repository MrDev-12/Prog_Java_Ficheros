
package dam105t2_ficheros;

import java.time.LocalDate;
import java.io.*;

public class Trabajador_v2 implements Serializable {

    private int ID;
    private String Nombre;
    private LocalDate FechaNac;
    private double Salario;

    Trabajador_v2(int id, String nom, LocalDate fnac, double sal) {

        ID = id;
        Nombre = nom;
        FechaNac = fnac;
        Salario = sal;

    }

    public void setID(int id) { ID = id; }

    public int getID() { return ID; }


    public void setNombre(String nom) { Nombre = nom; }

    public String getNombre() { return Nombre; }


    public void setFechaNac(LocalDate fnac) { FechaNac = fnac; }

    public LocalDate getFechaNac() { return FechaNac; }


    public void setSalario(double sal) { Salario = sal; }

    public double getSalario() { return Salario; }


    public String toString() {

        String txt = String.format("Identificador: " + ID + "; Nombre: " + Nombre + "; Fecha de Nacimiento: " + FechaNac + "; Salario: " + Salario);

        return txt;

    }

    public boolean equals(Trabajador_v2 trab) {

        if(this.ID == trab.ID) { return true; }

        else { return false; }
        
    }

}

class Asalariado_v2 extends Trabajador_v2 {

    private double salarioFinal;
    private int horasExtra;

    Asalariado_v2(int id, String nom, LocalDate fnac, double sal) {

        super(id, nom, fnac, sal);

        salarioFinal = sal;
        horasExtra = 0;

    }

    public void setHorasExtra(int horasEx) { horasExtra = horasEx; }

    public int getHorasExtra() { return horasExtra; }

    public void calcularSalarioFinal(double costeHoraEx) {

        salarioFinal = super.getSalario() + (horasExtra * costeHoraEx);

    }

    public double getSalarioFinal() { return salarioFinal; }

}

class ConsultorExterno_v2 extends Trabajador_v2 {

    private int horasTrabajadas;
    private double salarioFinal;

    ConsultorExterno_v2(int id, String nom, LocalDate fnac, double sal) {

        super(id, nom, fnac, sal);

        super.setSalario(0);
        salarioFinal = 0;
        horasTrabajadas = 0;

    }

    public void setHorasTrabajadas(int horasTrab) { horasTrabajadas = horasTrab; }

    public int getHorasTrabajadas() { return horasTrabajadas; }

    public void calcularSalarioFinal(double costeHoraTrab) {

        salarioFinal = horasTrabajadas * costeHoraTrab;

    }

    public double getSalarioFinal() { return salarioFinal; }


}