package programming.serialization.Exercise5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarritoDeCompras carritoDeCompras = new CarritoDeCompras();

        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar carrito");
            System.out.println("3. Calcular total");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad en stock: ");
                    int cantidadEnStock = scanner.nextInt();
                    scanner.nextLine();

                    Producto producto = new Producto(nombre, precio, cantidadEnStock);
                    carritoDeCompras.agregarProducto(producto);
                    break;
                case 2:
                    carritoDeCompras.mostrarCarrito();
                    break;
                case 3:
                    double total = carritoDeCompras.calcularTotal();
                    System.out.println("Total de la compra: $" + total);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
