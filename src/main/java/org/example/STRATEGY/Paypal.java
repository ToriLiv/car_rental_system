package org.example.STRATEGY;

import org.example.INTERFACES.MetodoPago;

public class Paypal implements MetodoPago {

    @Override
    public void pagar(double monto) {
        System.out.println("================================================");
        System.out.println("Pagando " + monto + " con PayPal");
    }
}
