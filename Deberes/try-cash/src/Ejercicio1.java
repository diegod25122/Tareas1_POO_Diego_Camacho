import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el precio del producto: ");
            double precio = sc.nextDouble();

            if (precio < 0) {
                System.out.println("El precio no puede ser negativo.");
            } else {
                double total = precio * 1.15;
                System.out.println("Precio final + IVA (15%): " + total);
            }

        } catch (Exception e) {
            System.out.println("ERROR: Ingrese un número válido.");
        }

        System.out.println("Programa finalizado.");
    }
}
