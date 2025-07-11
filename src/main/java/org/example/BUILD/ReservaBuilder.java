package org.example.BUILD;

import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.INTERFACES.MetodoPago;
import org.example.INTERFACES.Servicio;

public class ReservaBuilder {
    private Cliente cliente;
    private Auto auto;
    private MetodoPago metodoPago;
    private double costoTotal;
    private int cantidadDias;
    private String estado;

    public ReservaBuilder(Cliente cliente, Auto auto, MetodoPago metodoPago, double costoTotal, int cantidadDias) {
        this.cliente = cliente;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.costoTotal = costoTotal;
        this.cantidadDias = cantidadDias;
        this.estado = "Pendiente";
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reserva build(){
        return new Reserva(cliente, auto, metodoPago, costoTotal, cantidadDias);
    }
}
