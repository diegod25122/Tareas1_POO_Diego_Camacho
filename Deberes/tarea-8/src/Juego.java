import java.util.Scanner;
import java.util.ArrayList;
//MENSAJE PERSONALIZADO
class datosInvalidos extends Exception{
    public datosInvalidos(String mensaje){
        super(mensaje);
    }
}
abstract class Juego {
   protected String nombre;
   protected double precio;
   // clase
    public Juego(String nombre, double precio) throws datosInvalidos {
        if(nombre==null||nombre.trim().isEmpty()){
            throw new datosInvalidos("El nombre es obligatorio");
        }
        if(precio<=0){
            throw new datosInvalidos("El precio debe ser mayor a 0");
        }
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public abstract void mostrarDetalles() ;
}

// clase hija mario bros
class MarioBros extends Juego {
    private ArrayList<String> mundos;
    public MarioBros(String nombre, double precio) throws datosInvalidos {
        super(nombre,precio);
        this.mundos = new ArrayList<>();
    }
    public void agregarMundo(String mundo){
        mundos.add(mundo);
    }
    @Override
    public void mostrarDetalles() {
        System.out.println("\nJUEGO MARIO BROS");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Mundos: " + mundos);
    }
}

// clase hija carrera vehiculos
class CarreraVehiculos extends Juego {
    private ArrayList<String> vehiculos;

    public CarreraVehiculos(String nombre, double precio) throws datosInvalidos {
        super(nombre, precio);
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(String vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\nJUEGO DE CARRERAS");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Vehículos: " + vehiculos);
    }
}