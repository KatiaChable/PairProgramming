import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private static int nextId = 1; 
    private final int idPedido;
    private Cliente cliente; 
    private List<LineaPedido> lineas; 
    private double totalPedido;

    public Pedido(Cliente cliente) {
        this.idPedido = nextId++;
        this.cliente = cliente;
        this.lineas = new ArrayList<>();
        this.totalPedido = 0.0;
    }

    public void agregarLinea(Producto producto, int cantidad) {
        LineaPedido linea = new LineaPedido(producto, cantidad);
        this.lineas.add(linea);
        this.calcularTotal(); 
    }

    public double calcularTotal() {
        this.totalPedido = 0.0;
        for (LineaPedido linea : lineas) {
            this.totalPedido += linea.getPrecioLinea();
        }
        return this.totalPedido;
    }

 
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
