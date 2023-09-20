package programming.serialization.Exercise2;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private String nombreCliente;
    private String paisOrigen;
    private int numPersonas;
    private Date fechaEntrada;
    private Date fechaSalida;
    private boolean trajoMascota;

    public Reserva(String nombreCliente, String paisOrigen, int numPersonas, Date fechaEntrada, Date fechaSalida, boolean trajoMascota) {
        this.nombreCliente = nombreCliente;
        this.paisOrigen = paisOrigen;
        this.numPersonas = numPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.trajoMascota = trajoMascota;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public boolean trajoMascota() {
        return trajoMascota;
    }

    public void setTrajoMascota(boolean trajoMascota) {
        this.trajoMascota = trajoMascota;
    }
}