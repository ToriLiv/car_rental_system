package org.example.ENTITIES;

import org.example.INTERFACES.MetodoPago;

public class Reserva {
    private Cliente cliente;
    private Auto auto;
    private MetodoPago metodoPago;
    private double costoTotal;

    public Reserva(Cliente cliente, Auto auto, MetodoPago metodoPago, double costoTotal) {
        this.cliente = cliente;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
