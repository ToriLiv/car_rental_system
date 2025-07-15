package org.example.DECORATOR;
import org.example.INTERFACES.Servicio;

/*-------------------------DECORATOR-------------------------
 * Perite agregar funcionalidades adicionales a un servicio
 * ---------------------------------------------------------
 */
public class GpsDecorator extends ServicioDecorator {

    public GpsDecorator(Servicio servicio, double costoAdicional) {
        super(servicio, costoAdicional);
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + " GPS incluido";
    }

    @Override
    public String toString() {
        return servicio.toString() + " GPS Adicional";
    }

}
