package org.example.STRATEGY;
import org.example.INTERFACES.MetodoPago;

/**
 * ===================================STRATEGY=============================
 * Representa un metodo de pago específico: Paypal.
 * Implementa la interfaz MetodoPago y define el comportamiento de pago.
 * ========================================================================
 */
public class Paypal implements MetodoPago {

    @Override
    public String toString() {
        return "Paypal";
    }

    @Override
    public void pagar(double monto) {
        System.out.println("===================================================================");
        System.out.println("Pagando " + monto + " con PayPal");
    }


}
