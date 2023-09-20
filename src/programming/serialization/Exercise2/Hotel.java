package programming.serialization.Exercise2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel implements Serializable {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void realizarReserva(Reserva reserva) {
        // Verificar disponibilidad de habitaciones antes de realizar la reserva
        if (verificarDisponibilidad(reserva)) {
            reservas.add(reserva);
            System.out.println("Reserva realizada con éxito.");
        } else {
            System.out.println("No hay habitaciones disponibles para esta reserva.");
        }
    }

    private boolean verificarDisponibilidad(Reserva reserva) {
        int capacidadRequerida = reserva.getNumPersonas();
        boolean aceptaMascotas = reserva.trajoMascota();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getCapacidad() >= capacidadRequerida && (!aceptaMascotas || habitacion.aceptaMascotas())) {
                return true;
            }
        }
        return false;
    }

    public int cantidadHabitacionesReservadas() {
        return reservas.size();
    }

    public int cantidadHabitacionesDisponibles() {
        return habitaciones.size() - reservas.size();
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    public boolean cancelarReserva(String nombreCliente, Date fechaEntrada) {
        for (Reserva reserva : reservas) {
            if (reserva.getNombreCliente().equals(nombreCliente) && reserva.getFechaEntrada().equals(fechaEntrada)) {
                reservas.remove(reserva);
                System.out.println("Reserva cancelada con éxito.");
                return true;
            }
        }
        System.out.println("No se encontró una reserva con ese nombre de cliente y fecha de entrada.");
        return false;
    }

    public List<Reserva> obtenerReservasPorFecha(Date fecha) {
        List<Reserva> reservasPorFecha = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getFechaEntrada().equals(fecha) || reserva.getFechaSalida().equals(fecha)) {
                reservasPorFecha.add(reserva);
            }
        }
        return reservasPorFecha;
    }

    public void imprimirReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Nombre del cliente: " + reserva.getNombreCliente());
            System.out.println("País de origen: " + reserva.getPaisOrigen());
            System.out.println("Número de personas: " + reserva.getNumPersonas());
            System.out.println("Fecha de entrada: " + reserva.getFechaEntrada());
            System.out.println("Fecha de salida: " + reserva.getFechaSalida());
            System.out.println("¿Mascota: " + (reserva.trajoMascota() ? "Sí" : "No"));
            System.out.println("-----------------------------");
        }
    }

}
