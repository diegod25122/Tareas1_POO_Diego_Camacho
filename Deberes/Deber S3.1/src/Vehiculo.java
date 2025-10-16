public class Vehiculo {
    public String marca;
    private String modelo;
    private int velocidadMax;
    private int codigoSeguridad;
    private String color;
    //constructor que asigne velocidad
    public Vehiculo(int velocidadMax){
        this.velocidadMax = velocidadMax;
    }
    // get y set modelo
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return this.modelo;
    }
    //get velocidadMax
    public int getVelocidadMax(){
        return this.velocidadMax;
    }
    //get codigo de seguridad
    public int getCodigoSeguridad(){
        return this.codigoSeguridad;
    }
    //get y set color
    public void setColor(String color){
        if (color.equalsIgnoreCase("red") ||
            color.equalsIgnoreCase("blue") ||
            color.equalsIgnoreCase("blanco")){
            this.color = color;
        }else {
            System.out.println("Color invalido");
        }
    }
    public String getColor(){
        return this.color;
    }
    //mostramos datos validos
    public void mostrar(){
        System.out.println("Marca: "+this.marca);
        System.out.println("Modelo: "+this.modelo);
        System.out.println("Velocidad max: "+this.velocidadMax);
        System.out.println("Codigo seguridad oculto por seguridad");
    }
    //main
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo(220);
        v1.marca="Chevrolet";
        v1.modelo="Aveo Emotion";
        v1.setColor("rojo");
        v1.setColor("verde");  //color invalido
        System.out.println("Datos");
        v1.mostrar();

    }
}
