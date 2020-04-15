
package dam105t2_ficheros;

public class movilPrepago {

    public long numeroMovil;
    private float costeEstablecLlamada;
    private float costeMinutoLlamada;
    private float costeConsumoMB;
    private float saldo;

    movilPrepago(long nM, float cEL, float cML, float cMB, float s) {

        numeroMovil = nM;
        costeEstablecLlamada = cEL;
        costeMinutoLlamada = cML;
        costeConsumoMB = cMB;
        saldo = s;

    }    

    public void efectuarLlamada(int segundos) {

        saldo -= Math.round(costeEstablecLlamada + costeMinutoLlamada /60f * segundos * 100f)/100f; 

        if (saldo < 0) saldo = 0;

    }

    public void navegar(int mb) {

        saldo -= Math.round(costeConsumoMB * mb * 100f) / 100f;

        if (saldo < 0) saldo = 0;

    }

    public boolean recargar(int importe) {

        if (importe % 5 == 0) {

            saldo += importe;
            return true;

        }

        else { return false; }
    }

    public float consultarSaldo() {

        return saldo;

    }

    public String toString() {

        String txt = String.format("El móvil " + numeroMovil + " tiene " + saldo + "€ de saldo");

        return txt;

    }

    // Añadido

    public float getSaldo() { return saldo; }

    public void setSaldo(float s) { saldo = s; }

    public float getCosteMinutoLlamada() { return costeMinutoLlamada; }

    //

}

class movilPlus extends movilPrepago {

    private float costeVideoLlamada;
    
    movilPlus(long nM, float cEL, float cML, float cMB, float s) {

        super(nM, cEL, cML, cMB, s);

        costeVideoLlamada = cMB * 2;

    }

    @Override

    public void efectuarLlamada(int segundos) {

        super.setSaldo(super.getSaldo() - Math.round(super.getCosteMinutoLlamada() /60f * segundos * 100f)/100f);

        if (super.getSaldo() < 0) { super.setSaldo(0); }

    }

    public void efectuarVideoLlamada(int segundos) {

        super.setSaldo(super.getSaldo() - Math.round(costeVideoLlamada * segundos * 100f) / 100f);

        if (super.getSaldo() < 0) { super.setSaldo(0); }

    }

}

class movilTarifaPlana extends movilPrepago {

    movilTarifaPlana(long nM, float cEL, float cML, float cMB, float s) {

        super(nM, cEL, cML, cMB, s);

    }

    @Override

    public void navegar(int mb) { }

}