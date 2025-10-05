// Ejercicio 3: Tabla de multiplicar
//•	Lee un número del 1 al 10.
//•	Imprime su tabla de multiplicar usando for.
import java.util.Scanner;
public class Ejercicio3s1 {
    public  static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero del 1 al 10: ");
        numero = sc.nextInt();
        //validar que el numero ingresado este entre 1 y 10
        if(numero<1 || numero>10){
            System.out.println("Numero fuera de rango: ");
        }else{
            System.out.println("Tabla de "+numero);
            //usamos bucle for para realizar la tabla de multiplicacion
            for (int i=1;i<=10;i++){
                System.out.println(numero+" * " +i+ " = " +numero*i);

            }
        }
    }
}
