public class Producto {
      private String sku;
    private String nombre;
    private double precioBase;

    public Producto(String sku, String nombre, double precioBase) {
        this.sku = sku;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Getters
    public String getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public String toString() {
        return String.format("Producto(SKU: %s, Nombre: %s, Precio: $%.2f)", sku, nombre, precioBase);
    }

}
