//Ejercicio 4 (opcional reto):
//•	Pide nombre, edad y altura.
//•	Si tiene más de 18 años y mide más de 1.60m, mostrar "Aceptado para el equipo".
//•	Si no, mostrar "No cumple los requisitos".
import java.util.Scanner;
public class Ejercicio4Reto {
    public static void main(String[] args) {
        //variables
        String nombre;
        int edad;
        double altura;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese el edad: ");
        edad = sc.nextInt();
        System.out.print("Ingrese el altura: ");
        altura = sc.nextDouble();
        //validamos la edad y la altura para aprobar al estudiante o no
        if (edad >= 18 && altura >= 1.60) {
            System.out.println(nombre+ " Aceptado para el equipo");
        }else{
            System.out.println(nombre+ " No puede ser aceptado en el equipo");
        }
        sc.close();
    }
}
