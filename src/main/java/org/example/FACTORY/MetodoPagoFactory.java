package org.example.FACTORY;

import org.example.INTERFACES.MetodoPago;
import org.example.STRATEGY.Paypal;
import org.example.STRATEGY.TarjetaCredito;

public class MetodoPagoFactory {
    public static MetodoPago obtenerMetodoPago(String tipo) {
        switch (tipo.toLowerCase()) {
            case "tarjeta de credito":
                return new TarjetaCredito();
            case "paypal":
                return new Paypal();
            default:
                throw new IllegalArgumentException("Método de pago no válido: " + tipo);
        }
    }
}
