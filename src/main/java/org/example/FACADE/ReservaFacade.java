package org.example.FACADE;

import org.example.BUILD.ReservaBuilder;
import org.example.DECORATOR.ServicioDecorator;
import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.INTERFACES.MetodoPago;
import org.example.INTERFACES.Servicio;


import java.util.List;

public class ReservaFacade {
    public Reserva realizarReserva(Cliente cliente, Auto auto, List<ServicioDecorator> servicios, MetodoPago metodoPago, int cantidadDias) {
        Servicio servicioAdicional = null;

        for (ServicioDecorator decorador : servicios) {
            if (servicioAdicional == null) {
                servicioAdicional = decorador;
            } else {
                decorador.setServicio(servicioAdicional);
                servicioAdicional = decorador;
            }
        }

        double costoTotal = auto.getPrecioPorDia();
        if (servicioAdicional != null) {
            costoTotal += servicioAdicional.getPrecio();
        }


        ReservaBuilder builder = new ReservaBuilder(cliente, auto, metodoPago, costoTotal, cantidadDias);
        Reserva reserva = builder.build();

        return reserva;
    }

}
