package org.example.FACTORY;

import org.example.DECORATOR.GpsDecorator;
import org.example.DECORATOR.SeguroDecorator;
import org.example.ENTITIES.ServicioBase;
import org.example.INTERFACES.Servicio;

/**
 * ===================FACTORY===================
 * Se encarga de crear instancias de diferentes tipos de servicios.
 * =============================================
 */

public class ServicioFactory {
    ServicioBase servicioBase;
    public static Servicio crearServicio(String tipo, Servicio servicioBase) {
        switch (tipo) {
            case "GPS":
                return new GpsDecorator(servicioBase);
            case "Seguro":
                return new SeguroDecorator(servicioBase);
            default:
                return servicioBase;
        }
    }
}
