//1. Cambia los atributos a privados.
//2. Corrige los nombres de los métodos a getNombre() y setPrecio(double).
//3. Valida que el precio sea mayor a 0.
//4. Crea un método que muestre toda la info del producto
//5. En el main, crea un objeto Producto y prueba con precios válidos e inválidos.

public class Producto {
    private double precio;
    private String nombre;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    //metodos set
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    public void setPrecio(double nuevoPrecio) {
        if(nuevoPrecio > 0) {
            this.precio = nuevoPrecio;
        }else{
            System.out.println("El precio no puede ser negativo");
        }
    }
    //metodos get
    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){
        return this.precio;
    }
    //mostrar info
    public void mostrar(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);

    }
    //main
    public static void main(String[] args){
        Producto producto1 = new Producto("Galletas", 15.15);
        producto1.mostrar();
        System.out.println("Datos errados");
        producto1.setPrecio(-0.2);
        producto1.setPrecio(0.0);
    }
}


