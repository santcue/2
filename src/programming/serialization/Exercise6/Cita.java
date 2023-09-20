package programming.serialization.Exercise6;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cita implements Serializable {
    private String nombrePaciente;
    private LocalDateTime fechaHora;
    private String medicoAsignado;

    public Cita(String nombrePaciente, LocalDateTime fechaHora, String medicoAsignado) {
        this.nombrePaciente = nombrePaciente;
        this.fechaHora = fechaHora;
        this.medicoAsignado = medicoAsignado;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(String medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }
}
