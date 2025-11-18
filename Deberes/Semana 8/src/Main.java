// Clase principal con menú

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Olimpiada> olimpiadas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("\n=== Menu precios inmobiliarios ===");
            System.out.println("1. Crear nueva Olimpiada");
            System.out.println("2. Agregar Evento a Olimpiada");
            System.out.println("3. Registrar Atleta en Evento");
            System.out.println("4. Registrar Equipo en Evento");
            System.out.println("5. Consultar Olimpiadas y Eventos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();   // AHORA SÍ dentro del try
                scanner.nextLine();           // Limpiar buffer

                switch (opcion) {
                    case 1:
                        crearOlimpiada();
                        break;
                    case 2:
                        agregarEvento();
                        break;
                    case 3:
                        registrarAtleta();
                        break;
                    case 4:
                        registrarEquipo();
                        break;
                    case 5:
                        consultarInformacion();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (InputMismatchException e) {
                System.out.println(" ERROR: Debes ingresar un número.");
                scanner.nextLine(); // limpia lo escrito
            } catch (DatosInsuficientesException e) {
                System.out.println(" ERROR: " + e.getMessage());
            }

        } while (opcion != 6);
    }



    private static void crearOlimpiada() throws DatosInsuficientesException {
        System.out.print("Nombre de la Olimpiada: ");
        String nombre = scanner.nextLine();
        System.out.print("Año: ");
        String anio = scanner.nextLine();

        if (nombre.isEmpty() || anio.isEmpty()) {
            throw new DatosInsuficientesException("El nombre y año son obligatorios.");
        }

        olimpiadas.add(new Olimpiada(nombre, anio));
        System.out.println("✔ Olimpiada creada correctamente.");
    }



    private static void agregarEvento() throws DatosInsuficientesException {
        if (olimpiadas.isEmpty()) {
            throw new DatosInsuficientesException("No hay olimpiadas registradas.");
        }

        mostrarOlimpiadas();
        System.out.print("Seleccione olimpiada: ");

        int indice;
        try {
            indice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new DatosInsuficientesException("Debe seleccionar un número válido.");
        }

        if (indice < 0 || indice >= olimpiadas.size()) {
            throw new DatosInsuficientesException("Índice de olimpiada inválido.");
        }

        System.out.print("Nombre del evento: ");
        String nombreEvento = scanner.nextLine();
        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();

        if (nombreEvento.isEmpty() || fecha.isEmpty()) {
            throw new DatosInsuficientesException("Nombre y fecha son obligatorios.");
        }

        olimpiadas.get(indice).agregarEvento(new Evento(nombreEvento, fecha));
        System.out.println("✔ Evento agregado exitosamente.");
    }


    private static void registrarAtleta() throws DatosInsuficientesException {
        Evento evento = seleccionarEvento();

        System.out.print("Nombre del atleta: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Fecha de nacimiento: ");
        String fechaNac = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Deporte: ");
        String deporte = scanner.nextLine();

        if (nombre.isEmpty() || cedula.isEmpty() || fechaNac.isEmpty() ||
                nacionalidad.isEmpty() || deporte.isEmpty()) {
            throw new DatosInsuficientesException("Todos los campos son obligatorios.");
        }

        evento.registrarParticipante(new Atleta(nombre, cedula, fechaNac, nacionalidad, deporte));
        System.out.println("✔ Atleta registrado exitosamente.");
    }



    private static void registrarEquipo() throws DatosInsuficientesException {
        Evento evento = seleccionarEvento();

        System.out.print("Nombre del equipo: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula/Registro: ");
        String cedula = scanner.nextLine();
        System.out.print("Fecha de formación: ");
        String fechaNac = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        int integrantes;
        try {
            System.out.print("Número de integrantes: ");
            integrantes = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new DatosInsuficientesException("El número de integrantes debe ser un entero válido.");
        }

        if (nombre.isEmpty() || cedula.isEmpty() || fechaNac.isEmpty()
                || nacionalidad.isEmpty() || integrantes <= 0) {
            throw new DatosInsuficientesException("Todos los datos deben ser válidos.");
        }

        evento.registrarParticipante(new Equipo(nombre, cedula, fechaNac, nacionalidad, integrantes));
        System.out.println("✔ Equipo registrado exitosamente.");
    }


    private static Evento seleccionarEvento() throws DatosInsuficientesException {

        if (olimpiadas.isEmpty()) {
            throw new DatosInsuficientesException("No hay olimpiadas registradas.");
        }

        mostrarOlimpiadas();
        System.out.print("Seleccione olimpiada: ");

        int indiceOli;
        try {
            indiceOli = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new DatosInsuficientesException("Debe ingresar un número válido.");
        }

        if (indiceOli < 0 || indiceOli >= olimpiadas.size()) {
            throw new DatosInsuficientesException("Índice inválido.");
        }

        Olimpiada olimpiada = olimpiadas.get(indiceOli);

        if (olimpiada.getEventos().isEmpty()) {
            throw new DatosInsuficientesException("Esta olimpiada no tiene eventos.");
        }

        System.out.println("\nEventos:");
        for (int i = 0; i < olimpiada.getEventos().size(); i++) {
            System.out.println(i + ". " + olimpiada.getEventos().get(i).getNombreEvento());
        }

        System.out.print("Seleccione evento: ");

        int indiceEvento;
        try {
            indiceEvento = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new DatosInsuficientesException("Debe ingresar un número.");
        }

        if (indiceEvento < 0 || indiceEvento >= olimpiada.getEventos().size()) {
            throw new DatosInsuficientesException("Índice de evento inválido.");
        }

        return olimpiada.getEventos().get(indiceEvento);
    }


    private static void consultarInformacion() {
        if (olimpiadas.isEmpty()) {
            System.out.println("\nNo hay información registrada.");
            return;
        }

        System.out.println("\n=== INFORMACIÓN DE OLIMPIADAS ===");

        for (Olimpiada o : olimpiadas) {
            System.out.println("\nOlimpiada: " + o.getNombreOlimpiada() + " (" + o.getAnio() + ")");

            for (Evento e : o.getEventos()) {
                System.out.println("  Evento: " + e.getNombreEvento() + " - Fecha: " + e.getFecha());
                System.out.println("  Participantes:");

                for (Participante p : e.getParticipantes()) {
                    System.out.println("    - " + p.obtenerTipo());
                }
            }
        }
    }


    private static void mostrarOlimpiadas() {
        System.out.println("\nOlimpiadas disponibles:");
        for (int i = 0; i < olimpiadas.size(); i++) {
            System.out.println(i + ". " + olimpiadas.get(i).getNombreOlimpiada());
        }
    }
}
