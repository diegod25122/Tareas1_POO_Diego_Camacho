import java.util.Scanner;
//Ejercicio 1: Registro de inventarios de plásticos
//Objetivo: Registrar producto plástico y calcular valor total de stock.
public class Ejercicio1 {
    public static void main(String [] agres){
        Scanner ingresarProductos = new Scanner(System.in);
        System.out.println("Cuantos productos desea ingresar?: ");
        int cantidadProductos= ingresarProductos.nextInt();
        ingresarProductos.nextLine(); //limpia el buffer

        double totalInventario= 0;

        for (int i=1; i<= cantidadProductos; i++){
            System.out.println("Nombre del producto: ");
            String nombreProducto = ingresarProductos.nextLine();

            System.out.println("Cantidad del producto: ");
            int cantidad = ingresarProductos.nextInt();
            ingresarProductos.nextLine(); //limpiar buffer y evita que se salte pregunats
            System.out.println("Precio del producto: ");
            double precio = ingresarProductos.nextDouble();
            ingresarProductos.nextLine(); //limpia el buffer
            double valor = cantidad*precio;

            totalInventario = totalInventario+valor;
        }
        System.out.println("El total del inventario es: "+totalInventario);
    }
}

