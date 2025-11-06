public class Cliente {
     private String identificador;
    private String nombre;

    public Cliente(String identificador, String nombre) {
        this.identificador = identificador; // Matrícula o código de acceso
        this.nombre = nombre;
    }

    // Getters
    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente(ID: " + identificador + ", Nombre: " + nombre + ")";
    }

}
