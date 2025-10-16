//Ejercicio 2: Números pares
//•	Pregunta cuántos números se van a ingresar.
//•	Usa un for para leer cada número.
//•	Muestra cuántos números pares se ingresaron.
import java.util.Scanner;
public class Ejercicio2S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ingresar;
        int numeros;
        int contador=0;
        System.out.print("Cuantos numeros desea ingresar: ");
        ingresar = sc.nextInt();
        //usamos un  bucle para que el usuario ingrese por consola
        for (int i = 1; i <= ingresar; i++) {
            System.out.println("Ingrese el "+i+ " numero: ");
            numeros = sc.nextInt();
            if (numeros%2==0){
                //inicializamos el contador para que poder saber cuantos pares se ingresaron
                contador = contador+1;
            }
        }
        System.out.println("Se han ingresado: "+contador+" numeros pares");
        sc.close();
    }

}
