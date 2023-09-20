package programming.serialization.Exercise2;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class GestorReservas {
    private List<Hotel> hoteles;

    public GestorReservas() {
        hoteles = new ArrayList<>();
    }

    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }

    public void guardarReservas() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("reservas.dat"))) {
            outputStream.writeObject(hoteles);
            System.out.println("Reservas guardadas exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarReservas() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("reservas.dat"))) {
            hoteles = (List<Hotel>) inputStream.readObject();
            System.out.println("Reservas cargadas exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void agregarReserva(int indiceHotel, Reserva reserva) {
        if (indiceHotel >= 0 && indiceHotel < hoteles.size()) {
            hoteles.get(indiceHotel).realizarReserva(reserva);
        } else {
            System.out.println("El índice del hotel no es válido.");
        }
    }

    public void eliminarReserva(int indiceHotel, String nombreCliente, Date fechaEntrada) {
        if (indiceHotel >= 0 && indiceHotel < hoteles.size()) {
            boolean eliminada = hoteles.get(indiceHotel).cancelarReserva(nombreCliente, fechaEntrada);
            if (eliminada) {
                System.out.println("Reserva eliminada con éxito.");
            } else {
                System.out.println("No se encontró una reserva con ese nombre de cliente y fecha de entrada.");
            }
        } else {
            System.out.println("El índice del hotel no es válido.");
        }
    }

    public void listarReservas(int indiceHotel) {
        if (indiceHotel >= 0 && indiceHotel < hoteles.size()) {
            hoteles.get(indiceHotel).imprimirReservas();
        } else {
            System.out.println("El índice del hotel no es válido.");
        }
    }

}
