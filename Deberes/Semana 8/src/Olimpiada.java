import java.util.ArrayList;
public class Olimpiada {
    private String nombreOlimpiada;
    private String anio;
    private ArrayList<Evento> eventos;

    public Olimpiada(String nombreOlimpiada, String anio) {
        this.nombreOlimpiada = nombreOlimpiada;
        this.anio = anio;
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public String getNombreOlimpiada() {
        return nombreOlimpiada;
    }

    public String getAnio() {
        return anio;
    }
}

// 6. Excepción personalizada
class DatosInsuficientesException extends Exception {
    public DatosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}