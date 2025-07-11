package org.example.FACTORY;

import org.example.ENTITIES.CAR.*;

/**
 * =============================FACTORY==================================
 * Se encarga de crear instancias de diferentes tipos de autos.
 * ======================================================================
 */
public class AutoFactory {
    public static Auto crearAuto(String id, String marca, String modelo, String color, String matricula, String tipo, double precioPorDia) {
        switch (tipo.toLowerCase()) {
            case "economico":
                return new Economico(id, marca, modelo, color, matricula, precioPorDia);
            case "pickup":
                return new Pickup(id, marca, modelo, color, matricula, precioPorDia);
            case "deportivo":
                return new Deportivo(id, marca, modelo, color, matricula, precioPorDia);
            case "sedan":
                return new Sedan(id, marca, modelo, color, matricula, precioPorDia);
            default:
                return null;
        }
    }

}
