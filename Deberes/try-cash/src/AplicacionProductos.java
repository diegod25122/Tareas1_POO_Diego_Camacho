import java.util.Scanner;

public class AplicacionProductos {


    static Producto productoGuardado = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Agregar producto nacional");
            System.out.println("2. Agregar producto importado");
            System.out.println("3. Mostrar producto");
            System.out.println("4. Promedio precio final");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                    case 2:
                        agregarProducto(sc, opcion);
                        break;

                    case 3:
                        mostrarProducto();
                        break;

                    case 4:
                        calcularPromedio();
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un número.");
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while (opcion != 5);
    }

    public static void agregarProducto(Scanner sc, int tipo) {

        try {
            System.out.print("Código: ");
            String codigo = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Precio base: ");
            double precio = Double.parseDouble(sc.nextLine());

            if (tipo == 1) {
                productoGuardado = new ProductoNacional(codigo, nombre, precio);
            } else {
                productoGuardado = new ProductoImportado(codigo, nombre, precio);
            }

            System.out.println("Producto guardado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Precio inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void mostrarProducto() {
        if (productoGuardado == null) {
            System.out.println("No hay producto guardado.");
            return;
        }

        System.out.println("\n===== PRODUCTO =====");
        System.out.println(productoGuardado);
    }

    public static void calcularPromedio() throws DatosInvalidosException {

        if (productoGuardado == null) {
            throw new DatosInvalidosException("No existe producto para calcular promedio.");
        }

        double promedio = productoGuardado.calcularPrecioFinal();

        System.out.println("Promedio del precio final (único producto): " + promedio);
    }



    static class DatosInvalidosException extends Exception {
        public DatosInvalidosException(String mensaje) {
            super(mensaje);
        }
    }

    static abstract class Producto {
        private String codigo;
        private String nombre;
        private double precioBase;

        public Producto(String codigo, String nombre, double precioBase) {

            if (codigo == null || codigo.isEmpty())
                throw new IllegalArgumentException("El código no puede estar vacío.");
            if (nombre == null || nombre.isEmpty())
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            if (precioBase < 0)
                throw new IllegalArgumentException("El precio base no puede ser negativo.");

            this.codigo = codigo;
            this.nombre = nombre;
            this.precioBase = precioBase;
        }

        public double getPrecioBase() {
            return precioBase;
        }

        public abstract double calcularPrecioFinal();

        @Override
        public String toString() {
            return codigo + " - " + nombre + " | Precio final: " + calcularPrecioFinal();
        }
    }

    static class ProductoNacional extends Producto {
        public ProductoNacional(String codigo, String nombre, double precioBase) {
            super(codigo, nombre, precioBase);
        }

        @Override
        public double calcularPrecioFinal() {
            return getPrecioBase() * 1.12;
        }
    }

    static class ProductoImportado extends Producto {
        public ProductoImportado(String codigo, String nombre, double precioBase) {
            super(codigo, nombre, precioBase);
        }

        @Override
        public double calcularPrecioFinal() {
            return getPrecioBase() * 1.05;
        }
    }
}
