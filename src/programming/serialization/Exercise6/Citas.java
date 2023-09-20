package programming.serialization.Exercise6;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Citas {
    private List<Cita> citas = new ArrayList<>();

    public void agregarCita(String nombrePaciente, LocalDateTime fechaHora, String medicoAsignado) {
        Cita cita = new Cita(nombrePaciente, fechaHora, medicoAsignado);
        citas.add(cita);
    }

    public List<Cita> obtenerCitas() {
        citas.sort(Comparator.comparing(Cita::getFechaHora));
        return citas;
    }

    public void actualizarCita(int indice, String nombrePaciente, LocalDateTime fechaHora, String medicoAsignado) {
        Cita cita = citas.get(indice);
        cita.setNombrePaciente(nombrePaciente);
        cita.setFechaHora(fechaHora);
        cita.setMedicoAsignado(medicoAsignado);
    }

    public void eliminarCita(int indice) {
        citas.remove(indice);
    }
}