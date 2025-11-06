
    
// Importamos la clase Producto
// import Producto; 

public class LineaPedido {
    // Relación de Agregación: Producto existe independientemente de la línea.
    private Producto producto; 
    private int cantidad;
    private double precioLinea;

    public LineaPedido(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioLinea = calcularPrecioLinea(); // Calcula el precio total de la línea
    }

    /**
     * Calcula el total de esta línea de pedido (precio del producto x cantidad).
     */
    public double calcularPrecioLinea() {
        return producto.getPrecioBase() * cantidad;
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public double getPrecioLinea() {
        return precioLinea;
    }

    @Override
    public String toString() {
        return String.format("  - %dx %s @ $%.2f = $%.2f", 
            cantidad, 
            producto.getNombre(), 
            producto.getPrecioBase(), 
            precioLinea
        );
    }

    
}
