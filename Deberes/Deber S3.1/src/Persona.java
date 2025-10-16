//aplicar correctamente get y set
import java.util.Scanner;
//1. Crea una clase llamada Persona.
//2. Declara los atributos nombre, edad y profesion como privados.
//3. Crea los métodos setNombre(String), setEdad(int), setProfesion(String) y sus respectivos get.
//   - setNombre debe verificar que el nombre no esté vacío.
//   - setEdad solo acepta valores mayores que 0.
//4. En el main, crea un objeto Persona, prueba asignando valores correctos e incorrectos.
//5. Muestra los resultados con System.out.println.
public class Persona {
    private String nombre;
    private int edad;
    private String profesion;
    //constructor
    public Persona(String nombre, int edad , String profesion) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }
    //creamos los metodos
    //metodos set y validaciones
    public void setNombre(String nuevoNombre){
        if (nuevoNombre !=null && !nuevoNombre.trim().isEmpty()){// validamos que nuevo nombre no este vacio
            // .trim() elimina los caracteres vacios al inicio y final
            this.nombre = nuevoNombre;
        }else{
            System.out.println("El nombre no puede estar vacio");
        }
    }
    public void setEdad(int nuevaEdad){
        if (nuevaEdad > 0) {
            this.edad = nuevaEdad;
        }else{
            System.out.println("La edad debe ser mayor a 0");
        }
    }
    public void setProfesion(String nuevaProfesion){
        this.profesion = nuevaProfesion;
    }
    //creamos metodos get
    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getProfesion(){
        return this.profesion;
    }
    //creamos el main
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Persona persona1= new Persona("Mateo",18,"Futbolista");


        System.out.println("Nombre: "+persona1.getNombre());
        System.out.println("Edad: "+persona1.getEdad());
        System.out.println("Profesion: "+persona1.getProfesion());
        System.out.println("Valores incorrectos");
        persona1.setNombre("");
        persona1.setEdad(-7);
        persona1.setProfesion("Futbolista");
    }
}