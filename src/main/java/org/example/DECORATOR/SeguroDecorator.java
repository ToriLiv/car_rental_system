package org.example.DECORATOR;
import org.example.INTERFACES.Servicio;

/*-------------------------DECORATOR-------------------------
 * Perite agregar funcionalidades adicionales a un servicio
 * ---------------------------------------------------------
 */
public class SeguroDecorator extends ServicioDecorator {

    public SeguroDecorator(Servicio servicio, double costoAdicional) {
        super(servicio, costoAdicional);
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + "Seguro adicional incluido.\n" +
               "Este seguro cubre daños menores y robo del vehículo.";
    }

    @Override
    public String toString(){
        return servicio.toString() + " Seguro Adicional";
    }
}
