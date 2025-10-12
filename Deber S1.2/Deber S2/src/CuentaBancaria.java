//6.	Crear la clase CuentaBancaria con los siguientes atributos privados:
//-	nombreTitular (String)
//-	saldo (double)
//7.	Crear un constructor público que permita inicializar los datos del titular y el saldo inicial.
//8.	Implementar los siguientes métodos propios públicos:
//-	mostrarInformacion(): Muestra el nombre del titular y el saldo actual.
//-	depositar(double monto): Aumenta el saldo.
//-	retirar(double monto): Disminuye el saldo si hay suficiente dinero.
//9.	En la clase principal (Main):
//-	Crear un objeto de tipo CuentaBancaria.
//-	Llamar a los tres métodos en orden lógico.
//-	Mostrar cómo se reutiliza la información del objeto en cada acción.
public class CuentaBancaria {
    private String nombreTitular;
    private Double saldo;
    //Constructor
    public CuentaBancaria(String nombre, Double saldoInicial){
        nombreTitular = nombre;
        saldo = saldoInicial;
    }
    //metodos propios
    public void mostrar(){
        System.out.println("Titular: "+nombreTitular);
        System.out.println("Saldo actual: $"+saldo);
    }
    public void depositar(Double deposito){
        saldo = saldo + deposito;
        System.out.println("Deposito de $"+deposito+" realizado correctamente");
    }
    public void retirar(Double retiro){
        if  (saldo >= retiro){
            saldo = saldo - retiro;
            System.out.println("Retiro de $"+retiro+" realizado correctamente");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    //clase principal
    public static void main(String[]args){
        CuentaBancaria cuenta1 =  new CuentaBancaria("Diego", 128.0);
        cuenta1.mostrar();
        cuenta1.depositar(250.0);
        cuenta1.retirar(157.0);
    }
}
