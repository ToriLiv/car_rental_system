package org.example.FACTORY;

import org.example.INTERFACES.MetodoPago;
import org.example.STRATEGY.Paypal;
import org.example.STRATEGY.TarjetaCredito;

/**
 * ===================================FACTORY============================
 * Se encarga de crear instancias de diferentes tipos de metodos de pago.
 * ======================================================================
 */

public class MetodoPagoFactory {
    public static MetodoPago obtenerMetodoPago(String tipo) {
        switch (tipo.toLowerCase()) {
            case "1":
                return new TarjetaCredito();
            case "2":
                return new Paypal();
            default:
                return null;
        }
    }
}
