///Práctica 1: Clase Libro
/// Objetivo: Crear una clase con atributos, constructor y método para mostrar información.
/// Descripción:
/// •	Crear la clase Libro con atributos: titulo, autor, anioPublicacion.
/// •	Crear un constructor.
/// •	Crear un método mostrarInformacion() que imprima los datos del libro.
/// •	Crear 2 objetos de tipo Libro y mostrar su información.
public class Libro{
    String titulo;
    String autor;
    String anioPublicacion;
    //metodo constructor

    public Libro(String titulo, String autor, String anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }
    //imprimimos
    public void mostrar(){
        System.out.println(titulo);
        System.out.println(autor);
        System.out.println(anioPublicacion);
    }
    //objetos con funcion main
    public static void main(String[]args){
        Libro objeto1 = new Libro("Black Clover", "Yuki Tabata", "Febrero del 2015");
        Libro objeto2= new Libro("El principito", "Antoine de Saint-Exupéry", "1943");
        objeto1.mostrar();
        objeto2.mostrar();
    }
}