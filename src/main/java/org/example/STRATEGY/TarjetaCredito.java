package org.example.STRATEGY;
import org.example.INTERFACES.MetodoPago;

/**
 * ===================================STRATEGY=============================
 * Representa un metodo de pago específico: Tarjeta de Crédito.
 * Implementa la interfaz MetodoPago y define el comportamiento de pago.
 * ========================================================================
 */
public class TarjetaCredito implements MetodoPago {

    @Override
    public String toString() {
        return "Tarjeta de Crédito";
    }

    @Override
    public void pagar(double monto) {
        System.out.println("================================================================");
        System.out.println("Pagando " + monto + " con Tarjeta de Crédito");
    }
}
