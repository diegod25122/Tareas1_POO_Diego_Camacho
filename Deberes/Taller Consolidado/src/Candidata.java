//excepcion personalizada
class DatosInvalidoException extends Exception{
    public DatosInvalidoException(String mensaje){
        super(mensaje);
    }
}

abstract class Candidata {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String distrito;
    protected double puntajeJurado;
    protected int votos;
    // constructor
    public Candidata(int id, String nombre, int edad, String distrito, double puntajeJurado) throws DatosInvalidoException{
        //excepciones personalizadas
        if(id<=0){
            throw new DatosInvalidoException("El id debe ser mayor a 0");
        }
        if (nombre.trim().isEmpty()){
            throw new DatosInvalidoException("El nombre del candidata es invalido");
        }
        if(edad<16||edad>90){
            throw new DatosInvalidoException("No cumple con el minimo de edad (16).");
        }
        if(distrito.trim().isEmpty()){
            throw new DatosInvalidoException("El distrito es invalido");
        }
        if(puntajeJurado<0){
            throw new DatosInvalidoException("El puntaje de jurado es invalido");

        }
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.distrito = distrito;
        this.puntajeJurado = puntajeJurado;
    }
    //getters && setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDistrito() {
        return distrito;
    }
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public double getPuntajeJurado() {
        return puntajeJurado;
    }
    public void setPuntajeJurado(double puntajeJurado) {
        this.puntajeJurado = puntajeJurado;
    }
    public int getVotos() {
        return votos;
    }
    public void setVotos() {
        this.votos= this.votos + 1;
    }
    public abstract void mostrarDetalles();
}
// crear clase hijas
class CandidataEstudiante extends Candidata{
    String universidad;
    String carrera;
    public CandidataEstudiante(int id, String nombre, int edad, String distrito, double puntajeJurado,String universidad, String carrera) throws DatosInvalidoException{
        super(id,nombre,edad,distrito,puntajeJurado);
        this.universidad = universidad;
        this.carrera = carrera;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("=== Candidata Estudiante ===");
        System.out.println("ID: "+getId());
        System.out.println("Nombre: " +getNombre());
        System.out.println("Edad: "+getEdad());
        System.out.println("Distrito: "+getDistrito());
        System.out.println("Puntaje Jurado: "+getPuntajeJurado());
        System.out.println("Universidad: "+universidad);
        System.out.println("Carrera: "+carrera);
    }
}
// segunda clase hija
class CandidataProfesional extends Candidata{
    String profesion;
    int aniosExperiencia;
    //constructor
    public CandidataProfesional (int id, String nombre, int edad, String distrito, double puntajeJurado,String profesion, int aniosExperiencia)throws DatosInvalidoException{
        super(id,nombre,edad,distrito,puntajeJurado);
        this.profesion = profesion;
        this.aniosExperiencia = aniosExperiencia;
    }
    //sobreescribimos
    @Override
    public void mostrarDetalles(){
        System.out.println("=== Candidata Profesional ===");
        System.out.println("ID: "+getId());
        System.out.println("Nombre: " +getNombre());
        System.out.println("Edad: "+getEdad());
        System.out.println("Distrito: "+getDistrito());
        System.out.println("Puntaje Jurado: "+getPuntajeJurado());
        System.out.println("Profesion: "+profesion);
        System.out.println("Años de Experiencia: "+aniosExperiencia);
    }
}