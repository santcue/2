package programming.serialization.Exercise6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Citas citas = new Citas();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Programar una cita");
            System.out.println("2. Ver citas programadas");
            System.out.println("3. Cancelar una cita");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    programarCita();
                    break;
                case 2:
                    verCitasProgramadas();
                    break;
                case 3:
                    cancelarCita();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    private static void programarCita() {
        System.out.println("Ingrese el nombre del paciente:");
        String nombrePaciente = scanner.nextLine();

        System.out.println("Ingrese la fecha y hora de la cita (YYYY-MM-DD HH:mm):");
        String fechaHoraString = scanner.nextLine();
        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.println("Ingrese el médico asignado:");
        String medicoAsignado = scanner.nextLine();

        citas.agregarCita(nombrePaciente, fechaHora, medicoAsignado);

        System.out.println("La cita ha sido programada exitosamente");
    }

    private static void verCitasProgramadas() {
        List<Cita> listaCitas = citas.obtenerCitas();

        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas programadas");
            return;
        }

        System.out.println("Citas.Citas programadas:");

        for (Cita cita : listaCitas) {
            System.out.println("- " + cita.getNombrePaciente() + " | " + cita.getFechaHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " | " + cita.getMedicoAsignado());
        }
    }

    private static void cancelarCita() {
        List<Cita> listaCitas = citas.obtenerCitas();

        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas programadas");
            return;
        }

        System.out.println("Seleccione la cita que desea cancelar:");

        for (int i = 0; i < listaCitas.size(); i++) {
            Cita cita = listaCitas.get(i);
            System.out.println((i + 1) + ". " + cita.getNombrePaciente() + " | " + cita.getFechaHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " | " + cita.getMedicoAsignado());
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > listaCitas.size()) {
            System.out.println("Opción inválida");
            return;
        }

        citas.eliminarCita(opcion - 1);

        System.out.println("La cita ha sido cancelada exitosamente");
    }
}
