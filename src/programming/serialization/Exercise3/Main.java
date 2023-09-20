package programming.serialization.Exercise3;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EstadisticasAtencion estadisticas = cargarEstadisticas();

        while (true) {
            System.out.println("Ingrese número de cédula (o 'salir' para terminar):");
            String cedula = scanner.nextLine();
            if (cedula.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Seleccione tipo de atención ('terminal' o 'asesoría'):");
            String tipoAtencion = scanner.nextLine();

            if (tipoAtencion.equalsIgnoreCase("terminal")) {
                Usuario usuario = new Usuario(cedula, "terminal");
                estadisticas.agregarUsuario(usuario);
            } else if (tipoAtencion.equalsIgnoreCase("asesoría")) {
                System.out.println("Seleccione tipo de asesoría ('estudiante' o 'directivo'):");
                String tipoAsesoria = scanner.nextLine();
                Usuario usuario = new Usuario(cedula, "asesoría " + tipoAsesoria);
                estadisticas.agregarUsuario(usuario);
            }
        }

        guardarEstadisticas(estadisticas);
        mostrarEstadisticas(estadisticas);
    }

    private static EstadisticasAtencion cargarEstadisticas() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("estadisticas.dat"))) {
            return (EstadisticasAtencion) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new EstadisticasAtencion();
        }
    }

    private static void guardarEstadisticas(EstadisticasAtencion estadisticas) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("estadisticas.dat"))) {
            outputStream.writeObject(estadisticas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarEstadisticas(EstadisticasAtencion estadisticas) {
        System.out.println("Estadísticas de Atención:");
        System.out.println("Cantidad total de usuarios atendidos: " + estadisticas.getCantidadUsuariosAtendidos());
        System.out.println("Cantidad de usuarios por tipo:");
        System.out.println("- Terminal: " + estadisticas.getCantidadUsuariosPorTipo("terminal"));
        System.out.println("- Asesoría Estudiante: " + estadisticas.getCantidadUsuariosPorTipo("asesoría estudiante"));
        System.out.println("- Asesoría Directivo: " + estadisticas.getCantidadUsuariosPorTipo("asesoría directivo"));
    }
}
