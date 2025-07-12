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
            case "1":
                return new GpsDecorator(servicioBase, 50.0);
            case "2":
                return new SeguroDecorator(servicioBase, 100.0);
            case "3":
                return new SeguroDecorator(
                        new GpsDecorator(servicioBase, 50.0), 100.0); // ← usa precios consistentes
            default:
                return servicioBase;
        }
    }
}
