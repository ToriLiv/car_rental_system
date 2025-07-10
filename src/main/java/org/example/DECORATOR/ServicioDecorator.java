package org.example.DECORATOR;

import org.example.INTERFACES.Servicio;

/*-------------------------DECORATOR-------------------------
 * Perite agregar funcionalidades adicionales a un servicio
 * ---------------------------------------------------------
 */

public class ServicioDecorator implements Servicio {
    protected Servicio servicio;

    public ServicioDecorator(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio();
    }
}
