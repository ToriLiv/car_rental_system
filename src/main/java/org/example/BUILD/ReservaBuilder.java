package org.example.BUILD;

import org.example.DECORATOR.ServicioDecorator;
import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.INTERFACES.MetodoPago;

/*=====================================BUILD========================================================
 * ReservaBuilder es una clase que permite construir objetos Reserva de manera fluida.
 * Utiliza el patrón Builder para facilitar la creación de reservas con diferentes configuraciones.
 * ==================================================================================================
 */

import java.util.ArrayList;
import java.util.List;

public class ReservaBuilder {
    private Cliente cliente;
    private Auto auto;
    private MetodoPago metodoPago;
    private int cantidadDias;
    private ServicioDecorator servicioFinal;

    public ReservaBuilder setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ReservaBuilder setAuto(Auto auto) {
        this.auto = auto;
        return this;
    }

public ReservaBuilder setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
        return this;
    }

    public ReservaBuilder setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    public ReservaBuilder setServicioDecorado(ServicioDecorator servicioFinal) {
        this.servicioFinal = servicioFinal;
        return this;
    }

    public Reserva build() {
        Reserva reserva = new Reserva(cliente, auto, metodoPago, cantidadDias);
        reserva.setServicioDecorado(servicioFinal);
        return reserva;
    }

}
