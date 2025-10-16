import java.util.Scanner;
//ejemplo Scanner
public class EjemploPractico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");

        String nombre = sc.nextLine();

        System.out.println("Hola " + nombre + "!");

        // if
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        if (edad >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }

        //for
        System.out.print("Ingrese un número del 1 al 10: ");
        int numero = sc.nextInt();


        if (numero >= 1 && numero <= 10) {
            System.out.println("Tabla del " + numero + ":");
            for (int i = 1; i <= 7; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
        } else {
            System.out.println("Número fuera de rango.");
        }
        sc.close();
    }
}

