package programming.serialization.Exercise2;

import java.io.Serializable;

public class Habitacion implements Serializable {
    private String tipo;
    private boolean fumador;
    private int capacidad;
    private boolean aceptaMascotas;

    public Habitacion(String tipo, boolean fumador, int capacidad, boolean aceptaMascotas) {
        this.tipo = tipo;
        this.fumador = fumador;
        this.capacidad = capacidad;
        this.aceptaMascotas = aceptaMascotas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean esFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean aceptaMascotas() {
        return aceptaMascotas;
    }

    public void setAceptaMascotas(boolean aceptaMascotas) {
        this.aceptaMascotas = aceptaMascotas;
    }
}
