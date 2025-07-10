package org.example.DECORATOR;

import org.example.INTERFACES.Servicio;

/*-------------------------DECORATOR-------------------------
 * Perite agregar funcionalidades adicionales a un servicio
 * ---------------------------------------------------------
 */
public class SeguroDecorator extends ServicioDecorator {

    public SeguroDecorator(Servicio servicio) {
        super(servicio);
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + "Seguro adicional incluido.\n" +
               "Este seguro cubre daños menores y robo del vehículo.";
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio() + 50.0; // Precio adicional por el seguro
    }

    @Override
    public String toString(){
        return servicio.toString() + " Seguro Adicional";
    }
}
