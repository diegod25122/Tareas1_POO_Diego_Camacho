import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        int opcion;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Ingresar como Cliente");
            System.out.println("3. Ingresar como Empleado");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: // REGISTRAR
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Tipo de cuenta: ");
                    String tipoCuenta = sc.nextLine();

                    cliente = new Cliente(nombre, cedula, direccion, telefono, tipoCuenta);
                    System.out.println("Cliente registrado con éxito.");
                    break;

                case 2: // MENU CLIENTE
                    if (cliente == null) {
                        System.out.println("No hay cliente registrado.");
                        break;
                    }

                    int c;
                    do {
                        System.out.println("\n--- MENU CLIENTE ---");
                        System.out.println("1. Abrir cuenta");
                        System.out.println("2. Solicitar prestamo");
                        System.out.println("3. Ver resumen");
                        System.out.println("4. Cerrar cuenta");
                        System.out.println("5. Salir");
                        System.out.print("Opcion: ");
                        c = sc.nextInt();
                        sc.nextLine();

                        if (c == 1) {
                            System.out.print("Tipo de cuenta: ");
                            String tipo = sc.nextLine();
                            cliente.registrarCuenta(tipo);
                        }

                        if (c == 2) {
                            System.out.print("Monto: ");
                            double m = sc.nextDouble();
                            sc.nextLine();
                            cliente.solicitarPrestamo(m);
                        }

                        if (c == 3) {
                            cliente.verResumenFinanciero();
                        }

                        if (c == 4) {
                            cliente.cerrarCuenta();
                        }

                    } while (c != 5);

                    break;

                case 3: // MENU EMPLEADO
                    System.out.println("\nSeleccione tipo de empleado:");
                    System.out.println("1. Cajero");
                    System.out.println("2. Balcón");
                    System.out.println("3. Jefe Agencia");
                    System.out.print("Opcion: ");
                    int emp = sc.nextInt();
                    sc.nextLine();

                    if (cliente == null) {
                        System.out.println("No hay cliente para trabajar.");
                        break;
                    }

                    if (emp == 1) {
                        Cajero caj = new Cajero("Cajero", "000", "Banco", "000", "u", "p");
                        System.out.print("Monto depósito: ");
                        double dep = sc.nextDouble();
                        sc.nextLine();
                        caj.procesarDeposito(cliente, dep);

                    } else if (emp == 2) {
                        BalconServicios b = new BalconServicios("Balcon", "000", "Banco", "000", "u", "p");
                        b.actualizarDatosCliente(cliente);

                    } else if (emp == 3) {
                        JefeAgencia j = new JefeAgencia("Jefe", "000", "Banco", "000", "u", "p");
                        j.generarReporteOperaciones();
                    }

                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }
}
