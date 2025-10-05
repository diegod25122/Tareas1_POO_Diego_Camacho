// Ejercicio 1: Notas del estudiante
//•	Pide el nombre del estudiante.
//•	Solicita tres notas (double).
//•	Calcula el promedio.
//•	Muestra si aprueba (>=7) o reprueba.
import java.util.Scanner;
//deber
public class Ejercicio1S1{
    public static void main(String[] args) {
        String nombre;
        double n1,n2,n3;
        double promedio;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante: ");
        nombre = sc.nextLine();
        System.out.println("Ingrese sus notas en una escala de 0 a 10: ");
        System.out.println("Ingrese la primera nota: ");
        n1 = sc.nextDouble();
        System.out.println("Ingrese la segunda nota: ");
        n2 = sc.nextDouble();
        System.out.println("Ingrese la tercera nota: ");
        n3 = sc.nextDouble();
        promedio = (n1 + n2 + n3)/3;
        System.out.println("El promedio del estudiante es: "+promedio);

        if (promedio>=7){
            System.out.println("El estudiante: "+nombre+" aprobo con un promedio de "+promedio);
        }else{
            System.out.println("El estudiante: "+nombre+" reprobo con un promedio de "+promedio);
        }

    }

}