public class LineaPedido {
    private Producto producto; 
    private int cantidad;
    private double precioLinea;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioLinea = calcularPrecioLinea();
    }


    public double calcularPrecioLinea() {
        return producto.getPrecioBase() * cantidad;
    }

    
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
