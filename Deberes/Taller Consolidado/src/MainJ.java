import java.util.Scanner;
import java.util.ArrayList;
public class MainJ {

    static ArrayList<Juego> juegos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE JUEGOS =====");
            System.out.println("1. Registrar Mario Bros");
            System.out.println("2. Registrar Carrera de Vehículos");
            System.out.println("3. Mostrar todos los juegos");
            System.out.println("4. Filtrar por tipo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Debe ingresar un número.");
                opcion = 0;
                continue;
            }

            try {
                switch (opcion) {
                    case 1: registrarMario(); break;
                    case 2: registrarCarrera(); break;
                    case 3: mostrarJuegos(); break;
                    case 4: filtrarPorTipo(); break;
                    case 5: System.out.println("Saliendo..."); break;
                    default: System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 5);
    }

    //======================
    // VALIDACIÓN DE PRECIO
    //======================
    public static double leerPrecio() throws Exception {
        System.out.print("Precio: ");
        String entrada = sc.nextLine();

        if (entrada.trim().isEmpty()) {
            throw new Exception("El precio no puede estar vacío.");
        }

        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            throw new Exception("El precio debe ser un número válido.");
        }
    }


    // REGISTRAR MARIO

    public static void registrarMario() throws Exception {
        System.out.print("Nombre del juego: ");
        String nombre = sc.nextLine();

        double precio = leerPrecio();

        MarioBros mario = new MarioBros(nombre, precio);

        System.out.print("¿Cuántos mundos? ");
        int cant = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cant; i++) {
            String mundo = "";

            do {
                System.out.print("Mundo " + (i + 1) + ": ");
                mundo = sc.nextLine();

                if (mundo.trim().isEmpty()) {
                    System.out.println("⚠ El nombre del mundo no puede estar vacío.");
                }

            } while (mundo.trim().isEmpty());

            mario.agregarMundo(mundo);
        }

        juegos.add(mario);
        System.out.println("Mario Bros registrado.");
    }


    // REGISTRAR CARRERA

    public static void registrarCarrera() throws Exception {
        System.out.print("Nombre del juego: ");
        String nombre = sc.nextLine();

        double precio = leerPrecio();

        CarreraVehiculos carrera = new CarreraVehiculos(nombre, precio);

        System.out.print("¿Cuántos vehículos?: ");
        int cant = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cant; i++) {
            String vehiculo = "";

            do {
                System.out.print("Vehículo " + (i + 1) + ": ");
                vehiculo = sc.nextLine();

                if (vehiculo.trim().isEmpty()) {
                    System.out.println("El nombre del vehículo no puede estar vacío.");
                }

            } while (vehiculo.trim().isEmpty());

            carrera.agregarVehiculo(vehiculo);
        }

        juegos.add(carrera);
        System.out.println("Carrera registrada.");
    }


    // MOSTRAR

    public static void mostrarJuegos() {
        if (juegos.isEmpty()) {
            System.out.println("No hay juegos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE JUEGOS =====");
        for (Juego j : juegos) {
            j.mostrarDetalles();
        }
    }


    // FILTRAR

    public static void filtrarPorTipo() {

        System.out.println("\nFiltrar por:");
        System.out.println("1. Mario Bros");
        System.out.println("2. Carrera de Vehículos");
        System.out.print("Opción: ");

        int tipo;

        try {
            tipo = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Debe ingresar un número válido.");
            return;
        }

        boolean encontrado = false;

        for (Juego j : juegos) {
            if (tipo == 1 && j instanceof MarioBros) {
                j.mostrarDetalles();
                encontrado = true;
            }
            if (tipo == 2 && j instanceof CarreraVehiculos) {
                j.mostrarDetalles();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay juegos de ese tipo.");
        }
    }
}