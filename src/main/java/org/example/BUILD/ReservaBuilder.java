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
    private double costoTotal;
    private int cantidadDias;
    private List<ServicioDecorator> extras = new ArrayList<>();

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

    public void setExtras(List<ServicioDecorator> extras) {
        this.extras = extras;
    }

    public ReservaBuilder addServicioExtra(ServicioDecorator extra) {
        this.extras.add(extra);
        return this;
    }

    public Reserva build() {
        Reserva reserva = new Reserva(cliente, auto, metodoPago, cantidadDias);
        for (ServicioDecorator extra : extras) {
            reserva.agregarExtra(extra);
        }
        return reserva;
    }

}
