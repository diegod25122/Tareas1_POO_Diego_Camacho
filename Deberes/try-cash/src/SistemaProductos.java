import java.util.ArrayList;
import java.util.Scanner;

public class SistemaProductos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> lista = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        registrarProducto(sc, lista);
                        break;

                    case 2:
                        mostrarProductos(lista);
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes ingresar un número.");
            } catch (Exception e) {
                System.out.println("ERROR inesperado: " + e.getMessage());
            }

        } while (opcion != 3);
    }

    // ===========================================================
    //  MÉTODO PARA REGISTRAR PRODUCTO
    // ===========================================================
    public static void registrarProducto(Scanner sc, ArrayList<Producto> lista) {
        try {
            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());

            // Validaciones
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            if (precio < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo.");
            }

            // Crear objeto
            Producto p = new Producto(nombre, precio);
            lista.add(p);

            System.out.println("Producto registrado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Debes ingresar un número válido para el precio.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // ===========================================================
    //  MÉTODO PARA MOSTRAR PRODUCTOS
    // ===========================================================
    public static void mostrarProductos(ArrayList<Producto> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE PRODUCTOS =====");
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    // ===========================================================
    // SUBCLASE: PRODUCTO
    // ===========================================================
    static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return nombre + " - $" + precio;
        }
    }
}
