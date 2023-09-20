package programming.serialization.Exercise2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        GestorReservas gestor = new GestorReservas();

        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();

        gestor.agregarHotel(hotel1);
        gestor.agregarHotel(hotel2);

        Habitacion habitacionIndividual = new Habitacion("Individual", false, 2, false);
        Habitacion habitacionDoble = new Habitacion("Doble", false, 4, false);
        Habitacion habitacionFamiliar = new Habitacion("Familiar", false, 6, true);

        hotel1.agregarHabitacion(habitacionIndividual);
        hotel1.agregarHabitacion(habitacionDoble);
        hotel2.agregarHabitacion(habitacionFamiliar);

        Reserva reserva1 = new Reserva("Cliente1", "País1", 2, new Date(), new Date(), false);
        Reserva reserva2 = new Reserva("Cliente2", "País2", 4, new Date(), new Date(), false);
        Reserva reserva3 = new Reserva("Cliente3", "País3", 6, new Date(), new Date(), true);

        gestor.agregarReserva(0, reserva1);
        gestor.agregarReserva(0, reserva2);
        gestor.agregarReserva(1, reserva3);

        System.out.println("Reservas en Hotel 1:");
        gestor.listarReservas(0);

        System.out.println("Reservas en Hotel 2:");
        gestor.listarReservas(1);

        gestor.eliminarReserva(0, "Cliente1", reserva1.getFechaEntrada());

        gestor.guardarReservas();
        gestor.cargarReservas();
    }
}