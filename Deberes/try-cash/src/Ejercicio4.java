import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el monto del pago: ");
            double pago = sc.nextDouble(); // error si escribe letra

            validarPago(pago);

            System.out.println("Pago procesado correctamente.");

        } catch (PagoInvalidoException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: Debe ingresar un número.");
        }
    }

    public static void validarPago(double pago) throws PagoInvalidoException {
        if (pago < 0) {
            throw new PagoInvalidoException("El pago no puede ser negativo.");
        }
        if (pago == 0) {
            throw new PagoInvalidoException("El pago no puede ser cero.");
        }
        if (pago > 5000) {
            throw new PagoInvalidoException("El pago no puede ser mayor a 5000.");
        }
    }

    // =============================
    //   SUBCLASE DE EXCEPCIÓN
    // =============================
    static class PagoInvalidoException extends Exception {
        public PagoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }
}
