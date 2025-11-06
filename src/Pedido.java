import java.util.ArrayList;
import java.util.List;

// Importamos las clases Cliente y LineaPedido
// import Cliente; 
// import LineaPedido;

public class Pedido {
    private static int nextId = 1; // Contador estático para IDs automáticos

    private final int idPedido;
    // Relación de Agregación: Cliente existe si el pedido se borra.
    private Cliente cliente; 
    // Relación de Composición: Las líneas de pedido no existen sin el pedido.
    private List<LineaPedido> lineas; 
    private double totalPedido;

    public Pedido(Cliente cliente) {
        this.idPedido = nextId++;
        this.cliente = cliente;
        this.lineas = new ArrayList<>();
        this.totalPedido = 0.0;
    }

    /**
     * 3. Agrega un producto con su cantidad al pedido.
     */
    public void agregarLinea(Producto producto, int cantidad) {
        LineaPedido linea = new LineaPedido(producto, cantidad);
        this.lineas.add(linea);
        this.calcularTotal(); // Recalcula el total al agregar una línea
    }

    /**
     * 4. Calcula el total del pedido sumando todas sus líneas de pedido.
     */
    public double calcularTotal() {
        this.totalPedido = 0.0;
        for (LineaPedido linea : lineas) {
            this.totalPedido += linea.getPrecioLinea();
        }
        return this.totalPedido;
    }

    // Getters
    public int getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    @Override
    public String toString() {
        StringBuilder resumenLineas = new StringBuilder();
        for (LineaPedido linea : lineas) {
            resumenLineas.append(linea.toString()).append("\n");
        }

        return String.format(
            "\n--- Pedido #%d ---\n"
            + "Cliente: %s (ID: %s)\n"
            + "Productos:\n%s"
            + "TOTAL del Pedido: $%.2f\n"
            + "-------------------",
            idPedido,
            cliente.getNombre(),
            cliente.getIdentificador(),
            resumenLineas.toString(),
            totalPedido
        );
    }
}
