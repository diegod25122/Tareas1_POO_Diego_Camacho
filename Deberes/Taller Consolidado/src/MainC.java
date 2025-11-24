import java.lang.foreign.PaddingLayout;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class MainC{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Candidata>listaCandidatas =new ArrayList<>();
    public static void main(String[] args) {
        //o	Registrar candidata.
        //o	Listar todas.
        //o	Buscar por nombre/id.
        //o	Filtrar por tipo/distrito.
        //o	Simular voto / registrar voto manual.
        //o	Mostrar resultados y ganador.
        //o	Salir.
        int option = 0;
        do{
            System.out.println("================= Sistema de Gestion de Elecciones =================");
            System.out.println("1. Registrar Candidata.");
            System.out.println("2. Listar Candidata.");
            System.out.println("3. Buscar por nombre/ID.");
            System.out.println("4. Filtrar por tipo/distrito.");
            System.out.println("5. Simular voto / registrar voto manual.");
            System.out.println("6. Mostrar resultados y ganado.");
            System.out.println("7. Eliminar candidata.");
            System.out.println("8. Editar candidata.");
            System.out.println("9. Salir");
            System.out.println("Ingrese una opcion: ");
            String entradaOpcion= sc.nextLine();
            try{
                if(entradaOpcion.trim().isEmpty()){
                    throw new DatosInvalidoException("No puede dejar vacio la opcion.");
                }
                option = Integer.parseInt(entradaOpcion);
            }catch(DatosInvalidoException ex){
                System.out.println("Error. "+ex.getMessage());
                continue;
            }catch(NumberFormatException ex){
                System.out.println("Error ingrese solo numeros");
                continue;
            }
            try{
                switch (option){
                    case 1:
                        //metodo para registrar candidatas
                        registrarCandidatas();
                        break;
                    case 2:
                        //Metodo para listar candidatas
                        listarCandidatas();
                        break;
                    case 3:
                        //metodo para buscar
                        buscarCandidata();
                        break;
                    case 4:
                        //metodo para filtrar tipo
                        filtrarCandidata();
                        break;
                    case 5:
                        //Metodo para simular votos
                        simularVotos();
                        break;
                    case 6:
                        // Mostrar resultados
                        mostrarResultados();
                        break;
                    case 7:
                        eliminarCandidata();
                        break;
                    case 8:
                        editarCandidata();
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        throw new DatosInvalidoException("Ingresa un numero valido");
                }
            }catch(DatosInvalidoException ex){
                System.out.println("Error. "+ex.getMessage());
            }
        }while(option!=9);
    }
    static void registrarCandidatas(){
        try{
            System.out.println("=== Registro de Candidatas ===");
            System.out.println("Ingrese el ID de la candidata: ");
            String entradaID = sc.nextLine();
            if(entradaID.trim().isEmpty()){
                throw new DatosInvalidoException("No puede dejar vacio la ID.");
            }
            int Id;
            try{
                Id =Integer.parseInt(entradaID);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros.");

            }
            System.out.println("Ingrese el nombre de la candidata: ");
            String Nombre = sc.nextLine();
            if(Nombre.trim().isEmpty()){
                throw new DatosInvalidoException("El nombre no puede estar vacio.");
            }
            System.out.println("Ingrese la edad de la candidata: ");
            String entradaEdad = sc.nextLine();
            if(entradaEdad.trim().isEmpty()){
                throw new DatosInvalidoException("La edad no puede estar vacio.");
            }
            int Edad;
            try{
                Edad = Integer.parseInt(entradaEdad);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros.");
            }
            System.out.println("Ingrese el distrito de la candidata: ");
            String distrito = sc.nextLine();
            if (distrito.trim().isEmpty()){
                throw new DatosInvalidoException("El distrito no puede estar vacio.");
            }
            System.out.println("Ingrese el puntaje del jurado: ");
            String puntajeEntrada = sc.nextLine();
            if (puntajeEntrada.trim().isEmpty()){
                throw new DatosInvalidoException("El puntaje no puede estar vacio");
            }
            double puntajeJurado;
            try{
                puntajeJurado = Double.parseDouble(puntajeEntrada);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("El puntaje debe ser un numero.");
            }
            //
            System.out.println("Ingrese el tipo de candidata: ");
            System.out.println("1. Estudiante.");
            System.out.println("2. Profesional.");
            System.out.println("Elija una opcion: ");
            String opcion =  sc.nextLine();
            if(opcion.trim().isEmpty()){
                throw new DatosInvalidoException("Opcion no puede estar vacio.");
            }
            int option;
            try{
                option = Integer.parseInt(opcion);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Opcion no puede estar vacio.");
            }
            //creamos el objeto
            Candidata nueva;
            if(option==1){
                System.out.println("Universidad: ");
                String universidad = sc.nextLine();
                System.out.println("Carrera: ");
                String carrera = sc.nextLine();
                if(universidad.trim().isEmpty()||carrera.trim().isEmpty()){
                    throw new DatosInvalidoException("No debe dejar ningun campo vacio.");
                }
                nueva = new CandidataEstudiante(Id, Nombre, Edad, distrito, puntajeJurado, universidad, carrera);
                System.out.println("Candidata agregada exitosamente.");
                listaCandidatas.add(nueva);
            }else if(option==2){
                System.out.println("Profesion: ");
                String profesion = sc.nextLine();
                System.out.println("Experiencia (anños) : ");
                String anios = sc.nextLine();
                if(profesion.trim().isEmpty()||anios.trim().isEmpty()){
                    throw new DatosInvalidoException("No debe dejar ningun campo vacio.");
                }
                int Anios;
                try{
                    Anios = Integer.parseInt(anios);
                }catch(NumberFormatException ex){
                    throw new DatosInvalidoException("Ingrese solo numeros.");
                }
                nueva = new CandidataProfesional(Id, Nombre, Edad, distrito, puntajeJurado, profesion, Anios);
                System.out.println("Candidata agregada exitosamente.");
                listaCandidatas.add(nueva);
            }else{
                System.out.println("Opcion incorrecta");
            }


        }catch(DatosInvalidoException ex){
            System.out.println("Error. "+ex.getMessage());
        }
    }
    static void listarCandidatas(){
        if(listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        System.out.println("=== Candidatas registradas ===");
        for (Candidata c:listaCandidatas) {
            c.mostrarDetalles();
            System.out.println("-----------------------------");
        }
    }
    static void buscarCandidata(){
        if (listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        try{
            System.out.println("=== Buscar Candidatas ===");
            System.out.println("1. Nombre.");
            System.out.println("2. ID.");
            String buscar = sc.nextLine();
            if (buscar.trim().isEmpty()){
                throw new DatosInvalidoException("NO debe dejar vacio el campo.");
            }
            int buscarCandidata;
            try {
                buscarCandidata = Integer.parseInt(buscar);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros");
            }
            switch (buscarCandidata) {
                case 1:
                    System.out.println("Ingrese el nombre de la candidata: ");
                    String nombre = sc.nextLine();
                    if(nombre.trim().isEmpty()){
                        throw new DatosInvalidoException("EL nombre no puede estar vacio");
                    }
                    boolean encontrarPorNombre = false;
                    for (Candidata c:listaCandidatas) {
                        if (c.getNombre().equals(nombre)) {
                            c.mostrarDetalles();
                            System.out.println("-----------------------");
                            encontrarPorNombre = true;

                        }
                    }

                    if(!encontrarPorNombre){
                        System.out.println("No se encontraron candidatas con el nombre : "+nombre);
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el ID de la candidata: ");
                    String idCandidata = sc.nextLine();
                    if(idCandidata.trim().isEmpty()){
                        System.out.println("No puede dejar vacio el campo.");
                    }
                    int id;
                    try {
                        id = Integer.parseInt(idCandidata);
                    }catch(NumberFormatException ex){
                        throw new DatosInvalidoException("Ingrese solo numeros");
                    }

                    boolean encontrarPorId= false;
                    for(Candidata c: listaCandidatas){
                        if(c.getId()==id){
                            c.mostrarDetalles();
                            System.out.println("-----------------------");
                            encontrarPorId = true;
                        }
                    }
                    if(!encontrarPorId){
                        System.out.println("No se encontraron candidatas con el id: "+id);
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");

            }
        }catch (DatosInvalidoException ex){
            System.out.println("Error. "+ex.getMessage());
        }
    }
    static void filtrarCandidata(){
        if (listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        try{
            System.out.println("=== Filtrar Candidatas ===");
            System.out.println("1. Filtrar por Estudiante.");
            System.out.println("2. Filtrar por Profesional.");
            System.out.println("3. Filtrar por Distrito.");
            String filtrar = sc.nextLine();
            if (filtrar.trim().isEmpty()){
                throw new DatosInvalidoException("No ouede dejar la opcion vacia");
            }
            int filtrarCandidata;
            try {
                filtrarCandidata = Integer.parseInt(filtrar);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros");
            }
            boolean encontrarPorEstudiante = false;
            switch(filtrarCandidata){
                case 1:
                    System.out.println("=== Candidatas estudiantes ===");
                    for(Candidata c:listaCandidatas){
                        if(c instanceof CandidataEstudiante){
                            c.mostrarDetalles();
                            System.out.println("-----------------------");
                            encontrarPorEstudiante = true;
                        }
                    }
                    if (!encontrarPorEstudiante){
                        System.out.println("No exixsten candidatas estudiantes");
                    }
                    break;
                case 2:
                    System.out.println("=== Candidatas profesionales ===");
                    boolean encontrarPorProfesional = false;
                    for(Candidata c:listaCandidatas){
                        if(c instanceof CandidataProfesional){
                            c.mostrarDetalles();
                            System.out.println("-----------------------");
                            encontrarPorProfesional = true;
                        }
                    }
                    if (!encontrarPorProfesional){
                        System.out.println("No exixsten candidatas profesionales");
                    }
                    break;
                case 3:
                    System.out.println("=== Candidatas por distritos ===");
                    System.out.println("Ingrese el distrito: ");
                    String distrito = sc.nextLine();
                    if(distrito.trim().isEmpty()){
                        System.out.println("No puede dejar vacio el distrito.");
                    }
                    boolean encontrarPorDistrito = false;
                    for(Candidata c:listaCandidatas){
                        if(c.getDistrito().equals(distrito)){
                            c.mostrarDetalles();
                            System.out.println("-----------------------");
                            encontrarPorDistrito = true;
                        }
                    }
                    if (!encontrarPorDistrito){
                        System.out.println("No exixsten candidatas por distritos");
                    }
                    break;
            }
        }catch(DatosInvalidoException ex){
            System.out.println("Error. "+ex.getMessage());
        }
    }

    static void simularVotos(){
        if(listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        // simulamos que cada candidata tenga de 0 a 100 votos
        Random random = new Random();
        System.out.println("=== Simular Votos ===");
        for(Candidata c:listaCandidatas){
            int votosSimulados = random.nextInt(101); // de 0 a 100
            for(int i=0;i<votosSimulados;i++){
                c.setVotos();
            }
            System.out.println(c.getNombre()+ " Recibio "+votosSimulados+" votos");
        }
        System.out.println("Simulacion completa");
    }
    static void mostrarResultados(){
        if(listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        System.out.println("=== Resultados de la Elección ===");
        // ordenamos por votos
        listaCandidatas.sort((a,b) ->b.getVotos() - a.getVotos());
        for(Candidata c:listaCandidatas){
            System.out.println("ID: "+c.getId()+
                    " | Nombre: "+c.getNombre()+
                    " | Votos: "+c.getVotos());
        }
        //ganadora
        Candidata ganadora = listaCandidatas.get(0);
        System.out.println("\n=== Ganadora ===");
        ganadora.mostrarDetalles();
        System.out.println("Total de votos: "+ganadora.getVotos());
    }
    static void eliminarCandidata(){
        if(listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        try{
            System.out.println("=== Eliminar Candidatas ===");
            System.out.println("Ingrese el Id de la candidata a eliminar: ");
            String idCandidata = sc.nextLine();
            if(idCandidata.trim().isEmpty()){
                throw new DatosInvalidoException("Esta dejando campos vacios");
            }
            int  id;
            try {
                id = Integer.parseInt(idCandidata);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros");
            }
            boolean eliminarporID= false;
            // eliminamos por indice
            for(int i = 0; i < listaCandidatas.size(); i++){
                if(listaCandidatas.get(i).getId() == id){
                    listaCandidatas.remove(i);
                    eliminarporID = true;
                    System.out.println("Candidata eliminada exitosamente");
                    break;
                }
            }
            if(!eliminarporID){
                System.out.println("No existe candidata con el id.");
            }

        }catch(DatosInvalidoException ex){
            System.out.println("Error. "+ex.getMessage());
        }

    }
    static void editarCandidata(){
        if(listaCandidatas.isEmpty()){
            System.out.println("No existen candidatas registradas.");
            return;
        }
        try{
            System.out.println("=== Editar Candidatas ===");
            System.out.println("Ingrese el Id de la candidata a editar: ");
            String idCandidata = sc.nextLine();
            if(idCandidata.trim().isEmpty()){
                throw new DatosInvalidoException("Esta dejando campos vacios");
            }
            int id;
            try {
                id = Integer.parseInt(idCandidata);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros");
            }
            Candidata c1 =null;
            //buscamos candidata
            for(Candidata c:listaCandidatas){
                if(c.getId() == id){
                    c1 = c;
                    break;
                }
            }
            if(c1 == null){
                System.out.println("No existe candidata con el id.");
            }
            //menu de edicion
            System.out.println("\n¿Qué desea editar?");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.println("3. Distrito");
            System.out.println("4. Puntaje del Jurado");
            System.out.print("Opción: ");
            String op = sc.nextLine();
            if(op.trim().isEmpty()){
                throw new DatosInvalidoException("Esta dejando campos vacios");
            }
            int opcion;
            try{
                opcion = Integer.parseInt(op);
            }catch(NumberFormatException ex){
                throw new DatosInvalidoException("Ingrese solo numeros");
            }
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    if(nombre.trim().isEmpty()){
                        throw  new DatosInvalidoException("El nombre no puede ser vacio");
                    }
                    c1.setNombre(nombre);
                    break;
                case 2:
                    System.out.println("Ingrese edad: ");
                    String edad = sc.nextLine();
                    if(edad.trim().isEmpty()){
                        throw new DatosInvalidoException("El edad no puede ser vacio");
                    }
                    int edad1 ;
                    try{
                        edad1 = Integer.parseInt(edad);
                    }catch(NumberFormatException ex){
                        throw new DatosInvalidoException("Ingrese solo numeros");
                    }
                    c1.setEdad(edad1);
                    break;
                case 3:
                    System.out.println("Ingrese distrito: ");
                    String distrito = sc.nextLine();
                    if(distrito.trim().isEmpty()){
                        throw new DatosInvalidoException("El distrito no puede ser vacio");
                    }
                    c1.setDistrito(distrito);
                    break;
                case 4:
                    System.out.println("Ingrese puntaje del Jurado: ");
                    String puntajeJurado = sc.nextLine();
                    if(puntajeJurado.trim().isEmpty()){
                        throw new DatosInvalidoException("Puntaje del Jurado no puede estar vacio");
                    }
                    double puntaje ;
                    try{
                        puntaje = Double.parseDouble(puntajeJurado);
                        c1.setPuntajeJurado(puntaje);
                    }catch(NumberFormatException ex){
                        throw new DatosInvalidoException("Ingrese solo numeros");
                    }

                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    return;
            }

        }catch(DatosInvalidoException ex){
            System.out.println("Error. "+ex.getMessage());
        }
    }
}