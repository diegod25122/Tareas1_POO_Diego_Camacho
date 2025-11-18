import java.util.Scanner;
public abstract class Participante {
    protected String nombre;
    protected String identificacion;
    protected String fecha;
    protected String nacionalidad;
    protected Scanner scanner;

    //Constructor
    public Participante(String nombre, String identificacion, String fecha, String nacionalidad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.scanner = new Scanner(System.in);
    }
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    //Metodo abstracto
    public abstract String obtenerTipo();
}

//Clases hijas
class Atleta extends Participante{
    private String tipoDeporte;

    public Atleta(String nombre, String identificacion, String fecha, String nacionalidad, String tipoDeporte) {
        super(nombre, identificacion, fecha, nacionalidad);
        this.tipoDeporte = tipoDeporte;
    }
    //Metodo heredado de la clase abstracta
    @Override
    public String obtenerTipo(){
        return "El Atleta "+nombre+ " y de nacionalidad "+nacionalidad+ " practica el deporte de "+tipoDeporte;
    }
    public String getTipoDeporte() {
        return tipoDeporte;
    }
}
class Equipo extends Participante{
    private int numeroParticipantes;

    public  Equipo(String nombre, String identificacion, String fecha, String nacionalidad, int numeroParticipantes) {
        super(nombre, identificacion, fecha, nacionalidad);{
            this.numeroParticipantes = numeroParticipantes;
        }
    }
    @Override
    public String obtenerTipo(){
        return"El equipo "+nombre+ " es de nacionalidad "+ nacionalidad;

    }
    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

}