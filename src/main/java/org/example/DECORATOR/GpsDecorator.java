package org.example.DECORATOR;

import org.example.INTERFACES.Servicio;

/*-------------------------DECORATOR-------------------------
 * Perite agregar funcionalidades adicionales a un servicio
 * ---------------------------------------------------------
 */
public class GpsDecorator extends ServicioDecorator {

    public GpsDecorator(Servicio servicio) {
        super(servicio);
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + " GPS incluido";
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio() + 25.0;
    }

    @Override
    public String toString() {
        return servicio.toString() + " GPS Adicional";
    }

}
