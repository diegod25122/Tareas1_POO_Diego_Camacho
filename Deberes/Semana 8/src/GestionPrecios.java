import java.util.Scanner;
import java.util.ArrayList;

public class GestionPrecios {

    private ArrayList<Double> precios;
    private Scanner scanner;

    public GestionPrecios() {
        this.precios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ingresarPrecio() {
        try {
            System.out.print("Introduce el precio de la casa o departamento: ");
            double precio = scanner.nextDouble();

            if (precio > 0) {
                precios.add(precio);
                System.out.println("✔ Precio agregado correctamente.");
            } else {
                System.out.println(" El precio debe ser mayor que 0.");
            }
        } catch (Exception e) {
            System.out.println("ERROR: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    public void mostrarPrecios() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        } else {
            System.out.println("========== PRECIOS ============");
            int contador = 1;
            for (Double precio : precios) {
                System.out.println("Inmobiliario " + contador + ": $" + precio);
                contador++;
            }
        }
    }

    public void precioMasAlto() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        } else {
            double maxPrecio = precios.get(0);
            for (double precio : precios) {
                if (precio > maxPrecio) {
                    maxPrecio = precio;
                }
            }
            System.out.println("El precio más alto es: $" + maxPrecio);
        }
    }

    public void precioMasBajo() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        } else {
            double minPrecio = precios.get(0);
            for (double precio : precios) {
                if (precio < minPrecio) {
                    minPrecio = precio;
                }
            }
            System.out.println("El precio más bajo es: $" + minPrecio);
        }
    }

    public void preciosIguales() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        } else {
            System.out.println("\n=== PRECIOS IGUALES ===");
            boolean hayDuplicados = false;

            for (int i = 0; i < precios.size(); i++) {
                for (int j = i + 1; j < precios.size(); j++) {
                    if (precios.get(i).equals(precios.get(j))) {
                        System.out.println("$" + precios.get(i));
                        hayDuplicados = true;
                        break;
                    }
                }
            }

            if (!hayDuplicados) {
                System.out.println("No hay precios iguales.");
            }
        }
    }

    public void buscarPrecio() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        } else {
            try {
                System.out.print("Ingrese el precio a buscar: ");
                double buscar = scanner.nextDouble();

                if (precios.contains(buscar)) {
                    System.out.println("✔ Se encontró el precio: $" + buscar);
                } else {
                    System.out.println("No se encontró el precio solicitado.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }
}
