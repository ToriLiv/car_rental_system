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

/**
 * =========================================FACADE========================================
 * Esta clase actúa como una fachada para simplificar la creación de reservas.
 * Agrega servicios extras, calculando el costo total y notificando al cliente.
 * * ======================================================================================
 */
public class ReservaFacade {
    public Reserva realizarReserva(Cliente cliente, Auto auto, ServicioDecorator servicioFinal, MetodoPago metodoPago, int cantidadDias) {
        ReservaBuilder builder = new ReservaBuilder()
                .setCliente(cliente)
                .setAuto(auto)
                .setMetodoPago(metodoPago)
                .setCantidadDias(cantidadDias)
                .setServicioDecorado(servicioFinal);

        Reserva reserva = builder.build();
        reserva.calcularCostoTotal();
        reserva.pagar();


        NotificadorReserva notificador = new NotificadorReserva();
        notificador.agregarObservador(cliente);
        SistemaReservas.getInstance().crearReserva(reserva);//si existe una instance de SistemaReservas, se crea la reserva

        return reserva;
    }


}
