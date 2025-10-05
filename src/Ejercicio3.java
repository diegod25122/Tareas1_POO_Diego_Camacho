//Ejercicio 3: Requisitos para el cuartel
//Objetivo: Determinar si un estudiante cumple (≥18 años y altura ≥ 1.60 m).
//Entradas: edad (int), altura (double).
//Salida: “Cumple” o “No cumple”.
//Reglas: edad y altura deben ser positivas.
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
        String nombre = "";
        int edad = 0;
        double altura = 0.0;
        Scanner ingresarEstudiante = new Scanner(System.in);

        System.out.println("Ingrese el nombre del aspirante: ");
        nombre = ingresarEstudiante.nextLine();

        System.out.println("Ingrese la edad del estudiante: ");
        //validamos edades negativas
        while(true){
            edad= ingresarEstudiante.nextInt();
            ingresarEstudiante.nextLine();
            if(edad<=0 || edad > 100){
                System.out.println("Ingrese una edad valida");
            }else{
                break;
            }
        }
        //validamos altura
        System.out.println("Ingrese la altura del aspirante: ");
        while(true){
            altura= ingresarEstudiante.nextDouble();
            ingresarEstudiante.nextLine();
            if (altura <=0){
                System.out.println("Ingrese una altura valida");
            }else{
                break;
            }
        }
        //validamos si cumple o no
        if (edad>=18 && altura >=1.60){
            System.out.println("El aspirante: "+nombre+" cumple con los requisitos");
        }else{
            System.out.println("El aspirante: "+nombre+" no cumple con los requisitos");
        }

    }
}
