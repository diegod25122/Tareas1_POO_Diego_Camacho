import java.util.ArrayList;
import java.util.Scanner;

public class Evento {
    private String nombreEvento;
    private String fecha;
    private ArrayList<Participante> participantes;
    private Scanner scanner;

    public Evento(String nombreEvento, String fecha) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.participantes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void registrarParticipante(Participante participante){
        participantes.add(participante);
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }
}