package programming.serialization.Exercise4;

import java.io.Serializable;

public class Turno implements Serializable {
    private int numero;
    private static int contador = 0;

    public Turno() {
        contador++;
        this.numero = contador;
    }

    public int getNumero() {
        return numero;
    }

    public static int getContador() {
        return contador;
    }
}
