//Ejercicio 2: Registro de clientes
//Objetivo: Capturar datos de un cliente y mostrar ficha.
//Entradas: cedula, nombres, telefono, email.
//Salida: Ficha en consola.
//Reglas: validar que los campos no estén vacíos.
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        String cedula, nombre, telefono, email = "";
        Scanner ingresarDatos = new Scanner(System.in);
        //validamos la entrada de la cedula

        while(true){
            System.out.println("Ingrese la cedula: ");
            cedula = ingresarDatos.nextLine();
            if(!cedula.trim().isEmpty() && cedula.length() >=10){ //.trim() elimina los espacios en blanco del inicio como del final,
            //. isEmpty() valida que no se ingrese texto vacio y ! funciona como un if not el .length lee los caracteres de lo que ingresa
                break;
            }else{
                System.out.println("Ingrese un numero de cedula valido :)");
            }
        }
        //validamos los nombres
        while(true){
            System.out.println("Ingrese el nombre: ");
            nombre = ingresarDatos.nextLine();
            if(!nombre.trim().isEmpty()){
                break;
            }else{
                System.out.println("Ingrese un nombre valido :)");
            }
        }
        //validamos telefono
        while(true){
            System.out.println("Ingrese el telefono: ");
            telefono = ingresarDatos.nextLine();
            if(!telefono.trim().isEmpty() && telefono.length()>=10){
                break;
            }else{
                System.out.println("Ingrese un numero de telefono valido :)");
            }
        }
        //validamos el email
        while(true){
            System.out.println("Ingrese el email: ");
            email = ingresarDatos.nextLine();
            if(!email.trim().isEmpty()){
                break;
            }else{
                System.out.println("Ingrese un email valido :)");
            }
        }
        System.out.println("----------------------\n");
        System.out.println("Datos del Cliente: \n");
        System.out.println("Nombre del Cliente: "+nombre+"\n");
        System.out.println("Cedula: "+cedula+"\n");
        System.out.println("Telefono: "+telefono+"\n");
        System.out.println("Email: "+email+"\n");
    }
}
