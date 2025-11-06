public class App {
    public static void main(String[] args) {
        Cafeteria cafeteriaApp = new Cafeteria();

        cafeteriaApp.registrarCliente("M1001", "Katia");
        cafeteriaApp.registrarCliente("P2005", "Alexa");

        cafeteriaApp.registrarProducto("E001", "Empanada de queso", 1.50);
        cafeteriaApp.registrarProducto("C002", "Café Americano chico", 2.25);
        cafeteriaApp.registrarProducto("P003", "Pollo empanizado", 8.75);
        cafeteriaApp.registrarProducto("G004", "Galleta de Chispas", 1.00);

        Producto empanada = cafeteriaApp.getProducto("E001");
        Producto cafe = cafeteriaApp.getProducto("C002");
        Producto pollo = cafeteriaApp.getProducto("P003");
        Producto galleta = cafeteriaApp.getProducto("G004");

        Pedido pedido1 = cafeteriaApp.crearPedido("M1001");
        if (pedido1 != null) {
            pedido1.agregarLinea(empanada, 2);
            pedido1.agregarLinea(cafe, 1);
            System.out.println(pedido1);
        }

        Pedido pedido2 = cafeteriaApp.crearPedido("P2005");
        if (pedido2 != null) {
            pedido2.agregarLinea(pollo, 1);
            pedido2.agregarLinea(galleta, 2);
            System.out.println(pedido2);
        }

        Pedido pedido3 = cafeteriaApp.crearPedido("M1001");
        if (pedido3 != null) {
            pedido3.agregarLinea(empanada, 1);
            pedido3.agregarLinea(cafe, 2);
            System.out.println(pedido3);
        }

        System.out.println("DEMOSTRACIÓN DE RESUMEN DE CLIENTE");

        cafeteriaApp.obtenerResumenCliente("M1001"); 
        cafeteriaApp.obtenerResumenCliente("P2005"); 
        cafeteriaApp.obtenerResumenCliente("ID_NO_EXISTE"); 
    }
}
