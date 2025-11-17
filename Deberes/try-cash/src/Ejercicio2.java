import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("MENÚ");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Salir");

        try {
            System.out.print("Ingrese una opción: ");
            int opcion = sc.nextInt(); // Aquí da error si se ingresa una letra

            if (opcion == 1) {
                System.out.println("Seleccionaste SUMAR");
            } else if (opcion == 2) {
                System.out.println("Seleccionaste RESTAR");
            } else if (opcion == 3) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción NO válida.");
            }

        } catch (Exception e) {
            System.out.println("ERROR: Ingrese solo números.");
        }
    }
}
