package org.example.DECORATOR;

import org.example.INTERFACES.Servicio;

/*-------------------------DECORATOR-------------------------
 * Perite agregar funcionalidades adicionales a un servicio
 * ---------------------------------------------------------
 */

public class ServicioDecorator implements Servicio {
    protected Servicio servicio;
    protected double costoAdicional;

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public ServicioDecorator(Servicio servicio, double costoAdicional) {
        this.servicio = servicio;
        this.costoAdicional = costoAdicional;
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return costoAdicional;
    }

    @Override
    public double obtenerCosto() {
        return servicio.obtenerCosto() + costoAdicional;
    }


}
