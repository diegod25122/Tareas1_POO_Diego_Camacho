import java.util.ArrayList;
import java.util.Scanner;

public class MainD {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Dispositivo> dispositivos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n===== MENÚ DISPOSITIVOS ELECTRÓNICOS =====");
            System.out.println("1. Registrar Laptop");
            System.out.println("2. Registrar Teléfono");
            System.out.println("3. Mostrar todos los dispositivos");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            // Validación menú
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese una opción válida.");
                opcion = 0;
                continue;
            }

            switch (opcion) {

                case 1:
                    registrarLaptop(dispositivos);
                    break;

                case 2:
                    registrarTelefono(dispositivos);
                    break;

                case 3:
                    mostrarDispositivos(dispositivos);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);
    }

    // =======================
    // REGISTRAR LAPTOP
    // =======================
    public static void registrarLaptop(ArrayList<Dispositivo> lista) {

        try {
            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.print("RAM (GB): ");
            int ram = Integer.parseInt(sc.nextLine());

            lista.add(new Laptop(marca, modelo, precio, ram));
            System.out.println("✔ Laptop registrada.");

        } catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Revise los datos.");
        }
    }

    // =======================
    // REGISTRAR TELEFONO
    // =======================
    public static void registrarTelefono(ArrayList<Dispositivo> lista) {

        try {

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.print("Sistema operativo: ");
            String sistema = sc.nextLine();

            lista.add(new Telefono(marca, modelo, precio, sistema));
            System.out.println("Teléfono registrado.");

        } catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Revise los datos.");
        }
    }

    // =======================
    // MOSTRAR DISPOSITIVOS
    // =======================
    public static void mostrarDispositivos(ArrayList<Dispositivo> lista) {

        if (lista.isEmpty()) {
            System.out.println("No hay dispositivos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE DISPOSITIVOS =====");

        // POLIMORFISMO
        for (Dispositivo d : lista) {
            d.mostrarInfo();
        }
    }
}
