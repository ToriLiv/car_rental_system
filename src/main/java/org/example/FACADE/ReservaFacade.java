package org.example.FACADE;

import org.example.BUILD.ReservaBuilder;
import org.example.DECORATOR.ServicioDecorator;
import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.INTERFACES.MetodoPago;
import org.example.INTERFACES.Servicio;
import org.example.OBSERVER.NotificadorReserva;
import org.example.SistemaReservas;


import java.util.List;

public class ReservaFacade {
    public void realizarReserva(Cliente cliente, Auto auto, List<ServicioDecorator> extras, MetodoPago metodoPago) {
        ReservaBuilder builder = new ReservaBuilder()
                .setAuto(auto)
                .setMetodoPago(metodoPago);

        for (ServicioDecorator extra : extras) {
            builder.addServicioExtra(extra);
        }

        Reserva reserva = builder.build();
        reserva.calcularCostoTotal();
        reserva.pagar();

        NotificadorReserva notificador = new NotificadorReserva();
        notificador.agregarObservador(cliente);
        notificador.notificar("¡Su reserva ha sido confirmada!");

        SistemaReservas.getInstance().crearReserva(reserva);
    }


}
