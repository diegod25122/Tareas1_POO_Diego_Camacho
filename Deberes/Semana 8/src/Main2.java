import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestionPrecios gp = new GestionPrecios();

        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ DE PRECIOS INMOBILIARIOS =====");
            System.out.println("1. Ingresar precio");
            System.out.println("2. Mostrar todos los precios");
            System.out.println("3. Mostrar precio más alto");
            System.out.println("4. Mostrar precio más bajo");
            System.out.println("5. Mostrar precios iguales");
            System.out.println("6. Buscar un precio específico");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1: gp.ingresarPrecio(); break;
                    case 2: gp.mostrarPrecios(); break;
                    case 3: gp.precioMasAlto(); break;
                    case 4: gp.precioMasBajo(); break;
                    case 5: gp.preciosIguales(); break;
                    case 6: gp.buscarPrecio(); break;
                    case 7: System.out.println("Saliendo..."); break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: Debes ingresar un número.");
                scanner.nextLine();
            }

        } while (opcion != 7);
    }
}
