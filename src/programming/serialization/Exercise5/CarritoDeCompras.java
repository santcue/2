package programming.serialization.Exercise5;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarCarrito() {
        System.out.println("Carrito de compras:");
        double subtotal = 0;
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - Cantidad: 1 - Subtotal: $" + p.getPrecio());
            subtotal += p.getPrecio();
        }
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
}
