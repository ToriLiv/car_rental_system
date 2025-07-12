package org.example.ENTITIES;

import org.example.DECORATOR.ServicioDecorator;
import org.example.ENTITIES.CAR.Auto;
import org.example.INTERFACES.MetodoPago;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String id;
    private Cliente cliente;
    private Auto auto;
    private MetodoPago metodoPago;
    private double costoTotal;
    private int cantidadDias;
    private String estado;
    private ServicioDecorator servicioFinal;

    public Reserva(Cliente cliente, Auto auto, MetodoPago metodoPago, int cantidadDias) {
        this.id = id;
        this.cliente = cliente;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.cantidadDias = cantidadDias;
        this.auto.setDisponible(false);
        this.estado = "Pendiente";
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

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //=================================METODOS==============================================
    public void calcularCostoTotal() {
        double costoBase = auto.getPrecioPorDia() * cantidadDias;
        double costoExtras = (servicioFinal != null) ? servicioFinal.obtenerCosto() : 0;

        this.costoTotal = costoBase + costoExtras;
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Costo servicios: $" + costoExtras);
        System.out.println("Total a pagar: $" + this.costoTotal);
    }
    public void cancelarReserva() {
        this.estado = "Cancelada";
        System.out.println("Reserva cancelada para el cliente: " + cliente.getNombre());
        auto.setDisponible(true);
    }

    public void pagar(){
        if (metodoPago != null) {
            metodoPago.pagar(costoTotal);
            System.out.println("Pago realizado con éxito para la reserva del cliente: " + cliente.getNombre());
        } else {
            System.out.println("No se ha definido un método de pago para esta reserva.");
        }
    }

    @Override
    public String toString() {
        return "========================================================\n" +
                "Cliente:\n" + cliente.toString() +
                "\n" + auto.toString() +
                "-----------------------------------" +
                "Método de pago: " + metodoPago.toString() + "\n" +
                "-----------------------------------" +
                "Cantidad de días: " + cantidadDias + "\n" +
                "-----------------------------------" +
                "Estado: " + estado + "\n" +
                "-----------------------------------" +
                "Costo total: $" + costoTotal + "\n" +
                "========================================================\n";
    }

    public void setServicioDecorado(ServicioDecorator servicioFinal) {
        this.servicioFinal = servicioFinal;
    }
}
