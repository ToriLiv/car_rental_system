package org.example.ENTITIES;

import org.example.INTERFACES.MetodoPago;
import org.example.INTERFACES.Servicio;

public class Reserva {
    private Cliente cliente;
    private Auto auto;
    private MetodoPago metodoPago;
    private double costoTotal;
    private int cantidadDias;
    private String estado;

    public Reserva(Cliente cliente, Auto auto, MetodoPago metodoPago, double costoTotal, int cantidadDias) {
        this.cliente = cliente;
        this.auto = auto;
        this.metodoPago = metodoPago;
        this.costoTotal = calcularCostoTotal();
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

    //=================================METODOS==============================================
    public double calcularCostoTotal() {
        return auto.getPrecioPorDia() * cantidadDias;
    }

    public void cancelarReserva() {
        this.estado = "Cancelada";
        System.out.println("Reserva cancelada para el cliente: " + cliente.getNombre());
    }


//    public void confirmarReserva() {
//        this.estado = "Completada";
//        System.out.println("Reserva completada para el cliente: " + cliente.getNombre());
//    }

    public void pagar(){
        if (metodoPago != null) {
            metodoPago.pagar(costoTotal);
            System.out.println("Pago realizado con éxito para la reserva del cliente: " + cliente.getNombre());
        } else {
            System.out.println("No se ha definido un método de pago para esta reserva.");
        }
    }
}
