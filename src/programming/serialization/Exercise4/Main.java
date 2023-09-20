package programming.serialization.Exercise4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Turno> colaDeEspera = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Tomar un turno");
            System.out.println("2. Llamar a un cliente");
            System.out.println("3. Mostrar la cola de espera");
            System.out.println("4. Contador de turnos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Turno turno = new Turno();
                    colaDeEspera.add(turno);
                    System.out.println("Se ha tomado el turno número " + turno.getNumero());
                    break;
                case 2:
                    if (colaDeEspera.isEmpty()) {
                        System.out.println("No hay clientes en espera");
                    } else {
                        Turno siguienteTurno = colaDeEspera.remove(0);
                        System.out.println("Llamando al cliente con el turno número " + siguienteTurno.getNumero());
                    }
                    break;
                case 3:
                    System.out.println("Cola de espera:");
                    for (Turno t : colaDeEspera) {
                        System.out.print(t.getNumero() + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Se han tomado " + Turno.getContador() + " turnos hasta el momento");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
