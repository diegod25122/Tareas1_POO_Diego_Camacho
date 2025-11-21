class DatoInvalidoException extends Exception {
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

abstract class Dispositivo {
    private String marca;
    private String modelo;
    private double precio;

    // Constructor con validaciones
    public Dispositivo(String marca, String modelo, double precio) throws DatoInvalidoException {

        if (marca == null || marca.trim().isEmpty()) {
            throw new DatoInvalidoException("La marca no puede estar vacía.");
        }
        if (precio < 0) {
            throw new DatoInvalidoException("El precio no puede ser negativo.");
        }

        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    // GETTERS Y SETTERS CON VALIDACIÓN
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws DatoInvalidoException {
        if (marca.trim().isEmpty()) {
            throw new DatoInvalidoException("La marca no puede estar vacía.");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws DatoInvalidoException {
        if (precio < 0) {
            throw new DatoInvalidoException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    // MÉTODO POLIMÓRFICO
    public void mostrarInfo() {
        System.out.println("Dispositivo genérico.");
    }
}
class Laptop extends Dispositivo {

    private int ram;

    public Laptop(String marca, String modelo, double precio, int ram) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.ram = ram;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\nLAPTOP");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("RAM: " + ram + " GB");
    }
}
class Telefono extends Dispositivo {

    private String sistemaOperativo;

    public Telefono(String marca, String modelo, double precio, String sistemaOperativo) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\nTELÉFONO");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Sistema Operativo: " + sistemaOperativo);
    }
}
