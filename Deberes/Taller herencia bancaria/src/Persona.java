public abstract class Persona {
    private String nombre;
    private  String cedula;
    private String direccion;
    private String telefono;
    public Persona (String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void actualizarDatos(String nuevaDireccion, String nuevoTelefono) {
        this.direccion = nuevaDireccion;
        this.telefono = nuevoTelefono;
        System.out.println("Datos actualizados correctamente.");
    }
    public abstract void mostrarRol();
}
class Cliente extends Persona {

    private String tipoCuenta;
    private Cuenta cuenta;                 // Una sola cuenta
    private TarjetaCredito tarjetaCredito; // Una sola tarjeta

    public Cliente(String nombre, String cedula, String direccion, String telefono, String tipoCuenta) {
        super(nombre, cedula, direccion, telefono);
        this.tipoCuenta = tipoCuenta;
    }

    // Getter y setter de tipoCuenta
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    // Implementación del método abstracto
    @Override
    public void mostrarRol() {
        System.out.println("Soy un Cliente bancario.");
    }

    public boolean ingresarAlSistema() {
        System.out.println("Cliente ingresó al sistema.");
        return true;
    }

    public void registrarCuenta(String tipo) {
        this.cuenta = new Cuenta(tipo);
        System.out.println("Cuenta creada del tipo: " + tipo);
    }

    public void solicitarPrestamo(double monto) {
        System.out.println("Solicitud de préstamo enviada. Monto: $" + monto);
    }

    public void agregarTarjetaCredito(TarjetaCredito tarjeta) {
        this.tarjetaCredito = tarjeta;
        System.out.println("Tarjeta de crédito agregada.");
    }

    public void verResumenFinanciero() {
        System.out.println("\n===== Resumen Financiero =====");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Tipo de Cuenta: " + tipoCuenta);

        if (cuenta != null) {
            System.out.println("Cuenta registrada: " + cuenta.getTipo());
        } else {
            System.out.println("No tiene cuenta registrada.");
        }

        if (tarjetaCredito != null) {
            System.out.println("Tarjeta de crédito registrada.");
        } else {
            System.out.println("No tiene tarjeta de crédito.");
        }
    }
    public void cerrarCuenta() {
        if (this.cuenta != null) {
            this.cuenta = null;
            System.out.println("La cuenta ha sido cerrada con éxito.");
        } else {
            System.out.println("El cliente no tiene ninguna cuenta activa.");
        }
    }

}

class Empleado extends Persona {
    private String usuario;
    private String clave;
    public Empleado(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono);
        this.usuario = usuario;
        this.clave = clave;
    }
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Empleado");
    }
    public boolean autenticarEmpleado(String usuario, String clave) {
        return this.usuario.equals(usuario) && this.clave.equals(clave);
    }
    public void crearCuentaParaCliente(Cliente cliente, String tipo){
        cliente.registrarCuenta(tipo);
    }
    public void modificarDatosCliente(Cliente cliente){
        cliente.actualizarDatos("Quito","0987456123");
    }
    public void registrarPrestamo(Cliente cliente, double monto){
        cliente.solicitarPrestamo(monto);
    }
    public void cerrarCuenta(Cliente cliente){
        cliente.cerrarCuenta();
    }

}
//cajero
class Cajero extends Empleado {
    public Cajero(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cajero");
    }
    public void procersarRetiro(Cliente cliente, double monto){
        System.out.println("Retiro procesado para: "+getNombre() + "por $"+monto);
    }
    public void consultarSaldo(Cliente cliente){
        System.out.println("Consultando saldo del cliente: "+cliente.getNombre());
        System.out.println("Saldo: ");
    }
    public void procesarDeposito(Cliente cliente, double monto){
        System.out.println("Deposito procesado para: "+getNombre() + "por $"+monto);
    }
}
class BalconServicios extends Empleado {

    public BalconServicios(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Balcón de Servicios");
    }

    public Cliente registrarNuevoCliente() {
        System.out.println("Registrando nuevo cliente...");
        return new Cliente("Cliente Nuevo", "0000000000", "Sin dirección", "0000000000", "Ahorros");
    }

    public void actualizarDatosCliente(Cliente cliente) {
        cliente.actualizarDatos("Dirección actualizada por Balcón", "0999999999");
        System.out.println("Datos actualizados para: " + cliente.getNombre());
    }
}
class JefeAgencia extends Empleado {

    public JefeAgencia(String nombre, String cedula, String direccion, String telefono, String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Jefe de Agencia");
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {
        System.out.println("Evaluando préstamo para " + cliente.getNombre() + "...");
        boolean aprobado = monto <= 5000; // Regla simple para demo
        System.out.println(aprobado ? "Préstamo aprobado." : "Préstamo rechazado.");
        return aprobado;
    }

    public void generarReporteOperaciones() {
        System.out.println("Generando reporte general de operaciones del día...");
    }

    public void evaluarEmpleado(Empleado empleado) {
        System.out.println("Evaluando desempeño del empleado: " + empleado.getNombre());
    }
}

//clases para crear cuenta y tarjeta de credito

class Cuenta {
    private String tipo;

    public Cuenta(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

class TarjetaCredito {
    private String numero;

    public TarjetaCredito(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}


