package org.example.FACTORY;

import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.CAR.Deportivo;
import org.example.ENTITIES.CAR.Economico;
import org.example.ENTITIES.CAR.Pickup;

/**
 * ===================FACTORY===================
 * Se encarga de crear instancias de diferentes tipos de autos.
 * =============================================
 */
public class AutoFactory {
    public static Auto crearAuto(String tipo, String id, String marca, String modelo, String color, String matricula, double precioPorDia) {
        switch (tipo.toLowerCase()) {
            case "economico":
                return new Economico(id, marca, modelo, color, matricula, precioPorDia);
            case "pickup":
                return new Pickup(id, marca, modelo, color, matricula, precioPorDia);
            case "deportivo":
                return new Deportivo(id, marca, modelo, color, matricula, precioPorDia);
            default:
                throw new IllegalArgumentException("Tipo de auto desconocido: " + tipo);
        }
    }

}
