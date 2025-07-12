package org.example.FACTORY;

import org.example.INTERFACES.MetodoPago;
import org.example.STRATEGY.Paypal;
import org.example.STRATEGY.TarjetaCredito;

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
