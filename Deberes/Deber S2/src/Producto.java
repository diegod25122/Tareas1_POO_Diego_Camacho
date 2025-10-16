//Indicaciones:
//1.	Explica con tus propias palabras qué es un constructor.
//2.	Crea una clase llamada Producto con tres atributos: nombre, precio, cantidad.
//3.	Implementa los tres tipos de constructores: uno con parámetros, uno con valores fijos, y uno vacío.
//4.	Crea tres objetos usando cada tipo de constructor.
//5.	Muestra los datos de cada objeto en consola.
public class Producto {
    String nombre;
    Double precio;
    int cantidad;
    //constructor con parametros
    public Producto(String nombre, Double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    //constructor sin parametros valores quemados
    public Producto(){
        nombre = "Galletas";
        precio = 10.00;
        cantidad = 50;
    }
    //constructor vacio
    public Producto(String n){
        nombre = n;
    }
    //mostrar objeots
    public void mostrar(){
        System.out.println("Nombre: "+nombre+ " precio: "+precio+" cantidad: "+cantidad);
    }
    //main
    public static void main(String[] args) {
        Producto producto1 = new Producto("Manzana",0.5, 10);
        producto1.mostrar();
        Producto producto2 = new Producto();
        producto2.mostrar();
        Producto producto3 = new Producto("Chupete");
        producto3.mostrar();
    }
}
