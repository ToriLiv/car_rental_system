package org.example.STRATEGY;

import org.example.INTERFACES.MetodoPago;

public class TarjetaCredito implements MetodoPago {

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando " + monto + " con Tarjeta de Crédito");
    }
}
