public class Estudiante {
    private String nombre;
    private int edad;

    public Estudiante(String nombre, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Edad inválida. Debe ser entre 0 y 120.");
        }

        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad);
    }
    public static void main(String[] args) {

        // Crear un estudiante
        Estudiante est = new Estudiante("Diego", 20);

        // Mostrar los datos
        est.mostrar();
    }
}
