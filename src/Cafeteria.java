import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cafeteria {
    private Map<String, Producto> productos;
    private Map<String, Cliente> clientes;
    private List<Pedido> pedidos;

    public Cafeteria() {
        this.productos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.pedidos = new ArrayList<>();
    }

    /**
     * 1. Registra un nuevo cliente.
     */
    public void registrarCliente(String identificador, String nombre) {
        if (clientes.containsKey(identificador)) {
            System.out.println("⚠️ Error: El cliente con ID '" + identificador + "' ya existe.");
            return;
        }

        Cliente cliente = new Cliente(identificador, nombre);
        clientes.put(identificador, cliente);
        System.out.println("cliente registrado: " );
    }

    /**
     * 2. Registra un nuevo producto en el menú.
     */
    public void registrarProducto(String sku, String nombre, double precioBase) {
        if (productos.containsKey(sku)) {
            System.out.println("ya existe");
            return;
        }

        Producto producto = new Producto(sku, nombre, precioBase);
        productos.put(sku, producto);
        System.out.println("listo");
    }

    /**
     * 3. Crea un nuevo pedido para un cliente existente.
     */
    public Pedido crearPedido(String idCliente) {
        Cliente cliente = clientes.get(idCliente);
        if (cliente == null) {
            System.out.println("no encontrado");
            return null;
        }

        Pedido nuevoPedido = new Pedido(cliente);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido no. " + nuevoPedido.getIdPedido() + " de " + cliente.getNombre() + ".");
        return nuevoPedido;
    }

    public Producto getProducto(String sku) {
        return productos.get(sku);
    }
    
    /**
     * 5. Muestra un resumen de todos los pedidos y el total acumulado de un cliente.
     */
    public void obtenerResumenCliente(String idCliente) {
        Cliente cliente = clientes.get(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        List<Pedido> pedidosCliente = new ArrayList<>();
        double totalGastado = 0.0;

        // Filtrar y sumar pedidos del cliente
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getIdentificador().equals(idCliente)) {
                pedidosCliente.add(pedido);
                totalGastado += pedido.getTotalPedido();
            }
        }

        System.out.println("\n======== RESUMEN DE CONSUMO: " + cliente.getNombre() + " ========");
        System.out.println("Identificador: " + cliente.getIdentificador());

        if (pedidosCliente.isEmpty()) {
            System.out.println("No se han registrado pedidos para este cliente.");
        } else {
            System.out.println("Número de pedidos realizados: " + pedidosCliente.size());
            for (Pedido pedido : pedidosCliente) {
                System.out.printf("  - Pedido #%d: $%.2f%n", pedido.getIdPedido(), pedido.getTotalPedido());
            }
        }

        System.out.printf("\nTOTAL ACUMULADO GASTADO: $%.2f%n", totalGastado);
        System.out.println("___________________________________________________");
    }
}

