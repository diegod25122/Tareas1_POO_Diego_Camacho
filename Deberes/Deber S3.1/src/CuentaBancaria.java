public class CuentaBancaria {
    private double saldo = 0;
    private String titular ;
    //metodo depositar
    public void depositar(double monto){
        if(monto>0){
            saldo=saldo+monto;
            System.out.println("Deposito Exitoso: "+saldo);
        }else{
            System.out.println("El monto debe ser positivo");
        }
    }
    //metodo para retirar
    public void retirar(double monto){
        if (monto<saldo && monto > 0){
            saldo=saldo-monto;
            System.out.println("Retiro Exitoso: "+saldo);
        }else if (monto<=0){
            System.out.println("El monto debe ser positivo");
        }else{
            System.out.println("Error, saldo insuficiente :)");
        }
    }
    //metodo get
    public double getSaldo(){
        return saldo;
    }
    //main de prueba
    public static void main(String[]args){
        CuentaBancaria cB = new CuentaBancaria();
        cB.depositar(500);
        cB.retirar(100);
        System.out.println("Retiro mayor al saldo");
        cB.retirar(500);
        System.out.println("deposito negativo");
        cB.depositar(-500);
        System.out.println("saldo final");
        System.out.println("Saldo final: "+cB.getSaldo());
    }
}
